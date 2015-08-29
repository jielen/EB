package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.commonbiz.dao.IInceptDocDao;

public class InceptDocDao extends SqlMapClientDaoSupport implements IInceptDocDao {

	public List getInceptDoc(int nd) {
	return this.getSqlMapClientTemplate().queryForList("InceptDoc.getInceptDoc",new Integer(nd));
	}

}
