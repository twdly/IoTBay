package isdwrk04.group5.iotbay.dao;

import isdwrk04.group5.iotbay.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

public class UserDao {

    private final Connection connection;

    public UserDao() {
        connection = new DbConnector().getConnection();
    }

    public void addUser(User user) {
        try {
            int id = getNextUserId();
            user.setId(id);
            PreparedStatement statement = connection.prepareStatement("insert into \"USER\" values (?, ?, ?, ?, ?, ?, ?)");
            buildInsertQuery(user, statement);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    Updates the user details in the database
    public void updateUserDetails(User user) {
        try {
//            Prepare the SQL statement to update the user details
            PreparedStatement statement = connection.prepareStatement("update \"USER\" set EMAIL_ADDRESS=?, PASSWORD_HASH=?, PASSWORD_SALT=?, NAME=?, PHONE=? where USER_ID=?");
//            Set the parameters for the SQL statement
            statement.setString(1, user.getEmail());
            statement.setString(2, Base64.getEncoder().encodeToString(user.getHashedPassword()));
            statement.setString(3, Base64.getEncoder().encodeToString(user.getSalt()));
            statement.setString(4, user.getUsername());
            statement.setString(5, user.getPhoneNo());
            statement.setInt(6, user.getId());
//            Execute the SQL statement
            statement.execute();
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
                users.add(new User(results.getInt("USER_ID"), results.getString("NAME"), results.getString("EMAIL_ADDRESS"), Base64.getDecoder().decode(results.getString("PASSWORD_HASH")), Base64.getDecoder().decode(results.getString("PASSWORD_SALT")), getRoleFromString(results.getString("USER_TYPE")), results.getString("PHONE")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    // This method is used for testing only
    public void deleteUser(String email) {
        try {
            PreparedStatement statement = connection.prepareStatement("select USER_ID as ID from \"USER\" where EMAIL_ADDRESS=?");
            statement.setString(1, email);
            ResultSet results = statement.executeQuery();
            int id = 0;
            if (results.next()) {
                id = results.getInt("ID");
            }

            statement = connection.prepareStatement("delete from \"ACCESSLOG\" where USER_ID=?");
            statement.setInt(1, id);
            statement.execute();

            statement = connection.prepareStatement("delete from \"USER\" where EMAIL_ADDRESS=?");
            statement.setString(1, email);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

    public void buildInsertQuery(User user, PreparedStatement statement) throws SQLException {
        statement.setInt(1, getNextUserId());
        statement.setString(2, user.getEmail());
        statement.setString(3, Base64.getEncoder().encodeToString(user.getHashedPassword()));
        statement.setString(4, Base64.getEncoder().encodeToString(user.getSalt()));
        statement.setString(5, user.getUsername());
        statement.setString(6, user.getPhoneNo());
        statement.setString(7, user.getRole().name());
    }
}
