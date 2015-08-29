package com.ufgov.gk.client.component.button;


public class PreviousButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1984568193661510953L;

	public PreviousButton() {
		super();
	}

	protected void init() {
		this.funcCtrl=false;
		this.defaultText="…œ“ªÃı";
		this.iconName="previous.jpg";
		super.init();

	}

}
