
package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.service.Register;
import com.example.service.SalesTaxCalculator;
import com.example.service.TaxCalculator;

@Configuration
public class Config {
    @Bean(name = "taxCalculator")
    public SalesTaxCalculator taxCalculator() {
        return new SalesTaxCalculator();
    }

    @Bean(name = "register")
    public Register register(TaxCalculator taxCalculator) {
        return new Register(taxCalculator);
    }
}
