package com.example.shirts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@EnableScheduling
@SpringBootApplication
public class ShirtsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShirtsApplication.class, args);
    }

}
