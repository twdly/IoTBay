export DERBY_HOME=/opt/Apache/db-derby-10.14.2.0-bin;
cd $DERBY_HOME/bin || exit;
./setNetworkClientCP;
sleep 1;
export CLASSPATH=$DERBY_HOME/lib/derbyclient.jar:$DERBY_HOME/lib/derbytools.jar
echo 'In the next prompt, please enter: connect '\''jdbc:derby://localhost:1527/IoTBayDb;create=true'\'';';
echo Afterwards, close the window and the database will have been created;
java org.apache.derby.tools.ij