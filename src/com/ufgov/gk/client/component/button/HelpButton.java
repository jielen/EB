package com.ufgov.gk.client.component.button;


public class HelpButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public HelpButton() {
		super();
	}

	protected void init() {
		this.funcCtrl=true;
		this.funcId="fhelp";
		this.defaultText="°ïÖú";
		this.iconName="help.gif";
		super.init();
		

	}
	

}
