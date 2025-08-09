package com.example.dao;

import com.example.entity.Purchase;
import java.util.Date;
import java.util.List;

public interface PurchaseDao {
    List<Purchase> getAllPurchases();
    Purchase getPurchase(int id);
    Purchase getPurchase(String customerName, Date purchaseDate);
    void savePurchase(Purchase purchase);
}