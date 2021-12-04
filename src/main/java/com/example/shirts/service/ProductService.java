package com.example.shirts.service;

import com.example.shirts.model.service.ProductAddServiceModel;
import com.example.shirts.model.view.ProductDetailsView;
import com.example.shirts.model.view.ProductSummaryView;

import java.util.List;

public interface ProductService {
    void addProduct(ProductAddServiceModel productAddServiceModel);

    List<ProductSummaryView> getAllProducts();

    ProductDetailsView findById(Long id, String currentUser);

    void deleteOffer(Long id);

    void buyProduct(Long id);
}
