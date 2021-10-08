package main.java;

import main.java.AuthManager;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserAuthController {
    private AuthManager authManager;

    public UserAuthController() {
        try {
            authManager = new AuthManager();
        } catch (Exception e) {
            authManager = null;
        }
    }

    @PutMapping("/users")
    public boolean putNewUser(@RequestParam(value = "username") String username, @RequestBody String password ) {
        return authManager.signUp(username, password);
    }

    @GetMapping("/users")
    public boolean validateUser(@RequestParam(value = "username") String username, @RequestBody String password ) {
        return authManager.signIn(username, password);
    }
}
