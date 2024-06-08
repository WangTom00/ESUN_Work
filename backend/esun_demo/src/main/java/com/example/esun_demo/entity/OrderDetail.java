package com.example.esun_demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderItemSN")
    private Long id;
    
    @Column(name = "OrderID", length = 20)
    private String orderId;
    
    @Column(name = "ProductID", length = 10)
    private String productId;
    
    @Column(name = "Quantity")
    private Integer quantity;
    
    @Column(name = "StandPrice")
    private BigDecimal standPrice;
    
    @Column(name = "ItemPrice")
    private BigDecimal itemPrice;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getStandPrice() {
        return standPrice;
    }

    public void setStandPrice(BigDecimal standPrice) {
        this.standPrice = standPrice;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }
}
