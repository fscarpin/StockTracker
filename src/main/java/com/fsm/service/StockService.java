package com.fsm.service;

import com.fsm.domain.Stock;
import com.fsm.repository.StockRepository;
import com.fsm.util.stock.StockFetcher;
import com.fsm.util.stock.YahooStock;
import com.stormpath.sdk.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

  private StockRepository stockRepository;

  @Autowired
  public StockService(StockRepository stockRepository) {
    this.stockRepository = stockRepository;
  }

  public void addStock(String stockSymbol, Account account) {
    YahooStock yahooYahooStock = StockFetcher.getStock(stockSymbol);

    Stock stock = new Stock();
    stock.setName(yahooYahooStock.getName());
    stock.setTicker(stockSymbol);
    stock.setLastPrice(yahooYahooStock.getPrice());
    stock.setUserEmail(account.getEmail());

    stockRepository.save(stock);
  }

  public boolean stockAlreadyAdded(String stockSymbol, Account account) {
    // Try to find the stock for the given user
    Stock stock = stockRepository.findFirstByTickerAndUserEmail(stockSymbol, account.getEmail());

    // Return true if the stock exists
    return (stock != null);
  }
}
