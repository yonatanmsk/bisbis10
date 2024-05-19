package com.att.tdp.bisbis10.repository;

import com.att.tdp.bisbis10.model.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants, Long> {
    List<Restaurants> findByCuisinesContaining(String cuisine);
    Restaurants findById(long id);
}