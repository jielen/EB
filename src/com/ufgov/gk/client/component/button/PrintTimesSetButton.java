package com.ufgov.gk.client.component.button;


public class PrintTimesSetButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public PrintTimesSetButton() {
		super();
	}

	protected void init() {
	
		this.funcId="fprintTimesSet";
		this.defaultText="���ô�ӡ״̬";
	  super.init();

	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText();
	    super.setToolTipText(tipText);
	  }

}
