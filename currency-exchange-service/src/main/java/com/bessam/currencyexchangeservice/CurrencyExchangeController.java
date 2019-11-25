package com.bessam.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository repository;


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from ,@PathVariable String to){
        Optional<ExchangeValue> exchangeValue = repository.findByFromAndTo(from,to);
        exchangeValue.get().setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue.get();
    }
}
