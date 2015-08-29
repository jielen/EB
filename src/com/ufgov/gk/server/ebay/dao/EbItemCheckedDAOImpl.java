package com.ufgov.gk.server.ebay.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.common.ebay.model.EbItemChecked;
import com.ufgov.gk.common.ebay.model.EbItemCheckedExample;

public class EbItemCheckedDAOImpl extends SqlMapClientDaoSupport implements EbItemCheckedDAO {

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  public EbItemCheckedDAOImpl() {
    super();
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  public void insert(EbItemChecked record) {
    getSqlMapClientTemplate().insert("EB_ITEM_CHECKED.abatorgenerated_insert", record);
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  public int updateByPrimaryKey(EbItemChecked record) {
    int rows = getSqlMapClientTemplate().update("EB_ITEM_CHECKED.abatorgenerated_updateByPrimaryKey", record);
    return rows;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  public int updateByPrimaryKeySelective(EbItemChecked record) {
    int rows = getSqlMapClientTemplate().update("EB_ITEM_CHECKED.abatorgenerated_updateByPrimaryKeySelective", record);
    return rows;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  public List selectByExample(EbItemCheckedExample example) {
    List list = getSqlMapClientTemplate().queryForList("EB_ITEM_CHECKED.abatorgenerated_selectByExample", example);
    return list;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  public EbItemChecked selectByPrimaryKey(String itemId) {
    EbItemChecked key = new EbItemChecked();
    key.setItemId(itemId);
    EbItemChecked record = (EbItemChecked) getSqlMapClientTemplate().queryForObject("EB_ITEM_CHECKED.abatorgenerated_selectByPrimaryKey", key);
    return record;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  public int deleteByExample(EbItemCheckedExample example) {
    int rows = getSqlMapClientTemplate().delete("EB_ITEM_CHECKED.abatorgenerated_deleteByExample", example);
    return rows;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  public int deleteByPrimaryKey(String itemId) {
    EbItemChecked key = new EbItemChecked();
    key.setItemId(itemId);
    int rows = getSqlMapClientTemplate().delete("EB_ITEM_CHECKED.abatorgenerated_deleteByPrimaryKey", key);
    return rows;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  public int countByExample(EbItemCheckedExample example) {
    Integer count = (Integer) getSqlMapClientTemplate().queryForObject("EB_ITEM_CHECKED.abatorgenerated_countByExample", example);
    return count.intValue();
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  public int updateByExampleSelective(EbItemChecked record, EbItemCheckedExample example) {
    UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
    int rows = getSqlMapClientTemplate().update("EB_ITEM_CHECKED.abatorgenerated_updateByExampleSelective", parms);
    return rows;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  public int updateByExample(EbItemChecked record, EbItemCheckedExample example) {
    UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
    int rows = getSqlMapClientTemplate().update("EB_ITEM_CHECKED.abatorgenerated_updateByExample", parms);
    return rows;
  }

  /**
   * This class was generated by Abator for iBATIS.
   * This class corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  private static class UpdateByExampleParms extends EbItemCheckedExample {
    private Object record;

    public UpdateByExampleParms(Object record, EbItemCheckedExample example) {
      super(example);
      this.record = record;
    }

    public Object getRecord() {
      return record;
    }
  }

  public void saveEbItemCheckeds(final List<EbItemChecked> itemLst) {
    getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (EbItemChecked item : itemLst) {
          executor.insert("EB_ITEM_CHECKED.abatorgenerated_insert", item);
        }
        return executor.executeBatch();
      }
    });
  }

}