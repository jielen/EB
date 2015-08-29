package com.ufgov.gk.server.commonbiz.service;

import java.util.List;

import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IManageService {

	List getManage( ElementConditionDto dto);

	List  getManageForBiXJ(ElementConditionDto dto);

	void saveBiManageXJ(List insertList, List updateList);

	void deleteManage(List idList);
}
