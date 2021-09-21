import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Security {

    private static byte[] getSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte

        return md.digest(input.getBytes(StandardCharsets.UTF_8));
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
    public static byte[] createPassword(String password) throws NoSuchAlgorithmException {
        // Generate salt
        byte[] salt = getSalt();
        String string_salt = toHexString(salt);
        String saltedPassword = string_salt + password;
        try {
            byte[] result = getSHA(saltedPassword);
            return result;
        } catch(Exception e) {
            throw new NoSuchAlgorithmException("The password could not be created due to an issue with the encryption algorithm");
        }


        //TODO: Store hashed password to google storage.
    }
    public static boolean checkPassword(byte[] password, byte[] password2){

        if(password == password2){
            return true;
        }
        else{
            return false;
        }

    }












}
