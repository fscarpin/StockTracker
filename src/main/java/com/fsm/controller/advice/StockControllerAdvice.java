package com.fsm.controller.advice;

import com.fsm.controller.StockController;
import com.fsm.domain.Stock;
import com.fsm.repository.StockRepository;
import com.fsm.util.AccountUtil;
import com.stormpath.sdk.account.Account;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice(basePackageClasses = StockController.class)
public class StockControllerAdvice {

  private StockRepository stockRepository;

  @Autowired
  public StockControllerAdvice(StockRepository stockRepository) {
    this.stockRepository = stockRepository;
  }

  /**
   * Return all the stocks for the current user
   * @return List of Stock
   */
  @ModelAttribute("userStocks")
  public List<Stock> getAllUserStocks(HttpServletRequest req) {
    Account account = AccountUtil.getUserAccount(req);

    // Update the stocks based on the current value

    return stockRepository.findAllByUserEmail(account.getEmail());
  }
}
