package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.commonbiz.dao.IMaBanknodeDao;

public class MaBanknodeDao extends SqlMapClientDaoSupport implements IMaBanknodeDao {
  public List getMaBanknode(int nd, String bankCode) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("bankCode", bankCode);
    return this.getSqlMapClientTemplate()
      .queryForList("MaBanknode.getBanknode", map);
  }

}
