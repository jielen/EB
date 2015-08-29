/**   
* @(#) project: ZFCG
* @(#) file: YlbPrintButton.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: YlbPrintButton
* @Description: TODO(������һ�仰��������������)
* @date: 2011-4-29 ����09:35:42
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class YlbPrintButton extends FuncButton {
  public YlbPrintButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fYlbPrint";
    this.defaultText = "��ʾ��Ӧ�̱�����Ϣ";
    this.iconName = "sendBill.png";
    super.init();
  }
}
