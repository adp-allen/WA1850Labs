package com.example.service;

import com.example.dao.PurchaseDao;
import com.example.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    
    @Autowired 
    PurchaseDao purchaseDAO;

    @Override
    public List<Purchase> findAllPurchases() {
        return purchaseDAO.getAllPurchases();
    }
}