package main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.GET;

@RestController

public class UserAuthController {
    private AuthManager authManager;

    @PutMapping("/users")
    public boolean putNewUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password ) {
        return authManager.signUp(username, password);
    }

    @GetMapping("/users")
    public boolean validateUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        return authManager.signIn(username, password);
    }
}
