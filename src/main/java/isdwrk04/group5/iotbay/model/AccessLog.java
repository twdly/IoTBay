package isdwrk04.group5.iotbay.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

//Represents an access log entry in the system

public class AccessLog implements Serializable {

//    Unique identifier for the log entry
    private int logId;

//    Id of the user associated with the log entry
    private final int userId;

//    Description of the event associated with the log entry
    private final String event;

//    Timestamp of when the event occurred
    private final Timestamp eventTime;

//    Constructor for creating a new access log
    public AccessLog(int userId, String event) {
        this.logId = 0;
        this.userId = userId;
        this.event = event;
        this.eventTime = Timestamp.valueOf(LocalDateTime.now());
    }

//    Constructor for creating a new access log with existing data
    public AccessLog(int logId, int userId, String event, Timestamp eventTime) {
        this.logId = logId;
        this.userId = userId;
        this.event = event;
        this.eventTime = eventTime;
    }

//    Getter method for retrieving the log id
    public  int getLogId() {
        return logId;
    }

//    Getter method for retrieving the user id
    public int getUserId() { return userId; }

//    Getter method for retrieving the event type
    public String getEvent() {
        return event;
    }

//    Getter method for retrieving the event time
    public Timestamp getEventTime() {
        return eventTime;
    }

//    Setter method for retrieving the log id
    public void setLogId(int id) {
        this.logId = id;
    }

}
