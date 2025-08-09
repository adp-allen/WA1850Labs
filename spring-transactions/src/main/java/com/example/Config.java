
package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.service.Register;
import com.example.service.SalesTaxCalculator;
import com.example.service.TaxCalculator;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan("com.example")
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
            .setType(EmbeddedDatabaseType.H2)
            .addScript("classpath:schema.sql")
            .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
