package main.java;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import java.util.Collections;

@SpringBootApplication
public class InterestingPlacesApp {
    public static void main(String args[]) {
        String port = System.getenv("PORT");
        if (port == null) {
            port = "8080";
        }
        SpringApplication app = new SpringApplication(InterestingPlacesApp.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", port));
        app.run(args);
    }
}
