package com.ufgov.gk.server.ebay.dao;

import com.ufgov.gk.common.ebay.model.EbSellerCategory;
import com.ufgov.gk.common.ebay.model.EbSellerCategoryExample;
import com.ufgov.gk.common.ebay.model.EbSellerCategoryKey;
import java.util.List;

public interface EbSellerCategoryDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_CATEGORY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    void insert(EbSellerCategory record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_CATEGORY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByPrimaryKey(EbSellerCategory record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_CATEGORY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByPrimaryKeySelective(EbSellerCategory record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_CATEGORY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    List selectByExample(EbSellerCategoryExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_CATEGORY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    EbSellerCategory selectByPrimaryKey(EbSellerCategoryKey key);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_CATEGORY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int deleteByExample(EbSellerCategoryExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_CATEGORY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int deleteByPrimaryKey(EbSellerCategoryKey key);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_CATEGORY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int countByExample(EbSellerCategoryExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_CATEGORY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByExampleSelective(EbSellerCategory record, EbSellerCategoryExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_CATEGORY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByExample(EbSellerCategory record, EbSellerCategoryExample example);
}