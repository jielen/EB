package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.IOutlayDao;

public class OutlayDao extends SqlMapClientDaoSupport implements IOutlayDao {

	public List getChildrenOutlay(int nd) {
    return this.getSqlMapClientTemplate().queryForList("Outlay.getChildrenOutlay", new Integer(nd));
	}

	public List getRootOutlay(int nd) {
		 return this.getSqlMapClientTemplate().queryForList("Outlay.getRootOutlay", new Integer(nd));
	}
	
	public List getOutlay(ElementConditionDto dto){
		return this.getSqlMapClientTemplate().queryForList("Outlay.getOutlay",dto);
	}



}
