package com.example.esun_demo.repository;

import com.example.esun_demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {}
