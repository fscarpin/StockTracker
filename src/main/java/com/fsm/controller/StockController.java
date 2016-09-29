package com.fsm.controller;

import com.fsm.util.Stock;
import com.fsm.util.StockFetcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StockController {

  @RequestMapping("/")
  public String myStocks() {
    return "stocks";
  }

  @RequestMapping("/findStock")
  public String findStock(@RequestParam("stock") String stock, Model model) {

    Stock yahooStock = StockFetcher.getStock(stock);
    if (yahooStock != null)
      model.addAttribute("stock", yahooStock);
    else
      model.addAttribute("error", "Couldn' find stock " + stock);

    return "stocks";
  }
}
