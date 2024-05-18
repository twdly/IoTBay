package isdwrk04.group5.iotbay.dao;

import isdwrk04.group5.iotbay.model.AccessLog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//DAO for managing access logs in the database

public class AccessLogDAO {

    private final Connection connection;

    //    Constructor that initializes the DAO by establishing a database connection
    public AccessLogDAO() {
        connection = new DbConnector().getConnection();
    }

//    Inserts a new AccessLog object into the database.
    public void insertLog(AccessLog log) {
        try {
            int id = getNextLogId();
            log.setLogId(id);
            PreparedStatement statement = connection.prepareStatement("insert into \"ACCESSLOG\" values (?, ?, ?, ?)");
            buildQuery(log, statement);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    Builds the SQL query for inserting an access log
    private void buildQuery(AccessLog log, PreparedStatement statement) throws SQLException {
        statement.setInt(1, log.getLogId());
        statement.setInt(2, log.getUserId());
        statement.setString(3, log.getEvent());
        statement.setTimestamp(4, log.getEventTime());
    }

//    Retrieves the next available log id
    private int getNextLogId() {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select max(LOG_ID) as ID from \"ACCESSLOG\"");
            result.next();
            return result.getInt("ID") + 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    Retrieves all access logs for a given user id
    public List<AccessLog> getLogsByUser(int id) {
        List<AccessLog> logs = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from ACCESSLOG where USER_ID = ?");
            statement.setInt(1, id);
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                logs.add(createAccessLogFromResult(results));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return logs;
    }

//    Retrieves all access logs for a given user on a specified date
    public List<AccessLog> getLogsByDate(int id, String date) {
        List<AccessLog> logs = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from ACCESSLOG where USER_ID = ? AND DATE(EVENT_TIME) = ?");
            statement.setInt(1, id);
            statement.setString(2, date);
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                logs.add(createAccessLogFromResult(results));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return logs;
    }

//    Retrieves all access logs from the database
    public List<AccessLog> getAllLogs() {
        List<AccessLog> logs = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from ACCESSLOG");
            while (results.next()) {
                logs.add(createAccessLogFromResult(results));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return logs;
    }

//    Deletes an access log from the database by its id
    public void deleteAccessLog(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from \"ACCESSLOG\" where LOG_ID = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    Creates an AccessLog object from a ResultSet
    private AccessLog createAccessLogFromResult(ResultSet result) throws SQLException {
        int logId = result.getInt("Log_ID");
        int userId = result.getInt("User_ID");
        String event = result.getString("Event");
        Timestamp eventTime = result.getTimestamp("Event_Time");
        return new AccessLog(logId, userId, event, eventTime);
    }

}
