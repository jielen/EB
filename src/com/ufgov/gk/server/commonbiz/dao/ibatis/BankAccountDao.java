package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.common.commonbiz.model.BankAccount;
import com.ufgov.gk.server.commonbiz.dao.IBankAccountDao;

public class BankAccountDao extends SqlMapClientDaoSupport implements IBankAccountDao {

  public List getPayBankAccount(int nd, String accoType, String userId) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("accoType", accoType);
    map.put("userid", userId);
    return getSqlMapClientTemplate().queryForList("BankAccount.getPayBankAccount", map);
  }

  public List getPayBank(int nd, String accoType, String userId) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("accoType", accoType);
    map.put("userid", userId);
    return getSqlMapClientTemplate().queryForList("BankAccount.getPayBank", map);
  }

  public List getPayBankAccountByAccoType(int nd, List accoTypeList) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("accoTypeList", accoTypeList);
    return getSqlMapClientTemplate().queryForList("BankAccount.getPayBankAccount", map);
  }

  public List getBankAccountByAccoType(int nd, String coCode, List accoTypeList) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("coCode", coCode);
    map.put("accoTypeList", accoTypeList);
    return getSqlMapClientTemplate().queryForList("BankAccount.getPayBankAccount", map);
  }

  public List getBankAccountByUserId(int nd, String userId, List accoTypeList) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("userid", userId);
    map.put("accoTypeList", accoTypeList);
    return getSqlMapClientTemplate().queryForList("BankAccount.getPayBankAccount", map);
  }

  public List getDefaultPayBankAccount(int nd, String isDefault, String coCode, String fundCode,
    List accoTypeList) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("isDefault", isDefault);
    map.put("coCode", coCode);
    map.put("fundCode", fundCode);
    map.put("accoTypeList", accoTypeList);
    return this.getSqlMapClientTemplate().queryForList("BankAccount.getPayBankAccount", map);
  }

  public BankAccount getDwZeroAccount(int nd, String coCode, String fundCode, String optFundFilterVal) {
    Map param = new HashMap();
    param.put("nd", new Integer(nd));
    param.put("coCode", coCode);
    param.put("accoType", "04");
    param.put("optFundFilterVal", optFundFilterVal);
    param.put("fundCode", fundCode);
    return (BankAccount) getSqlMapClientTemplate().queryForObject("BankAccount.getPayBankAccount", param);
  }

  public void deleteReceBankAccout(final List bankAccountList) {
    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (int i = 0; i < bankAccountList.size(); i++) {
          executor.update("BankAccount.deleteReceBankAccount", bankAccountList.get(i));
        }
        executor.executeBatch();
        return null;
      }
    });
  }

  public List getReceBankAccountList(int nd, String userId) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("userId", userId);
    return getSqlMapClientTemplate().queryForList("BankAccount.getReceBankAccountList", map);
  }

  public BankAccount insertReceBankAccount(BankAccount bankAccount) {
    return (BankAccount) getSqlMapClientTemplate().insert("BankAccount.insertReceBankAccount", bankAccount);
  }

  public BankAccount getReceBankAccount(String accName, String bankAccCode, String bankNodeName,
    String coCode, String userId) {
    Map param = new HashMap();
    param.put("accName", accName);
    param.put("bankAccCode", bankAccCode);
    param.put("bankNodeName", bankNodeName);
    param.put("coCode", coCode);
    param.put("inputorId", userId);
    return (BankAccount) getSqlMapClientTemplate().queryForObject("BankAccount.getReceBankAccount", param);
  }

  public BankAccount getReceBankAccount(BankAccount bankAccount) {
    Map param = new HashMap();
    param.put("accName", bankAccount.getAccName());
    param.put("bankAccCode", bankAccount.getBankAccCode());
    param.put("bankNodeName", bankAccount.getBankNodeName());
    param.put("coCode", bankAccount.getCoCode());
    param.put("inputorId", bankAccount.getInputorId());
    return (BankAccount) getSqlMapClientTemplate().queryForObject("BankAccount.getReceBankAccount", param);
  }

  public List getDwBaseBankAccountList(int nd, List accoType, String coCode) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("coCode", coCode);
    map.put("accoTypeList", accoType);
    return this.getSqlMapClientTemplate().queryForList("BankAccount.getBankAccountList", map);
  }

  public List getBankAccountByAccNo(int nd,String no){
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("no", no);
    return this.getSqlMapClientTemplate().queryForList("BankAccount.getBankAccountByAccNo", map);
  }

  public List getDwZeroAccountList(int nd, List accoType, String coCode) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("coCode", coCode);
    map.put("accoTypeList", accoType);
    return this.getSqlMapClientTemplate().queryForList("BankAccount.getBankAccountList", map);
  }

  public List getSpecialAccountList(int nd, List accoType) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("accoTypeList", accoType);
    return this.getSqlMapClientTemplate().queryForList("BankAccount.getBankAccountList", map);
  }

  public List getReceAccountInfoList(int nd, String coCode, String product) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("product", product);
    map.put("coCode", coCode);
    return this.getSqlMapClientTemplate().queryForList("BankAccount.getReceAccountInfoList", map);
  }

  public int updateReceBankAccount(BankAccount bankAccount) {
    return this.getSqlMapClientTemplate().update("BankAccount.updateReceBankAccount", bankAccount);
  }
}
