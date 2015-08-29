/**
 * 
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
public class ChangeSellerIdButton extends FuncButton {
	 /**
	   * 
	   */
	  private static final long serialVersionUID = -2331011196661004179L;

	  public ChangeSellerIdButton() {
	    super();
	  }

	  protected void init() {

	    this.funcId = "fChangeSellerId";
	    this.defaultText = "¸ü¸ÄÂô¼ÒID";
	    //    this.iconName = "add.jpg";
	    super.init();

	    getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK), "newAction");
	    getActionMap().put("newAction", new AbstractAction() {
	      public void actionPerformed(ActionEvent e) {
	        doClick();
	      }
	    });

	  }

	  public void setToolTipText(String text) {
	    String tipText = this.getText() + "£¨Ctrl+C£©";
	    super.setToolTipText(tipText);
	  }

}
