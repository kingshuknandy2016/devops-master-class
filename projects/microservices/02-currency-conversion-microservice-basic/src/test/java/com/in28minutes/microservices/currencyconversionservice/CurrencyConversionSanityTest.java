package com.in28minutes.microservices.currencyconversionservice;

import static org.junit.Assert.assertEquals;

import com.in28minutes.microservices.currencyconversionservice.resource.CurrencyConversionBean;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CurrencyConversionSanityTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void testUSDToINRConversion() {
    //Setup test data
    String from = "USD", to = "INR";
    BigDecimal rate = new BigDecimal(65), quantity = new BigDecimal(10);
    // Get conversion rate
    CurrencyConversionBean res = testRestTemplate
        .getForObject(
            "http://localhost:" + port + "/currency-conversion/from/" + from + "/to/" + to
                + "/quantity/"
                + quantity,
            CurrencyConversionBean.class);
    BigDecimal calculatedAmount = res.getTotalCalculatedAmount();
    // Verify calculated value
    assertEquals("USD " + quantity + " should equal INR " + rate.multiply(quantity),
        calculatedAmount.compareTo(rate.multiply(quantity)), 0);
  }

  @Test
  public void testAUDToINRConversion() {
    //Setup test data
    String from = "AUD", to = "INR";
    BigDecimal rate = new BigDecimal(25), quantity = new BigDecimal(10);
    // Get conversion rate
    CurrencyConversionBean res = testRestTemplate
        .getForObject(
            "http://localhost:" + port + "/currency-conversion/from/" + from + "/to/" + to
                + "/quantity/"
                + quantity,
            CurrencyConversionBean.class);
    BigDecimal calculatedAmount = res.getTotalCalculatedAmount();
    // Verify calculated value
    assertEquals("AUD " + quantity + " should equal INR " + rate.multiply(quantity),
        calculatedAmount.compareTo(rate.multiply(quantity)), 0);
  }

  @Test
  public void testEURToINRConversion() {
    //Setup test data
    String from = "EUR", to = "INR";
    BigDecimal rate = new BigDecimal(75), quantity = new BigDecimal(10);
    // Get conversion rate
    CurrencyConversionBean res = testRestTemplate
        .getForObject(
            "http://localhost:" + port + "/currency-conversion/from/" + from + "/to/" + to
                + "/quantity/"
                + quantity,
            CurrencyConversionBean.class);
    BigDecimal calculatedAmount = res.getTotalCalculatedAmount();
    // Verify calculated value
    assertEquals("EUR " + quantity + " should equal INR " + rate.multiply(quantity),
        calculatedAmount.compareTo(rate.multiply(quantity)), 0);
  }
}
