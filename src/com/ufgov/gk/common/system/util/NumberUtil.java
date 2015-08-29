package com.ufgov.gk.common.system.util;

import java.text.NumberFormat;

public class NumberUtil {
  static private NumberFormat numberFormat;
  static {
    numberFormat = NumberFormat.getInstance();
    numberFormat.setMinimumFractionDigits(2);
    numberFormat.setMaximumFractionDigits(2);
  }

  /**
   * 
   * @param number
   * @return
   */
  public static String format(Object number){
    return numberFormat.format(number);
  }
  
}
