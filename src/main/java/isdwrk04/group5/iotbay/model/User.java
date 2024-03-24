package isdwrk04.group5.iotbay.model;

import java.io.Serializable;

public abstract class User implements Serializable {

    private final String username;
    private final String email;
    private final byte[] hashedPassword;
    private final byte[] salt;

    public User(String username, String email, byte[] salt, byte[] hashedPassword) {
        this.username = username;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
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
}
