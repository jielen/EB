package com.ufgov.gk.client.util;

import java.util.Calendar;

import com.ufgov.gk.client.common.AsOptionMeta;
import com.ufgov.gk.client.common.WorkEnv;

public class BalanceUtil {
  public static int getMonthIdBySysOption() {
    String exchangeDay = AsOptionMeta.getOptVal("OPT_CP_CDP_EXEC");
    Calendar c = Calendar.getInstance();
    c.setTime(WorkEnv.getInstance().getTransDate());
    int curDay = c.get(Calendar.DATE);
    int month = c.get(Calendar.MONTH)+1;
    if ((curDay > Integer.parseInt(exchangeDay)) && (Integer.parseInt(exchangeDay) > 0) && (month != 12)) {
      month = month + 1;
    }
    return month;
  }
  
}
