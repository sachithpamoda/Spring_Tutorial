package uk.ac.westminster.products_api;

import java.time.LocalDate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "Goodbye from Spring Boot!";
    }

    // Includes Tutorial 1's optional date exercise.
    @GetMapping("/status")
    public String status() {
        return "API is running — Tutorial 1 — " + LocalDate.now();
    }
}
