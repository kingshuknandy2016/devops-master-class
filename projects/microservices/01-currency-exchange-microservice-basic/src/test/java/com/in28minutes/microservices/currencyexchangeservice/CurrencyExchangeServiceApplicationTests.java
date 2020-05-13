package com.in28minutes.microservices.currencyexchangeservice;

import static org.junit.Assert.assertNotNull;

import com.in28minutes.microservices.currencyexchangeservice.resource.CurrencyExchangeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyExchangeServiceApplicationTests {

	@Autowired
	private CurrencyExchangeController currencyExchangeController;

	@Test
	public void testApplicationContextLoads() {
		assertNotNull(currencyExchangeController);
	}

}
