package com.ufgov.gk.client.component.button;


public class BackButton extends FuncButton {

  private static final long serialVersionUID = -4801282269234069575L;

  public BackButton() {
		super();
	}

	protected void init() {
		this.funcId="fback";
		this.defaultText="������";
		this.iconName="back.png";
		super.init();
	}

}
