package tests;

import main.Security;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SecurityTest {

    @Test
    void createPasswordTest() throws NoSuchAlgorithmException {
        String password = "testPasswd";
        String hashedPassword = Security.toHexString(Security.createPassword(password).getHash());
        assertNotEquals(password, hashedPassword);

        // Now verify that salts are unique to each new password stored.
        String secondHashedPassword = Security.toHexString(Security.createPassword(password).getHash());
        assertNotEquals(hashedPassword, secondHashedPassword);
    }
}