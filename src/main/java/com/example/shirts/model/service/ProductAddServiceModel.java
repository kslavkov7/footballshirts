package com.example.shirts.model.service;

import com.example.shirts.model.entity.ProductConditionEnum;
import com.example.shirts.model.entity.ProductTypeEnum;
import com.example.shirts.model.entity.User;

import java.math.BigDecimal;

public class ProductAddServiceModel {
    private String name;
    private String size;
    private BigDecimal price;
    private String description;
    private String teamName;
    private ProductConditionEnum productCondition;
    private ProductTypeEnum type;
    private String photoUrl;
    private User productUploader;

    public ProductAddServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public ProductConditionEnum getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(ProductConditionEnum productCondition) {
        this.productCondition = productCondition;
    }

    public ProductTypeEnum getType() {
        return type;
    }

    public void setType(ProductTypeEnum type) {
        this.type = type;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public User getProductUploader() {
        return productUploader;
    }

    public void setProductUploader(User productUploader) {
        this.productUploader = productUploader;
    }
}
