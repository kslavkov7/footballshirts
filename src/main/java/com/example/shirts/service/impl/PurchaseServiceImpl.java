package com.example.shirts.service.impl;

import com.example.shirts.model.entity.Purchase;
import com.example.shirts.model.entity.Team;
import com.example.shirts.model.view.PurchaseView;
import com.example.shirts.model.view.TeamSummaryView;
import com.example.shirts.repository.PurchaseRepository;
import com.example.shirts.service.PurchaseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private ModelMapper modelMapper;
    private PurchaseRepository purchaseRepository;

    public PurchaseServiceImpl(ModelMapper modelMapper, PurchaseRepository purchaseRepository) {
        this.modelMapper = modelMapper;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public List<PurchaseView> getAllPurchases() {
        return purchaseRepository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    private PurchaseView map(Purchase purchase) {
        PurchaseView purchaseView = this.modelMapper
                .map(purchase, PurchaseView.class);
        purchaseView.setBuyerName(purchase.getBuyer().getFullName());
        return purchaseView;
    }


}
