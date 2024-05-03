export DERBY_HOME=/opt/Apache/db-derby-10.14.2.0-bin;
cd $DERBY_HOME/bin || exit;
./setNetworkServerCP;
sleep 1;
./startNetworkServer;