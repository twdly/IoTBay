package isdwrk04.group5.iotbay.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AccessLog implements Serializable {

    private int logId;

    private final int userId;

    private final String event;

    private final Timestamp eventTime;

    public AccessLog(int logId, int userId, String event) {
        this.logId = logId;
        this.userId = userId;
        this.event = event;
        this.eventTime = Timestamp.valueOf(LocalDateTime.now());
    }

    public AccessLog(int userId, String event) {
        this.logId = 0;
        this.userId = userId;
        this.event = event;
        this.eventTime = Timestamp.valueOf(LocalDateTime.now());
    }

    public AccessLog(int logId, int userId, String event, Timestamp eventTime) {
        this.logId = 0;
        this.userId = userId;
        this.event = event;
        this.eventTime = eventTime;
    }

    public  int getLogId() {
        return logId;
    }

    public int getUserId() { return userId; }

    public String getEvent() {
        return event;
    }

    public Timestamp getEventTime() {
        return eventTime;
    }

    public void setLogId(int id) {
        this.logId = id;
    }

}
