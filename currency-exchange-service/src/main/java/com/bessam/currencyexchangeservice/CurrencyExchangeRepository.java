package com.bessam.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue,Long> {

    Optional<ExchangeValue> findByFromAndTo(String from,String to);
}
