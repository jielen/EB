package com.ufgov.gk.server.commonbiz.service.impl;

import java.util.List;

import com.ufgov.gk.server.commonbiz.dao.IInceptDocDao;
import com.ufgov.gk.server.commonbiz.service.IInceptDocService;

public class InceptDocService implements IInceptDocService {
	private IInceptDocDao inceptDocDao ;
	
	public IInceptDocDao getInceptDocDao() {
		return inceptDocDao;
	}

	public void setInceptDocDao(IInceptDocDao inceptDocDao) {
		this.inceptDocDao = inceptDocDao;
	}

	public List getInceptDoc(int nd) {
		
		return inceptDocDao.getInceptDoc(nd);
	}

}
