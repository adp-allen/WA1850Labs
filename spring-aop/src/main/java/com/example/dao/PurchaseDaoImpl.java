package com.example.dao;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {
    
    private List<Purchase> purchases = new ArrayList<>();
    
    public PurchaseDaoImpl() {
        // Add some sample data
        purchases.add(new Purchase(1, "Sample Purchase 1", 100.0));
        purchases.add(new Purchase(2, "Sample Purchase 2", 200.0));
    }
    
    @Override
    public Purchase getPurchase(int id) {
        return purchases.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Purchase> getAllPurchases() {
        return new ArrayList<>(purchases);
    }
    
    @Override
    public void savePurchase(Purchase purchase) {
        purchases.add(purchase);
    }
}