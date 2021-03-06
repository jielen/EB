package com.ufgov.gk.server.commonbiz.service.impl;

import java.util.List;

import com.ufgov.gk.server.commonbiz.dao.ISendDocTypeDao;
import com.ufgov.gk.server.commonbiz.service.ISendDocTypeService;

public class SendDocTypeService implements ISendDocTypeService {
	private ISendDocTypeDao sendDocTypeDao ;
	
	public ISendDocTypeDao getSendDocTypeDao() {
		return sendDocTypeDao;
	}

	public void setSendDocTypeDao(ISendDocTypeDao sendDocTypeDao) {
		this.sendDocTypeDao = sendDocTypeDao;
	}

	public List getSendDocType(int nd) {
		
		return sendDocTypeDao.getSendDocType(nd);
	}

}
