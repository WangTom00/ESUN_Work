package com.example.backend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @Column(name = "ProductID", length = 10)
    private String id;
    
    @Column(name = "ProductName", length = 100)
    private String name;
    
    @Column(name = "Price")
    private BigDecimal price;
    
    @Column(name = "Quantity")
    private Integer quantity;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}