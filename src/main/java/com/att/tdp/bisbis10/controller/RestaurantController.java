package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.model.Restaurants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.att.tdp.bisbis10.service.RestaurantService;
//import service.e;

import java.util.List;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<List<Restaurants>> getAllRestaurants() {
        List<Restaurants> restaurants = restaurantService.getAllRestaurants();
        for (Restaurants restaurant : restaurants) {
            restaurant.setDishes(null);
        }
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/by-cuisine")
    public ResponseEntity<List<Restaurants>> getRestaurantsByCuisine(@RequestParam String cuisine) {
        List<Restaurants> restaurants = restaurantService.getRestaurantsByCuisine(cuisine);
        for (Restaurants restaurant : restaurants) {
            restaurant.setDishes(null);
        }
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurants> getRestaurantById(@PathVariable Long id) {
        Restaurants restaurant = restaurantService.getRestaurantById(id);
        if (restaurant != null) {
            return ResponseEntity.ok(restaurant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> addRestaurant(@RequestBody Restaurants restaurant) {
        restaurantService.addRestaurant(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRestaurant(@PathVariable Long id, @RequestBody Restaurants updatedRestaurant) {
        ResponseEntity<Void> restaurant = restaurantService.updateRestaurant(id, updatedRestaurant);
        if (restaurant != null) {
            return ResponseEntity.ok().build(); // Return 200 OK status
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found status
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }
}