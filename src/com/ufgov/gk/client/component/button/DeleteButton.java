package com.ufgov.gk.client.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class DeleteButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public DeleteButton() {
		super();
	}

	protected void init() {
	  this.defaultText="É¾³ý";
		this.funcId="fdelete";
		this.iconName="delete.gif";
	  super.init();
		
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK),
				"deleteAction");
		getActionMap().put("deleteAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				doClick();
			}
		});
		
	}
	
	public void setToolTipText(String text) {
	  String tipText=this.getText()+"(Ctrl+D)";
	  super.setToolTipText(tipText);
	}
	
}
