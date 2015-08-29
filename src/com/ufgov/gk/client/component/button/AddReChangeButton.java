package com.ufgov.gk.client.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class AddReChangeButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public AddReChangeButton() {
		super();
	}

	protected void init() {
	
		this.funcId="frechgnew";
		this.defaultText="新增(再次变更)";
		this.iconName="add.jpg";
	  super.init();
	  
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_MASK),
				"newAction");
		getActionMap().put("newAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				doClick();
			}
		});

	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText()+"（Ctrl+R）";
	    super.setToolTipText(tipText);
	  }

}
