package com.ufgov.gk.common.system.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

  private static DateFormat ddFormat = new SimpleDateFormat("yyyy-MM-dd");

  private static DateFormat ddShortFormat = new SimpleDateFormat("yyyyMMdd");

  private static DateFormat ssFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private static DateFormat chinaFormat = new SimpleDateFormat("yyyy年MM月dd日");

  static {
    String cnTimeZone = TimeZone.getDefault().getID();
    if (cnTimeZone.toLowerCase().indexOf("shanghai") == -1) {
      TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
      TimeZone.setDefault(tz);
      System.out.println("22新时区：" + TimeZone.getDefault().getID());
    }
  }

  /**
   * 
   * @param date
   * @return  yyyy-MM-dd
   */
  public static String dateToDdString(Date date) {
    if (date == null) {
      return null;
    }
    return ddFormat.format(date);
  }

  /**
   * 
   * @param date
   * @return  yyyy年MM月dd日
   */
  public static String dateToChinaString(Date date) {
    if (date == null) {
      return null;
    }
    return chinaFormat.format(date);
  }

  public static String dateToShortDdString(Date date) {
    return ddShortFormat.format(date);
  }

  /**
   * 
   * @param date
   * @return yyyy-MM-dd HH:mm:ss
   */
  public static String dateToSsString(Date date) {
    return ssFormat.format(date);
  }

  /**
   * 
   * @param dateStr yyyy-MM-dd
   * @return
   */
  public static Date ddStringToDate(String dateStr) {
    Date date = null;
    try {
      date = ddFormat.parse(dateStr);
    } catch (ParseException pe) {
      throw new RuntimeException(pe.getMessage(), pe);
    }
    return date;
  }

  /**
   * 
   * @param dateStr yyyy-MM-dd HH:mm:ss
   * @return
   */
  public static Date ssStringToDate(String dateStr) {
    Date date = null;
    try {
      date = ssFormat.parse(dateStr);
    } catch (ParseException pe) {
      throw new RuntimeException(pe.getMessage(), pe);
    }
    return date;
  }

  /**
   * 取月份的最后一天
   * @param nd
   * @param month
   * @return
   */
  public static Date getLastDayOfMonth(int nd, int month) {
    Calendar c = Calendar.getInstance();
    c.set(c.YEAR, nd);
    c.set(c.MONTH, month - 1);
    c.set(c.DAY_OF_MONTH, c.getActualMaximum(c.DAY_OF_MONTH));
    return c.getTime();
  }

  /**
   * 取月份的第一天
   * @param nd
   * @param month
   * @return Date
   */
  public static Date getFirstDayOfMonth(int nd, int month) {
    Calendar c = Calendar.getInstance();
    c.set(c.YEAR, nd);
    c.set(c.MONTH, month - 1);
    c.set(c.DAY_OF_MONTH, c.getActualMinimum(c.DAY_OF_MONTH));
    c.set(c.HOUR_OF_DAY, 0);
    c.set(c.MINUTE, 0);
    c.set(c.SECOND, 0);
    c.set(c.MILLISECOND, 0);
    return c.getTime();
  }

  /**
   * 取月份的第一天
   * @param nd
   * @param month
   * @return String
   */
  public static String getFirstDayOfMonthDateToDdString(int nd, int month) {
    return dateToDdString(getFirstDayOfMonth(nd, month));
  }
}
