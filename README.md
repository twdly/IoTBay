# IoTBay
### A Jakarta EE web app for 41025 Introduction to Software Development, Autumn 2024

# Source code
The source code for this project can be found in our team's [GitHub repository](https://github.com/twdly/IoTBay).

# How to run
1. If you don't already have the WAR file to deploy, download the newest WAR file from our [repository's package page](https://github.com/twdly/IoTBay/packages/2106668) or build it yourself using Maven with `mvn package`.
2. Download the newest version of Apache Tomcat from [here](https://tomcat.apache.org/download-90.cgi) (this project has been tested with 9.0.86 and 9.0.87).
3. Extract the downloaded copy of Apache Tomcat to your desired install location.
4. Open the extracted Tomcat directory and open conf/tomcat-users.xml.
5. Inside tomcat-users.xml, create a user with the role manager-gui with your desired username and password.
6. Open the bin folder within the Tomcat directory and run startup.bat on Windows or startup.sh on macOS/Linux.
7. Go to http://localhost:8080 (or the port that you have configured for Tomcat if you have used it before).
8. Click on "manager app" then enter the username and password you configured earlier.
9. Scroll down to the "WAR file to deploy" subheading, click on "Choose file" and then locate and open the IoTBay WAR file.
10. Click deploy and the IoTBay website should be ready to use.

# How to create the database with IntelliJ
1. Download the Apache Derby binaries from [here](https://db.apache.org/derby/releases/release-10_14_2_0.html).
2. Extract the binary files to C:\Apache\ on Windows or /opt/Apache/ on macOS/Unix. If these directories do not already exist, be sure to create them yourself.
3. Navigate to IoTBay/src/main/resources/db in the IoTBay project files
4. Run startServer.bat from the commandline if you are on Windows or startServer.sh on macOS/Unix. If you get a permission denied message on Unix, run `chmod +x ./startServer.sh`.
5. After you see the message that the Derby server is ready to receive connections, run createDb.bat on Windows or createDb.sh on macOS/Unix. Once again, you may need to run `chmod +x ./createDb.sh` to execute the script.
6. When you see the `ij>` prompt, copy and enter the connect command as presented to you by the script.
7. Open IntelliJ and click the Database icon on the right sidebar.
8. Click New -> Data Source -> Apache Derby -> Apache Derby (Remote).
9. Change authentication to no auth and append 'IoTBayDb' to the connection URL.
10. Update or select drivers if IntelliJ prompts you to do so.
11. Assuming you haven't shut the command line that you ran the startServer script in, click test connection to ensure that the database has been successfully created.
12. If the connection test was successful, click OK to add the database to your IntelliJ data sources
13. From IntelliJ, execute schema.sql to create the database tables ensuring that you have selected the newly created database connection.
14. Run sampleData.sql to create the sample data entries.
15. If you ever need to clear the database, running dropSchema.sql will drop all the tables for you.
16. Whenever working on this project, ensure that you have the startServer script running in the background or the database will be inaccessible.