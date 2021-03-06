package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.commonbiz.dao.ISendDocTypeDao;

public class SendDocTypeDao extends SqlMapClientDaoSupport implements ISendDocTypeDao {

	public List getSendDocType(int nd) {
	return this.getSqlMapClientTemplate().queryForList("SendDocType.getSendDocType",new Integer(nd));
	}

}
