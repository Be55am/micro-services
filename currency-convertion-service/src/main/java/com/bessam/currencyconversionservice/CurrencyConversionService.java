package com.bessam.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
//enable feign to scan for clients and we pass the packages we wants to scan
@EnableFeignClients("com.bessam.currencyconversionservice")
@EnableDiscoveryClient
public class CurrencyConversionService {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConversionService.class, args);
    }

}
