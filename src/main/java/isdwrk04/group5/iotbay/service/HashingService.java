package isdwrk04.group5.iotbay.service;

import isdwrk04.group5.iotbay.model.Customer;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

/**
 * Service to hash and check passwords using PBKDF2
 */
public class HashingService {

    private final SecureRandom random;
    private final SecretKeyFactory keyFactory;

    public HashingService() throws NoSuchAlgorithmException {
        this.random = new SecureRandom();
        this.keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    }

    public byte[] hashPassword(byte[] salt, String password) throws InvalidKeySpecException {
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        return keyFactory.generateSecret(keySpec).getEncoded();
    }

    public byte[] createSalt() {
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public boolean checkPassword(Customer customer, String password) throws InvalidKeySpecException {
        byte[] salt = customer.getSalt();
        byte[] hashedPassword = hashPassword(salt, password);
        return Arrays.equals(hashedPassword, customer.getHashedPassword());
    }
}
