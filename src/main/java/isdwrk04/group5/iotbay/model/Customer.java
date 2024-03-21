package isdwrk04.group5.iotbay.model;

public class Customer extends User {

    private final String username;
    private final String password;

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
