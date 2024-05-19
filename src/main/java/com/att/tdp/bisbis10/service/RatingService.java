package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.model.Restaurants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DecimalFormat;

@Service
public class RatingService {

    @Autowired
    private RestaurantService restaurantService;

    public void addRating(Long restaurantId, double rating) {
        // Validate rating
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating should be between 0 and 5");
        }

        // Get the restaurant by ID
        Restaurants restaurant = restaurantService.getRestaurantById(restaurantId);
        if (restaurant == null) {
            throw new RuntimeException("Restaurant not found with ID: " + restaurantId);
        }

        restaurant.getRatings().add(rating);
        double newRating = calculateAverageRating(restaurant, rating);
        DecimalFormat df = new DecimalFormat("#.##");
        newRating = Double.parseDouble(df.format(newRating));
        // Add the rating to the restaurant
        restaurant.setAverageRating(newRating);

        // Update the restaurant in the database
        restaurantService.updateRating(restaurant.getId(), newRating);
    }

    private double calculateAverageRating(Restaurants restaurant, double newRating) {
        // Calculate the new sum of ratings by adding the new rating to the existing sum of ratings
        double currentSumOfRatings = 0.0;
        for (Double rating : restaurant.getRatings()) {
            currentSumOfRatings += rating;
        }
        // Add the new rating to the sum of ratings
        currentSumOfRatings += newRating;

        // Calculate the new average rating
        int totalRatings = restaurant.getRatings().size();
        return currentSumOfRatings / (totalRatings + 1);
    }
}