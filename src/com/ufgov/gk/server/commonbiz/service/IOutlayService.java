package com.ufgov.gk.server.commonbiz.service;

import java.util.List;

import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IOutlayService {
	
	List getOutlayTree(int nd);
	
	List getOutlay(ElementConditionDto dto);

}
