package com.ufgov.gk.client.component.button;


public class ForceTakeBackButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public ForceTakeBackButton() {
		super();
	}

	protected void init() {
	
		this.funcId="fforcetakeback";
		this.defaultText="ǿ���ջ�";
	  super.init();

	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText();
	    super.setToolTipText(tipText);
	  }

}
