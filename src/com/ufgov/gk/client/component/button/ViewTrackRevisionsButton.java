package com.ufgov.gk.client.component.button;


public class ViewTrackRevisionsButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

  public ViewTrackRevisionsButton() {
		super();
	}

	protected void init() {
	
    this.funcId = "fview";
    this.defaultText = "œ‘ æ∫€º£";
		this.iconName="edit.jpg";
	  super.init();

	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText();
	    super.setToolTipText(tipText);
	  }

}
