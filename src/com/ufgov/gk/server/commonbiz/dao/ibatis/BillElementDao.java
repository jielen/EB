package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.common.commonbiz.model.BillElement;
import com.ufgov.gk.server.commonbiz.dao.IBillElementDao;
import com.ufgov.gk.server.system.util.RequestMetaUtil;

public class BillElementDao extends SqlMapClientDaoSupport implements IBillElementDao {

  public Map getBillElement(int nd, String billTypeCode) {
    Map params = new HashMap();
    params.put("nd", new Integer(nd));
    params.put("billTypeCode", billTypeCode);
    return this.getSqlMapClientTemplate().queryForMap("BillElement.getBillElement", params, "elementCode");
  }

  public Map getDecBillElement(int nd, String billTypeCode) {
    Map params = new HashMap();
    params.put("nd", new Integer(nd));
    params.put("billTypeCode", billTypeCode);
    return this.getSqlMapClientTemplate().queryForMap("BillElement.getBillDecElement", params, "elementCode");
  }
  
  public Map getBillIncludeElement(int nd, String billTypeCode) {
	    Map params = new HashMap();
	    params.put("nd", new Integer(nd));
	    params.put("billTypeCode", billTypeCode);
	    return this.getSqlMapClientTemplate().queryForMap("BillElement.getBillIncludeElement", params, "elementCode");
  }  

  public List getDecBillElementList(int nd, String billTypeCode) {
    Map params = new HashMap();
    params.put("nd", new Integer(nd));
    params.put("billTypeCode", billTypeCode);
    return this.getSqlMapClientTemplate().queryForList("BillElement.getBillDecFlagElement", params);
  }

  public List getAllDecBillElementList(int nd, String billTypeCode) {
    Map params = new HashMap();
    params.put("nd", new Integer(nd));
    params.put("billTypeCode", billTypeCode);
    return this.getSqlMapClientTemplate().queryForList("BillElement.getAllBillDecFlagElement", params);
  }

  public List getDownDisplayBillElementList(int nd, String billTypeCode, String displayFieldType) {
    Map params = new HashMap();
    params.put("nd", new Integer(nd));
    params.put("billTypeCode", billTypeCode);
    params.put("displayFieldType", displayFieldType);
    return this.getSqlMapClientTemplate().queryForList("BillElement.getBillDecFlagElement", params);
  }

  public void updateIncludeForBillElement(BillElement billElement) {
    this.getSqlMapClientTemplate().update("BillElement.updateIncludeForBillElement", billElement);
  }

  public void updateBillElementGroupInfo(BillElement billElement) {
    this.getSqlMapClientTemplate().update("BillElement.updateBillElementGroupInfo", billElement);
  }

  public void updateBillElementForBb(List billElementlist) {
    final List list = billElementlist;

    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (int i = 0; i < list.size(); i++) {
          BillElement billElement = (BillElement) list.get(i);
          executor.update("BillElement.updateBillElementForBb", billElement);
        }
        executor.executeBatch();
        return null;
      }
    });
  }

  public Map getWfCanEditField(Long proInstId) {
    Map params = new HashMap();
    params.put("compoId", RequestMetaUtil.getCompoId());
    params.put("proInstId", proInstId);
    params.put("executor", RequestMetaUtil.getSvUserID());
    return this.getSqlMapClientTemplate().queryForMap("BillElement.getWfCanEditField", params, "elementCode",
      "elementName");
  }

}
