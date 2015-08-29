package com.ufgov.gk.server.commonbiz.service;

import java.util.List;

import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IMaCpElementMappingService {

  List getMaCpElementMapping(ElementConditionDto dto);

  void  save(List maCpElementMappingList,String type,String useType);

}
