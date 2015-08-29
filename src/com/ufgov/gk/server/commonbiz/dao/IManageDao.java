package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IManageDao {

  List getManage(ElementConditionDto dto);

  List getManageForBiXJ(ElementConditionDto dto);

  void updateBiManage(List uList);

  void insertBiManage(List iList);

  void deleteManage(List idList);

}
