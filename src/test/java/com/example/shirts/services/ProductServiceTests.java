package com.example.shirts.services;

import com.example.shirts.base.BaseTest;
import com.example.shirts.model.entity.Product;
import com.example.shirts.model.entity.User;
import com.example.shirts.model.entity.UserRole;
import com.example.shirts.model.view.ProductSummaryView;
import com.example.shirts.repository.ProductRepository;
import com.example.shirts.repository.UserRepository;
import com.example.shirts.service.ProductService;
import com.example.shirts.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class ProductServiceTests extends BaseTest {
    private List<Product> productsList;

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Before
    public void setupTest() {
        productsList = new ArrayList<>();
        when(productRepository.findAll())
                .thenReturn(productsList);
    }

    @Test
    public void testGetAllProductsWhenEmpty(){
        productsList.clear();
        List<ProductSummaryView>productSummaryViewList = productService.getAllProducts();
        Assert.assertEquals(0, productSummaryViewList.size());
    }

    @Test
    public void testGetAllProductWhenNotEmpty(){
        productsList.clear();
        Product product = new Product();
        productsList.add(product);
        List<ProductSummaryView> productSummaryViewList = productService.getAllProducts();
        Assert.assertEquals(1, productSummaryViewList.size());
    }
}
