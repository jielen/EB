package com.ufgov.gk.common.console.publish;

import java.util.List;

import com.ufgov.gk.common.console.model.AsGrantedRole;
import com.ufgov.gk.common.console.model.AsRole;
import com.ufgov.gk.common.console.model.AsRoleNumLim;
import com.ufgov.gk.common.console.model.AsUserNumLim;
import com.ufgov.gk.common.console.model.MaRoleNumLim;
import com.ufgov.gk.common.console.model.MaUserNumLim;
import com.ufgov.gk.common.system.Publishable;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IConsoleServiceDelegate extends Publishable {

  List getAsOrg(int nd, RequestMeta requestMeta);

  List getAsOrg(int nd, String coCode, RequestMeta requestMeta);

  List getAsRoleNumLim(String roleId, String compoId, String funcId, String ctrlField, RequestMeta requestMeta);

  int deleteAsRoleNumLim(String roleId, String compoId, String funcId, String ctrlField,
    RequestMeta requestMeta);

  AsRoleNumLim insertAsRoleNumLim(AsRoleNumLim asRoleNumLim, RequestMeta requestMeta);

  AsRoleNumLim updateAsRoleNumLim(AsRoleNumLim asRoleNumLim, RequestMeta requestMeta);

  List getAsRoleNumLimByUserId(String userId, String compoId, String funcId, String ctrlField,
    RequestMeta requestMeta);

  List getAsRole(int nd, RequestMeta requestMeta);

  AsRole getAsRoleById(String id, RequestMeta requestMeta);

  List getAsUserNumLim(String userId, String compoId, String funcId, String ctrlField, RequestMeta requestMeta);

  int deleteAsUserNumLim(String userId, String compoId, String funcId, String ctrlField,
    RequestMeta requestMeta);

  AsUserNumLim insertAsUserNumLim(AsUserNumLim asUserNumLim, RequestMeta requestMeta);

  AsUserNumLim updateAsUserNumLim(AsUserNumLim asUserNumLim, RequestMeta requestMeta);

  List getCompoList(RequestMeta requestMeta);

  List getFunctionList(String compoId, RequestMeta requestMeta);

  List getMaRoleNumLim(String roleId, String compoId, String funcId, String ctrlField, RequestMeta requestMeta);

  int deleteMaRoleNumLim(String roleId, String compoId, String funcId, String ctrlField,
    RequestMeta requestMeta);

  MaRoleNumLim insertMaRoleNumLim(MaRoleNumLim maRoleNumLim, RequestMeta requestMeta);

  void insertMaRoleNumLimList(List maRoleNumLimList, RequestMeta requestMeta);

  void updateMaRoleNumLimList(String roleId, String compoId, String funcId, String ctrlField,
    List maRoleNumLimList, RequestMeta requestMeta);

  List getMaUserNumLim(String userId, String compoId, String funcId, String ctrlField, RequestMeta requestMeta);

  int deleteMaUserNumLim(String userId, String compoId, String funcId, String ctrlField,
    RequestMeta requestMeta);

  MaUserNumLim insertMaUserNumLim(MaUserNumLim maUserNumLim, RequestMeta requestMeta);

  void insertMaUserNumLimList(List maUserNumLimList, RequestMeta requestMeta);

  void updateMaUserNumLimList(String userId, String compoId, String funcId, String ctrlField,
    List maUserNumLimList, RequestMeta requestMeta);

  List getMenuList(String systemCode, String roleCode, RequestMeta requestMeta);

  void checkSelectSql(String selectSql, RequestMeta requestMeta);

  public List getGkCompoNewToOld(RequestMeta requestMeta);

  public List getGkGetdataRule(RequestMeta requestMeta);

  public void updateGkGetdataRule(List gkGetdataRuleList, RequestMeta requestMeta);

  public List getAsOrgByCocode(String cocode, String nd, RequestMeta requestMeta);

  public List getOrgAsEmp(ElementConditionDto dto, RequestMeta requestMeta);

  public List getUserGrantedRole(ElementConditionDto condition, RequestMeta requestMeta);

  public void insertGrantedRole(AsGrantedRole grantedRole, RequestMeta requestMeta);

  public void deleteGrantedRoleById(String id, RequestMeta requestMeta);

  public void deleteGrantedRoleByGranted(ElementConditionDto condition, RequestMeta requestMeta);

  public void deleteGrantedRoleByGrant(ElementConditionDto condition, RequestMeta requestMeta);

  public List getAsRoleByPosi(String posi, RequestMeta requestMeta);

  public void insertGrantedRoles(List roles, RequestMeta requestMeta);

  public void deleteGrantedRoles(List roles, RequestMeta requestMeta);


  public void deleteAllGrantedTask(String granter, RequestMeta requestMeta);

  public void deleteSelectedGrantedTask(String granter, String granterInfo, String granted,
    RequestMeta requestMeta);

  public void insertGrantedTask(String granter, String granted, String granterInfo, String roleids, RequestMeta requestMeta);

}
