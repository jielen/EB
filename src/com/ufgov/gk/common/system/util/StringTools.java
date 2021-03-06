package com.ufgov.gk.common.system.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

public class StringTools {

  public static String replaceChars(String str, String searchChars, String replaceChars) {
    if (str == null || str.length() == 0 || searchChars == null || searchChars.length() == 0) {
      return str;
    }
    char[] chars = str.toCharArray();
    int len = chars.length;
    boolean modified = false;
    for (int i = 0, isize = searchChars.length(); i < isize; i++) {
      char searchChar = searchChars.charAt(i);
      if (replaceChars == null || i >= replaceChars.length()) {
        // delete
        int pos = 0;
        for (int j = 0; j < len; j++) {
          if (chars[j] != searchChar) {
            chars[pos++] = chars[j];
          } else {
            modified = true;
          }
        }
        len = pos;
      } else {
        // replace
        for (int j = 0; j < len; j++) {
          if (chars[j] == searchChar) {
            chars[j] = replaceChars.charAt(i);
            modified = true;
          }
        }
      }
    }
    if (modified == false) {
      return str;
    }
    return new String(chars, 0, len);
  }

  /**
   * 格式化日期
   * @param svTransDate
   * @return 返回每月的第一天:2009-05-01
   */
  public static String getMonthBeginStr(Date svTransDate) {
    String result = null;
    String dateFormat = "yyyy-MM";
    DateFormat df = new SimpleDateFormat(dateFormat);
    result = df.format(svTransDate) + "-01";
    return result;
  }

  public static Date getMonthBeginDate(Date svTransDate) {
    try {
      return getDateFromString(getMonthBeginStr(svTransDate), null);
    } catch (ParseException e) {
      return svTransDate;
    }
  }

  /**
   * 格式化日期
   * @param svTransDate
   * @return 2009-05-11
   */
  public static String getDateFormat(Date svTransDate) {
    String result = null;
    String dateFormat = "yyyy-MM-dd";
    DateFormat df = new SimpleDateFormat(dateFormat);
    result = df.format(svTransDate);
    return result;
  }

  public static Date getDateFromString(String dateStr, String format) throws ParseException {
    format = format == null ? "yyyy-MM-dd" : format;
    DateFormat df = new SimpleDateFormat(format);
    return df.parse(dateStr);
  }

  /**
   * 格式化千分位
   * @param value
   * @return 如：123,455.00
   */
  public static String getNumberFormat(String value) {
    if (value == null || value.trim().equals("")) {
      return value;
    }
    if (!isNumeric(value))
      throw new RuntimeException("参数中有特殊字符");
    NumberFormat numberFormat = NumberFormat.getInstance();
    numberFormat.setMinimumFractionDigits(2);
    numberFormat.setMaximumFractionDigits(2);
    return numberFormat.format(Double.valueOf(value));
  }

  public static String getNumberFormat(BigDecimal value) {
    NumberFormat numberFormat = NumberFormat.getInstance();
    numberFormat.setMinimumFractionDigits(2);
    numberFormat.setMaximumFractionDigits(2);
    return numberFormat.format(value);
  }

  /**
   * 用正则表达式字符串是否为数字
   * @param str
   * @return
   */
  public static boolean isNumeric(String str) {
    Pattern pattern = Pattern.compile("-?[0-9]*\\.?[0-9]*");
    return pattern.matcher(str).matches();
  }

  /**
   * 用一字符分隔字符串
   * 
   * @param var
   *            -分割字符
   * @param word
   *            -字符串
   * @return Vector
   */
  public static Vector splitToVector(String var, String word) {
    Vector vec = new Vector();
    String tmpStr = "";
    int startIndex = 0;
    if (var != null && var.length() > 0 && word != null && word.length() > 0) {
      for (; word.indexOf(var) > -1;) {
        startIndex = word.indexOf(var);
        tmpStr = word.substring(0, startIndex);
        word = word.substring(startIndex + 1, word.length());
        vec.addElement(tmpStr);
      }
      vec.addElement(word);
    }
    return vec;
  }

  public static String replaceText(String strTmp, String strS, String strD) {
    return replaceAll(strTmp, strS, strD);
  }

  public static String replaceAll(String strSource, String strOld, String strNew) {
    if (null == strSource || null == strOld || null == strNew || 0 == strOld.length()
      || strOld.equals(strNew)) {
      return strSource;
    }

    String strDest = "";
    String strTemp;
    int iOldLength = strOld.length();
    int iStartIndex = strSource.indexOf(strOld);
    while (iStartIndex >= 0) {
      strTemp = strSource.substring(0, iStartIndex);
      strDest = strDest + strTemp + strNew;
      strSource = strSource.substring(iStartIndex + iOldLength, strSource.length());
      iStartIndex = strSource.indexOf(strOld);
    }
    strDest = strDest + strSource;

    return strDest;
  }

  public static List toList(String source, String splitChar) {
    List result = new ArrayList();
    if (source == null || source.length() == 0)
      return result;
    String[] array = source.split(splitChar);
    for (int i = 0; i < array.length; i++) {
      result.add(array[i].trim());
    }
    return result;
  }
}
