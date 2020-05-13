package com.in28minutes.microservices.currencyexchangeservice;


import com.in28minutes.microservices.currencyexchangeservice.resource.ExchangeValue;
import com.in28minutes.microservices.currencyexchangeservice.resource.ExchangeValueRepository;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExchangeValueValidationTests {

  @Autowired
  private ExchangeValueRepository repository;

  private ExchangeValue exchangeValue;

  private BigDecimal conversionValue;
  private String from, to;

  @Test
  public void testUSDToINRConversion() {
    this.from="USD";
    this.to = "INR";
    this.conversionValue = new BigDecimal(65);
    exchangeValue = repository.findByFromAndTo(from, to);
    System.out.println("Exchange Rate details USD->INR: " + exchangeValue.toString());
    assertEquals(" Failed to match conversion rates! for USD to INR",
        exchangeValue.getConversionMultiple().compareTo(conversionValue), 0);
  }


  @Test
  public void testAUDToINRConversion() {
    this.from="AUD";
    this.to = "INR";
    this.conversionValue = new BigDecimal(25);
    exchangeValue = repository.findByFromAndTo(from, to);
    System.out.println("Exchange Rate details AUD->INR: " + exchangeValue.toString());
    assertEquals(" Failed to match conversion rates! for AUD to INR",
        exchangeValue.getConversionMultiple().compareTo(conversionValue), 0);
  }


  @Test
  public void testEURToINRConversion() {
    this.from="EUR";
    this.to = "INR";
    this.conversionValue = new BigDecimal(75);
    exchangeValue = repository.findByFromAndTo(from, to);
    System.out.println("Exchange Rate details AUD->INR: " + exchangeValue.toString());
    assertEquals(" Failed to match conversion rates! for AUD to INR",
        exchangeValue.getConversionMultiple().compareTo(conversionValue), 0);
  }
}
