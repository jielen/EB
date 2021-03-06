package com.ufgov.gk.server.ebay.dao;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbItemChecked;
import com.ufgov.gk.common.ebay.model.EbItemCheckedExample;

public interface EbItemCheckedDAO {
  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  void insert(EbItemChecked record);

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  int updateByPrimaryKey(EbItemChecked record);

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  int updateByPrimaryKeySelective(EbItemChecked record);

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  List selectByExample(EbItemCheckedExample example);

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  EbItemChecked selectByPrimaryKey(String itemId);

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  int deleteByExample(EbItemCheckedExample example);

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  int deleteByPrimaryKey(String itemId);

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  int countByExample(EbItemCheckedExample example);

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  int updateByExampleSelective(EbItemChecked record, EbItemCheckedExample example);

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_ITEM_CHECKED
   *
   * @abatorgenerated Fri Sep 21 17:00:47 CST 2012
   */
  int updateByExample(EbItemChecked record, EbItemCheckedExample example);

  void saveEbItemCheckeds(List<EbItemChecked> itemLst);

}