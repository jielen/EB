/**
 * ButtonStatus.java
 * com.ufgov.gk.client.zc
 * Administrator
 * 2010-5-14
 */
package com.ufgov.gk.client.util;

import java.util.ArrayList;
import java.util.List;

import com.ufgov.gk.client.component.button.FuncButton;

/**
 * @author Administrator
 *
 */
public class ButtonStatus {
  private FuncButton button;
  private List<String> pageStatus=new ArrayList<String>();
  private List<String> billStats=new ArrayList<String>();
  /**
   * @return the button
   */
  public FuncButton getButton() {
    return button;
  }
  /**
   * @param button the button to set
   */
  public void setButton(FuncButton button) {
    this.button = button;
  }
  /**
   * @return the pageStatus
   */
  public List<String> getPageStatus() {
    return pageStatus;
  }
  /**
   * @param pageStatus the pageStatus to set
   */
  public void setPageStatus(List<String> pageStatus) {
    this.pageStatus = pageStatus;
  }
  /**
   * @return the billStats
   */
  public List<String> getBillStats() {
    return billStats;
  }
  /**
   * @param billStats the billStats to set
   */
  public void setBillStats(List<String> billStats) {
    this.billStats = billStats;
  }
  public void addPageStatus(String pageStatus){
    this.pageStatus.add(pageStatus);
  }
  public void addBillStatus(String billStatus){
    this.billStats.add(billStatus);
  }
}
