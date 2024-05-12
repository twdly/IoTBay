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

    public AccessLog createAccessLogFromResult(ResultSet result) throws SQLException {
        int logId = result.getInt("Log_ID");
        int userId = result.getInt("User_ID");
        String event = result.getString("Event");
        Timestamp eventTime = result.getTimestamp("Event_Time");
        return new AccessLog(logId, userId, event, eventTime);
    }

}
