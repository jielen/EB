package com.ufgov.gk.client.component.button;


public class CreateButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public CreateButton() {
		super();
	}

	protected void init() {
		this.funcId="fcreate";
		this.defaultText="Éú³É";
	  super.init();
	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText()+"£¨Ctrl+N£©";
	    super.setToolTipText(tipText);
	  }

}
