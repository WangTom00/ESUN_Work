package com.example.esun_demo.service;

import com.example.esun_demo.entity.Product;
import com.example.esun_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAvailableProducts() {
        return productRepository.findByQuantityGreaterThan(0);
    }
}
