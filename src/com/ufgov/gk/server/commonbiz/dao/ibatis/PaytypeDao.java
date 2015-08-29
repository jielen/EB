package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.IPaytypeDao;

public class PaytypeDao extends SqlMapClientDaoSupport implements IPaytypeDao {

	public List getPaytype(ElementConditionDto dto) {
	return this.getSqlMapClientTemplate().queryForList("Paytype.getPaytype",dto);
	}

}
