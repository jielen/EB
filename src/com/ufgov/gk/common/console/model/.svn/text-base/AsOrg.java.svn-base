package com.ufgov.gk.common.console.model;

import java.io.Serializable;

import com.ufgov.gk.common.commonbiz.model.BaseElement;

public class AsOrg extends BaseElement implements Serializable {

	private static final long serialVersionUID = 5156950107442824147L;

	// 组织机构的类型
	public final static String COMPANY = "company";
	public final static String ORG = "org";
	public final static String POSI = "position";
	public final static String EMP = "emp";
	public final static String UNRECOGNIZED = "unrecognized";	// 无法识别


	private String coCode;
	private String orgCode;
	private String posiCode;
	private String empCode;
	private String userId;
	private String normImg;


	public String getCoCode() {
		return coCode;
	}
	public void setCoCode(String coCode) {
		this.coCode = coCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNd() {
		return nd;
	}
	public void setNd(int nd) {
		this.nd = nd;
	}
	public String getNormImg() {
		return normImg;
	}
	public void setNormImg(String normImg) {
		this.normImg = normImg;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getPosiCode() {
		return posiCode;
	}
	public void setPosiCode(String posiCode) {
		this.posiCode = posiCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 获取该组织机构的类型
	 * @return
	 */
	public String getType() {
		if(coCode!=null && orgCode==null)
			return COMPANY;
		else if(coCode!=null && orgCode!=null && posiCode==null)
			return ORG;
		else if(coCode!=null && orgCode!=null && posiCode!=null && empCode==null)
			return POSI;
		else if(coCode!=null && orgCode!=null && posiCode!=null && empCode!=null)
			return EMP;
		else
			return UNRECOGNIZED;
	}

	/**
	 * 用于在树里显示
	 */
	public String toString() {
		return this.name;
	}

}
