package com.example.shirts.web;

import com.example.shirts.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class ProductController {
    private ProductService productService;
    private ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/products/all")
    public String allOffers(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/products/{id}/details")
    public String showProduct(
            @PathVariable Long id, Model model,
            Principal principal) {
        model.addAttribute("product", this.productService.findById(id, principal.getName()));
        return "product-details";
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id) {

        productService.deleteOffer(id);

        return "redirect:/products/all";
    }

    @GetMapping("/products/{id}/buy")
    public String buyProduct(
            @PathVariable Long id) {
        productService.buyProduct(id);
        return "redirect:/products/all";
    }

}
