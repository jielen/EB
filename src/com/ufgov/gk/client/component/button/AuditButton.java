/**
 * AuditButton.java
 * com.ufgov.gk.client.component.button
 * Administrator
 * 2010-5-18
 */
package com.ufgov.gk.client.component.button;

/**
 * @author Administrator
 *
 */
public class AuditButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = -4562975339140978995L;
  
  public AuditButton() {
    super();
  }
  
  protected void init() {
    this.funcId = "faudit";
    this.defaultText="���";
    this.iconName="audit.jpg";
    super.init();
  }

}
