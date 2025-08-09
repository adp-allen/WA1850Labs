package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("compound")
public class CompoundSalesTaxCalculator implements TaxCalculator {

	private final double taxRate;	// default rate
	private final double localTaxRate;	// default rate

	//  TODO-09:  (OPTIONAL) Add @Value annotations to populate the constructor parameters.  
	//	The parameter keys can be found in the app.properties file.
	public CompoundSalesTaxCalculator(
		@Value("${tax.rate}") double taxRate,
		@Value("${local.tax.rate}") double localTaxRate) {
		this.taxRate = taxRate;
		this.localTaxRate = localTaxRate;
	}

	public double calculateTax(double amount) {
		return amount * (taxRate + localTaxRate);
	}	

	//  TODO-10: (OPTIONAL) Organize imports, save your work.
	//	Run the previous test, it should FAIL.  
	//	Find the root cause of the exception and try to understand why.

}	
