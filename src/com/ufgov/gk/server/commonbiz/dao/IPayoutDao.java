package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IPayoutDao {
	
	List getPayout( ElementConditionDto dto);

}
