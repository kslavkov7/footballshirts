package com.example.shirts.model.view;

import com.example.shirts.model.entity.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PurchaseView {
    private Long id;
    private String productName;
    private BigDecimal price;
    private LocalDateTime timeOfProductPurchase;
    private User buyer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getTimeOfProductPurchase() {
        return timeOfProductPurchase;
    }

    public void setTimeOfProductPurchase(LocalDateTime timeOfProductPurchase) {
        this.timeOfProductPurchase = timeOfProductPurchase;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }
}
