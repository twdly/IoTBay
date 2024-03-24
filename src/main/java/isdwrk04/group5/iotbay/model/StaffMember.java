package isdwrk04.group5.iotbay.model;

public class StaffMember extends User {
    public StaffMember(String username, String email, byte[] salt, byte[] hashedPassword) {
        super(username, email, salt, hashedPassword);
    }
}
