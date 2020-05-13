package com.in28minutes.microservices.currencyconversionservice;

import static org.junit.Assert.assertNotNull;

import com.in28minutes.microservices.currencyconversionservice.resource.CurrencyConversionController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyConversionServiceApplicationTests {

	@Autowired
	private CurrencyConversionController conversionController;

	@Test
	public void applicationContextLoads() {
		assertNotNull(conversionController);
	}

}
