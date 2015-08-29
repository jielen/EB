package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class MaExpSerial implements Serializable {
  public final static String EXP_DATE = "expDate";

  public final static String EXP_TYPE = "expType";

  public final static String EXP_TYPE_01 = "01";//拨款

  public final static String EXP_TYPE_02 = "02";//授权支付申请划退款凭证

  public final static String EXP_TYPE_03 = "03";//直接支付申请划退款凭证

  public final static String EXP_ND = "nd";

  public final static String EXP_PADMARK = "padMark";

  public final static String EXP_SERIAL_LEN = "serialLen";

  private String expDate;

  private String expType;

  private BigDecimal nd;

  private BigDecimal serial = new BigDecimal(1);

  private String padMark = "0";

  private BigDecimal serialLen = new BigDecimal(4);

  public String getExpDate() {
    return expDate;
  }

  public void setExpDate(String expDate) {
    this.expDate = expDate;
  }

  public String getExpType() {
    return expType;
  }

  public void setExpType(String expType) {
    this.expType = expType;
  }

  public BigDecimal getSerial() {
    if (serial == null) {
      serial = new BigDecimal(1);
    }
    return serial;
  }

  public void setSerial(BigDecimal serial) {
    this.serial = serial;
  }

  public String getPadMark() {
    return padMark;
  }

  public void setPadMark(String padMark) {
    this.padMark = padMark;
  }

  public BigDecimal getSerialLen() {
    if (serialLen == null) {
      serialLen = new BigDecimal(0);
    }
    return serialLen;
  }

  public void setSerialLen(BigDecimal serialLen) {
    this.serialLen = serialLen;
  }

  public BigDecimal getNd() {
    return nd;
  }

  public void setNd(BigDecimal nd) {
    this.nd = nd;
  }

  public String getOutPutStr() {
    StringBuffer buffer = new StringBuffer();
    buffer.append(this.getExpDate());
    String pad = this.getPadMark();
    pad = pad == null ? " " : pad;
    if (this.serialLen.intValue() > 0) {
      String temp = this.serial.toString();
      int fillLen = this.serialLen.intValue() - temp.length();
      if (fillLen > 0) {
        for (int i = 0; i < fillLen; i++) {
          temp = pad + temp;
        }
      }
      buffer.append(temp.substring(temp.length() - 4));
    } else {
      buffer.append(this.serial);
    }
    return buffer.toString();
  }

  public MaExpSerial() {
  }

  public static void main(String[] args) {
    MaExpSerial s = new MaExpSerial();
    s.setExpDate("20090909");
    s.setExpType("01");
    s.setPadMark("0");
    s.setSerialLen(new BigDecimal(4));
    s.setSerial(new BigDecimal(10));
    System.out.println(s.getOutPutStr());
  }

}
