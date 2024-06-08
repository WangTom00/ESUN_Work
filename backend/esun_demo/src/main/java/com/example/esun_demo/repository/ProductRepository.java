package com.example.esun_demo.repository;

import com.example.esun_demo.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByQuantityGreaterThan(int quantity);
}