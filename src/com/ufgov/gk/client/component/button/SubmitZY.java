package com.ufgov.gk.client.component.button;

public class SubmitZY extends FuncButton {

	/**
	 * 质疑提交
	 */
	private static final long serialVersionUID = 1L;

	public SubmitZY() {
		super();
	}

	protected void init() {
		this.funcId = "fsubmitzy";
		this.defaultText = "质疑提交";
		this.iconName = "sendBill.png";
		super.init();
	}
}
