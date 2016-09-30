package com.fsm.controller;

import com.fsm.domain.Stock;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class StockController {

  private StockService stockService;

  @Autowired
  public StockController(StockService stockService) {
    this.stockService = stockService;
  }

  @RequestMapping("/")
  public String myStocks() {

    // Go to the stocks page
    return "stock/stocks";
  }

  @RequestMapping("/findStock")
  public String findStock(@RequestParam("stockSymbol") String stockSymbol, Model model, HttpServletRequest req) {

    // Get the stock from Yahoo
    YahooStock yahooYahooStock = StockFetcher.getStock(stockSymbol);

    // If the stock was found, let' show it, so the user can add it
    if (yahooYahooStock != null) {
      model.addAttribute("stock", yahooYahooStock);

      // Check if the stock was already added. If so, it' not possible to add it again
      if (stockService.stockAlreadyAdded(stockSymbol, AccountUtil.getUserAccount(req))) {
        model.addAttribute("stock_already_added", "You already added this stock");
      }
    } else {
      // Stock was not found
      model.addAttribute("error", "Could not find stock " + stockSymbol);
    }

    // Go to stocks page
    return "stock/stocks";
  }

  @RequestMapping("/addStock")
  public String addStock(@RequestParam("stockSymbol") String stockSymbol, Model model, HttpServletRequest req) {

    Account account = AccountUtil.getUserAccount(req);

    // Show an error if the stock was already added
    if (stockService.stockAlreadyAdded(stockSymbol, account)) {
      model.addAttribute("error", "You already added this stock");
    }
    // Add the stock and show a successfull message
    else {
      if (stockService.addStock(stockSymbol, account))
        model.addAttribute("success", "Stock " + stockSymbol + " has been successfully added");
      else
        model.addAttribute("error", "Error adding stock " + stockSymbol);
    }

    // Redirect to the main page
    return "redirect:/";
  }

  @RequestMapping("/deleteStock")
  public String deleteStock(@RequestParam("stockId") String stockId, Model model, HttpServletRequest req) {

    Account account = AccountUtil.getUserAccount(req);

    // Make sure the stock belongs to the logged in user
    if (!stockService.stockBelongsToUser(stockId, account)) {
      model.addAttribute("error", "You are not allowed to delete this stock");
    }
    // Delete the given stock and show a successfull message
    else {
      stockService.deleteStock(stockId);
      model.addAttribute("success", "Stock has been removed from your portfolio");
    }

    // Redirect to the main page
    return "redirect:/";
  }

}
