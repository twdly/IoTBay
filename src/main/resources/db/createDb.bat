set DERBY_INSTALL=C:\Apache\db-derby-10.14.2.0-bin
cd %DERBY_INSTALL%\bin
call setNetworkClientCP.bat
echo In the next prompt, please enter: connect 'jdbc:derby://localhost:1527/IoTBayDb;create=true';
echo Afterwards, close the window and the database will have been created
java org.apache.derby.tools.ij