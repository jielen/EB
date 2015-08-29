package com.ufgov.gk.client.component.button;


public class FinishItemButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public FinishItemButton() {
		super();
	}

	protected void init() {
	
		this.funcId="ffinishitem";
		this.defaultText="Ω·œÓ";
	  super.init();
	  

	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText() ;
	    super.setToolTipText(tipText);
	  }

}
