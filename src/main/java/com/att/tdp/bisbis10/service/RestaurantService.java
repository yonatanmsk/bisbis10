package com.att.tdp.bisbis10.service;
import com.att.tdp.bisbis10.model.Restaurants;
import com.att.tdp.bisbis10.repository.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurants> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public List<Restaurants> getRestaurantsByCuisine(String cuisine) {
        return restaurantRepository.findByCuisinesContaining(cuisine);
    }

    public Restaurants getRestaurantById(Long id) {
        Optional<Restaurants> optionalRestaurant = restaurantRepository.findById(id);
        return (Restaurants) ((Optional<?>) optionalRestaurant).orElse(null);
    }

    public Restaurants addRestaurant(Restaurants restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public ResponseEntity<Void> updateRestaurant(Long id, Restaurants updatedRestaurant) {
        Restaurants existingRestaurant = restaurantRepository.findById(id).orElse(null);

        if (existingRestaurant != null) {
            // Update the cuisines of the existing restaurant
            existingRestaurant.setCuisines(updatedRestaurant.getCuisines());

            // Save the updated restaurant
            restaurantRepository.save(existingRestaurant);

            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    public Restaurants updateRating(Long id, double newRating) {
        Restaurants existingRestaurant = restaurantRepository.findById(id).orElse(null);

        if (existingRestaurant != null) {
            // Update the average rating of the existing restaurant
            existingRestaurant.setAverageRating(newRating);

            // Save the updated restaurant
            return restaurantRepository.save(existingRestaurant);
        } else {
            return null; // Restaurant not found
        }
    }
}