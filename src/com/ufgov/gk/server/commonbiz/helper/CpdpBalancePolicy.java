package com.ufgov.gk.server.commonbiz.helper;

import java.util.Calendar;
import java.util.Date;

public class CpdpBalancePolicy {

  private int getToMonth(Date procDate, String optCpCdpExec) {
    Calendar calendar= Calendar.getInstance();
    calendar.setTime(procDate);
    int month= calendar.get(Calendar.MONTH)+1;
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int optValue = Integer.parseInt(optCpCdpExec);
    if ((optValue > 0) && (day > optValue) && (month != 12)) {
      month = month + 1;
    }
    return month;
  }

  public String getBalanceString(Date procDate, String optCpCdpExec) {
    StringBuffer result = new StringBuffer("dp_cd_money");
    for (int i = 1; i <= getToMonth(procDate, optCpCdpExec); i++) {
      result.append("+dp_money");
      result.append(i);
    }
    result.append("-AM_MONEY-CP_MONEY-FREEZE_MONEY-CD_MONEY");
    return result.toString();
  }

}

