package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;

import com.ufgov.gk.common.system.Copyable;
import com.ufgov.gk.common.system.Digestable;
import com.ufgov.gk.common.system.util.BeanUtil;
import com.ufgov.gk.common.system.util.DigestUtil;
import com.ufgov.gk.common.system.util.ObjectUtil;

public class MaCpElementMapping implements Serializable, Digestable, Copyable {

  public static String TYPE_BACC = "bacc";

  public static String TYPE_ORIGIN = "origin";

  public static String TYPE_FUND = "fund";

  public static String TYPE_BANK_CODE = "bankcode";

  public static String TYPE_CO_CODE = "cocode";

  public static String USE_TYPE_CARRYDOWN = "carrydown";

  public static String USE_TYPE_BANKEXPORT = "bankexport";

  /**
   * 
   */
  private static final long serialVersionUID = 396074295448356572L;

  private int nd;

  private String curYearCode;

  private String curYearName;

  private String nextYearCode;

  private String nextYearName;

  private String type;

  private String useType;

  public int getNd() {
    return nd;
  }

  public void setNd(int nd) {
    this.nd = nd;
  }

  public String getCurYearCode() {
    return curYearCode;
  }

  public void setCurYearCode(String curYearCode) {
    this.curYearCode = curYearCode;
  }

  public String getNextYearCode() {
    return nextYearCode;
  }

  public void setNextYearCode(String nextYearCode) {
    this.nextYearCode = nextYearCode;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String digest() {
    return DigestUtil.digest(this);
  }

  public Copyable copy() {
    return (Copyable) ObjectUtil.deepCopy(this);
  }

  public Object get(String name) {
    return BeanUtil.get(name, this);
  }

  public void set(String name, Object value) {
    BeanUtil.set(name, value, this);
  }

  public String getCurYearName() {
    return curYearName;
  }

  public void setCurYearName(String curYearName) {
    this.curYearName = curYearName;
  }

  public String getNextYearName() {
    return nextYearName;
  }

  public void setNextYearName(String nextYearName) {
    this.nextYearName = nextYearName;
  }

  public String getUseType() {
    return useType;
  }

  public void setUseType(String useType) {
    this.useType = useType;
  }

}
