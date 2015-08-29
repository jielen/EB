package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;

public class NumLimCompo implements Serializable {

	private static final long serialVersionUID = 101044846014921814L;

	private String compoId;
	private String compoName;
	private String parentCompoId;
	private String tableId;
  private String billTypeCode;
	private String remark;
	
	public String getTableId() {
		return tableId;
	}
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	public String getCompoId() {
		return compoId;
	}
	public void setCompoId(String compoId) {
		this.compoId = compoId;
	}
	public String getCompoName() {
		return compoName;
	}
	public void setCompoName(String compoName) {
		this.compoName = compoName;
	}
	public String getParentCompoId() {
		return parentCompoId;
	}
	public void setParentCompoId(String parentCompoId) {
		this.parentCompoId = parentCompoId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
  public String getBillTypeCode() {
    return billTypeCode;
  }
  public void setBillTypeCode(String billTypeCode) {
    this.billTypeCode = billTypeCode;
  }
  
  public String toString() {
    return compoId + " " + compoName;
  }
	
}
