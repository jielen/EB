package com.ufgov.gk.client.component.button;


public class DisTrackRevisionsButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

  public DisTrackRevisionsButton() {
		super();
	}

	protected void init() {
	
    this.funcId = "fdisplay";
    this.defaultText = "Òþ²ØºÛ¼£";
		this.iconName="edit.jpg";
	  super.init();

	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText();
	    super.setToolTipText(tipText);
	  }

}
