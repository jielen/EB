package com.ufgov.gk.client.component.button;

import javax.swing.Action;
import javax.swing.Icon;

public class AddRowButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4783499025450922527L;

	public AddRowButton() {
		super();
	}

	public AddRowButton(Action a) {
		super(a);
	}

	public AddRowButton(Icon icon) {
		super(icon);
	}

	public AddRowButton(String text) {
		super(text);
	}

	public AddRowButton(String text, Icon icon) {
		super(text, icon);
	}

	protected void init() {
		this.funcCtrl=false;
		this.defaultText="������";
    super.init();

	}

}
