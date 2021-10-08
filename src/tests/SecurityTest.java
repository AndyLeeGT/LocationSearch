package tests;

import main.java.PasswordParams;
import main.java.Security;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void comparePasswordTest() {
        String password = "testPasswd";
        PasswordParams hashedPassword = Security.createPassword(password);
        assertTrue(Security.checkPassword(hashedPassword, password));
    }
}