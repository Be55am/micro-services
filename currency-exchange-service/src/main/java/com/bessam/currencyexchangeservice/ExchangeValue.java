package com.bessam.currencyexchangeservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExchangeValue {

    private Long id;
    private String from;
    private String to ;
    private BigDecimal conversionMultiple;

}
