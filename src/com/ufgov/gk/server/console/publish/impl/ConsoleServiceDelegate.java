package com.ufgov.gk.server.console.publish.impl;

import java.util.List;

import com.ufgov.gk.common.console.model.AsGrantedRole;
import com.ufgov.gk.common.console.model.AsRole;
import com.ufgov.gk.common.console.model.AsRoleNumLim;
import com.ufgov.gk.common.console.model.AsUserNumLim;
import com.ufgov.gk.common.console.model.MaRoleNumLim;
import com.ufgov.gk.common.console.model.MaUserNumLim;
import com.ufgov.gk.common.console.publish.IConsoleServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.console.service.IAsEmpService;
import com.ufgov.gk.server.console.service.IAsOrgService;
import com.ufgov.gk.server.console.service.IAsRoleGrantedService;
import com.ufgov.gk.server.console.service.IAsRoleNumLimService;
import com.ufgov.gk.server.console.service.IAsRoleService;
import com.ufgov.gk.server.console.service.IAsUserNumLimService;
import com.ufgov.gk.server.console.service.IComponentService;
import com.ufgov.gk.server.console.service.IGkCompoNewToOldService;
import com.ufgov.gk.server.console.service.IGkGetdataRuleService;
import com.ufgov.gk.server.console.service.IMaRoleNumLimService;
import com.ufgov.gk.server.console.service.IMaUserNumLimService;
import com.ufgov.gk.server.console.service.IMenuService;
import com.ufgov.gk.server.console.service.ISqlCheckService;

public class ConsoleServiceDelegate implements IConsoleServiceDelegate {

  private IAsOrgService asOrgService;

  private IAsRoleNumLimService asRoleNumLimService;

  private IAsRoleService asRoleService;

  private IAsUserNumLimService asUserNumLimService;

  private IComponentService componentService;

  private IMaRoleNumLimService maRoleNumLimService;

  private IMaUserNumLimService maUserNumLimService;

  private IMenuService menuService;

  private ISqlCheckService sqlCheckService;

  private IAsEmpService asEmpService;

  private IAsRoleGrantedService asRoleGrantedService;

  public IAsRoleGrantedService getAsRoleGrantedService() {
    return asRoleGrantedService;
  }

  public void setAsRoleGrantedService(IAsRoleGrantedService asRoleGrantedService) {
    this.asRoleGrantedService = asRoleGrantedService;
  }

  public IAsEmpService getAsEmpService() {
    return asEmpService;
  }

  public void setAsEmpService(IAsEmpService asEmpService) {
    this.asEmpService = asEmpService;
  }

  public void checkSelectSql(String selectSql, RequestMeta requestMeta) {
    sqlCheckService.checkSelectSql(selectSql);
  }

  public int deleteAsRoleNumLim(String roleId, String compoId, String funcId, String ctrlField,
    RequestMeta requestMeta) {
    return asRoleNumLimService.deleteAsRoleNumLim(roleId, compoId, funcId, ctrlField);
  }

  public int deleteAsUserNumLim(String userId, String compoId, String funcId, String ctrlField,
    RequestMeta requestMeta) {
    return asUserNumLimService.deleteAsUserNumLim(userId, compoId, funcId, ctrlField);
  }

  public int deleteMaRoleNumLim(String roleId, String compoId, String funcId, String ctrlField,
    RequestMeta requestMeta) {
    return maRoleNumLimService.deleteMaRoleNumLim(roleId, compoId, funcId, ctrlField);
  }

  public int deleteMaUserNumLim(String userId, String compoId, String funcId, String ctrlField,
    RequestMeta requestMeta) {
    return maUserNumLimService.deleteMaUserNumLim(userId, compoId, funcId, ctrlField);
  }

  public List getAsOrg(int nd, RequestMeta requestMeta) {
    return asOrgService.getAsOrg(nd);
  }

  public List getAsOrg(int nd, String coCode, RequestMeta requestMeta) {
    return asOrgService.getAsOrg(nd, coCode);
  }

  public List getAsRole(int nd, RequestMeta requestMeta) {
    return asRoleService.getAsRole(nd);
  }

  public AsRole getAsRoleById(String id, RequestMeta requestMeta) {
    return asRoleService.getAsRoleById(id);
  }

  public List getAsRoleNumLim(String roleId, String compoId, String funcId, String ctrlField,
    RequestMeta requestMeta) {
    return asRoleNumLimService.getAsRoleNumLim(roleId, compoId, funcId, ctrlField);
  }

  public List getAsRoleNumLimByUserId(String userId, String compoId, String funcId, String ctrlField,
    RequestMeta requestMeta) {
    return asRoleNumLimService.getAsRoleNumLimByUserId(userId, compoId, funcId, ctrlField);
  }

  public List getAsUserNumLim(String userId, String compoId, String funcId, String ctrlField,
    RequestMeta requestMeta) {
    return asUserNumLimService.getAsUserNumLim(userId, compoId, funcId, ctrlField);
  }

  public List getCompoList(RequestMeta requestMeta) {
    return componentService.getCompoList();
  }

  public List getFunctionList(String compoId, RequestMeta requestMeta) {
    return componentService.getFunctionList(compoId);
  }

  public List getMaRoleNumLim(String roleId, String compoId, String funcId, String ctrlField,
    RequestMeta requestMeta) {
    return maRoleNumLimService.getMaRoleNumLim(roleId, compoId, funcId, ctrlField);
  }

  public List getMaUserNumLim(String userId, String compoId, String funcId, String ctrlField,
    RequestMeta requestMeta) {
    return maUserNumLimService.getMaUserNumLim(userId, compoId, funcId, ctrlField);
  }

  public List getMenuList(String systemCode, String roleCode, RequestMeta requestMeta) {
    return menuService.getMenuList(systemCode, roleCode);
  }

  public AsRoleNumLim insertAsRoleNumLim(AsRoleNumLim asRoleNumLim, RequestMeta requestMeta) {
    return asRoleNumLimService.insertAsRoleNumLim(asRoleNumLim);
  }

  public AsUserNumLim insertAsUserNumLim(AsUserNumLim asUserNumLim, RequestMeta requestMeta) {
    return asUserNumLimService.insertAsUserNumLim(asUserNumLim);
  }

  public MaRoleNumLim insertMaRoleNumLim(MaRoleNumLim maRoleNumLim, RequestMeta requestMeta) {
    return maRoleNumLimService.insertMaRoleNumLim(maRoleNumLim);
  }

  public void insertMaRoleNumLimList(List maRoleNumLimList, RequestMeta requestMeta) {
    maRoleNumLimService.insertMaRoleNumLimList(maRoleNumLimList);
  }

  public MaUserNumLim insertMaUserNumLim(MaUserNumLim maUserNumLim, RequestMeta requestMeta) {
    return maUserNumLimService.insertMaUserNumLim(maUserNumLim);
  }

  public void insertMaUserNumLimList(List maUserNumLimList, RequestMeta requestMeta) {
    maUserNumLimService.insertMaUserNumLimList(maUserNumLimList);
  }

  public AsRoleNumLim updateAsRoleNumLim(AsRoleNumLim asRoleNumLim, RequestMeta requestMeta) {
    return asRoleNumLimService.updateAsRoleNumLim(asRoleNumLim);
  }

  public AsUserNumLim updateAsUserNumLim(AsUserNumLim asUserNumLim, RequestMeta requestMeta) {
    return asUserNumLimService.updateAsUserNumLim(asUserNumLim);
  }

  public void updateMaRoleNumLimList(String roleId, String compoId, String funcId, String ctrlField,
    List maRoleNumLimList, RequestMeta requestMeta) {
    maRoleNumLimService.updateMaRoleNumLimList(roleId, compoId, funcId, ctrlField, maRoleNumLimList);
  }

  public void updateMaUserNumLimList(String userId, String compoId, String funcId, String ctrlField,
    List maUserNumLimList, RequestMeta requestMeta) {
    maUserNumLimService.updateMaUserNumLimList(userId, compoId, funcId, ctrlField, maUserNumLimList);
  }

  public IAsOrgService getAsOrgService() {
    return asOrgService;
  }

  public void setAsOrgService(IAsOrgService asOrgService) {
    this.asOrgService = asOrgService;
  }

  public IAsRoleNumLimService getAsRoleNumLimService() {
    return asRoleNumLimService;
  }

  public void setAsRoleNumLimService(IAsRoleNumLimService asRoleNumLimService) {
    this.asRoleNumLimService = asRoleNumLimService;
  }

  public IAsRoleService getAsRoleService() {
    return asRoleService;
  }

  public void setAsRoleService(IAsRoleService asRoleService) {
    this.asRoleService = asRoleService;
  }

  public IAsUserNumLimService getAsUserNumLimService() {
    return asUserNumLimService;
  }

  public void setAsUserNumLimService(IAsUserNumLimService asUserNumLimService) {
    this.asUserNumLimService = asUserNumLimService;
  }

  public IComponentService getComponentService() {
    return componentService;
  }

  public void setComponentService(IComponentService componentService) {
    this.componentService = componentService;
  }

  public IMaRoleNumLimService getMaRoleNumLimService() {
    return maRoleNumLimService;
  }

  public void setMaRoleNumLimService(IMaRoleNumLimService maRoleNumLimService) {
    this.maRoleNumLimService = maRoleNumLimService;
  }

  public IMaUserNumLimService getMaUserNumLimService() {
    return maUserNumLimService;
  }

  public void setMaUserNumLimService(IMaUserNumLimService maUserNumLimService) {
    this.maUserNumLimService = maUserNumLimService;
  }

  public IMenuService getMenuService() {
    return menuService;
  }

  public void setMenuService(IMenuService menuService) {
    this.menuService = menuService;
  }

  public ISqlCheckService getSqlCheckService() {
    return sqlCheckService;
  }

  public void setSqlCheckService(ISqlCheckService sqlCheckService) {
    this.sqlCheckService = sqlCheckService;
  }

  private IGkCompoNewToOldService gkCompoNewToOldService;

  public List getGkCompoNewToOld(RequestMeta requestMeta) {
    return gkCompoNewToOldService.getGkCompoNewToOld();
  }

  private IGkGetdataRuleService gkGetdataRuleService;

  public List getGkGetdataRule(RequestMeta requestMeta) {
    return gkGetdataRuleService.getGkGetdataRule();
  }

  public void updateGkGetdataRule(List gkGetdataRuleList, RequestMeta requestMeta) {
    gkGetdataRuleService.updateGkGetdataRule(gkGetdataRuleList);
  }

  public IGkCompoNewToOldService getGkCompoNewToOldService() {
    return gkCompoNewToOldService;
  }

  public void setGkCompoNewToOldService(IGkCompoNewToOldService gkCompoNewToOldService) {
    this.gkCompoNewToOldService = gkCompoNewToOldService;
  }

  public IGkGetdataRuleService getGkGetdataRuleService() {
    return gkGetdataRuleService;
  }

  public void setGkGetdataRuleService(IGkGetdataRuleService gkGetdataRuleService) {
    this.gkGetdataRuleService = gkGetdataRuleService;
  }

  public List getAsOrgByCocode(String cocode, String nd, RequestMeta requestMeta) {
    return this.asOrgService.getAsOrgByCocode(cocode, nd);
  }

  public List getOrgAsEmp(ElementConditionDto dto, RequestMeta requestMeta) {
    return this.asEmpService.getOrgAsEmp(dto);
  }

  public void deleteGrantedRoleByGrant(ElementConditionDto condition, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    this.asRoleGrantedService.deleteGrantedRoleByGrant(condition);
  }

  public void deleteGrantedRoleByGranted(ElementConditionDto condition, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    this.asRoleGrantedService.deleteGrantedRoleByGranted(condition);
  }

  public void deleteGrantedRoleById(String id, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    this.asRoleGrantedService.deleteGrantedRoleById(id);
  }

  public List getUserGrantedRole(ElementConditionDto condition, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return asRoleGrantedService.getUserGrantedRole(condition);
  }

  public void insertGrantedRole(AsGrantedRole grantedRole, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    asRoleGrantedService.insertGrantedRole(grantedRole);
  }
  
  public void insertGrantedRoles(List roles, RequestMeta requestMeta) {
    asRoleGrantedService.insertGrantedRoles(roles);
  }

  public List getAsRoleByPosi(String posi, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return asRoleService.getAsRoleByPosi(posi);
  }

  public void deleteGrantedRoles(List roles, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    asRoleGrantedService.deleteGrantedRoles(roles);
  }

  public void deleteAllGrantedTask(String granter, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    asRoleGrantedService.deleteAllGrantedTask(granter);
  }

  public void deleteSelectedGrantedTask(String granter, String granterInfo, String granted, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    asRoleGrantedService.deleteSelectedGrantedTask(granter, granterInfo, granted);
  }
  
  public void insertGrantedTask(String granter, String granted, String granterInfo, String roleids, RequestMeta requestMeta) {
    asRoleGrantedService.insertGrantedTask(granter, granted, granterInfo, roleids);
  }

}
