package unit;

import isdwrk04.group5.iotbay.model.User;
import isdwrk04.group5.iotbay.service.HashingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class HashingServiceTest {

    @Test
    public void testHashingService() throws NoSuchAlgorithmException, InvalidKeySpecException {
        HashingService hashingService = new HashingService();
        byte[] salt = hashingService.createSalt();
        byte[] hash;
        byte[] otherHash;
        hash = hashingService.hashPassword(salt, "testPassword");
        otherHash = hashingService.hashPassword(salt, "otherTestPassword");
        Assertions.assertNotEquals(hash, otherHash);

        User testUser = new User("name", "email", salt, hash, User.Role.Customer, "");

        Assertions.assertTrue(hashingService.checkPassword(testUser, "testPassword"));
        Assertions.assertFalse(hashingService.checkPassword(testUser, "testpassword"));
    }
}