package com.ufgov.gk.client.component.button;


public class FinishButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public FinishButton() {
		super();
	}

	protected void init() {
	
		this.funcId="f_finish";
		this.defaultText="Íê³É";
	  super.init();
	  

	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText() ;
	    super.setToolTipText(tipText);
	  }

}
