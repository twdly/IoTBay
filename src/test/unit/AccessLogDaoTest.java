package unit;

import isdwrk04.group5.iotbay.dao.AccessLogDAO;
import isdwrk04.group5.iotbay.model.AccessLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for the AccessLogDAO class.

public class AccessLogDaoTest {
    private AccessLogDAO dao;

//    Setup method to create a new DAO instance before each test
    @BeforeEach
    public void before() {
        dao = new AccessLogDAO();
    }

//    Test for inserting and deleting a log
    @Test
    public void testInsertDeleteLog() {
        AccessLog log = new AccessLog(1001, "logout");
        dao.insertLog(log);
        List<AccessLog> logs = dao.getLogsByUser(1001);
        assertTrue(logs.stream().anyMatch(l -> l.getEvent().equals("logout")));

        dao.deleteAccessLog(log.getLogId());
        logs = dao.getLogsByUser(1001);
        assertTrue(logs.stream().noneMatch(user -> user.getEvent().equals("logout")));
    }

//    Test for getting logs by user ID
    @Test
    public void testGetLogsByUser() {
        List<AccessLog> logs = dao.getLogsByUser(1);
        assertTrue(logs.isEmpty());

        logs = dao.getLogsByUser(1001);
        assertFalse(logs.isEmpty());
        assertEquals("registration", logs.get(0).getEvent());
    }

//    Test for getting logs by date
    @Test
    public void testGetLogsByDate() {
        List<AccessLog> logs = dao.getLogsByDate(1001, "2000-05-15");
        assertTrue(logs.isEmpty());

        logs = dao.getLogsByDate(1001, "2024-05-16");
        assertFalse(logs.isEmpty());
        assertEquals("registration", logs.get(0).getEvent());
    }
}
