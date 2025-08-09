package com.example.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="PURCHASES")
public class Purchase {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;
    
    @Column(name="PURCHASE_DATE")
    private Date purchaseDate;
    
    @Column(name="PRODUCT")
    private String product;
    
    public Purchase() {}
    
    public Purchase(Customer customer, String product, Date purchaseDate) {
        this.customer = customer;
        this.product = product;
        this.purchaseDate = purchaseDate;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Date getPurchaseDate() {
        return purchaseDate;
    }
    
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    public String getProduct() {
        return product;
    }
    
    public void setProduct(String product) {
        this.product = product;
    }
}