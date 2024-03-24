package isdwrk04.group5.iotbay.dao;

import isdwrk04.group5.iotbay.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao {

    private static List<User> users;

    public UserDao() {
        if (users == null) {
            users = new ArrayList<>();
        }
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserByEmail(String email) {
        Optional<User> foundUser = users.stream().filter(x -> x.getEmail().equals(email)).findFirst();
        return foundUser.orElse(null);
    }
}
