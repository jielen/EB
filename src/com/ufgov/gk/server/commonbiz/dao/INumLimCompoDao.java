package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.NumLimCompo;

public interface INumLimCompoDao {
	
	List getNumLimCompo();

	NumLimCompo getNumLimCompoByCompoId(String compoId);
	
	List getNumLimCompoByParentCompoId(String parentCompoId);
	
}
