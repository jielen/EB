package com.ufgov.gk.client.component.button;


public class CommitButton extends FuncButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommitButton() {
		super();
	}

	protected void init() {
		this.funcId = "fcalc";
		this.defaultText = "Ã·Ωª";
		this.iconName = "commit.jpg";
		super.init();
	}

}
