package com.ufgov.gk.server.commonbiz.service.impl;

import java.util.List;

import com.ufgov.gk.server.commonbiz.dao.INumLimCompoDao;
import com.ufgov.gk.server.commonbiz.service.INumLimCompoService;
import com.ufgov.gk.common.commonbiz.model.NumLimCompo;

public class NumLimCompoService implements INumLimCompoService {
	
	private INumLimCompoDao numLimCompoDao;

	public INumLimCompoDao getNumLimCompoDao() {
		return numLimCompoDao;
	}

	public void setNumLimCompoDao(INumLimCompoDao numLimCompoDao) {
		this.numLimCompoDao = numLimCompoDao;
	}

	public List getNumLimCompo() {
		return numLimCompoDao.getNumLimCompo();
	}
	
	public NumLimCompo getNumLimCompoByCompoId(String compoId) {
		return numLimCompoDao.getNumLimCompoByCompoId(compoId);
	}

	public List getNumLimCompoByParentCompoId(String parentCompoId) {
		return numLimCompoDao.getNumLimCompoByParentCompoId(parentCompoId);
	}
	
}
