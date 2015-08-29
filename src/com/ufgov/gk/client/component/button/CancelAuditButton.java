/**
 * CancelAuditButton.java
 * com.ufgov.gk.client.component.button
 * Administrator
 * 2010-5-18
 */
package com.ufgov.gk.client.component.button;

/**
 * @author Administrator
 *
 */
public class CancelAuditButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = 5938063631740448938L;

  
  public CancelAuditButton() {
    super();
  }
  
  protected void init() {
    this.funcId = "funaudit";
    this.defaultText="œ˙…Û";
    super.init();
  }
}
