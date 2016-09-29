package com.fsm.repository;

import com.fsm.domain.MyStock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<MyStock, Long> {


}
