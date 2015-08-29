package com.ufgov.gk.client.component.button;



public class SendBillButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public SendBillButton() {
		super();
	}

	protected void init() {
		this.funcId="fsendBill";
		this.defaultText="·¢ËÍ";
		this.iconName="sendBill.png";
		super.init();
	}
	
}
