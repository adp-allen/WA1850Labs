package com.example.service;

import com.example.Purchase;
import java.util.Date;

public interface PurchaseService {
    void savePurchase(Purchase purchase);
    Purchase findPurchase(String customerName, Date purchaseDate);
}