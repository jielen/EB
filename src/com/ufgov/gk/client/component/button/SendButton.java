package com.ufgov.gk.client.component.button;



public class SendButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public SendButton() {
		super();
	}

	protected void init() {
		this.funcId="fnewcommit";
		this.defaultText="ÀÕ…Û";
		this.iconName="send.jpg";
		super.init();
	}
	
}
