package com.ufgov.gk.client.component.button;

import javax.swing.ImageIcon;


public class PrintButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public PrintButton() {
		super();
	}


	protected void init() {
		this.funcId="fprint";
		this.defaultText="¥Ú”°";
		this.iconName="print.gif";
		super.init();
	}
	

}
