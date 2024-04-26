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
1. Click on the Database icon in the right sidebar
2. Click New -> Data Source -> Apache Derby -> Apache Derby (Embedded).
3. Set the path to be your directory to the IoTBay project folder plus "/db". Do not create the db folder yourself or the database creation process will fail.
4. Change authentication to "No auth."
5. Tick the "Create database" checkbox.
6. If IntelliJ prompts you to download missing drivers, click the download button and wait for the drivers to install.
7. Click OK to create the database.
8. Right-click the newly created database then navigate to New -> Schema.
9. Replace "schema_name" with "IoTBayDB" then click OK.
10. Navigate to IoTBay/src/main/resources/db.
11. Execute schema.sql to create the database tables. Make sure that you run this script (and all others) on the IoTBayDB schema. If this fails on the first run, click ignore all because you have already initialised the IoTBayDB schema.
12. Run sampleData.sql to create the sample data entries.
13. If you ever need to clear the database, running dropSchema.sql will drop all the tables for you.