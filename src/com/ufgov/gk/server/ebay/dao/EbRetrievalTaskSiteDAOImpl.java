package com.ufgov.gk.server.ebay.dao;

import com.ufgov.gk.common.ebay.model.EbRetrievalTaskSiteExample;
import com.ufgov.gk.common.ebay.model.EbRetrievalTaskSiteKey;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EbRetrievalTaskSiteDAOImpl extends SqlMapClientDaoSupport implements EbRetrievalTaskSiteDAO {

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK_SITE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public EbRetrievalTaskSiteDAOImpl() {
        super();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK_SITE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public void insert(EbRetrievalTaskSiteKey record) {
        getSqlMapClientTemplate().insert("EB_RETRIEVAL_TASK_SITE.insert", record);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK_SITE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public List selectByExample(EbRetrievalTaskSiteExample example) {
        List list = getSqlMapClientTemplate().queryForList("EB_RETRIEVAL_TASK_SITE.selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK_SITE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int deleteByExample(EbRetrievalTaskSiteExample example) {
        int rows = getSqlMapClientTemplate().delete("EB_RETRIEVAL_TASK_SITE.deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK_SITE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int deleteByPrimaryKey(EbRetrievalTaskSiteKey key) {
        int rows = getSqlMapClientTemplate().delete("EB_RETRIEVAL_TASK_SITE.deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK_SITE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int countByExample(EbRetrievalTaskSiteExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EB_RETRIEVAL_TASK_SITE.countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK_SITE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int updateByExampleSelective(EbRetrievalTaskSiteKey record, EbRetrievalTaskSiteExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EB_RETRIEVAL_TASK_SITE.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_RETRIEVAL_TASK_SITE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int updateByExample(EbRetrievalTaskSiteKey record, EbRetrievalTaskSiteExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EB_RETRIEVAL_TASK_SITE.updateByExample", parms);
        return rows;
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table EB_RETRIEVAL_TASK_SITE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    private static class UpdateByExampleParms extends EbRetrievalTaskSiteExample {
        private Object record;

        public UpdateByExampleParms(Object record, EbRetrievalTaskSiteExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}