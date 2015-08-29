package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.commonbiz.dao.INumLimCompoDao;
import com.ufgov.gk.common.commonbiz.model.NumLimCompo;

public class NumLimCompoDao extends SqlMapClientDaoSupport implements INumLimCompoDao {
	
	public List getNumLimCompo() {
		return this.getSqlMapClientTemplate().queryForList("NumLimCompo.getNumLimCompo");
	}
	
	public NumLimCompo getNumLimCompoByCompoId(String compoId) {
		return (NumLimCompo)this.getSqlMapClientTemplate().queryForObject(
				"NumLimCompo.getNumLimCompoByCompoId", compoId);
	}

	public List getNumLimCompoByParentCompoId(String parentCompoId) {
		return this.getSqlMapClientTemplate().queryForList(
				"NumLimCompo.getNumLimCompoByParentCompoId", parentCompoId);
	}

}
