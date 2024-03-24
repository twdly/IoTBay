package isdwrk04.group5.iotbay.model;

public class Customer extends User {

    public Customer(String username, String email, byte[] salt, byte[] hashedPassword) {
        super(username, email, salt, hashedPassword);
    }
}
