package com.ufgov.gk.client.component.button;


public class CarryDownButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public CarryDownButton() {
		super();
	}

	protected void init() {
	
		this.funcId="fcarrydown";
		this.defaultText="½á×ª";
	  super.init();

	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText();
	    super.setToolTipText(tipText);
	  }

}
