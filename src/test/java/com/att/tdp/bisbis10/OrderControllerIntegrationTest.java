package com.att.tdp.bisbis10;

import com.att.tdp.bisbis10.DTO.OrderRequest;
import com.att.tdp.bisbis10.service.OrderService;
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
public class OrderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderService orderService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testPlaceOrder() throws Exception {
        // Create an OrderRequest object
        OrderRequest orderRequest = new OrderRequest();
        // Set order details as needed

        // Perform POST request to place an order
        mockMvc.perform(MockMvcRequestBuilders.post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderId").exists());
    }
}