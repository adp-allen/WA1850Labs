package com.example.dao;

import java.util.List;

public interface PurchaseDao {
    Purchase getPurchase(int id);
    List<Purchase> getAllPurchases();
    void savePurchase(Purchase purchase);
}