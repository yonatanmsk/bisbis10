package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.DTO.OrderRequest;
import com.att.tdp.bisbis10.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Map<String, String>> placeOrder(@RequestBody OrderRequest orderRequest) {
        UUID orderId = orderService.placeOrder(orderRequest);
        Map<String, String> response = new HashMap<>();
        response.put("orderId", orderId.toString());
        return ResponseEntity.ok().body(response);
    }
}