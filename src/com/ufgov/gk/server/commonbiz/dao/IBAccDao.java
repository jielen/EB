package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IBAccDao {
	
List getRootBAcc(int nd);

List getChildrenBAcc(int nd);

List getBAcc(ElementConditionDto dto);

}
