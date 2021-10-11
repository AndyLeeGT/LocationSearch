package main.java;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> putNewUser(@RequestBody LoginForm form ) {
        try {
            boolean success = authManager.signUp(form.getUsername(), form.getPassword());
            if (success) {
                return ResponseEntity.ok("success");
            } else {
                return ResponseEntity.badRequest().body("Failed to create user");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to create user, user already exists.");
        }
    }

    @PostMapping("/users")
    public ResponseEntity<String> validateUser(@RequestBody LoginForm form) {
        try {
            boolean success = authManager.signIn(form.getUsername(), form.getPassword());
            if (success) {
                return ResponseEntity.ok("success");
            } else {
                return ResponseEntity.badRequest().body("Failed to validate password");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to validate user");
        }
    }
}

class LoginForm {
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
