package com.example.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Config;

class RegisterTest {

    static Register register;

    @BeforeAll
    static void setUp() {
        ApplicationContext spring = new AnnotationConfigApplicationContext(Config.class);
        register = spring.getBean(Register.class);
    }

    @Test
    void testComputeTotal() {
        double result = register.computeTotal(100.00);
        assertThat(result).isEqualTo(105.00);
    }
}
