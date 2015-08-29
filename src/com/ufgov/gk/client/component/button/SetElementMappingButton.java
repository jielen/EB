package com.ufgov.gk.client.component.button;


public class SetElementMappingButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public SetElementMappingButton() {
		super();
	}

	protected void init() {
	
		this.funcId="fsetelementmapping";
		this.defaultText="����Ҫ�ض�Ӧ��ϵ";
	  super.init();
	}
	
	 public void setToolTipText(String text) {
	    String tipText=this.getText();
	    super.setToolTipText(tipText);
	  }

}
