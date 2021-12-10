package com.example.shirts.config;

import com.example.shirts.service.PurchaseService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulingConfiguration {
    private PurchaseService purchaseService;

    public SchedulingConfiguration(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Scheduled(cron = "0 30 0 * * *")
    public void deleteAllPurchases(){
        purchaseService.deleteAllPurchases();
    }
}
