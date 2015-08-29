/**
 * CreateRetrievalTaskButton.java
 * com.ufgov.gk.client.component.button
 * Administrator
 * Jul 8, 2012
 */
package com.ufgov.gk.client.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 * 生成检索任务
 * @author Administrator
 *
 */
public class CreateRetrievalTaskButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = -1720666804624424508L;

  public CreateRetrievalTaskButton() {
    super();
  }

  protected void init() {
    this.funcId = "fcreateRetrievalTask";
    this.defaultText = "生成检索任务";
    super.init();

    getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_MASK), "createRetrievalTaskAction");
    getActionMap().put("createRetrievalTaskAction", new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        doClick();
      }
    });

  }

  public void setToolTipText(String text) {
    String tipText = this.getText() + "（Ctrl+T）";
    super.setToolTipText(tipText);
  }

}
