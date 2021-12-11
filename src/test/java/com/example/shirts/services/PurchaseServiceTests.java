package com.example.shirts.services;

import com.example.shirts.base.BaseTest;
import com.example.shirts.model.entity.Purchase;
import com.example.shirts.model.view.PurchaseView;
import com.example.shirts.repository.PurchaseRepository;
import com.example.shirts.service.PurchaseService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class PurchaseServiceTests extends BaseTest {
    private List<Purchase> purchaseList;


    @Autowired
    private PurchaseService purchaseService;
    @MockBean
    private PurchaseRepository purchaseRepository;

    @Before
    public void setupTest() {
        purchaseList = new ArrayList<>();
        when(purchaseRepository.findAll())
                .thenReturn(purchaseList);
    }

    @Test
    public void testGetAllPurchasesWhenEmpty(){
        purchaseList.clear();
        List <PurchaseView> purchaseViewList = purchaseService.getAllPurchases();
        Assert.assertEquals(0, purchaseViewList.size());
    }

}
