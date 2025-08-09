package com.example.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import com.example.Config;

@SpringJUnitConfig(Config.class)
public class PurchaseDaoImplTests {

    @Autowired 
    PurchaseDao dao;

    @Test
    void testGetPurchase() {
        Purchase purchase = dao.getPurchase(1);
        System.out.println("Retrieved purchase: " + purchase.getDescription());
    }

    @Test
    void testGetAllPurchases() {
        var purchases = dao.getAllPurchases();
        System.out.println("Found " + purchases.size() + " purchases");
    }

    @Test
    void savePurchase() {
        Purchase newPurchase = new Purchase(3, "New Purchase", 300.0);
        dao.savePurchase(newPurchase);
        System.out.println("Saved new purchase");
    }
}