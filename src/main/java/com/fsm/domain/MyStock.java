package com.fsm.domain;

import com.stormpath.sdk.account.Account;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock")
public class MyStock {

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
}



//  create_table "stocks", force: :cascade do |t|
//          t.string   "ticker"
//          t.string   "name"
//          t.decimal  "last_price"
//          t.datetime "created_at", null: false
//          t.datetime "updated_at", null: false
//          end