package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.commonbiz.dao.IMaCpBankBalDao;

public class MaCpBankBalDao extends SqlMapClientDaoSupport implements IMaCpBankBalDao {
  public List getMaCpBankBal(int nd, String bankCode, String fundCode) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    if (bankCode != null)
      map.put("bankCode", bankCode);
    if (fundCode != null)
      map.put("fundCode", fundCode);
    return this.getSqlMapClientTemplate().queryForList("MaCpBankBal.getMaCpBankBal", map);
  }

  public List getMaCpBankBalByView(int nd, String bankCode, String fundCode, String maCpBankBalView) {
    Map param = new HashMap();
    param.put("nd", new Integer(nd));
    if (bankCode != null)
      param.put("bankCode", bankCode);
    if (fundCode != null)
      param.put("fundCode", fundCode);
    param.put("maCpBankBalView", maCpBankBalView);
    return this.getSqlMapClientTemplate().queryForList("MaCpBankBal.getMaCpBankBalByView", param);
  }

  public List getMaCpBankBalForTzd(int nd, String payAccNo, String fundCode) {
    Map param = new HashMap();
    param.put("nd", new Integer(nd));
    if (payAccNo != null)
      param.put("payAccNo", payAccNo);
    if (fundCode != null)
      param.put("fundCode", fundCode);
    return this.getSqlMapClientTemplate().queryForList("MaCpBankBal.getMaCpBankBalForTzd", param);
  }

  public List getMaCpBankBalByAuto(int nd, String bankCode, String clearAccNo, String maCpBankBalView) {
    Map param = new HashMap();
    param.put("nd", new Integer(nd));
    if (bankCode != null)
      param.put("bankCode", bankCode);
    if (clearAccNo != null)
      param.put("clearAccNo", clearAccNo);
    param.put("maCpBankBalView", maCpBankBalView);
    return this.getSqlMapClientTemplate().queryForList("MaCpBankBal.getMaCpBankBalByAuto", param);
  }

  public List getMaCpBankBalList(int nd){
    Map param = new HashMap();
    param.put("nd", new Integer(nd));
    return this.getSqlMapClientTemplate().queryForList("MaCpBankBal.getMaCpBankBalList", param);
  }
}
