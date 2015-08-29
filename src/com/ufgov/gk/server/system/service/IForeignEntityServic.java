package com.ufgov.gk.server.system.service;

import java.util.List;

import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IForeignEntityServic {

  List getForeignEntitySelectedData(String sqlMapSelectedId, ElementConditionDto elementConditionDto, RequestMeta requestMeta);

}
