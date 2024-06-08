package com.example.backend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Order")
public class Order {
    @Id
    @Column(name = "OrderID", length = 20)
    private String id;
    
    @Column(name = "MemberID")
    private Integer memberId;
    
    @Column(name = "Price")
    private BigDecimal price;
    
    @Column(name = "PayStatus")
    private Boolean payStatus;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Boolean payStatus) {
        this.payStatus = payStatus;
    }
}