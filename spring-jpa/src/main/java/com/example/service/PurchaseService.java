package com.example.service;

import com.example.domain.Purchase;
import java.util.Date;
import java.util.List;

public interface PurchaseService {
    List<Purchase> findAllPurchases();
    Purchase findPurchase(int id);
    Purchase findPurchase(String customerName, Date date);
    void savePurchase(Purchase purchase);
}