package com.ufgov.gk.common.system.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PrintObject implements Serializable  {

  /**
   * 
   */
  private static final long serialVersionUID = -3859145615327461426L;
  
  private boolean showPrintDialog=false;
  
  /**
   * ÔªËØÎªbyte[] 
   */
  
  private List printDataList= new ArrayList();

  public boolean isShowPrintDialog() {
    return showPrintDialog;
  }

  public void setShowPrintDialog(boolean showPrintDialog) {
    this.showPrintDialog = showPrintDialog;
  }

  public List getPrintDataList() {
    return printDataList;
  }

  public void setPrintDataList(List printDataList) {
    this.printDataList = printDataList;
  }

}
