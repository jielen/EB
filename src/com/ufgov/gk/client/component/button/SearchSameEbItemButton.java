/**
 * SearchSameEbItemButton.java
 * com.ufgov.gk.client.component.button
 * Administrator
 * Jul 18, 2012
 */
package com.ufgov.gk.client.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 * @author Administrator
 *
 */
public class SearchSameEbItemButton extends FuncButton {
  public SearchSameEbItemButton() {
    super();
  }

  protected void init() {

    this.funcId = "fsearchSameEbItem";
    this.defaultText = "搜索同一商品";
    //    this.iconName = "add.jpg";
    super.init();

    getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK), "newAction");
    getActionMap().put("newAction", new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        doClick();
      }
    });

  }

  public void setToolTipText(String text) {
    String tipText = "匹配相同商品（Ctrl+H）";
    super.setToolTipText(tipText);
  }

}
