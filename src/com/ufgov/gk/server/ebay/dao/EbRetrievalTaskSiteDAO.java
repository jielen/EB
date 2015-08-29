package com.ufgov.gk.server.ebay.dao;

import com.ufgov.gk.common.ebay.model.EbRetrievalTaskSiteExample;
import com.ufgov.gk.common.ebay.model.EbRetrievalTaskSiteKey;
import java.util.List;

public interface EbRetrievalTaskSiteDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK_SITE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    void insert(EbRetrievalTaskSiteKey record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK_SITE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    List selectByExample(EbRetrievalTaskSiteExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK_SITE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int deleteByExample(EbRetrievalTaskSiteExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK_SITE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int deleteByPrimaryKey(EbRetrievalTaskSiteKey key);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK_SITE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int countByExample(EbRetrievalTaskSiteExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK_SITE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByExampleSelective(EbRetrievalTaskSiteKey record, EbRetrievalTaskSiteExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK_SITE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    int updateByExample(EbRetrievalTaskSiteKey record, EbRetrievalTaskSiteExample example);
}