package com.ufgov.gk.common.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageData implements Serializable {
	
	private List data = new ArrayList();
	
	private int recordCount;

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

}
