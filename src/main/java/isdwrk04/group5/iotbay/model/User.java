package isdwrk04.group5.iotbay.model;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private final String username;
    private final String email;
    private final byte[] hashedPassword;
    private final byte[] salt;
    private final Role role;
    private String phoneNo;

    public enum Role {
        Staff,
        Customer
    }

    // This constructor is used for registration as the user ID is not yet known
    public User(String username, String email, byte[] salt, byte[] hashedPassword, Role role, String phoneNo) {
        this.id = 0;
        this.username = username;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
        this.role = role;
        this.phoneNo = phoneNo;
    }

    // This constructor is used after the user has registered as they have already been assigned an ID
    public User(int id, String username, String email, byte[] hashedPassword, byte[] salt, Role role, String phoneNo) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
        this.role = role;
        this.phoneNo = phoneNo;
    }

    public User() {
        this.id = 0;
        this.username = "";
        this.email = "";
        this.hashedPassword = new byte[0];
        this.salt = new byte[0];
        this.role = Role.Customer;
        this.phoneNo = "";
    }

    public int getId() {
        return this.id;
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

    public String getPhoneNo() {
        return null != phoneNo ? phoneNo : "";
    }

    public void setId(int id) {
        this.id = id;
    }

//    public void setEmail(String email) {this.email = email;}

//    public void setUsername(String name) {this.username = name;}

//    public void setHashedPassword(byte[] hashedPassword) {this.hashedPassword = hashedPassword;}

//    public void setSalt(byte[] salt) {this.salt = salt;}

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
