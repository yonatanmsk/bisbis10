package com.att.tdp.bisbis10.service;
import com.att.tdp.bisbis10.DTO.OrderRequest;
import com.att.tdp.bisbis10.model.Orders;
import com.att.tdp.bisbis10.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public UUID placeOrder(OrderRequest orderRequest) {
        Orders order = new Orders(orderRequest.getRestaurantId(), orderRequest.getOrderItems());
        orderRepository.save(order);
        return order.getOrderId();
    }
}