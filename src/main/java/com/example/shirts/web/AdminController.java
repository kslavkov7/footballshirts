package com.example.shirts.web;

import com.example.shirts.service.PurchaseService;
import com.example.shirts.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private PurchaseService purchaseService;
    private UserService userService;

    public AdminController(PurchaseService purchaseService, UserService userService) {
        this.purchaseService = purchaseService;
        this.userService = userService;
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

    @GetMapping("/admin/manage")
    private String manageRoles(Model model){
        model.addAttribute("users", this.userService.getAllUsers());
        return "roles";
    }
}
