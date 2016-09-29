package com.fsm.domain;

import com.stormpath.sdk.account.Account;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
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
  private String userEmail;

  @CreatedDate
  @Column(columnDefinition = "TIMESTAMP")
  private Date createdAt;
  // Account comes from Stormpath (login manager) so it's not persisted in my database. How should I define this relation?
//  @ManyToOne
//  private Account account;


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
}



//  create_table "stocks", force: :cascade do |t|
//          t.string   "ticker"
//          t.string   "name"
//          t.decimal  "last_price"
//          t.datetime "created_at", null: false
//          t.datetime "updated_at", null: false
//          end