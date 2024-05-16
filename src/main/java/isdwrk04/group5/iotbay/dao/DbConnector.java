package isdwrk04.group5.iotbay.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector extends Db {

    public DbConnector() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {

        return this.connection;
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
