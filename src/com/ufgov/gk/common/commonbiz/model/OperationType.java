package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;

public class OperationType  extends BaseElement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2054913945100029581L;

	private String flowCode;

  public String getFlowCode() {
    return flowCode;
  }

  public void setFlowCode(String flowCode) {
    this.flowCode = flowCode;
  }

	
}
