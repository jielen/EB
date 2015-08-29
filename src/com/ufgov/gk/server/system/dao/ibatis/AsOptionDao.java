package com.ufgov.gk.server.system.dao.ibatis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.exception.BusinessException;
import com.ufgov.gk.common.system.model.AsOption;
import com.ufgov.gk.server.system.dao.IAsOptionDao;

public class AsOptionDao extends SqlMapClientDaoSupport implements IAsOptionDao {

  public AsOption getAsOption(String optId) {
    return (AsOption) this.getSqlMapClientTemplate().queryForObject("AsOption.getAsOption", optId);
  }

  public AsOption getAsOptionById(String optId) {
    return (AsOption) this.getSqlMapClientTemplate().queryForObject("AsOption.getAsOptionById", optId);
  }

  public List getAllAsOptionById(String optId) {
    return this.getSqlMapClientTemplate().queryForList("AsOption.getAsOptionById", optId);
  }

  public AsOption getAsOptionByCoCode(String optId, String coCode) {
    Map params = new HashMap();
    params.put("optId", optId);
    params.put("coCode", coCode);
    AsOption opt = (AsOption) this.getSqlMapClientTemplate().queryForObject("AsOption.getAsOptionByCoCode", params);
    if (opt == null) {
      opt = this.getAsOption(optId);
    }
    return opt;
  }

  public void updateOptionVal(AsOption asOption) {
    this.getSqlMapClientTemplate().update("AsOption.updateOptionVal", asOption);
  }

  public Map getFieldLevelOptions() {
    List result = this.getSqlMapClientTemplate().queryForList("AsOption.getFieldLevelOptions");
    return (Map) result.get(0);
  }

  public int getFieldLevel(String code, String codeValue) {
    Map map = getFieldLevelOptions();
    String codeOption = (String) map.get(code);
    String[] temp = codeOption.split("-");
    List splitLevels = Arrays.asList(temp);
    int splitLevel = splitLevels.size();
    Map lenAndLevel = new HashMap();
    int levelLen = 0;
    for (int i = 0; i < splitLevel; i++) {
      levelLen = levelLen + Integer.parseInt((String) splitLevels.get(i));
      lenAndLevel.put(String.valueOf(levelLen), String.valueOf(i + 1));
    }
    String coCodeLevelStr = (String) lenAndLevel.get(String.valueOf(codeValue.length()));

    if (coCodeLevelStr == null) {
      throw new BusinessException("代码:" + codeValue + " 不符合编码格式：" + codeOption);
    }
    return Integer.parseInt(coCodeLevelStr);
  }

}
