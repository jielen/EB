package com.ufgov.gk.client.component.button;



public class BankQueryButton extends FuncButton {


	/**
   * 
   */
  private static final long serialVersionUID = -1041644129837692933L;

  public BankQueryButton() {
		super();
	}

	protected void init() {
	  this.funcCtrl = true;
		this.funcId="fquerybank";
		this.defaultText="∆æ÷§≤È—Ø";
		super.init();
	}
	
}
