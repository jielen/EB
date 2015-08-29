package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.commonbiz.dao.IContractDao;

public class ContractDao extends SqlMapClientDaoSupport implements IContractDao {

	public List getContract(int nd) {
	return this.getSqlMapClientTemplate().queryForList("Contract.getContract",new Integer(nd));
	}

}
