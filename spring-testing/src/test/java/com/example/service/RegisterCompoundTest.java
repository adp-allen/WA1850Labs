package com.example.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Config;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
@ActiveProfiles("compound")
@TestPropertySource(properties = {"tax.rate=0.03", "local.tax.rate=0.04"})


public class RegisterCompoundTest {

    @Autowired
    private Register register;


    @Test 
    void testRegister() {
        double result = register.computeTotal(100);
        Assertions.assertThat(result).isEqualTo(100.00 + 7.0);
        System.out.println(String.format("The computed total including tax is: %.2f", result));
    }


//  TODO-04:  (OPTIONAL) Without modifying app.properties, change the 
//  tax.rate and local.tax.rate properties used by this test to 0.03 and 0.04 respectively.
//  Modify the code in the testRegister() method to expect a result of 100.00 + 7.
//  Run the test.  It should pass.


}
