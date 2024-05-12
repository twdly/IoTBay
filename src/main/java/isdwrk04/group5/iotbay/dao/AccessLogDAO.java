package isdwrk04.group5.iotbay.dao;

import isdwrk04.group5.iotbay.model.AccessLog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AccessLogDAO {

    private final Connection connection;

    public AccessLogDAO() {
        connection = new DbConnector().getConnection();
    }

    public void insertLog(AccessLog log) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("insert into \"ACCESSLOG\" VALUES (" + buildQuery(log) + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String buildQuery(AccessLog log) {
        StringBuilder builder = new StringBuilder();
        builder.append(getNextLogId()).append(", ");
        builder.append("'").append(log.getUserId()).append("', ");
        builder.append("'").append(log.getEvent()).append("', ");
        builder.append("'").append(log.getEventTime()).append("', ");
        return builder.toString().trim();
    }

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

    private AccessLog createAccessLogFromResult(ResultSet result) throws SQLException {
        int logId = result.getInt("Log_ID");
        int userId = result.getInt("User_ID");
        String event = result.getString("Event");
        Timestamp eventTime = result.getTimestamp("Event_Time");
        return new AccessLog(logId, userId, event, eventTime);
    }

}
