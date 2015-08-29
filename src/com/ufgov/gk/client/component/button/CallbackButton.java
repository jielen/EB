package com.ufgov.gk.client.component.button;


public class CallbackButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public CallbackButton() {
		super();
	}
	
	protected void init() {
		this.funcId="fcallback";
		this.defaultText=" ’ªÿ";
		this.iconName="callback.jpg";
	  super.init();
	}

}
