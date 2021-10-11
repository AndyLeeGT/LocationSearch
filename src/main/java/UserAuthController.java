package main.java;

import org.springframework.http.HttpStatus;
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
    public boolean putNewUser(@RequestParam(value = "username") String username, @RequestBody String password ) {
        return authManager.signUp(username, password);
    }

    @PostMapping("/users")
    public ResponseEntity<String> validateUser(@RequestBody LoginForm form) {
        try {
            boolean success = authManager.signIn(form.getUsername(), form.getPassword());
            return ResponseEntity.ok("success");
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
