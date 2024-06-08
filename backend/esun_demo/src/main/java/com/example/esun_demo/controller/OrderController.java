package com.example.esun_demo.controller;

import com.example.esun_demo.entity.Order;
import com.example.esun_demo.entity.OrderDetail;
import com.example.esun_demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order, @RequestBody List<OrderDetail> orderDetails) {
        Order createdOrder = orderService.createOrder(order, orderDetails);
        return ResponseEntity.ok(createdOrder);
    }
}