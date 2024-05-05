package isdwrk04.group5.iotbay.dao;

import java.sql.Connection;

public abstract class Db {

    protected String url = "jdbc:derby://localhost:1527/IoTBayDb";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection connection;
}
