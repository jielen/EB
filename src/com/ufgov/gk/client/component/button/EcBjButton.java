/**   
* @(#) project: ZFCG
* @(#) file: EcBjButton.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: EcBjButton
* @Description: TODO(������һ�仰��������������)
* @date: 2011-2-19 ����02:09:15
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class EcBjButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = -2564446291342163428L;

  public EcBjButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = true;
    this.funcId = "fecbj";
    this.defaultText = "�ٴα���";
    this.iconName = "group_edit.png";
    super.init();
  }
}
