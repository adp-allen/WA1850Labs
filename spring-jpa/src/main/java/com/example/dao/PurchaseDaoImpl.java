package com.example.dao;

import com.example.domain.Purchase;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {
    
    @PersistenceContext
    EntityManager em;
    
    @Override
    public List<Purchase> getAllPurchases() {
        String jpql = "SELECT p FROM Purchase p";
        return em
            .createQuery(jpql, Purchase.class)
            .getResultList();
    }
    
    @Override
    public Purchase getPurchase(int id) {
        return em.find(Purchase.class, id);
    }
    
    @Override
    public Purchase getPurchase(String customerName, Date date) {
        String jpql = "SELECT p FROM Purchase p WHERE p.customer.name = :name AND p.purchaseDate = :date";
        return em
            .createQuery(jpql, Purchase.class)
            .setParameter("name", customerName)
            .setParameter("date", date)
            .getSingleResult();
    }
    
    @Override
    public void savePurchase(Purchase purchase) {
        if(purchase.getId() < 1) {
            em.persist(purchase);
        } else {
            em.merge(purchase);
        }
    }
}