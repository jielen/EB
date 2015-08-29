package com.ufgov.gk.client.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class SendTZDButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2352845141080851653L;

	public SendTZDButton() {
		super();
	}

	protected void init() {
		this.funcId = "f_send";
		this.defaultText = "����";
		this.iconName = "";
		super.init();

		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK),
				"newAction");
		getActionMap().put("newAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				doClick();
			}
		});

	}

	public void setToolTipText(String text) {
		String tipText = this.getText() + "��Ctrl+S��";
		super.setToolTipText(tipText);
	}
}
