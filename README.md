Set the following environment variables:-
For windows
Check environment variable value e.g.
echo %JAVA_HOME% 
C:\Program Files\Java\jdk1.7.0_51
Adding to PATH: Add the unpacked distribution’s bin directory to your user PATH environment variable by opening up the system properties (WinKey + Pause), selecting the “Advanced” tab, and the “Environment Variables” button, then adding or selecting the PATH variable in the user variables with the value C:\Program Files\apache-maven-3.6.3\bin. The same dialog can be used to set JAVA_HOME to the location of your JDK, e.g. C:\Program Files\Java\jdk1.7.0_51

For Linux
Check environment variable value
echo $JAVA_HOME
/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home
Adding to PATH
export PATH=/opt/apache-maven-3.6.3/bin:$PATH

Run the app locally by running the command 
mvn spring-boot:run

Install mongodb 
https://docs.mongodb.com/manual/tutorial/install-mongodb-on-os-x/
https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/

Connect to your own mongodb cluster by configuring in file application.properties 

