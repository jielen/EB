package com.ufgov.gk.common.system.model;

import java.io.Serializable;

public class AsNumToolNo implements Serializable {

	private static final long serialVersionUID = 5388754576980929041L;

	private String altPrefix;

	private String fixPrefix;

	private String numToolId;

	private Long numNo;

	public String getAltPrefix() {
		return altPrefix;
	}

	public void setAltPrefix(String altPrefix) {
		this.altPrefix = altPrefix;
	}

	public String getFixPrefix() {
		return fixPrefix;
	}

	public void setFixPrefix(String fixPrefix) {
		this.fixPrefix = fixPrefix;
	}

	public Long getNumNo() {
		return numNo;
	}

	public void setNumNo(Long numNo) {
		this.numNo = numNo;
	}

	public String getNumToolId() {
		return numToolId;
	}

	public void setNumToolId(String numToolId) {
		this.numToolId = numToolId;
	}

}
