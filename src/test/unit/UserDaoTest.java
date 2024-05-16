package unit;

import isdwrk04.group5.iotbay.dao.UserDao;
import isdwrk04.group5.iotbay.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {

    public UserDao dao;

    @BeforeEach
    public void before() {
        dao = new UserDao();
    }

    @Test
    public void testAddAndDeleteUser() {
        List<User> users = dao.getAllUsers();
        assertTrue(users.stream().noneMatch(user -> user.getUsername().equals("Creation Test")));

        dao.addUser(new User("Creation Test", "testemail@gmail.com", new byte[16], new byte[16], User.Role.Customer, ""));
        users = dao.getAllUsers();
        assertTrue(users.stream().anyMatch(user -> user.getUsername().equals("Creation Test")));

        dao.deleteUser("testemail@gmail.com");
        users = dao.getAllUsers();
        assertTrue(users.stream().noneMatch(user -> user.getUsername().equals("Creation Test")));
    }

    @Test
    public void testGetUserByEmail() {
        User user = dao.getUserByEmail("fakeemail@gmail.com");
        assertNull(user);

        user = dao.getUserByEmail("johnshep@email.com");
        assertNotNull(user);
        assertEquals("John Sheppard", user.getUsername());
    }
}
