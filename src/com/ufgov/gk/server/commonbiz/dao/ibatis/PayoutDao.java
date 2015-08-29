package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.IPayoutDao;

public class PayoutDao extends SqlMapClientDaoSupport implements IPayoutDao {

	public List getPayout(ElementConditionDto dto) {
	 return this.getSqlMapClientTemplate().queryForList("Payout.getPayout",dto);
	}

}
