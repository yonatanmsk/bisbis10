package com.att.tdp.bisbis10;

import com.att.tdp.bisbis10.DTO.RatingRequest;
import com.att.tdp.bisbis10.service.RatingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RatingControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testAddRating() throws Exception {
        // Create a RatingRequest object
        RatingRequest ratingRequest = new RatingRequest();
        ratingRequest.setRestaurantId(7L);
        ratingRequest.setRating(5);

        // Perform POST request to add rating
        mockMvc.perform(MockMvcRequestBuilders.post("/ratings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ratingRequest)))
                .andExpect(status().isOk());
    }
}