package com.example;

import java.util.Date;

public class Purchase {
    private Long id;
    private String customerName;
    private Date purchaseDate;
    private String item;

    public Purchase() {}

    public Purchase(String customerName, Date purchaseDate, String item) {
        this.customerName = customerName;
        this.purchaseDate = purchaseDate;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", item='" + item + '\'' +
                '}';
    }
}