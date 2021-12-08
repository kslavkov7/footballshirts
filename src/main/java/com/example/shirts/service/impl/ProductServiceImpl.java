package com.example.shirts.service.impl;

import com.example.shirts.model.entity.*;
import com.example.shirts.model.service.ProductAddServiceModel;
import com.example.shirts.model.view.ProductDetailsView;
import com.example.shirts.model.view.ProductSummaryView;
import com.example.shirts.repository.ProductRepository;
import com.example.shirts.repository.PurchaseRepository;
import com.example.shirts.repository.UserRepository;
import com.example.shirts.service.ProductService;
import com.example.shirts.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;
    private UserService userService;
    private UserRepository userRepository;
    private PurchaseRepository purchaseRepository;


    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, UserService userService, UserRepository userRepository, PurchaseRepository purchaseRepository) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.userRepository = userRepository;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public void addProduct(ProductAddServiceModel productAddServiceModel) {
        User currentUser = userService.findLoggedInUser();

        productAddServiceModel.setProductUploader(currentUser);

        Product newProduct = modelMapper.map(productAddServiceModel, Product.class);

        productRepository.save(newProduct);

    }

    @Override
    public List<ProductSummaryView> getAllProducts() {
       return productRepository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDetailsView findById(Long id, String currentUser) {
        return this.productRepository.findById(id)
                .map(p -> mapDetailsView(currentUser, p)).get();
    }

    @Override
    public void deleteOffer(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        String productName = product.getName();
        BigDecimal price = product.getPrice();
        String photoUrl = product.getPhotoUrl();
        Purchase purchase = new Purchase();
        purchase.setProductName(productName);
        purchase.setPrice(price);
        purchase.setTimeOfProductPurchase(LocalDateTime.now());
        purchase.setPhotoUrl(photoUrl);
        User buyer = userService.findLoggedInUser();
        purchase.setBuyer(buyer);
        purchaseRepository.save(purchase);
        productRepository.deleteById(id);
    }


    private ProductSummaryView map(Product product) {
        ProductSummaryView summaryView = this.modelMapper
                .map(product, ProductSummaryView.class);
        return summaryView;
    }


    private ProductDetailsView mapDetailsView(String currentUser, Product product) {
        ProductDetailsView productDetailsView = this.modelMapper.map(product, ProductDetailsView.class);
        productDetailsView.setCanDelete(isAdmin(userRepository.findByUsername(currentUser).orElseThrow()));
        return productDetailsView;
    }

    private boolean isAdmin(User user) {
        return user.
                getRoles().
                stream().
                map(UserRole::getRole).
                anyMatch(r -> r == UserRoleEnum.ADMIN);
    }

}
