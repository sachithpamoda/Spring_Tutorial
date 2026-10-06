package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Tutorial 1 optional stretch task.
@RestController
public class InfoController {
    @GetMapping("/info")
    public String info() {
        return "Products API — completed Tutorials 1 and 2: encapsulation, JSON and UML.";
    }
}
