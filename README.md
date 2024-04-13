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