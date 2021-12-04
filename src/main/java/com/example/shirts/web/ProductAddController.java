package com.example.shirts.web;

import com.example.shirts.model.binding.ProductAddBindingModel;
import com.example.shirts.model.binding.TeamAddBindingModel;
import com.example.shirts.model.service.ProductAddServiceModel;
import com.example.shirts.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProductAddController {

    private ProductService productService;
    private ModelMapper modelMapper;

    public ProductAddController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("products/add")
    private String addProduct(){
        return "add-product";
    }

    @ModelAttribute("productModel")
    public ProductAddBindingModel productModel() {
        return new ProductAddBindingModel();
    }

    @PostMapping("products/add")
    private String addProductConfirm(@Valid ProductAddBindingModel productModel,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productModel",productModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productModel", bindingResult);
            return "redirect:/products/add";
        }

        ProductAddServiceModel productAddServiceModel =
                modelMapper.map(productModel,ProductAddServiceModel.class);

        productService.addProduct(productAddServiceModel);
        return "redirect:/";
    }


}
