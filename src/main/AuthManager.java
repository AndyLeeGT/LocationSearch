package main;

interface AuthManagerInterface {
    boolean signIn(String email, String password);
    boolean signUp(String email, String password);
}

public class AuthManager implements AuthManagerInterface {
    public static AuthManager shared = new AuthManager();

    private AuthManager() { }


    @Override
    public boolean signIn(String email, String password) {
        PasswordParams params = fetchPasswordParams(email);
        boolean passwordMatches = Security.checkPassword(params, password);
        return passwordMatches;
    }

    @Override
    public boolean signUp(String email, String password) {
        PasswordParams params = Security.createPassword(password);
        // TODO: Create new user in the database
        return true;
    }

    private PasswordParams fetchPasswordParams(String email) {
        return new PasswordParams(new byte[2], new byte[2]);
    }
}