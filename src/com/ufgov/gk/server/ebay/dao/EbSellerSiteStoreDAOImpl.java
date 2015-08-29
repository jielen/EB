package com.ufgov.gk.server.ebay.dao;

import com.ufgov.gk.common.ebay.model.EbSellerSiteStore;
import com.ufgov.gk.common.ebay.model.EbSellerSiteStoreExample;
import com.ufgov.gk.common.ebay.model.EbSellerSiteStoreKey;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EbSellerSiteStoreDAOImpl extends SqlMapClientDaoSupport implements EbSellerSiteStoreDAO {

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_SITE_STORE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public EbSellerSiteStoreDAOImpl() {
        super();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_SITE_STORE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public void insert(EbSellerSiteStore record) {
        getSqlMapClientTemplate().insert("EB_SELLER_SITE_STORE.insert", record);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_SITE_STORE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int updateByPrimaryKey(EbSellerSiteStore record) {
        int rows = getSqlMapClientTemplate().update("EB_SELLER_SITE_STORE.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_SITE_STORE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int updateByPrimaryKeySelective(EbSellerSiteStore record) {
        int rows = getSqlMapClientTemplate().update("EB_SELLER_SITE_STORE.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_SITE_STORE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public List selectByExample(EbSellerSiteStoreExample example) {
        List list = getSqlMapClientTemplate().queryForList("EB_SELLER_SITE_STORE.selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_SITE_STORE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public EbSellerSiteStore selectByPrimaryKey(EbSellerSiteStoreKey key) {
        EbSellerSiteStore record = (EbSellerSiteStore) getSqlMapClientTemplate().queryForObject("EB_SELLER_SITE_STORE.selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_SITE_STORE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int deleteByExample(EbSellerSiteStoreExample example) {
        int rows = getSqlMapClientTemplate().delete("EB_SELLER_SITE_STORE.deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_SITE_STORE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int deleteByPrimaryKey(EbSellerSiteStoreKey key) {
        int rows = getSqlMapClientTemplate().delete("EB_SELLER_SITE_STORE.deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_SITE_STORE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int countByExample(EbSellerSiteStoreExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EB_SELLER_SITE_STORE.countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_SITE_STORE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int updateByExampleSelective(EbSellerSiteStore record, EbSellerSiteStoreExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EB_SELLER_SITE_STORE.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_SELLER_SITE_STORE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int updateByExample(EbSellerSiteStore record, EbSellerSiteStoreExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EB_SELLER_SITE_STORE.updateByExample", parms);
        return rows;
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table EB_SELLER_SITE_STORE
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    private static class UpdateByExampleParms extends EbSellerSiteStoreExample {
        private Object record;

        public UpdateByExampleParms(Object record, EbSellerSiteStoreExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}