package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.IBAccDao;

public class BAccDao extends SqlMapClientDaoSupport implements IBAccDao {

	public List getChildrenBAcc(int nd) {
		return this.getSqlMapClientTemplate().queryForList("BAcc.getChildrenBAcc",new Integer(nd));
	}

	public List getRootBAcc(int nd) {
		return this.getSqlMapClientTemplate().queryForList("BAcc.getRootBAcc",new Integer(nd));
	}
	
	public List getBAcc(ElementConditionDto dto){
		return this.getSqlMapClientTemplate().queryForList("BAcc.getBAcc",dto);
	}

}
