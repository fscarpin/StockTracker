package com.fsm.repository;

import com.fsm.domain.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

  Stock findFirstByTickerAndUserEmailAllIgnoreCase(String ticker, String userEmail);
  List<Stock> findAllByUserEmail(String userEmail);
}
