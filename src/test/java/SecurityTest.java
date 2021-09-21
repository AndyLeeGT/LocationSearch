import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class SecurityTest {

    @Test
    void createPasswordTest() throws NoSuchAlgorithmException {
        String password = "testPasswd";
        String hashedPassword = Security.toHexString(Security.createPassword(password));
        assertNotEquals(password, hashedPassword);

        // Now verify that salts are unique to each new password stored.
        String secondHashedPassword = Security.toHexString(Security.createPassword(password));
        assertNotEquals(hashedPassword, secondHashedPassword);
    }
}