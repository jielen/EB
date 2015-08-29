package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.commonbiz.dao.IProjectTypeDao;

public class ProjectTypeDao extends SqlMapClientDaoSupport implements
		IProjectTypeDao {

	public List getChildrenProjectType(int nd) {
		return this.getSqlMapClientTemplate().queryForList("ProjectType.getChildrenProjectType", new Integer(nd));
	}

	public List getProjectType(int nd) {
		return this.getSqlMapClientTemplate().queryForList("ProjectType.getProjectType", new Integer(nd));
	}

	public List getRootProjectType(int nd) {
		return this.getSqlMapClientTemplate().queryForList("ProjectType.getRootProjectType", new Integer(nd));
	}

}
