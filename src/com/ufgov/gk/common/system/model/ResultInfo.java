package com.ufgov.gk.common.system.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 每次通过socket访问bank的返回信息
 * @author liubo
 *
 */
public class ResultInfo implements Serializable {
  //银行Id
  private String bankId;
  
  //交易日期
  private Date tradeDate;
  
  //返回码
  private String resultCode;

  //返回码说明
  private String resultMessage;

  //业务标记
  private String tradeFlag;
  
  //业务说明
  private String desc;
  
  //返回的消息
  private String originalMessage;
  
  //发送的消息
  private String sendMessage;
  
  //凭证编号
  private String vouNo;
  
  //存放返回数据
  private Map userData = new HashMap();

  public String getTradeFlag() {
    if (tradeFlag == null) {
      tradeFlag = "";
    }
    return tradeFlag;
  }

  public void setTradeFlag(String tradeFlag) {
    this.tradeFlag = tradeFlag;
  }

  public String getResultCode() {
    if (resultCode == null) {
      resultCode = "";
    }
    return resultCode;
  }

  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }

  public String getResultMessage() {
    if (resultMessage == null) {
      resultMessage = "";
    }
    return resultMessage;
  }

  public void setResultMessage(String resultMessage) {
    this.resultMessage = resultMessage;
  }

  public String getDesc() {
    if (desc == null) {
      desc = "";
    }
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getOriginalMessage() {
    return originalMessage;
  }

  public void setOriginalMessage(String originalMessage) {
    this.originalMessage = originalMessage;
  }
  
  
  public String getSendMessage() {
    return sendMessage;
  }

  public void setSendMessage(String sendMessage) {
    this.sendMessage = sendMessage;
  }

  public void put(String key, Object value) {
    this.userData.put(key, value);
  }
  
  public Object get(String key) {
    return this.userData.get(key);
  }

  public String getBankId() {
    return bankId;
  }

  public void setBankId(String bankId) {
    this.bankId = bankId;
  }

  public Date getTradeDate() {
    return tradeDate;
  }

  public void setTradeDate(Date tradeDate) {
    this.tradeDate = tradeDate;
  }

  public Map getUserData() {
    return userData;
  }

  public void setUserData(Map userData) {
    this.userData = userData;
  }

  public String getVouNo() {
    return vouNo;
  }

  public void setVouNo(String vouNo) {
    this.vouNo = vouNo;
  }

  public ResultInfo() {
    super();
  }

  public ResultInfo(String code, String message, String tradeFlag, String desc) {
    this.resultCode = code;
    this.resultMessage = message;
    this.tradeFlag = tradeFlag;
    this.desc = desc;
  }
}
