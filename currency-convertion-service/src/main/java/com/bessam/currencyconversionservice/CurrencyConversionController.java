package com.bessam.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    /**
     * in this method we called the currencyExchangeService manually (using RestTemplate).
     * @param from
     * @param to
     * @param quantity
     * @return
     */
    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from , @PathVariable String to, @PathVariable BigDecimal quantity){
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);
        CurrencyConversionBean response = responseEntity.getBody();

        return new CurrencyConversionBean(response.getId(),response.getFrom(),response.getTo(),response.getConversionMultiple(),quantity,response.getPort(),quantity.multiply(response.getConversionMultiple()));
    }

    /**
     * in this method we use feign to call the exchange service using the proxy.
     * @param from
     * @param to
     * @param quantity
     * @return
     */
    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from , @PathVariable String to, @PathVariable BigDecimal quantity){
        CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
        response.setQuantity(quantity);
        response.setTotalAmount(quantity.multiply(response.getConversionMultiple()));
        return response;
    }
}
