package com.example.shirts.model.binding;

import com.example.shirts.model.entity.ProductConditionEnum;
import com.example.shirts.model.entity.ProductTypeEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductAddBindingModel {
    private String name;
    private String size;
    private BigDecimal price;
    private String description;
    private String teamName;
    private ProductConditionEnum productCondition;
    private ProductTypeEnum type;
    private String photoUrl;

    public ProductAddBindingModel() {
    }

    @NotNull
    @Size(min = 3, max = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Size(min = 1)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Positive
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    @Size(min = 3)
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @NotNull
    public ProductConditionEnum getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(ProductConditionEnum productCondition) {
        this.productCondition = productCondition;
    }

    @NotNull
    public ProductTypeEnum getType() {
        return type;
    }

    public void setType(ProductTypeEnum type) {
        this.type = type;
    }

    @NotNull
    @Size(min = 1)
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
