package com.example.shirts.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchases")
public class Purchase extends BaseEntity {
    private String productName;
    private BigDecimal price;
    private LocalDateTime timeOfProductPurchase;
    private User buyer;

    public Purchase() {
    }

    @Column(nullable = false)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(nullable = false)
    public LocalDateTime getTimeOfProductPurchase() {
        return timeOfProductPurchase;
    }

    public void setTimeOfProductPurchase(LocalDateTime timeOfProductPurchase) {
        this.timeOfProductPurchase = timeOfProductPurchase;
    }

    @ManyToOne
    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }
}
