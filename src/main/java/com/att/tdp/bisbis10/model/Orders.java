package com.att.tdp.bisbis10.model;

import jakarta.persistence.*;

//import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Orders {

    @Id
    private UUID orderId;
    private Long restaurantId;

    @ElementCollection
    @CollectionTable(name = "order_item", joinColumns = @JoinColumn(name = "order_id"))
    private List<OrderItem> orderItems;

    public Orders() {
        this.orderId = UUID.randomUUID();
    }

    public Orders(Long restaurantId, List<OrderItem> orderItems) {
        this();
        this.restaurantId = restaurantId;
        this.orderItems = orderItems;
    }

    // Getters and setters

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Embeddable
    public static class OrderItem {

        private Long dishId;
        private int amount;

        public OrderItem() {
        }

        public OrderItem(Long dishId, int amount) {
            this.dishId = dishId;
            this.amount = amount;
        }

        // Getters and setters

        public Long getDishId() {
            return dishId;
        }

        public void setDishId(Long dishId) {
            this.dishId = dishId;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }
}


