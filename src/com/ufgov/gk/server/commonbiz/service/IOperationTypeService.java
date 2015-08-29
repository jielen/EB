package com.ufgov.gk.server.commonbiz.service;

import java.util.List;

import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IOperationTypeService {
  
  List getOperationType( ElementConditionDto dto);

}
