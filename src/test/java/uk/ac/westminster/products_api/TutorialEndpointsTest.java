package uk.ac.westminster.products_api;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TutorialEndpointsTest {
    @Autowired private MockMvc mvc;

    @Test void weekOneGreetings() throws Exception {
        mvc.perform(get("/hello")).andExpect(status().isOk())
            .andExpect(content().string("Hello from Spring Boot!"));
        mvc.perform(get("/goodbye")).andExpect(status().isOk())
            .andExpect(content().string("Goodbye from Spring Boot!"));
    }

    @Test void weekOneStretchEndpoints() throws Exception {
        mvc.perform(get("/status")).andExpect(status().isOk())
            .andExpect(content().string("API is running — Tutorial 1 — " + LocalDate.now()));
        mvc.perform(get("/info")).andExpect(status().isOk())
            .andExpect(content().string("Products API — completed Tutorials 1 and 2: encapsulation, JSON and UML."));
    }

    @Test void productIncludesAllFieldsAndUsesPathId() throws Exception {
        mvc.perform(get("/products/1")).andExpect(status().isOk())
            .andExpect(content().json("{\"id\":1,\"name\":\"Laptop\",\"price\":999.99}"));
        mvc.perform(get("/products/7")).andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(7));
    }

    @Test void customerContainsCompleteNestedAddress() throws Exception {
        mvc.perform(get("/customers/1")).andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("Ada Lovelace"))
            .andExpect(jsonPath("$.email").value("ada@example.com"))
            .andExpect(jsonPath("$.address.street").value("115 New Cavendish Street"))
            .andExpect(jsonPath("$.address.city").value("London"))
            .andExpect(jsonPath("$.address.postcode").value("W1W 6UW"));
    }

    @Test void swaggerDocumentsEveryTutorialEndpoint() throws Exception {
        mvc.perform(get("/v3/api-docs")).andExpect(status().isOk())
            .andExpect(jsonPath("$.paths['/hello']").exists())
            .andExpect(jsonPath("$.paths['/goodbye']").exists())
            .andExpect(jsonPath("$.paths['/status']").exists())
            .andExpect(jsonPath("$.paths['/info']").exists())
            .andExpect(jsonPath("$.paths['/products/{id}']").exists())
            .andExpect(jsonPath("$.paths['/customers/{id}']").exists());
        mvc.perform(get("/swagger-ui.html")).andExpect(status().is3xxRedirection());
        mvc.perform(get("/swagger-ui/index.html")).andExpect(status().isOk());
    }
}
