package com.in28minutes.microservices.currencyconversionservice;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = "com.in28minutes.microservices:01-currency-exchange-basic:+:stubs:8000", stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ContractTests {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void validateGradeOCondition() throws Exception {
    mockMvc.perform(
        MockMvcRequestBuilders.get("/currency-conversion/from/USD/to/INR/quantity/10")
            .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json(
            "{"
                + "\"id\":10001,"
                + "\"from\":\"USD\","
                + "\"to\":\"INR\","
                + "\"conversionMultiple\":65,"
                + "\"quantity\":10,"
                + "\"totalCalculatedAmount\":650,"
                + "\"exchangeEnvironmentInfo\":\"UNKNOWN v1 KNOWN\","
                + "\"conversionEnvironmentInfo\":\"UNKNOWN v1 KNOWN\""
                + "}"));
  }

}
