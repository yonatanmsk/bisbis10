package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.model.Dish;
import com.att.tdp.bisbis10.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/restaurants/{restaurantId}/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    // add dish to given restaurants
    @PostMapping
    public ResponseEntity<Void> addDish(@PathVariable Long restaurantId, @RequestBody Dish dish) {
        dishService.addDish(restaurantId, dish);
        return ResponseEntity.status(201).build();
    }

    // update requested dish
    @PutMapping("/{dishId}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long restaurantId, @PathVariable Long dishId, @RequestBody Dish dishDetails) {
        dishService.updateDish(restaurantId, dishId, dishDetails);
        return ResponseEntity.ok().build();
    }

    // delete dish by id
    @DeleteMapping("/{dishId}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long restaurantId, @PathVariable Long dishId) {
        dishService.deleteDish(restaurantId, dishId);
        return ResponseEntity.noContent().build();
    }

    // get dish by restaurants
    @GetMapping
    public ResponseEntity<List<Dish>> getDishesByRestaurant(@PathVariable Long restaurantId) {
        List<Dish> dishes = dishService.getDishesByRestaurantId(restaurantId);
        return ResponseEntity.ok(dishes);
    }
}