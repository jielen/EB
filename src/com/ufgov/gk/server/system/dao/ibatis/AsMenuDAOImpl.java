package com.ufgov.gk.server.system.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.model.AsMenu;
import com.ufgov.gk.common.system.model.AsMenuExample;
import com.ufgov.gk.server.system.dao.AsMenuDAO;

public class AsMenuDAOImpl extends SqlMapClientDaoSupport implements AsMenuDAO {

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table AS_MENU
   *
   * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
   */
  public AsMenuDAOImpl() {
    super();
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table AS_MENU
   *
   * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
   */
  public void insert(AsMenu record) {
    getSqlMapClientTemplate().insert("AS_MENU.insert", record);
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table AS_MENU
   *
   * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
   */
  public int updateByPrimaryKey(AsMenu record) {
    int rows = getSqlMapClientTemplate().update("AS_MENU.updateByPrimaryKey", record);
    return rows;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table AS_MENU
   *
   * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
   */
  public int updateByPrimaryKeySelective(AsMenu record) {
    int rows = getSqlMapClientTemplate().update("AS_MENU.updateByPrimaryKeySelective", record);
    return rows;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table AS_MENU
   *
   * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
   */
  public List selectByExample(AsMenuExample example) {
    List list = getSqlMapClientTemplate().queryForList("AS_MENU.selectByExample", example);
    return list;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table AS_MENU
   *
   * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
   */
  public AsMenu selectByPrimaryKey(String menuId) {
    AsMenu key = new AsMenu();
    key.setMenuId(menuId);
    AsMenu record = (AsMenu) getSqlMapClientTemplate().queryForObject("AS_MENU.selectByPrimaryKey", key);
    return record;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table AS_MENU
   *
   * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
   */
  public int deleteByExample(AsMenuExample example) {
    int rows = getSqlMapClientTemplate().delete("AS_MENU.deleteByExample", example);
    return rows;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table AS_MENU
   *
   * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
   */
  public int deleteByPrimaryKey(String menuId) {
    AsMenu key = new AsMenu();
    key.setMenuId(menuId);
    int rows = getSqlMapClientTemplate().delete("AS_MENU.deleteByPrimaryKey", key);
    return rows;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table AS_MENU
   *
   * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
   */
  public int countByExample(AsMenuExample example) {
    Integer count = (Integer) getSqlMapClientTemplate().queryForObject("AS_MENU.countByExample", example);
    return count.intValue();
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table AS_MENU
   *
   * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
   */
  public int updateByExampleSelective(AsMenu record, AsMenuExample example) {
    UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
    int rows = getSqlMapClientTemplate().update("AS_MENU.updateByExampleSelective", parms);
    return rows;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table AS_MENU
   *
   * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
   */
  public int updateByExample(AsMenu record, AsMenuExample example) {
    UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
    int rows = getSqlMapClientTemplate().update("AS_MENU.updateByExample", parms);
    return rows;
  }

  /**
   * This class was generated by Abator for iBATIS.
   * This class corresponds to the database table AS_MENU
   *
   * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
   */
  private static class UpdateByExampleParms extends AsMenuExample {
    private Object record;

    public UpdateByExampleParms(Object record, AsMenuExample example) {
      super(example);
      this.record = record;
    }

    public Object getRecord() {
      return record;
    }
  }

  @Override
  public List<AsMenu> selectRootMenu() {
    // TODO Auto-generated method stub
    List list = getSqlMapClientTemplate().queryForList("AS_MENU.selectRootMenu");
    return list;
  }

  @Override
  public List<AsMenu> selectChildMenu() {
    // TODO Auto-generated method stub
    List list = getSqlMapClientTemplate().queryForList("AS_MENU.selectChildMenu");
    return list;
  }
}