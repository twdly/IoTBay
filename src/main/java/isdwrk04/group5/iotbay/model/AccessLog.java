package isdwrk04.group5.iotbay.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class AccessLog implements Serializable {

    private int logId;

    private int userId;

    private String event;

    private Timestamp eventTime;

    public AccessLog(int logId, int userId, String event, Timestamp eventTime) {
        this.logId = logId;
        this.userId = userId;
        this.event = event;
        this.eventTime = eventTime;
    }

    public  int getLogId() {
        return logId;
    }

    public int getUserId() {
        return userId;
    }

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
