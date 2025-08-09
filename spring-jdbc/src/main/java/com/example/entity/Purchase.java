package com.example.entity;

import java.util.Date;

public class Purchase {
    private Integer id;
    private String customerName;
    private String product;
    private Date purchaseDate;

    public Purchase() {
    }

    public Purchase(String customerName, String product, Date purchaseDate) {
        this.customerName = customerName;
        this.product = product;
        this.purchaseDate = purchaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", product='" + product + '\'' +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}