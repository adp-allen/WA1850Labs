package com.example.service;

import com.example.Config;
import com.example.Purchase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(Config.class)
public class PurchaseServiceImplTests {

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Test
    public void testSavePurchase() {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        Purchase p = new Purchase("Praveen", new Date(), "lava lamp");
        purchaseService.savePurchase(p);

        Purchase retrievedPurchase = null;
        try {
            retrievedPurchase = purchaseService.findPurchase(p.getCustomerName(), p.getPurchaseDate());
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }

        transactionManager.rollback(status);

        assertNotNull(retrievedPurchase, "Purchase should have been found before rollback");
        assertEquals("Praveen", retrievedPurchase.getCustomerName());
        assertEquals("lava lamp", retrievedPurchase.getItem());
    }
}