package com.ufgov.gk.server.ebay.dao;

import com.ufgov.gk.common.ebay.model.EbAppAccount;
import com.ufgov.gk.common.ebay.model.EbAppAccountExample;
import java.util.List;

public interface EbAppAccountDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    void insert(EbAppAccount record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByPrimaryKey(EbAppAccount record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByPrimaryKeySelective(EbAppAccount record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    List selectByExample(EbAppAccountExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    EbAppAccount selectByPrimaryKey(String appAccount);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int deleteByExample(EbAppAccountExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int deleteByPrimaryKey(String appAccount);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int countByExample(EbAppAccountExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByExampleSelective(EbAppAccount record, EbAppAccountExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_APP_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByExample(EbAppAccount record, EbAppAccountExample example);
}