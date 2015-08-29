/**   
* @(#) project: ZFCG
* @(#) file: ShowEvalComlResultButton.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: ShowEvalComlResultButton
* @Description: TODO(������һ�仰��������������)
* @date: 2011-4-17 ����10:09:40
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ShowEvalComlResultButton extends FuncButton {
  private static final long serialVersionUID = 8176162602374553497L;

  public ShowEvalComlResultButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fShowEvalComlResult";
    this.defaultText = "��ʾ������������ܱ�";
    this.iconName = "import.jpg";
    super.init();
  }

}
