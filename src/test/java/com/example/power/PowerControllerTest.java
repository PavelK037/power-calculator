package com.example.power;

import com.example.power.dto.PowerRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PowerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCalculatePowerSuccessfully() throws Exception {
        PowerRequest request = new PowerRequest(2.0, 3.0);

        mockMvc.perform(post("/api/v1/power")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "x": 2.0,
                            "y": 3.0
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(8.0));
    }
}