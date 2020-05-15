package com.in28minutes.microservices.currencyexchangeservice;

import static org.mockito.Mockito.mock;

import com.in28minutes.microservices.currencyexchangeservice.resource.CurrencyExchangeController;
import com.in28minutes.microservices.currencyexchangeservice.resource.ExchangeValue;
import com.in28minutes.microservices.currencyexchangeservice.resource.ExchangeValueRepository;
import com.in28minutes.microservices.currencyexchangeservice.util.environment.InstanceInformationService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.math.BigDecimal;
import org.junit.Before;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class BaseTestCase {

  @Before
  public void setUp(){
    // Mock dependencies
    ExchangeValueRepository exchangeValueRepository = mock(ExchangeValueRepository.class);
    InstanceInformationService instanceInformationService = mock(InstanceInformationService.class);
    CurrencyExchangeController controller = new CurrencyExchangeController();
    controller.setRepository(exchangeValueRepository);
    controller.setInstanceInformationService(instanceInformationService);

    // DataSet to handle USD to INR conversion for contract tests
    when(exchangeValueRepository.findByFromAndTo("USD","INR")).thenReturn(new ExchangeValue(10001L,"USD","INR", new BigDecimal(65)));
    when(instanceInformationService.retrieveInstanceInfo()).thenReturn("UNKNOWN v1 KNOWN");

    RestAssuredMockMvc.standaloneSetup(controller);
  }

}
