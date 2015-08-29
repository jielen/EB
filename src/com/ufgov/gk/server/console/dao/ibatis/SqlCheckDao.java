package com.ufgov.gk.server.console.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.console.dao.ISqlCheckDao;
import com.ufgov.gk.server.system.util.Util;

public class SqlCheckDao extends SqlMapClientDaoSupport implements ISqlCheckDao {

	public void checkSelectSql(String selectSql) {
	  selectSql= Util.handleSv(selectSql);
		this.getSqlMapClientTemplate().queryForList("SqlCheck.checkSelectSql", selectSql);
	}
	
}
