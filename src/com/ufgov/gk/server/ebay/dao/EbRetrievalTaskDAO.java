package com.ufgov.gk.server.ebay.dao;

import com.ufgov.gk.common.ebay.model.EbRetrievalTask;
import com.ufgov.gk.common.ebay.model.EbRetrievalTaskExample;
import java.util.List;

public interface EbRetrievalTaskDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    void insert(EbRetrievalTask record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByPrimaryKey(EbRetrievalTask record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByPrimaryKeySelective(EbRetrievalTask record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    List selectByExample(EbRetrievalTaskExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    EbRetrievalTask selectByPrimaryKey(String sellerId);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int deleteByExample(EbRetrievalTaskExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int deleteByPrimaryKey(String sellerId);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int countByExample(EbRetrievalTaskExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByExampleSelective(EbRetrievalTask record, EbRetrievalTaskExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByExample(EbRetrievalTask record, EbRetrievalTaskExample example);
}