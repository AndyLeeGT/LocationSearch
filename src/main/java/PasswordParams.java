package main.java;

public class PasswordParams {
    private byte[] hash;
    private byte[] salt;

    public PasswordParams(byte[] hash, byte[] salt) {
        this.hash = hash;
        this.salt = salt;
    }

    public byte[] getSalt() {
        return salt;
    }

    public byte[] getHash() {
        return hash;
    }
}
