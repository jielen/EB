package com.ufgov.gk.client.component.button;


public class EditButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public EditButton() {
		super();
	}

	protected void init() {
	
		this.funcId="fedit";
		this.defaultText="ÐÞ¸Ä";
		this.iconName="edit.jpg";
	  super.init();

	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText();
	    super.setToolTipText(tipText);
	  }

}
