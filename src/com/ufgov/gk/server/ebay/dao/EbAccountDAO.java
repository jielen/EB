package com.ufgov.gk.server.ebay.dao;

import com.ufgov.gk.common.ebay.model.EbAccount;
import com.ufgov.gk.common.ebay.model.EbAccountExample;
import java.util.List;

public interface EbAccountDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    void insert(EbAccount record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByPrimaryKey(EbAccount record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByPrimaryKeySelective(EbAccount record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    List selectByExample(EbAccountExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    EbAccount selectByPrimaryKey(String ebayAccount);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int deleteByExample(EbAccountExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int deleteByPrimaryKey(String ebayAccount);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int countByExample(EbAccountExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByExampleSelective(EbAccount record, EbAccountExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByExample(EbAccount record, EbAccountExample example);
}