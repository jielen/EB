package com.ufgov.gk.client.component.button;

public class SubmitZY extends FuncButton {

	/**
	 * �����ύ
	 */
	private static final long serialVersionUID = 1L;

	public SubmitZY() {
		super();
	}

	protected void init() {
		this.funcId = "fsubmitzy";
		this.defaultText = "�����ύ";
		this.iconName = "sendBill.png";
		super.init();
	}
}
