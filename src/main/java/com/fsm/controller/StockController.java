package com.fsm.controller;

import com.fsm.service.StockService;
import com.fsm.util.AccountUtil;
import com.fsm.util.stock.YahooStock;
import com.fsm.util.stock.StockFetcher;
import com.stormpath.sdk.account.Account;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StockController {

  private StockService stockService;

  @Autowired
  public StockController(StockService stockService) {
    this.stockService = stockService;
  }

  @RequestMapping("/")
  public String myStocks() {

    return "stocks";
  }

  @RequestMapping("/findStock")
  public String findStock(@RequestParam("stockSymbol") String stockSymbol, Model model) {

    YahooStock yahooYahooStock = StockFetcher.getStock(stockSymbol);
    if (yahooYahooStock != null)
      model.addAttribute("stock", yahooYahooStock);
    else
      model.addAttribute("error", "Could not find stock " + stockSymbol);

    return "stocks";
  }

  @RequestMapping("/addStock")
  public String addStock(@RequestParam("stockSymbol") String stockSymbol, Model model, HttpServletRequest req) {

    Account account = AccountUtil.getUserAccount(req);

    if (stockService.stockAlreadyAdded(stockSymbol, account)) {
      model.addAttribute("error", "You already added this stock");
    } else {
      stockService.addStock(stockSymbol, account);
      model.addAttribute("success", "Stock " + stockSymbol + " has been successfully added");
    }

    return "stocks";
  }

}
