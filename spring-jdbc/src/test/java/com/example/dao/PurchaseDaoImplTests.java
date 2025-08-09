package com.example.dao;

import com.example.Config;
import com.example.entity.Purchase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(Config.class)
public class PurchaseDaoImplTests {

    @Autowired 
    PurchaseDao dao;

    @Test
    public void findAllPurchases() {
        List<Purchase> purchases = dao.getAllPurchases();
        assertThat(purchases).isNotNull();
        assertThat(purchases.size()).isEqualTo(4);
    }

    @Test
    public void getPurchase() {
        List<Purchase> allPurchases = dao.getAllPurchases();
        Purchase paulPurchase = allPurchases.stream()
            .filter(p -> "Paul".equals(p.getCustomerName()))
            .findFirst()
            .orElse(null);
        
        assertThat(paulPurchase).isNotNull();
        
        Purchase p = dao.getPurchase(paulPurchase.getId());
        assertThat(p).isNotNull();
        assertThat(p.getId()).isNotNull();
        assertThat(p.getCustomerName()).isNotNull();
        assertThat(p.getCustomerName()).isEqualTo("Paul");
        assertThat(p.getProduct()).isEqualTo("Football");
    }

    @Test
    public void savePurchase() {
        Purchase p = new Purchase();
        p.setCustomerName("Sample");
        p.setProduct("Sample Product");
        p.setPurchaseDate(new Date());
        dao.savePurchase(p);
        Purchase newPurchase = dao.getPurchase(p.getCustomerName(), p.getPurchaseDate());
        assertThat(newPurchase).isNotNull();
        assertThat(newPurchase.getId()).isNotNull();
        assertThat(newPurchase.getCustomerName()).isNotNull();
        assertThat(newPurchase.getCustomerName()).isEqualTo(p.getCustomerName());
        assertThat(newPurchase.getProduct()).isEqualTo(p.getProduct());
    }
}