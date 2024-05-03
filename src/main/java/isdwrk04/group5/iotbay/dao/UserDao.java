package isdwrk04.group5.iotbay.dao;

import isdwrk04.group5.iotbay.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao {

    private final Connection connection;

    public UserDao() {
        connection = new DbConnector().getConnection();
    }

    public void addUser(User user) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("insert into \"USER\" VALUES (" + buildInsertQuery(user) + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from \"USER\"");
            while (results.next()) {
                users.add(new User(results.getString("NAME"), results.getString("EMAIL_ADDRESS"), results.getString("PASSWORD_SALT").getBytes(), results.getString("PASSWORD_HASH").getBytes(), getRoleFromString(results.getString("USER_TYPE"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public User getUserByEmail(String email) {
        Optional<User> foundUser = getAllUsers().stream().filter(x -> x.getEmail().equals(email)).findFirst();
        return foundUser.orElse(null);
    }

    private int getNextUserId() {
        int foundId;
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select max(USER_ID) as ID from \"USER\"");
            result.next();
            foundId = result.getInt("ID") + 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return foundId;
    }

    private User.Role getRoleFromString(String role) {
        if (role.equals(User.Role.Customer.name())) {
            return User.Role.Customer;
        } else {
            return User.Role.Staff;
        }
    }

    public String buildInsertQuery(User user) {
        StringBuilder builder = new StringBuilder();
        builder.append(getNextUserId()).append(", ");
        builder.append("'").append(user.getEmail()).append("', ");
        builder.append("'").append(new String(user.getHashedPassword())).append("', ");
        builder.append("'").append(new String(user.getSalt())).append("', ");
        builder.append("'").append(user.getUsername()).append("', ");
        builder.append("'").append("92").append("', ");
        builder.append("'").append(user.getRole()).append("'");
        return builder.toString().trim();
    }
}
