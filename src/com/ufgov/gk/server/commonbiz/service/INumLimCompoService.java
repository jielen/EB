package com.ufgov.gk.server.commonbiz.service;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.NumLimCompo;

public interface INumLimCompoService {

	List getNumLimCompo();
	
	NumLimCompo getNumLimCompoByCompoId(String compoId);
	
	List getNumLimCompoByParentCompoId(String parentCompoId);
	
}
