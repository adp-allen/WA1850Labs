package com.example;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Greeting greetingBean(){
        return new Greeting();
    }
}
