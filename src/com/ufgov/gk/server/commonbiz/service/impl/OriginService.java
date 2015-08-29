package com.ufgov.gk.server.commonbiz.service.impl;

import java.util.List;

import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.IOriginDao;
import com.ufgov.gk.server.commonbiz.service.IOriginService;

public class OriginService implements IOriginService {
	private IOriginDao originDao ;
	
	public IOriginDao getOriginDao() {
		return originDao;
	}

	public void setOriginDao(IOriginDao originDao) {
		this.originDao = originDao;
	}

	public List getOrigin(ElementConditionDto dto) {
		
		return originDao.getOrigin(dto);
	}

}
