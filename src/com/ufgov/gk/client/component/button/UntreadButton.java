package com.ufgov.gk.client.component.button;


public class UntreadButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6715792915113964497L;

	public UntreadButton() {
		super();
	}

	protected void init() {
		this.funcId="funtread";
		this.defaultText="ÍË»Ø";
		this.iconName="untread.jpg";
		super.init();
	}

}
