package com.fsm.util;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.servlet.account.AccountResolver;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

public class AccountUtil {

  public static Account getUserAccount(HttpServletRequest servletRequest) {
    if (!AccountResolver.INSTANCE.hasAccount(servletRequest)) {
      return null;
    }

    // A known user has authenticated previously - get the user identity:
    Account account = AccountResolver.INSTANCE.getRequiredAccount(servletRequest);

    return account;
  }
}
