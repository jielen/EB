package com.ufgov.gk.common.system.model;

import java.io.Serializable;

public class AsNumTool implements Serializable {

	private static final long serialVersionUID = -5440373154175648339L;
	
	private String numToolId;
	private String numToolName;
	private String isCont;
	private String numToolDesc;
	
	public String getIsCont() {
		return isCont;
	}
	public void setIsCont(String isCont) {
		this.isCont = isCont;
	}
	public String getNumToolDesc() {
		return numToolDesc;
	}
	public void setNumToolDesc(String numToolDesc) {
		this.numToolDesc = numToolDesc;
	}
	public String getNumToolId() {
		return numToolId;
	}
	public void setNumToolId(String numToolId) {
		this.numToolId = numToolId;
	}
	public String getNumToolName() {
		return numToolName;
	}
	public void setNumToolName(String numToolName) {
		this.numToolName = numToolName;
	}
	
}
