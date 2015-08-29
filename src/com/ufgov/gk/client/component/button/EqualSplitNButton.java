package com.ufgov.gk.client.component.button;


public class EqualSplitNButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public EqualSplitNButton() {
		super();
	}

	protected void init() {
    this.funcId="fequalsplit_n";
    this.defaultText="¾ù·Ö";
	  super.init();
	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText() ;
	    super.setToolTipText(tipText);
	  }

}
