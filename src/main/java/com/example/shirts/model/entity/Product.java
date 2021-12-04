package com.example.shirts.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product extends BaseEntity{
    private String name;
    private String size;
    private BigDecimal price;
    private String description;
    private String teamName;
    private User productUploader;
    private ProductConditionEnum productCondition;
    private ProductTypeEnum type;
    private String photoUrl;

    public Product() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @ManyToOne
    public User getProductUploader() {
        return productUploader;
    }

    public void setProductUploader(User productUploader) {
        this.productUploader = productUploader;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public ProductConditionEnum getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(ProductConditionEnum productCondition) {
        this.productCondition = productCondition;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public ProductTypeEnum getType() {
        return type;
    }

    public void setType(ProductTypeEnum type) {
        this.type = type;
    }

    @Column
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
