
package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.service.Register;
import com.example.service.SalesTaxCalculator;
import com.example.service.TaxCalculator;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.example")
@EnableTransactionManagement
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
        var ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;INIT=RUNSCRIPT FROM 'classpath:schema.sql'");
        ds.setUsername("sa");
        ds.setPassword("");
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
        var emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(ds);
        emfb.setPackagesToScan("com.example.domain");
        var adapter = new HibernateJpaVendorAdapter();
        emfb.setJpaVendorAdapter(adapter);
        var props = new Properties();
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.format_sql", "true");
        props.setProperty("hibernate.use_sql_comments", "true");
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        emfb.setJpaProperties(props);
        return emfb;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
