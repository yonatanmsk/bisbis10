package com.att.tdp.bisbis10.DTO;

import com.att.tdp.bisbis10.model.Orders;

import java.util.List;

public class OrderRequest {

    private Long restaurantId;
    private List<Orders.OrderItem> orderItems;

    public OrderRequest() {
    }

    public OrderRequest(Long restaurantId, List<Orders.OrderItem> orderItems) {
        this.restaurantId = restaurantId;
        this.orderItems = orderItems;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<Orders.OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Orders.OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}