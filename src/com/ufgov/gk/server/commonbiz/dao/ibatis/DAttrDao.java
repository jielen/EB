package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.IDAttrDao;

public class DAttrDao extends SqlMapClientDaoSupport implements IDAttrDao {

	public List getDAttr(ElementConditionDto dto) {
		return this.getSqlMapClientTemplate().queryForList("DAttr.getDAttr",dto);
	}

}
