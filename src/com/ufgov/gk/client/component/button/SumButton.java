package com.ufgov.gk.client.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class SumButton extends FuncButton {
  public SumButton() {
    super();
  }

  protected void init() {
    this.funcId = "f_collectcreate";
    this.defaultText="����";
    super.init();

    getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
      KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK), "sumAction");
    getActionMap().put("sumAction", new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        doClick();
      }
    });

  }
  
  public void setToolTipText(String text) {
    String tipText = this.getText() + "��Ctrl+X��";
    super.setToolTipText(tipText);
  }
}
