package com.example.dao;

import com.example.Purchase;
import java.util.Date;

public interface PurchaseDAO {
    void save(Purchase purchase);
    Purchase find(String customerName, Date purchaseDate);
}