package com.ufgov.gk.common.system.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainSubBill implements Serializable  {

  /**
   * 
   */
  private static final long serialVersionUID = -1715092971832431999L;

  private Object mainBill;

  private List subBillList = new ArrayList();

  public Object getMainBill() {
    return mainBill;
  }

  public void setMainBill(Object mainBill) {
    this.mainBill = mainBill;
  }

  public List getSubBillList() {
    return subBillList;
  }

  public void setSubBillList(List subBillList) {
    this.subBillList = subBillList;
  }

}
