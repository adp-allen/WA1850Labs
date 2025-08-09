package com.example.service;

import com.example.dao.PurchaseDao;
import com.example.domain.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {
    
    @Autowired 
    PurchaseDao purchaseDao;
    
    @Override
    public List<Purchase> findAllPurchases() {
        return purchaseDao.getAllPurchases();
    }
    
    @Override
    public Purchase findPurchase(int id) {
        return purchaseDao.getPurchase(id);
    }
    
    @Override
    public Purchase findPurchase(String customerName, Date date) {
        return purchaseDao.getPurchase(customerName, date);
    }
    
    @Override
    public void savePurchase(Purchase purchase) {
        purchaseDao.savePurchase(purchase);
    }
}