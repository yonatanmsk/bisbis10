package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.model.Dish;
import com.att.tdp.bisbis10.model.Restaurants;
import com.att.tdp.bisbis10.repository.DishRepository;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Dish addDish(Long restaurantId, Dish dish) {
        Restaurants restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        if (restaurant == null) { // check if existing restaurants
            throw new RuntimeException("Restaurant not found with ID: " + restaurantId);
        }
        dish.setRestaurant(restaurant);
        return dishRepository.save(dish);
    }

    public Dish updateDish(Long restaurantId, Long dishId, Dish dishDetails) {
        Dish dish = dishRepository.findById(dishId).orElse(null);
        if (dish == null || !dish.getRestaurant().getId().equals(restaurantId)) { // check if existing restaurants and dish
            throw new RuntimeException("Dish not found with ID: " + dishId + " for restaurant ID: " + restaurantId);
        }
        dish.setDescription(dishDetails.getDescription());
        dish.setPrice(dishDetails.getPrice());
        return dishRepository.save(dish);
    }

    public void deleteDish(Long restaurantId, Long dishId) {
        Dish dish = dishRepository.findById(dishId).orElse(null);
        if (dish == null || !dish.getRestaurant().getId().equals(restaurantId)) { // check if existing restaurants
            throw new RuntimeException("Dish not found with ID: " + dishId + " for restaurant ID: " + restaurantId);
        }
        dishRepository.delete(dish);
    }

    public List<Dish> getDishesByRestaurantId(Long restaurantId) {
        return dishRepository.findByRestaurantId(restaurantId);
    }
}