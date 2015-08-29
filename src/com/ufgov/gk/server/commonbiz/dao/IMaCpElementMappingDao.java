package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.MaCpElementMapping;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IMaCpElementMappingDao {
	
	List getMaCpElementMapping( ElementConditionDto dto);
	
	void insert(MaCpElementMapping maCpElementMapping);
	void insert(List maCpElementMappingList);
	int  update(MaCpElementMapping maCpElementMapping);
	void  delete(int nd, String type,String useType);

}
