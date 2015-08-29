package com.ufgov.gk.client.component.button;

public class ComplainButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComplainButton() {
		super();
	}

	protected void init() {
		this.funcId = "fcomplain";
		this.defaultText = "ÎÒÒªÍ¶Ëß";
		this.iconName = "sendBill.png";
		super.init();
	}
}
