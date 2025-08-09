package com.example.service;

import com.example.Purchase;
import com.example.dao.PurchaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDAO purchaseDAO;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void savePurchase(Purchase purchase) {
        purchaseDAO.save(purchase);
    }

    @Override
    public Purchase findPurchase(String customerName, Date purchaseDate) {
        return purchaseDAO.find(customerName, purchaseDate);
    }
}