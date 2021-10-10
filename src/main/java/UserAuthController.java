package main.java;

import org.springframework.web.bind.annotation.*;

@RestController

public class UserAuthController {
    private AuthManager authManager;

    public UserAuthController() {
        try {
            authManager = new AuthManager();
        } catch (Exception e) {
            System.out.println("[WARN]: " + e.getLocalizedMessage());
            authManager = null;
        }
    }

    @PutMapping("/users")
    public boolean putNewUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password ) {
        return authManager.signUp(username, password);
    }

    @GetMapping("/users")
    public boolean validateUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password ) {
        return authManager.signIn(username, password);
    }
}
