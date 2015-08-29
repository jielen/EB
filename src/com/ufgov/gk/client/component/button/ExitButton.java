package com.ufgov.gk.client.component.button;


public class ExitButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8176162602374553497L;
    
	public ExitButton() {
		super();
	}

	protected void init() {
		this.funcCtrl=false;
	  // this.funcId = "fexit";
		this.defaultText="ÍË³ö";
		this.iconName="exit.jpg";
		super.init();
	}

}
