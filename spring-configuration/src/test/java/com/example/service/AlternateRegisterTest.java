
package com.example.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.AlternateConfig;

class AlternateRegisterTest {

    private static Register register;

    @BeforeAll
    static void setup() {
        System.setProperty("spring.profiles.active", "alternate");
        ApplicationContext spring = new AnnotationConfigApplicationContext(AlternateConfig.class);
        register = spring.getBean(Register.class);
    }

    @Test
    void testComputeTotalWithAlternateProfile() {
        double result = register.computeTotal(100.00);
        // Adjust expected value based on your app.properties tax.rate value. Default is 0.05, so 105.0
        Assertions.assertThat(result).isEqualTo(106.0);
    }
}
