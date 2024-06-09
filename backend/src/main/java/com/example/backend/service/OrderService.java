package com.example.backend.service;

import com.example.backend.entity.Order;
import com.example.backend.entity.OrderDetail;
import com.example.backend.entity.Product;
import com.example.backend.repository.OrderDetailRepository;
import com.example.backend.repository.OrderRepository;
import com.example.backend.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.math.BigDecimal;
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
        BigDecimal totalAmount = BigDecimal.ZERO;

        for (OrderDetail detail : orderDetails) {
            Product product = productRepository.findById(detail.getProductId()).orElseThrow();
            if (product.getQuantity() < detail.getQuantity()) {
                throw new IllegalArgumentException("Insufficient stock for product: " + product.getProductName());
            }
            product.setQuantity(product.getQuantity() - detail.getQuantity());
            productRepository.save(product);

            detail.setStandPrice(product.getPrice());
            detail.setItemPrice(product.getPrice().multiply(new BigDecimal(detail.getQuantity())));
            totalAmount = totalAmount.add(detail.getItemPrice());
            detail.setOrder(order);
        }

        order.setOrderDetails(orderDetails);
        order.setPrice(totalAmount); // Correct method name based on Order class
        orderRepository.save(order);
        orderDetailRepository.saveAll(orderDetails);

        return order;
    }
}
