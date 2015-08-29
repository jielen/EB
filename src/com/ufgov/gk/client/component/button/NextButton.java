package com.ufgov.gk.client.component.button;

import javax.swing.Action;
import javax.swing.Icon;

public class NextButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4783499025450922527L;

	public NextButton() {
		super();
	}

	public NextButton(Action a) {
		super(a);
	}

	public NextButton(Icon icon) {
		super(icon);
	}

	public NextButton(String text) {
		super(text);
	}

	public NextButton(String text, Icon icon) {
		super(text, icon);
	}

	protected void init() {
		this.funcCtrl=false;
		this.defaultText="ÏÂÒ»Ìõ";
		this.iconName="next.jpg";
    super.init();

	}

}
