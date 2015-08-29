package com.ufgov.gk.client.component.button;

import com.ufgov.gk.client.common.WorkEnv;


public class SystemSettingButton extends FuncButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564446291342163428L;

	public SystemSettingButton() {
		super();
	}

	protected void init() {
	  this.funcCtrl=false;
		this.defaultText="œµÕ≥…Ë÷√";
		super.init();
	}
	
	 public void setVisible(boolean aFlag) {
	   String userId=WorkEnv.getInstance().getCurrUserId();
	   if("sa".equals(userId)){
	     super.setVisible(aFlag);
	   }
	   else{
	     super.setVisible(false);
	   }
	 }

}
