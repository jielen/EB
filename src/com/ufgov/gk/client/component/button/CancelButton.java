package com.ufgov.gk.client.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class CancelButton extends FuncButton {
  public CancelButton() {
    super();
  }

  protected void init() {

    this.funcId = "fcancel";
    this.defaultText = "ȡ��";
    this.iconName = "untread.jpg";
    super.init();

    getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK), "cancelAction");
    getActionMap().put("cancelAction", new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        doClick();
      }
    });

  }

  public void setToolTipText(String text) {
    String tipText = this.getText() + "��Ctrl+Z��";
    super.setToolTipText(tipText);
  }
}
