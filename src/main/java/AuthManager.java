package main.java;

import com.google.cloud.datastore.*;

interface AuthManagerInterface {
    boolean signIn(String email, String password);
    boolean signUp(String email, String password);
}

public class AuthManager implements AuthManagerInterface {
    private Datastore db;
    private KeyFactory keyFactory;

    public AuthManager() {
        db = GDSFactory.getGDS();
        keyFactory = db.newKeyFactory().setKind("User");
    }

    @Override
    public boolean signIn(String email, String password) {
        PasswordParams params = fetchPasswordParams(email);]
        if (params == null) {
            return false;
        }
        boolean passwordMatches = Security.checkPassword(params, password);
        return passwordMatches;
    }

    @Override
    public boolean signUp(String email, String password) {
        PasswordParams params = Security.createPassword(password);

        // Store to GDS
        Key key = keyFactory.newKey(email);
        Entity entity = Entity.newBuilder(key)
                .set("password", String.valueOf(params.getHash()))
                .set("salt", String.valueOf(params.getSalt()))
                .build();
        if (db.put(entity) != null) {
            return true;
        }
        return false;
    }

    private PasswordParams fetchPasswordParams(String email) {
        Entity userEntity = db.get(keyFactory.newKey(email));
        try {
            String hash = userEntity.getProperties().get("password").toString();
            String salt = userEntity.getProperties().get("salt").toString();
        } catch (Exception e) {
            return null;
        }
        return new PasswordParams(hash.getBytes(), salt.getBytes());
    }
}