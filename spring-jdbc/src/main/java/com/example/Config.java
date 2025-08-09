
package com.example;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.example.service.Register;
import com.example.service.SalesTaxCalculator;
import com.example.service.TaxCalculator;

@Configuration
@ComponentScan
public class Config {
    @Bean(name = "taxCalculator")
    public SalesTaxCalculator taxCalculator() {
        return new SalesTaxCalculator();
    }

    @Bean(name = "register")
    public Register register(TaxCalculator taxCalculator) {
        return new Register(taxCalculator);
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("classpath:schema.sql")
            .addScript("classpath:data.sql")
            .build();
    }

    @Bean
    public JdbcClient jdbcClient(DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }
}
