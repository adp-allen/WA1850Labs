package com.example.service;

import com.example.entity.Purchase;
import java.util.List;

public interface PurchaseService {
    List<Purchase> findAllPurchases();
}