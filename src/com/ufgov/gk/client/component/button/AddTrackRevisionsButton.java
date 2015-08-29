package com.ufgov.gk.client.component.button;


public class AddTrackRevisionsButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

  public AddTrackRevisionsButton() {
		super();
	}

	protected void init() {
	
    this.funcId = "faddtrack";
    this.defaultText = "±£¡Ù∫€º£";
    this.iconName = "add.jpg";
	  super.init();

	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText();
	    super.setToolTipText(tipText);
	  }

}
