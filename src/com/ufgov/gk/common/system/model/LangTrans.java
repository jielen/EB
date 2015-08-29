package com.ufgov.gk.common.system.model;

import java.io.Serializable;

public class LangTrans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resId;
	private String langId;
	private String resNa;
	
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public String getLangId() {
		return langId;
	}
	public void setLangId(String langId) {
		this.langId = langId;
	}
	public String getResNa() {
		return resNa;
	}
	public void setResNa(String resNa) {
		this.resNa = resNa;
	}
	
	
}
