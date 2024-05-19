package com.att.tdp.bisbis10;

import com.att.tdp.bisbis10.model.Dish;
import com.att.tdp.bisbis10.service.DishService;
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
public class DishControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DishService dishService;

    // Manually create ObjectMapper
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testAddDish() throws Exception {
        Dish dish = new Dish();
        // Set dish properties as needed

        mockMvc.perform(MockMvcRequestBuilders.post("/restaurants/{restaurantId}/dishes", 3L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dish)))
                .andExpect(status().isCreated());
    }

    @Test
    void testUpdateDish() throws Exception {
        Dish dishDetails = new Dish();
        // Set updated dish details as needed

        mockMvc.perform(MockMvcRequestBuilders.put("/restaurants/{restaurantId}/dishes/{dishId}", 3L, 12L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dishDetails)))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteDish() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/restaurants/{restaurantId}/dishes/{dishId}", 3L, 12L))
                .andExpect(status().isNoContent());
    }

    @Test
    void testGetDishesByRestaurant() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants/{restaurantId}/dishes", 3L))
                .andExpect(status().isOk());
    }
}