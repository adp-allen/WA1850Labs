package com.example.dao;

import com.example.Config;
import com.example.domain.Customer;
import com.example.domain.Purchase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(Config.class)
@Transactional
public class PurchaseDaoImplTests {
    
    @PersistenceContext 
    EntityManager em;
    
    @Autowired 
    PurchaseDao repo;
    
    @Test
    public void findAllPurchases() {
        List<Purchase> purchases = repo.getAllPurchases();
        assertThat(purchases).isNotNull();
        assertThat(purchases.size()).isGreaterThan(0);
        Purchase p = purchases.get(0);
        assertThat(p).isNotNull();
        assertThat(p.getId()).isNotNull();
        assertThat(p.getCustomer().getName()).isNotNull();
        assertThat(p.getCustomer().getName()).isEqualTo("Bruce");
    }
    
    @Test
    public void getPurchase() {
        Purchase p = repo.getPurchase(2);
        assertThat(p).isNotNull();
        assertThat(p.getId()).isNotNull();
        assertThat(p.getCustomer().getName()).isNotNull();
        assertThat(p.getCustomer().getName()).isEqualTo("Paul");
        assertThat(p.getProduct()).isEqualTo("Football");
    }
    
    @Test
    public void testSaveAndFind() {
        Customer c = em.find(Customer.class, 1L);
        Purchase p = new Purchase();
        p.setCustomer(c);
        p.setProduct("Incan ceremonial headmask");
        p.setPurchaseDate(new Date());
        repo.savePurchase(p);
        em.clear();
        Purchase purchase = repo.getPurchase(p.getId());
        assertEquals(p.getProduct(), purchase.getProduct());
        assertEquals(p.getPurchaseDate(), purchase.getPurchaseDate());
    }
}