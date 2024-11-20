# Appclient JNDI lookup of remote EJB

Glassfish reported issue: https://github.com/eclipse-ee4j/glassfish/issues/25219

Run the test using `mvn test`:

```bash
starksm@Scotts-Mac-Studio appclient-jndi % mvn test
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< org.glassfish.test:appclient-jndi >------------------
[INFO] Building appclient-jndi 11.0.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ appclient-jndi ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/starksm/Dev/Jakarta/appclient-jndi/src/main/resources
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ appclient-jndi ---
[INFO] No sources to compile
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ appclient-jndi ---
[WARNING] File encoding has not been set, using platform encoding UTF-8. Build is platform dependent!
[WARNING] See https://maven.apache.org/general.html#encoding-warning
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 5 resources from src/test/resources to target/test-classes
[INFO] The encoding used to copy filtered properties files have not been set. This means that the same encoding will be used to copy filtered properties files as when copying other filtered resources. This might not be what you want! Run your build with --debug to see which files might be affected. Read more at https://maven.apache.org/plugins/maven-resources-plugin/examples/filtering-properties-files.html
[INFO] 
[INFO] --- dependency:3.2.0:unpack (001-unpack) @ appclient-jndi ---
[INFO] Configured Artifact: org.glassfish.main.distributions:glassfish:8.0.0-JDK17-M7:zip
[INFO] glassfish-8.0.0-JDK17-M7.zip already unpacked.
[INFO] 
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ appclient-jndi ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- surefire:3.2.2:test (default-test) @ appclient-jndi ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running client.AppClientTest
Exported test ear to: /Users/starksm/Dev/Jakarta/appclient-jndi/target/appclient/jpa_core_EntityGraph_ear.ear
Exported test ear content to: /Users/starksm/Dev/Jakarta/appclient-jndi/target/appclient/jpa_core_EntityGraph_vehicle_client.jar
Exported test ear content to: /Users/starksm/Dev/Jakarta/appclient-jndi/target/appclient/jpa_core_EntityGraph_stateless_vehicle_ejb.jar
Exported test ear content to: /Users/starksm/Dev/Jakarta/appclient-jndi/target/appclient/META-INF/application.xml
Starting container using command: [/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home/bin/java, -jar, /Users/starksm/Dev/Jakarta/appclient-jndi/target/glassfish8/glassfish/modules/admin-cli.jar, start-domain, -t]
Waiting finished after 1,354 ms.
Successfully started the domain : domain1
domain  Location: /Users/starksm/Dev/Jakarta/appclient-jndi/target/glassfish8/glassfish/domains/domain1
Log File: /Users/starksm/Dev/Jakarta/appclient-jndi/target/glassfish8/glassfish/domains/domain1/logs/server.log
Admin Port: 4,848
Nov 20, 2024 8:52:04 AM client.AppClientTest runAppClientWithConfig
INFO: Created process[user: Optional[starksm], cmd: /bin/sh, args: [target/glassfish8/glassfish/bin/appclient, -Djava.util.logging.config.file=target/test-classes/logging.properties, -jar, target/appclient/jpa_core_EntityGraph_vehicle_client.jar], startTime: Optional[2024-11-20T14:52:04.846Z]]
Nov 20, 2024 8:52:04 AM client.AppClientTest runAppClientWithConfig
INFO: process(42566).envp: [AS_JAVA=/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home, AS_DEBUG=true]
Nov 20, 2024 8:52:04 AM client.AppClientTest readClientProcess
INFO: Begin readClientProcess
Nov 20, 2024 8:52:04 AM client.AppClientTest readClientProcess
INFO: Begin readClientProcess
Nov 20, 2024 8:52:04 AM client.AppClientTest runAppClientWithConfig
INFO: Started process reader threads
Nov 20, 2024 8:52:05 AM client.AppClientTest readClientProcess
INFO: [err] acc._AS_INSTALL set to target/glassfish8/glassfish/bin/..
Nov 20, 2024 8:52:05 AM client.AppClientTest readClientProcess
INFO: [err] VMARGS = null
Nov 20, 2024 8:52:05 AM client.AppClientTest readClientProcess
INFO: [err] "/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home/bin/java" -Dorg.glassfish.gmbal.no.multipleUpperBoundsException=true --add-opens=java.base/java.lang=ALL-UNNAMED -Dcom.sun.aas.installRoot="/Users/starksm/Dev/Jakarta/appclient-jndi/target/glassfish8/glassfish/bin/.." -Djava.security.policy="/Users/starksm/Dev/Jakarta/appclient-jndi/target/glassfish8/glassfish/bin/../lib/appclient/client.policy" -classpath /Users/starksm/Dev/Jakarta/appclient-jndi/target/glassfish8/glassfish/bin/../lib/gf-client.jar:. -Djava.system.class.loader=org.glassfish.appclient.client.acc.agent.ACCAgentClassLoader -Xshare:off -Djava.security.auth.login.config="/Users/starksm/Dev/Jakarta/appclient-jndi/target/glassfish8/glassfish/bin/../lib/appclient/appclientlogin.conf"  "-Djava.util.logging.config.file=target/test-classes/logging.properties"  -javaagent:"/Users/starksm/Dev/Jakarta/appclient-jndi/target/glassfish8/glassfish/bin/../lib/gf-client.jar"=argsfile="/var/folders/yh/t0fnl559607crz2vyp509bjr0000gn/T/acc14810244134800704423.dat"  -classpath  /Users/starksm/Dev/Jakarta/appclient-jndi/target/glassfish8/glassfish/bin/../lib/gf-client.jar:target/appclient/jpa_core_EntityGraph_vehicle_client.jar  client.RemoteEjbClient 
Nov 20, 2024 8:52:05 AM client.AppClientTest readClientProcess
INFO: [err] [2024-11-20 08:52:05] I jakarta.enterprise.resource.jta.com.sun.enterprise.transaction DTX5019: Transaction Manager is ready. Using [com.sun.enterprise.transaction.jts.JavaEETransactionManagerJTSDelegate] as the delegate 
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err] [2024-11-20 08:52:06] I org.glassfish.enterprise.iiop.impl.GlassFishORBManager ORB initialization succeeded: com.sun.corba.ee.impl.orb.ORBImpl@310d57b1 
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err] Exception in thread "main" javax.naming.NamingException: Lookup failed for java:comp/env/ejb/StatelessVehicleBean in SerialContext[myEnv={java.naming.factory.initial=com.sun.enterprise.naming.impl.SerialInitContextFactory, java.naming.factory.url.pkgs=com.sun.enterprise.naming, java.naming.factory.state=com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl}] [Root exception is javax.naming.NameNotFoundException: No object bound for java:comp/env/ejb/StatelessVehicleBean]
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]     at com.sun.enterprise.naming.impl.SerialContext.lookup(SerialContext.java:836)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]     at com.sun.enterprise.naming.impl.SerialContext.lookup(SerialContext.java:257)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]     at java.naming/javax.naming.InitialContext.lookup(InitialContext.java:409)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]     at client.RemoteEjbClient.main(RemoteEjbClient.java:13)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err] Caused by: javax.naming.NameNotFoundException: No object bound for java:comp/env/ejb/StatelessVehicleBean
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]     at com.sun.enterprise.naming.impl.JavaURLContext.lookup(JavaURLContext.java:135)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]     at com.sun.enterprise.naming.impl.SerialContext.lookup(SerialContext.java:818)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]     ... 3 more
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]     Suppressed: javax.naming.NamingException: Exception resolving Ejb for 'Remote ejb-ref name=ejb/StatelessVehicleBean,Remote 3.x interface =ejb.VehicleIF,ejb-link=StatelessVehicleBean,lookup=,mappedName=,jndi-name=,refType=Session' .  Actual (possibly internal) Remote JNDI name used for lookup is '#ejb.VehicleIF' [Root exception is javax.naming.NamingException: Lookup failed for #ejb.VehicleIF in SerialContext[myEnv={java.naming.factory.initial=com.sun.enterprise.naming.impl.SerialInitContextFactory, java.naming.factory.url.pkgs=com.sun.enterprise.naming, java.naming.factory.state=com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl}] [Root exception is javax.naming.NameNotFoundException: #ejb.VehicleIF not found]]
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.ejb.EjbNamingReferenceManagerImpl.resolveEjbReference(EjbNamingReferenceManagerImpl.java:159)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.enterprise.container.common.impl.ComponentEnvManagerImpl$EjbReferenceProxy.create(ComponentEnvManagerImpl.java:975)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.enterprise.naming.impl.GlassfishNamingManagerImpl.lookup(GlassfishNamingManagerImpl.java:621)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.enterprise.naming.impl.GlassfishNamingManagerImpl.lookup(GlassfishNamingManagerImpl.java:587)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.enterprise.naming.impl.JavaURLContext.lambda$lookup$0(JavaURLContext.java:153)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.enterprise.naming.impl.JavaURLContext.lookupOrCollectException(JavaURLContext.java:550)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.enterprise.naming.impl.JavaURLContext.lookup(JavaURLContext.java:153)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             ... 4 more
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]     Caused by: javax.naming.NamingException: Lookup failed for #ejb.VehicleIF in SerialContext[myEnv={java.naming.factory.initial=com.sun.enterprise.naming.impl.SerialInitContextFactory, java.naming.factory.url.pkgs=com.sun.enterprise.naming, java.naming.factory.state=com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl}] [Root exception is javax.naming.NameNotFoundException: #ejb.VehicleIF not found]
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.enterprise.naming.impl.SerialContext.lookup(SerialContext.java:836)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.enterprise.naming.impl.SerialContext.lookup(SerialContext.java:257)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at java.naming/javax.naming.InitialContext.lookup(InitialContext.java:409)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.ejb.EjbNamingReferenceManagerImpl.resolveEjbReference(EjbNamingReferenceManagerImpl.java:154)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             ... 10 more
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]     Caused by: javax.naming.NameNotFoundException: #ejb.VehicleIF not found
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.enterprise.naming.impl.TransientContext.doLookup(TransientContext.java:234)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.enterprise.naming.impl.TransientContext.lookup(TransientContext.java:202)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.enterprise.naming.impl.SerialContextProviderImpl.lookup(SerialContextProviderImpl.java:37)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.enterprise.naming.impl.RemoteSerialContextProviderImpl.lookup(RemoteSerialContextProviderImpl.java:85)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at java.base/java.lang.reflect.Method.invoke(Method.java:568)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.corba.ee.impl.presentation.rmi.ReflectiveTie.dispatchToMethod(ReflectiveTie.java:122)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.corba.ee.impl.presentation.rmi.ReflectiveTie._invoke(ReflectiveTie.java:152)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.corba.ee.impl.protocol.ServerRequestDispatcherImpl.dispatchToServant(ServerRequestDispatcherImpl.java:501)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.corba.ee.impl.protocol.ServerRequestDispatcherImpl.dispatch(ServerRequestDispatcherImpl.java:172)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.corba.ee.impl.protocol.MessageMediatorImpl.handleRequestRequest(MessageMediatorImpl.java:1529)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.corba.ee.impl.protocol.MessageMediatorImpl.handleRequest(MessageMediatorImpl.java:1405)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.corba.ee.impl.protocol.MessageMediatorImpl.handleInput(MessageMediatorImpl.java:910)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.corba.ee.impl.protocol.giopmsgheaders.RequestMessage_1_2.callback(RequestMessage_1_2.java:192)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.corba.ee.impl.protocol.MessageMediatorImpl.handleRequest(MessageMediatorImpl.java:674)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.corba.ee.impl.protocol.MessageMediatorImpl.dispatch(MessageMediatorImpl.java:476)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.corba.ee.impl.protocol.MessageMediatorImpl.doWork(MessageMediatorImpl.java:2202)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.corba.ee.impl.threadpool.ThreadPoolImpl$WorkerThread.performWork(ThreadPoolImpl.java:476)
Nov 20, 2024 8:52:06 AM client.AppClientTest readClientProcess
INFO: [err]             at com.sun.corba.ee.impl.threadpool.ThreadPoolImpl$WorkerThread.run(ThreadPoolImpl.java:519)
Nov 20, 2024 8:52:07 AM client.AppClientTest readClientProcess
INFO: Exiting(true), read 51 lines
Nov 20, 2024 8:52:07 AM client.AppClientTest readClientProcess
INFO: Exiting(false), read 0 lines
Nov 20, 2024 8:52:07 AM client.AppClientTest runAppClientWithConfig
INFO: Exited onExit future loop
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 8.227 s <<< FAILURE! -- in client.AppClientTest
[ERROR] client.AppClientTest.runAppClientWithConfig -- Time elapsed: 2.338 s <<< FAILURE!
org.opentest4j.AssertionFailedError: PASS not found in output ==> expected: <true> but was: <false>
...
Stopping container using command: [/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home/bin/java, -jar, /Users/starksm/Dev/Jakarta/appclient-jndi/target/glassfish8/glassfish/modules/admin-cli.jar, stop-domain, -t]
Waiting finished after 45 ms.
[INFO] 
[INFO] Results:
[INFO] 
[ERROR] Failures: 
[ERROR]   AppClientTest.runAppClientWithConfig:177 PASS not found in output ==> expected: <true> but was: <false>
[INFO] 
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  9.797 s
[INFO] Finished at: 2024-11-20T08:52:07-06:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.2.2:test (default-test) on project appclient-jndi: There are test failures.
[ERROR] 
[ERROR] Please refer to /Users/starksm/Dev/Jakarta/appclient-jndi/target/surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
starksm@Scotts-Mac-Studio appclient-jndi % 



```