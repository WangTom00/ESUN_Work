package com.example.esun_demo.controller;

import com.example.esun_demo.entity.Product;
import com.example.esun_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getAvailableProducts();
        return ResponseEntity.ok(products);
    }
}
