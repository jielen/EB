package com.ufgov.gk.client.component.button;


public class PendButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public PendButton() {
		super();
	}

	protected void init() {
	
		this.funcId="fpend";
		this.defaultText="´ý´¦Àí";
	  super.init();

	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText();
	    super.setToolTipText(tipText);
	  }

}
