package com.ufgov.gk.client.component.button;


public class AcceptedButton extends FuncButton {

  private static final long serialVersionUID = -4801282269234069575L;

  public AcceptedButton() {
		super();
	}

	protected void init() {
		this.funcId="faccepted";
		this.defaultText="Ω” ’";
		this.iconName="accepted.png";
		super.init();
	}

}
