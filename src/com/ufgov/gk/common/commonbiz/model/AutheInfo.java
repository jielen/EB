package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;

import com.ufgov.gk.common.system.util.Des;
import com.ufgov.gk.common.system.util.ObjectUtil;

public class AutheInfo implements Serializable {
  
  private String userId;
  
  private String operId;

  private String origUserInfo;//40位客户号 + 10位代表号

  private String dataTmp;//随机数,传输密钥加密（16位），送9200交易返回的内容

  private String dateTime;//系统时间,YYYYMMDDhhmmss(14位)，送9200交易返回的内容

  private String cerInfo;//证书信息

  private String publicKey;//公钥

  private String keyInfo;//发证机构签名信息
  
  private String signData;
  
  private String plainText;
  
  private String clientIp;
  
  private String operator;

  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  public String getPlainText() {
    return plainText;
  }

  public void setPlainText(String plainText) {
    this.plainText = plainText;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getOperId() {
    return operId;
  }

  public void setOperId(String operId) {
    this.operId = operId;
  }

  public String getClientIp() {
    return clientIp;
  }

  public void setClientIp(String clientIp) {
    this.clientIp = clientIp;
  }

  public String getOrigUserInfo() {
    return origUserInfo;
  }

  public void setOrigUserInfo(String origUserInfo) {
    this.origUserInfo = origUserInfo;
  }

  //工行用
  public String getUserInfo() {
    try {
      //TODO: 暂时测试
      String user = origUserInfo.substring(0, 40);
      String dele = origUserInfo.substring(40);
      StringBuffer buffer1 = new StringBuffer();
      StringBuffer buffer2 = new StringBuffer();
      Des.xToB(user.toCharArray(), buffer1);
      Des.xToB(dele.toCharArray(), buffer2);
      String user1 = buffer1.toString().trim();
      String user2 = "000" + buffer2.toString().trim();
      user2 = user2.substring(user2.length() - 3);
      return user1 + user2;
    } catch (Exception ex) {
      throw new IllegalArgumentException(ex.getMessage());
    }
  }

  public String getDataTmp() {
    return dataTmp;
  }

  public void setDataTmp(String dataTmp) {
    this.dataTmp = dataTmp;
  }

  public String getDateTime() {
    return dateTime;
  }

  public void setDateTime(String dateTime) {
    this.dateTime = dateTime;
  }

  public String getCerInfo() {
    return cerInfo;
  }

  public void setCerInfo(String cerInfo) {
    this.cerInfo = cerInfo;
  }

  public String getPublicKey() {
    return publicKey;
  }

  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }

  public String getKeyInfo() {
    return keyInfo;
  }

  public void setKeyInfo(String keyInfo) {
    this.keyInfo = keyInfo;
  }

  public String getSignData() {
    return signData;
  }

  public void setSignData(String signData) {
    this.signData = signData;
  }

  public AutheInfo() {
  }

  public AutheInfo(String origUserInfo, String dataTmp, String dateTime, String cerInfo, String publicKey,
    String keyInfo) {
    this.origUserInfo = origUserInfo;
    this.dataTmp = dataTmp;
    this.dateTime = dateTime;
    this.cerInfo = cerInfo;
    this.publicKey = publicKey;
    this.keyInfo = keyInfo;
  }

  public AutheInfo cloneAutheInfo() {
    return (AutheInfo) ObjectUtil.deepCopy(this);
  }

  public String toString() {
    StringBuffer buffer = new StringBuffer();
    buffer.append("origUserInfo:" + this.getOrigUserInfo() + "\r\n");
    buffer.append("cerInfo:" + this.getCerInfo() + "\r\n");
    buffer.append("publicKey:" + this.getPublicKey() + "\r\n");
    buffer.append("keyInfo:" + this.getKeyInfo() + "\r\n");
    buffer.append("sign:" + this.getSignData());
    return buffer.toString();
  }
}
