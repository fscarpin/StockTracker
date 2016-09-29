package com.fsm.repository;

import com.fsm.domain.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

  Stock findFirstByTickerAndUserEmail(String ticker, String userEmail);
}
