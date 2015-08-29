package com.ufgov.gk.client.component.button;



public class PayToBankButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public PayToBankButton() {
		super();
	}

	protected void init() {
	  this.funcCtrl = true;
		this.funcId="fpaytobank";
		this.defaultText="Ö§¸¶ÒøÐÐ";
		super.init();
	}
	
}
