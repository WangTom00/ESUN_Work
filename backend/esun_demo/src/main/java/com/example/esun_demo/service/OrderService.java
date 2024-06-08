package com.example.esun_demo.service;

import com.example.esun_demo.entity.Order;
import com.example.esun_demo.entity.OrderDetail;
import com.example.esun_demo.entity.Product;
import com.example.esun_demo.repository.OrderRepository;
import com.example.esun_demo.repository.OrderDetailRepository;
import com.example.esun_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Order createOrder(Order order, List<OrderDetail> orderDetails) {
        for (OrderDetail detail : orderDetails) {
            Product product = productRepository.findById(detail.getProductId()).orElseThrow();
            if (product.getQuantity() < detail.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }
            product.setQuantity(product.getQuantity() - detail.getQuantity());
            productRepository.save(product);
        }
        orderRepository.save(order);
        orderDetailRepository.saveAll(orderDetails);
        return order;
    }
}
