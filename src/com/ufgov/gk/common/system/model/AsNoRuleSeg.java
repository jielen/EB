package com.ufgov.gk.common.system.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AsNoRuleSeg implements Serializable {

	private static final long serialVersionUID = -2587969413069277659L;

	private String compoId;

	private BigDecimal ordIndex;

	private String ruleCode;

	private String segField;

	private String segSv;

	private String segConst;

	private BigDecimal segLen;

	private String segFillPosi;

	private String segFill;

	private String segDeli;

	private String dateFmt;

	private String isBeforeNo;

	public String getCompoId() {
		return compoId;
	}

	public void setCompoId(String compoId) {
		this.compoId = compoId;
	}

	public String getDateFmt() {
		return dateFmt;
	}

	public void setDateFmt(String dateFmt) {
		this.dateFmt = dateFmt;
	}

	public String getIsBeforeNo() {
		return isBeforeNo;
	}

	public void setIsBeforeNo(String isBeforeNo) {
		this.isBeforeNo = isBeforeNo;
	}

	public BigDecimal getOrdIndex() {
		return ordIndex;
	}

	public void setOrdIndex(BigDecimal ordIndex) {
		this.ordIndex = ordIndex;
	}

	public String getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	public String getSegConst() {
		return segConst;
	}

	public void setSegConst(String segConst) {
		this.segConst = segConst;
	}

	public String getSegDeli() {
		return segDeli;
	}

	public void setSegDeli(String segDeli) {
		this.segDeli = segDeli;
	}

	public String getSegField() {
		return segField;
	}

	public void setSegField(String segField) {
		this.segField = segField;
	}

	public String getSegFill() {
		return segFill;
	}

	public void setSegFill(String segFill) {
		this.segFill = segFill;
	}

	public String getSegFillPosi() {
		return segFillPosi;
	}

	public void setSegFillPosi(String segFillPosi) {
		this.segFillPosi = segFillPosi;
	}

	public BigDecimal getSegLen() {
		return segLen;
	}

	public void setSegLen(BigDecimal segLen) {
		this.segLen = segLen;
	}

	public String getSegSv() {
		return segSv;
	}

	public void setSegSv(String segSv) {
		this.segSv = segSv;
	}

}
