package com.example.domain;

import jakarta.persistence.*;

@Entity
@Table(name="CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name="CUSTOMER_NAME")
    private String name;
    
    public Customer() {}
    
    public Customer(String name) {
        this.name = name;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}