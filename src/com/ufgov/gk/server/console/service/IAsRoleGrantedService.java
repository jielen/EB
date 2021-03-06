package com.ufgov.gk.server.console.service;

import java.util.List;

import com.ufgov.gk.common.console.model.AsGrantedRole;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IAsRoleGrantedService {
  public List getUserGrantedRole(ElementConditionDto condition);

  public void insertGrantedRole(AsGrantedRole grantedRole);
  
  public void insertGrantedRoles(List roles);

  public void deleteGrantedRoleById(String id);
  
  public void deleteGrantedRoles(List roles);

  public void deleteGrantedRoleByGranted(ElementConditionDto condition);

  public void deleteGrantedRoleByGrant(ElementConditionDto condition);
  
  public void deleteAllGrantedTask(String granter);
  
  public void deleteSelectedGrantedTask(String granter, String granterInfo, String granted);
  
  public void insertGrantedTask(String granter, String granted, String granterInfo, String roleids);
}
