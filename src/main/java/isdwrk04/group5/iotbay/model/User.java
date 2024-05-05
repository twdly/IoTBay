package isdwrk04.group5.iotbay.model;

import java.io.Serializable;

public class User implements Serializable {

    private final String username;
    private final String email;
    private final byte[] hashedPassword;
    private final byte[] salt;
    private final Role role;

    public enum Role {
        Staff,
        Customer
    }

    public User(String username, String email, byte[] salt, byte[] hashedPassword, Role role) {
        this.username = username;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
        this.role = role;
    }

    public User() {
        this.username = "";
        this.email = "";
        this.hashedPassword = new byte[0];
        this.salt = new byte[0];
        this.role = Role.Customer;
    }

    public String getUsername() {
        return username;
    }

    public byte[] getHashedPassword() {
        return hashedPassword;
    }

    public byte[] getSalt() {
        return salt;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }
}
