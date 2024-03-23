package isdwrk04.group5.iotbay.model;

public class Customer extends User {

    private final String username;
    private final byte[] hashedPassword;
    private final byte[] salt;

    public Customer(String username, byte[] salt, byte[] hashedPassword) {
        this.username = username;
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
}
