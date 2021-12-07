package com.example.shirts.web;

import com.example.shirts.service.PurchaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private PurchaseService purchaseService;

    public AdminController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/admin")
    private String admin(){
        return "admin";
    }


    @GetMapping("/admin/purchases")
    private String purchases(Model model){
        model.addAttribute("purchases", this.purchaseService.getAllPurchases());
        return "purchases";
    }
}
