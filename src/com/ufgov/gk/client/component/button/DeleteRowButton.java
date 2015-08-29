package com.ufgov.gk.client.component.button;

import javax.swing.Action;
import javax.swing.Icon;

public class DeleteRowButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4783499025450922527L;

	public DeleteRowButton() {
		super();
	}

	public DeleteRowButton(Action a) {
		super(a);
	}

	public DeleteRowButton(Icon icon) {
		super(icon);
	}

	public DeleteRowButton(String text) {
		super(text);
	}

	public DeleteRowButton(String text, Icon icon) {
		super(text, icon);
	}

	protected void init() {
		this.funcCtrl=false;
		this.defaultText="ɾ����";
    super.init();

	}

}
