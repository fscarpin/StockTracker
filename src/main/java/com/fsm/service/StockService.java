package com.fsm.service;

import com.fsm.domain.Stock;
import com.fsm.repository.StockRepository;
import com.fsm.util.stock.StockFetcher;
import com.fsm.util.stock.YahooStock;
import com.stormpath.sdk.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

  private StockRepository stockRepository;

  @Autowired
  public StockService(StockRepository stockRepository) {
    this.stockRepository = stockRepository;
  }

  public boolean addStock(String stockSymbol, Account account) {
    YahooStock yahooYahooStock = StockFetcher.getStock(stockSymbol);
    if (yahooYahooStock == null)
      return false;

    Stock stock = new Stock();
    stock.setName(yahooYahooStock.getName());
    stock.setTicker(stockSymbol);
    stock.setLastPrice(yahooYahooStock.getPrice());
    stock.setUserEmail(account.getEmail());

    Stock savedStock = stockRepository.save(stock);
    if (savedStock == null)
      return false;

    return true;
  }

  public boolean stockAlreadyAdded(String stockSymbol, Account account) {
    // Try to find the stock for the given user
    Stock stock = stockRepository.findFirstByTickerAndUserEmailAllIgnoreCase(stockSymbol, account.getEmail());

    // Return true if the stock exists
    return (stock != null);
  }

  public Stock getStock(String id) {
    return stockRepository.findOne(Long.parseLong(id));
  }

  public boolean stockBelongsToUser(String id, Account account) {
    Stock stock = getStock(id);

    return stock.getUserEmail().equalsIgnoreCase(account.getEmail());
  }

  public void deleteStock(String id) {
    stockRepository.delete(Long.parseLong(id));
  }

  public List<Stock> getAllStocks(Account account) {
    // Get all stocks from the database
    List<Stock> stocks = stockRepository.findAllByUserEmailOrderByName(account.getEmail());

    // Update the prices and save the stock
    for (Stock stock: stocks) {
      // Get the values from Yahoo
      String symbol = stock.getTicker();
      YahooStock yahooStock = StockFetcher.getStock(symbol);

      // Update the price
      stock.setLastPrice(yahooStock.getPrice());
      stockRepository.save(stock);
    }

    return stocks;
  }
}
