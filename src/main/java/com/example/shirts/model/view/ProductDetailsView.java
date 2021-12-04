package com.example.shirts.model.view;

import com.example.shirts.model.entity.ProductConditionEnum;
import com.example.shirts.model.entity.ProductTypeEnum;

import java.math.BigDecimal;

public class ProductDetailsView {
    private Long id;
    private String name;
    private String size;
    private BigDecimal price;
    private String teamName;
    private ProductConditionEnum productCondition;
    private ProductTypeEnum type;
    private String photoUrl;
    private String description;
    private boolean canDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }
}
