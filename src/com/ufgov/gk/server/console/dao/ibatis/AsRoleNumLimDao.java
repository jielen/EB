package com.ufgov.gk.server.console.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.console.model.AsRoleNumLim;
import com.ufgov.gk.server.console.dao.IAsRoleNumLimDao;
import com.ufgov.gk.server.system.util.RequestMetaUtil;

public class AsRoleNumLimDao extends SqlMapClientDaoSupport implements IAsRoleNumLimDao {

  public List getAsRoleNumLim(String roleId, String compoId, String funcId, String ctrlField) {
    Map map = new HashMap();
    map.put("role_id", roleId);
    map.put("compo_id", compoId);
    map.put("func_id", funcId);
    map.put("ctrl_field", ctrlField);
    return this.getSqlMapClientTemplate().queryForList("AsRoleNumLim.getAsRoleNumLim", map);
  }

  public int deleteAsRoleNumLim(String roleId, String compoId, String funcId, String ctrlField) {
    Map map = new HashMap();
    map.put("role_id", roleId);
    map.put("compo_id", compoId);
    map.put("func_id", funcId);
    map.put("ctrl_field", ctrlField);
    return this.getSqlMapClientTemplate().delete("AsRoleNumLim.deleteAsRoleNumLim", map);
  }

  public AsRoleNumLim insertAsRoleNumLim(AsRoleNumLim asRoleNumLim) {
    return (AsRoleNumLim) this.getSqlMapClientTemplate().insert("AsRoleNumLim.insertAsRoleNumLim",
      asRoleNumLim);
  }

  public List getAsRoleNumLimByUserId(String userId, String compoId, String funcId, String ctrlField) {
    Map map = new HashMap();
    map.put("user_id", userId);
    map.put("compo_id", compoId);
    map.put("func_id", funcId);
    map.put("nd", new Integer(RequestMetaUtil.getSvNd()));
    map.put("ctrl_field", ctrlField);
    return this.getSqlMapClientTemplate().queryForList("AsRoleNumLim.getAsRoleNumLimByUserId", map);
  }

  public List getAsGrantRoleNumLimByUserId(String userId, String compoId, String funcId, String ctrlField){
    Map map = new HashMap();
    map.put("user_id", userId);
    map.put("compo_id", compoId);
    map.put("func_id", funcId);
    map.put("nd", new Integer(RequestMetaUtil.getSvNd()));
    map.put("ctrl_field", ctrlField);
    return this.getSqlMapClientTemplate().queryForList("AsRoleNumLim.getAsGrantRoleNumLimByUserId", map);
  }
  
  public List getRoleNumLimByRoleId(String roles, String compoId, String funcId) {
    Map param = new HashMap();
    param.put("roles", roles);
    param.put("compoId", compoId);
    param.put("funcId", funcId);
    return this.getSqlMapClientTemplate().queryForList("AsRoleNumLim.getRoleNumLimByRoleId", param);
  }
}
