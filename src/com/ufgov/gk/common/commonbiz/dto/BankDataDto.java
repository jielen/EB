package com.ufgov.gk.common.commonbiz.dto;

import java.io.Serializable;

public class BankDataDto implements Serializable{
  
  /**
   * 
   */
  private static final long serialVersionUID = 8823853056902202672L;
  

  private String fileName;

  private String data;

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

}
