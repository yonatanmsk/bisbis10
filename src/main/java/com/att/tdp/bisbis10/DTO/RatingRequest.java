package com.att.tdp.bisbis10.DTO;

public class RatingRequest {

    private Long restaurantId;
    private double rating;

    // Getters
    public Long getRestaurantId() {
        return restaurantId;
    }

    public double getRating() {
        return rating;
    }

    // Setters
    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}