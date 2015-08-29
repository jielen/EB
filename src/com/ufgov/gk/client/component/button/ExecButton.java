package com.ufgov.gk.client.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class ExecButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public ExecButton() {
		super();
	}

	protected void init() {
	  this.funcCtrl = true;
		this.funcId="fexec";
		this.defaultText="����Ӧ�ó���";
	  super.init();
	  
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK),
				"execAction");
		getActionMap().put("execAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				doClick();
			}
		});

	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText()+"��Ctrl+E��";
	    super.setToolTipText(tipText);
	  }

}
