package com.ufgov.gk.client.component.button;


public class ResetButton extends FuncButton {
	/**
	 *
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public ResetButton() {
		super();
	}

	protected void init() {
    this.funcCtrl=false;
    this.funcId = "freset";
    this.defaultText="ÖØÖÃ";
	  super.init();
	}

	 public void setToolTipText(String text) {
	    String tipText=this.getText() ;
	    super.setToolTipText(tipText);
	  }

}
