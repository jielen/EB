package com.ufgov.gk.client.component.button;


public class TakeBackButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public TakeBackButton() {
		super();
	}

	protected void init() {
	
		this.funcId="ftakeback";
		this.defaultText=" ’ªÿ";
	  super.init();

	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText();
	    super.setToolTipText(tipText);
	  }

}
