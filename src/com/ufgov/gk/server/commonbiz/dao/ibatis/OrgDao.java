package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.IOrgDao;

public class OrgDao extends SqlMapClientDaoSupport implements IOrgDao {

	public List getCzOrg(int nd) {
	return this.getSqlMapClientTemplate().queryForList("Org.getCzOrg",new Integer(nd));
	}

	 public List getZcOrg(int nd) {
	   return this.getSqlMapClientTemplate().queryForList("Org.getZcOrg",new Integer(nd));
	   }

	
	 public List getOrg(int nd) {
	   return this.getSqlMapClientTemplate().queryForList("Org.getOrg",new Integer(nd));
	   }

	 public List getOrg(ElementConditionDto dto){
	   return this.getSqlMapClientTemplate().queryForList("Org.getOrgByDto",dto);
	 }

	  public List getPosition(int nd){
	    return this.getSqlMapClientTemplate().queryForList("Org.getPosition",new Integer(nd));
	  }
	  public List getEmp(int nd){
	    return this.getSqlMapClientTemplate().queryForList("Org.getEmp",new Integer(nd));
	  }
}
