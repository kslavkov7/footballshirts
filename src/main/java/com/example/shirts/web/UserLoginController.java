package com.example.shirts.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserLoginController {
    @GetMapping("/users/login")
    public String login() {
        return "login";
    }
}
