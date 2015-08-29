package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.IOriginDao;

public class OriginDao extends SqlMapClientDaoSupport implements IOriginDao {

	public List getOrigin(ElementConditionDto dto) {
	return this.getSqlMapClientTemplate().queryForList("Origin.getOrigin",dto);
	}

}
