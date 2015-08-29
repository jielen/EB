/**   
* @(#) project: ZFCG
* @(#) file: FuncMenuButton.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import com.ufgov.gk.client.component.JFuncPopupMenu;
import com.ufgov.gk.client.component.button.FuncButton;

/**
* @ClassName: FuncMenuButton
* @Description: TODO(������һ�仰��������������)
* @date: 2011-6-8 ����04:51:43
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class FuncMenuButton extends FuncButton {
  private JFuncPopupMenu menu;

  @Override
  protected void init() {
    this.setFocusable(false);
    //this.setVisible(true);
    this.setModuleCode("ZC");
    this.setButtonIcon();
    this.setHorizontalTextPosition(SwingConstants.RIGHT);
    addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        if (menu != null) {
          menu.show(FuncMenuButton.this, 0, FuncMenuButton.this.getHeight());
        }
      }
    });
  }

  public void addMenu(JFuncPopupMenu menu) {
    this.menu = menu;
  }
}
