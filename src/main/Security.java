package main;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;

public class Security {

    private static byte[] getSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private static MessageDigest makeHasher() {
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (Exception e) {
            return null;
        }
    }

    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    public static PasswordParams createPassword(String password) {
        // Generate salt
        byte[] salt = getSalt();
        byte[] pass = password.getBytes();

        MessageDigest md = Security.makeHasher();
        md.update(salt);
        byte[] hash = md.digest(pass);
        return new PasswordParams(hash, salt);
    }

    public static boolean checkPassword(PasswordParams params, String password){
        MessageDigest md = Security.makeHasher();
        md.update(params.getSalt());
        byte[] hashedPassword = md.digest(password.getBytes());
        return Arrays.equals(hashedPassword, params.getHash());

    }
}
