package client;

import ejb.VehicleIF;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ArchivePath;
import org.jboss.shrinkwrap.api.Node;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ArchiveAsset;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Simple test to run an application client against a remote EJB
 *
 * Run with:
 * mvn test
 */
@ExtendWith(ArquillianExtension.class)
public class AppClientTest {
    private static final Logger LOGGER = Logger.getLogger(AppClientTest.class.getName());

    private BlockingQueue<String> outputQueue = new LinkedBlockingQueue<String>();

    @Deployment(name = "jpa_core_EntityGraph_stateless_vehicle", testable = false)
    public static EnterpriseArchive createDeployment() {
        JavaArchive jpa_core_EntityGraph_stateless_vehicle_client = ShrinkWrap.create(JavaArchive.class, "jpa_core_EntityGraph_vehicle_client.jar");
        // The class files
        jpa_core_EntityGraph_stateless_vehicle_client.addClasses(RemoteEjbClient.class, VehicleIF.class);
        // The application-client.xml descriptor
        URL resURL = AppClientTest.class.getResource("/application-client.xml");
        jpa_core_EntityGraph_stateless_vehicle_client.addAsManifestResource(resURL, "application-client.xml");
        jpa_core_EntityGraph_stateless_vehicle_client.addAsManifestResource(new StringAsset("Main-Class: " + RemoteEjbClient.class.getName() + "\n"), "MANIFEST.MF");

        JavaArchive jpa_core_EntityGraph_stateless_vehicle_ejb = ShrinkWrap.create(JavaArchive.class, "jpa_core_EntityGraph_stateless_vehicle_ejb.jar");
        // The class files
        jpa_core_EntityGraph_stateless_vehicle_ejb.addClasses(
                VehicleIF.class,
                ejb.StatelessVehicleBean.class
        );
        // The sun-ejb-jar.xml file
        URL ejbResURL1 = AppClientTest.class.getResource("/sun-ejb-jar.xml");
        jpa_core_EntityGraph_stateless_vehicle_ejb.addAsManifestResource(ejbResURL1, "sun-ejb-jar.xml");

        EnterpriseArchive jpa_core_EntityGraph_vehicles_ear = ShrinkWrap.create(EnterpriseArchive.class, "jpa_core_EntityGraph_ear.ear");

        // The component jars built by the package target
        //jpa_core_EntityGraph_vehicles_ear.addAsLibrary(jpa_core_EntityGraph_stateless_vehicle_ejb);
        jpa_core_EntityGraph_vehicles_ear.addAsModule(jpa_core_EntityGraph_stateless_vehicle_client);
        jpa_core_EntityGraph_vehicles_ear.addAsModule(jpa_core_EntityGraph_stateless_vehicle_ejb);
        URL earURL = AppClientTest.class.getResource("/application.xml");
        jpa_core_EntityGraph_vehicles_ear.addAsManifestResource(earURL, "application.xml");

        extractEar(jpa_core_EntityGraph_vehicles_ear);

        return jpa_core_EntityGraph_vehicles_ear;
    }

    // From the AppClientDeploymentPackager, extracts the ear to a directory for use by the appclient launcher
    private static void extractEar(EnterpriseArchive ear) {
        // Write out the ear with the test dependencies for use by the appclient launcher
        String extractDir = "target/appclient";
        File appclient = new File(extractDir);
        if(!appclient.exists()) {
            if(appclient.mkdirs()) {
                System.out.println("Created appclient directory: " + appclient.getAbsolutePath());
            } else {
                throw new RuntimeException("Failed to create appclient directory: " + appclient.getAbsolutePath());
            }
        }
        File archiveOnDisk = new File(appclient, ear.getName());
        final ZipExporter exporter = ear.as(ZipExporter.class);
        exporter.exportTo(archiveOnDisk, true);
        System.out.println("Exported test ear to: " + archiveOnDisk.getAbsolutePath());

        for (ArchivePath path : ear.getContent().keySet()) {
            Node node = ear.get(path);
            if (node.getAsset() instanceof ArchiveAsset) {
                ArchiveAsset asset = (ArchiveAsset) node.getAsset();
                File archiveFile = new File(appclient, path.get());
                if(!archiveFile.getParentFile().exists()) {
                    archiveFile.getParentFile().mkdirs();
                }
                final ZipExporter zipExporter = asset.getArchive().as(ZipExporter.class);
                zipExporter.exportTo(archiveFile, true);
                System.out.println("Exported test ear content to: " + archiveFile.getAbsolutePath());
            } else if(node.getAsset() instanceof FileAsset) {
                FileAsset asset = (FileAsset) node.getAsset();
                File file = new File(appclient, path.get());
                if(!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                try {
                    Files.copy(asset.openStream(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Exported test ear content to: " + file.getAbsolutePath());
                } catch (Exception e) {
                    throw new RuntimeException("Failed to export test ear content to: " + file.getAbsolutePath(), e);
                }
            }
        }
    }

    @Test
    public void runAppClientWithConfig() throws Exception {
        String[] clientEnvp = {
                "AS_JAVA="+System.getenv("JAVA_HOME"),
                "AS_DEBUG=true"
        };
        String[] cmdLine = {
                "target/glassfish8/glassfish/bin/appclient",
                "-Djava.util.logging.config.file=target/test-classes/logging.properties",
                "-jar",
                "target/appclient/jpa_core_EntityGraph_vehicle_client.jar"
        };

        ArrayList<String> cmdList = new ArrayList<String>();
        for (int n = 0; n < cmdLine.length; n ++) {
            String arg = cmdLine[n];
            cmdList.addAll(Arrays.asList(cmdLine[n].split(" ")));
        }

        Process appClientProcess = Runtime.getRuntime().exec(cmdLine, clientEnvp, null);
        CompletableFuture<Process> onExit = appClientProcess.onExit();
        LOGGER.info("Created process" + appClientProcess.info());
        LOGGER.info("process(%d).envp: %s".formatted(appClientProcess.pid(), Arrays.toString(clientEnvp)));
        BufferedReader outputReader = new BufferedReader(new InputStreamReader(appClientProcess.getInputStream(), StandardCharsets.UTF_8));
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(appClientProcess.getErrorStream(), StandardCharsets.UTF_8));

        final Thread readOutputThread = new Thread(() -> readClientProcess(outputReader, false), "APPCLIENT-out");
        readOutputThread.start();
        final Thread readErrorThread = new Thread(() -> readClientProcess(errorReader, true), "APPCLIENT-err");
        readErrorThread.start();
        LOGGER.info("Started process reader threads");

        ArrayList<String> lines = new ArrayList<String>();
        do {
            try {
                String line = outputQueue.poll(100, TimeUnit.MILLISECONDS);
                if (line != null)
                    lines.add(line);
            } catch (InterruptedException ioe) {
            }

        } while (!onExit.isDone());
        LOGGER.info("Exited onExit future loop");

        boolean foundPass = false;
        for (String line : lines) {
            if (line.contains("PASS")) {
                foundPass = true;
                break;
            }
        }
        Assertions.assertTrue(foundPass, "PASS not found in output");
    }

    private void readClientProcess(BufferedReader reader, boolean errReader) {
        LOGGER.info("Begin readClientProcess");
        int count = 0;
        try {
            String line = reader.readLine();
            while (line != null) {
                count++;
                if (errReader) {
                    LOGGER.info("[err] " + line);
                    outputQueue.add(line);
                } else {
                    LOGGER.info("[out] " + line);
                    outputQueue.add(line);
                }
                line = reader.readLine();
            }
        } catch (Throwable e) {
            LOGGER.warning(formatException("error during read, caused by:\n", e));
        }
        LOGGER.info(String.format("Exiting(%s), read %d lines", errReader, count));
    }

    private static String formatException(String msg, Throwable e) {
        StringWriter sw = new StringWriter();
        sw.append(msg);
        e.printStackTrace(new PrintWriter(sw, true));
        return sw.toString();
    }

}
