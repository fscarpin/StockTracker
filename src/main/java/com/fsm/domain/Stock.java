package com.fsm.domain;

import com.stormpath.sdk.account.Account;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.Date;

@Entity
@Table(name = "stock")
public class Stock {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private String ticker;
  private Double lastPrice;
  private Double yesterdayClosePrice;
  private String currency;
  private String userEmail;

  @Transient
  private Double percentage;

  @CreatedDate
  @Column(columnDefinition = "TIMESTAMP")
  private Date createdAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTicker() {
    return ticker;
  }

  public void setTicker(String ticker) {
    this.ticker = ticker;
  }

  public Double getLastPrice() {
    return lastPrice;
  }

  public void setLastPrice(Double lastPrice) {
    this.lastPrice = lastPrice;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Double getYesterdayClosePrice() {
    return yesterdayClosePrice;
  }

  public void setYesterdayClosePrice(Double yesterdayClosePrice) {
    this.yesterdayClosePrice = yesterdayClosePrice;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getPercentage() {
    double current = getLastPrice();
    double previousClose = getYesterdayClosePrice();

    double diff = current - previousClose;

    if (current == 0)
      return "---";
    else {
      double result = diff * 100 / current;

      DecimalFormat df = new DecimalFormat("##.##");

      if (result > 0)
        return "+ " + df.format(result) + " %";
      else
        return "- " + df.format(Math.abs(result)) + " %";
    }
  }
}