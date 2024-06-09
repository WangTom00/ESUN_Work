package com.example.backend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @Column(name = "ProductID", length = 10)
    private String productId;
    
    @Column(name = "ProductName", length = 100)
    private String productName;
    
    @Column(name = "Price")
    private BigDecimal price;
    
    @Column(name = "Quantity")
    private Integer quantity;

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
