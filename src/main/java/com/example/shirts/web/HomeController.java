package com.example.shirts.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/about")
    private String about(){
        return "about";
    }
}
