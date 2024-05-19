package com.att.tdp.bisbis10.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonPropertyOrder({ "id", "name", "averageRating", "isKosher", "cuisines" })
public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    @JsonIgnore
    private List<Double> ratings = new ArrayList<>();;

    private double averageRating;
    private boolean isKosher;

    @ElementCollection
    private List<String> cuisines;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Dish> dishes;

    public Restaurants() {
        this.ratings = new ArrayList<>();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("averageRating")
    public double getAverageRating() {
        return ratings.isEmpty() ? 0.0 : ratings.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    @JsonProperty("isKosher")
    public boolean isKosher() {
        return isKosher;
    }

    public void setKosher(boolean kosher) {
        isKosher = kosher;
    }

    public List<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }

    public List<Double> getRatings() {
        return ratings;
    }

    public void setRatings(List<Double> ratings) {
        this.ratings = ratings;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}