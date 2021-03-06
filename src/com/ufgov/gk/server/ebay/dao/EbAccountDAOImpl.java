package com.ufgov.gk.server.ebay.dao;

import com.ufgov.gk.common.ebay.model.EbAccount;
import com.ufgov.gk.common.ebay.model.EbAccountExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EbAccountDAOImpl extends SqlMapClientDaoSupport implements EbAccountDAO {

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public EbAccountDAOImpl() {
        super();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public void insert(EbAccount record) {
        getSqlMapClientTemplate().insert("EB_ACCOUNT.insert", record);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int updateByPrimaryKey(EbAccount record) {
        int rows = getSqlMapClientTemplate().update("EB_ACCOUNT.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int updateByPrimaryKeySelective(EbAccount record) {
        int rows = getSqlMapClientTemplate().update("EB_ACCOUNT.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public List selectByExample(EbAccountExample example) {
        List list = getSqlMapClientTemplate().queryForList("EB_ACCOUNT.selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public EbAccount selectByPrimaryKey(String ebayAccount) {
        EbAccount key = new EbAccount();
        key.setEbayAccount(ebayAccount);
        EbAccount record = (EbAccount) getSqlMapClientTemplate().queryForObject("EB_ACCOUNT.selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int deleteByExample(EbAccountExample example) {
        int rows = getSqlMapClientTemplate().delete("EB_ACCOUNT.deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int deleteByPrimaryKey(String ebayAccount) {
        EbAccount key = new EbAccount();
        key.setEbayAccount(ebayAccount);
        int rows = getSqlMapClientTemplate().delete("EB_ACCOUNT.deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int countByExample(EbAccountExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EB_ACCOUNT.countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int updateByExampleSelective(EbAccount record, EbAccountExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EB_ACCOUNT.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int updateByExample(EbAccount record, EbAccountExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EB_ACCOUNT.updateByExample", parms);
        return rows;
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table EB_ACCOUNT
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    private static class UpdateByExampleParms extends EbAccountExample {
        private Object record;

        public UpdateByExampleParms(Object record, EbAccountExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}