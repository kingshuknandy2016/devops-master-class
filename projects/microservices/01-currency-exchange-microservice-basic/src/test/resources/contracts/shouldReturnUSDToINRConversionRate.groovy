package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make{
    description "should return exchange rate as 65 for USD to INR conversion"
    request {
        url "/currency-exchange/from/USD/to/INR"
        method GET()
    }

    response {
        status 200
        body """
            {
                "id":10001,
                "from":"USD",
                "to":"INR",
                "conversionMultiple":65.00,
                "exchangeEnvironmentInfo":"UNKNOWN v1 KNOWN"
            }
            """
        headers {
            contentType applicationJson()
        }
    }

}