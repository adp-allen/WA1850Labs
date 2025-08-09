package com.example.dao;

import com.example.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {
    
    @Autowired 
    JdbcClient jdbcClient;

    @Override
    public List<Purchase> getAllPurchases() {
        String sql = "SELECT * FROM PURCHASE";
        return jdbcClient
            .sql(sql)
            .query(Purchase.class)
            .list();
    }

    @Override
    public Purchase getPurchase(int id) {
        String sql = "SELECT * FROM PURCHASE WHERE ID = ?";
        return jdbcClient
            .sql(sql)
            .param(id)
            .query(Purchase.class)
            .single();
    }

    @Override
    public Purchase getPurchase(String customerName, Date purchaseDate) {
        String sql = "SELECT * FROM PURCHASE WHERE CUSTOMERNAME = ? AND PURCHASEDATE = ?";
        return jdbcClient
            .sql(sql)
            .param(customerName)
            .param(purchaseDate)
            .query(Purchase.class)
            .single();
    }

    @Override
    public void savePurchase(Purchase purchase) {
        String sql = "insert into PURCHASE (CUSTOMERNAME, PRODUCT, PURCHASEDATE) values(?,?,?)";
        jdbcClient
            .sql(sql)
            .param(purchase.getCustomerName())
            .param(purchase.getProduct())
            .param(purchase.getPurchaseDate())
            .update();
    }
}