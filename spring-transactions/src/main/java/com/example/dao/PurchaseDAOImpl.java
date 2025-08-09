package com.example.dao;

import com.example.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class PurchaseDAOImpl implements PurchaseDAO {
    
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Purchase purchase) {
        String sql = "INSERT INTO purchase (customer_name, purchase_date, item) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, 
            purchase.getCustomerName(), 
            purchase.getPurchaseDate(), 
            purchase.getItem());
    }

    @Override
    public Purchase find(String customerName, Date purchaseDate) {
        String sql = "SELECT * FROM purchase WHERE customer_name = ? AND purchase_date = ?";
        List<Purchase> purchases = jdbcTemplate.query(sql, new PurchaseRowMapper(), customerName, purchaseDate);
        return purchases.isEmpty() ? null : purchases.get(0);
    }

    private static class PurchaseRowMapper implements RowMapper<Purchase> {
        @Override
        public Purchase mapRow(ResultSet rs, int rowNum) throws SQLException {
            Purchase purchase = new Purchase();
            purchase.setId(rs.getLong("id"));
            purchase.setCustomerName(rs.getString("customer_name"));
            purchase.setPurchaseDate(rs.getTimestamp("purchase_date"));
            purchase.setItem(rs.getString("item"));
            return purchase;
        }
    }
}