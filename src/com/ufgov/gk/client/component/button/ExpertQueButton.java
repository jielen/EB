/**   
* @(#) project: ZFCG
* @(#) file: ExpertQueButton.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: ExpertQueButton
* @Description: TODO(������һ�仰��������������)
* @date: 2011-3-31 ����11:34:33
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ExpertQueButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = -1984568193661510953L;

  public ExpertQueButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fque";
    this.defaultText = "����";
    this.iconName = "send.jpg";
    super.init();

  }

}
