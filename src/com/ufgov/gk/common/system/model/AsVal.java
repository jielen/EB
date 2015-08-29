package com.ufgov.gk.common.system.model;

import java.io.Serializable;

public class AsVal implements Serializable{

	private static final long serialVersionUID = -2011653545828332493L;
	
	private String valSetId;
	private String valId;
	private String val;
	
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public String getValId() {
		return valId;
	}
	public void setValId(String valId) {
		this.valId = valId;
	}
	public String getValSetId() {
		return valSetId;
	}
	public void setValSetId(String valSetId) {
		this.valSetId = valSetId;
	}
	
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((val == null) ? 0 : val.hashCode());
		result = PRIME * result + ((valId == null) ? 0 : valId.hashCode());
		result = PRIME * result + ((valSetId == null) ? 0 : valSetId.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final AsVal other = (AsVal) obj;
		if (val == null) {
			if (other.val != null)
				return false;
		} else if (!val.equals(other.val))
			return false;
		if (valId == null) {
			if (other.valId != null)
				return false;
		} else if (!valId.equals(other.valId))
			return false;
		if (valSetId == null) {
			if (other.valSetId != null)
				return false;
		} else if (!valSetId.equals(other.valSetId))
			return false;
		return true;
	}
	
	

}
