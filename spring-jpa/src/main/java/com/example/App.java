/*
 * Spring JPA Demo Application
 */
package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.domain.Customer;
import com.example.domain.Purchase;
import com.example.service.PurchaseService;
import com.example.service.Register;

import java.util.Date;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println("=== Spring JPA Demo Application Starting ===");
        ApplicationContext spring = new AnnotationConfigApplicationContext(Config.class);
        
        // Demo original functionality
        System.out.println("\n1. Testing original Register functionality:");
        Register register = spring.getBean(Register.class);
        double total = register.computeTotal(100.00);
        System.out.println("   Register Total: " + total);
        
        // Demo JPA functionality
        System.out.println("\n2. Testing JPA Purchase functionality:");
        PurchaseService purchaseService = spring.getBean(PurchaseService.class);
        
        // Find all purchases
        System.out.println("\n   a) All purchases in database:");
        List<Purchase> allPurchases = purchaseService.findAllPurchases();
        for (Purchase p : allPurchases) {
            System.out.println("      Purchase ID: " + p.getId() + 
                             ", Customer: " + p.getCustomer().getName() + 
                             ", Product: " + p.getProduct() + 
                             ", Date: " + p.getPurchaseDate());
        }
        
        // Find specific purchase by ID
        System.out.println("\n   b) Finding purchase with ID 2:");
        Purchase specificPurchase = purchaseService.findPurchase(2);
        if (specificPurchase != null) {
            System.out.println("      Found: " + specificPurchase.getCustomer().getName() + 
                             " bought " + specificPurchase.getProduct());
        }
        
        // Create and save a new purchase
        System.out.println("\n   c) Creating new purchase:");
        Purchase newPurchase = new Purchase();
        Customer customer = new Customer("Demo Customer");
        customer.setId(1L); // Use existing customer
        newPurchase.setCustomer(customer);
        newPurchase.setProduct("Spring Framework Book");
        newPurchase.setPurchaseDate(new Date());
        
        try {
            purchaseService.savePurchase(newPurchase);
            System.out.println("      New purchase saved successfully with ID: " + newPurchase.getId());
            
            // Show all purchases again
            System.out.println("\n   d) All purchases after adding new one:");
            List<Purchase> updatedPurchases = purchaseService.findAllPurchases();
            System.out.println("      Total purchases now: " + updatedPurchases.size());
            
        } catch (Exception e) {
            System.out.println("      Error saving purchase: " + e.getMessage());
        }
        
        System.out.println("\n=== Spring JPA Demo Application Complete ===");
    }
}
