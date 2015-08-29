/**
 * FreezeButton.java
 * com.ufgov.gk.client.component.button
 * Administrator
 * 2010-5-18
 */
package com.ufgov.gk.client.component.button;

/**
 * @author Administrator
 *
 */
public class FreezeButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = -5730558314645160419L;

  public FreezeButton() {
    super();
  }
  
  protected void init() {
    this.funcId = "ffreeze";
    this.defaultText="¶³½á";
    super.init();
  }
}
