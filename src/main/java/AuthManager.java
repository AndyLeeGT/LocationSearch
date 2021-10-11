package main.java;

import com.google.cloud.datastore.*;

import java.util.Base64;

interface AuthManagerInterface {
    boolean signIn(String email, String password) throws AuthException;
    boolean signUp(String email, String password) throws AuthException;
}

public class AuthManager implements AuthManagerInterface {
    private Datastore db;
    private KeyFactory keyFactory;

    public AuthManager() {
        db = GDSFactory.getGDS();
        keyFactory = db.newKeyFactory().setKind("User");
    }

    @Override
    public boolean signIn(String email, String password) throws AuthException {
        PasswordParams params = fetchPasswordParams(email);
        if (params == null) {
            return false;
        }
        boolean passwordMatches = Security.checkPassword(params, password);
        return passwordMatches;
    }

    @Override
    public boolean signUp(String email, String password) throws AuthException {
        PasswordParams params = Security.createPassword(password);

        Entity userEntity = db.get(keyFactory.newKey(email));
        if (userEntity != null) {
            throw new AuthException("User already exists. Cannot create new user.");
        }

        // Store to GDS
        Key key = keyFactory.newKey(email);
        Entity entity = Entity.newBuilder(key)
                .set("password", Base64.getEncoder().encodeToString(params.getHash()))
                .set("salt", Base64.getEncoder().encodeToString(params.getSalt()))
                .build();
        if (db.put(entity) != null) {
            return true;
        }
        return false;
    }

    private PasswordParams fetchPasswordParams(String email) throws AuthException {
        Entity userEntity = db.get(keyFactory.newKey(email));
        if (userEntity == null) {
            throw new AuthException("Could not find a user based on email");
        }
        String hash = userEntity.getProperties().get("password").get().toString();
        String salt = userEntity.getProperties().get("salt").get().toString();
        return new PasswordParams(Base64.getDecoder().decode(hash), Base64.getDecoder().decode(salt));
    }
}

class AuthException extends Exception {
    public AuthException(String message) {
        super(message);
    }
}