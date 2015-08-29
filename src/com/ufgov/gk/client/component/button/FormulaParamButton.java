/**   
* @(#) project: ZC
* @(#) file: FormulaParamButton.java
* 
* Copyright 2010 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: FormulaParamButton
* @Description: TODO(������һ�仰��������������)
* @date: 2010-12-20 ����05:27:40
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class FormulaParamButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = -2564446291342163428L;

  public FormulaParamButton() {
    super();
  }

  protected void init() {

    this.funcId = "fformulaParam";
    this.defaultText = "�����������";
    this.iconName = "edit.jpg";
    super.init();

  }

  public void setToolTipText(String text) {
    String tipText = this.getText();
    super.setToolTipText(tipText);
  }
}
