package com.ufgov.gk.server.ebay.dao;

import com.ufgov.gk.common.ebay.model.EbAppServer;
import com.ufgov.gk.common.ebay.model.EbAppServerExample;
import java.util.List;

public interface EbAppServerDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_SERVER
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    void insert(EbAppServer record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_SERVER
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByPrimaryKey(EbAppServer record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_SERVER
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByPrimaryKeySelective(EbAppServer record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_SERVER
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    List selectByExample(EbAppServerExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_SERVER
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    EbAppServer selectByPrimaryKey(String siteId);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_SERVER
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int deleteByExample(EbAppServerExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_SERVER
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int deleteByPrimaryKey(String siteId);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_SERVER
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int countByExample(EbAppServerExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_SERVER
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByExampleSelective(EbAppServer record, EbAppServerExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_SERVER
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByExample(EbAppServer record, EbAppServerExample example);
}