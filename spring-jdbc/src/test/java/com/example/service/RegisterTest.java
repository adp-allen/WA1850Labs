package com.example.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegisterTest {

    private Register register;

    @BeforeEach
    void setUp() {
        TaxCalculator taxCalculator = new SalesTaxCalculator();
        register = new Register(taxCalculator);
    }

    @Test
    void testComputeTotal() {
        double result = register.computeTotal(100.00);
        assertThat(result).isEqualTo(105.00);
    }
}
