package com.ufgov.gk.client.component.button;


public class DelTrackRevisionsButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

  public DelTrackRevisionsButton() {
		super();
	}

	protected void init() {
	
    this.funcId = "fdeltrack";
    this.defaultText = "É¾³ýºÛ¼£";
    this.iconName = "delete.gif";
	  super.init();

	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText();
	    super.setToolTipText(tipText);
	  }

}
