package com.example.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.AlternateConfig;

class RegisterTest {

    static Register register;

    @BeforeAll
    static void setUp() {
        System.setProperty("spring.profiles.active", "alternate");
        ApplicationContext spring = new AnnotationConfigApplicationContext(AlternateConfig.class);
        register = spring.getBean(Register.class);
    }

    @Test
    void testComputeTotal() {
        double result = register.computeTotal(100.00);
        assertThat(result).isEqualTo(106.00);
    }
}
