package main;

public class PasswordParams {
    byte[] hash;
    byte[] salt;

    public PasswordParams(byte[] hash, byte[] salt) {
        this.hash = hash;
        this.salt = salt;
    }
}
