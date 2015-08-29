package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IOutlayDao {
	
List getRootOutlay(int nd);

List getChildrenOutlay(int nd);

List getOutlay(ElementConditionDto dto);

}
