package com.ufgov.gk.server.console.service.impl;

import com.ufgov.gk.server.console.dao.ISqlCheckDao;
import com.ufgov.gk.server.console.service.ISqlCheckService;

public class SqlCheckService implements ISqlCheckService {
	
	ISqlCheckDao sqlCheckDao;

	public ISqlCheckDao getSqlCheckDao() {
		return sqlCheckDao;
	}

	public void setSqlCheckDao(ISqlCheckDao sqlCheckDao) {
		this.sqlCheckDao = sqlCheckDao;
	}

	public void checkSelectSql(String selectSql) {
		sqlCheckDao.checkSelectSql(selectSql);
	}

}
