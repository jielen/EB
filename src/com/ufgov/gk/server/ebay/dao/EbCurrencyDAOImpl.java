package com.ufgov.gk.server.ebay.dao;

import com.ufgov.gk.common.ebay.model.EbCurrency;
import com.ufgov.gk.common.ebay.model.EbCurrencyExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EbCurrencyDAOImpl extends SqlMapClientDaoSupport implements EbCurrencyDAO {

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_CURRENCY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public EbCurrencyDAOImpl() {
        super();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_CURRENCY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public void insert(EbCurrency record) {
        getSqlMapClientTemplate().insert("EB_CURRENCY.insert", record);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_CURRENCY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int updateByPrimaryKey(EbCurrency record) {
        int rows = getSqlMapClientTemplate().update("EB_CURRENCY.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_CURRENCY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int updateByPrimaryKeySelective(EbCurrency record) {
        int rows = getSqlMapClientTemplate().update("EB_CURRENCY.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_CURRENCY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public List selectByExample(EbCurrencyExample example) {
        List list = getSqlMapClientTemplate().queryForList("EB_CURRENCY.selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_CURRENCY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public EbCurrency selectByPrimaryKey(String currencyId) {
        EbCurrency key = new EbCurrency();
        key.setCurrencyId(currencyId);
        EbCurrency record = (EbCurrency) getSqlMapClientTemplate().queryForObject("EB_CURRENCY.selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_CURRENCY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int deleteByExample(EbCurrencyExample example) {
        int rows = getSqlMapClientTemplate().delete("EB_CURRENCY.deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_CURRENCY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int deleteByPrimaryKey(String currencyId) {
        EbCurrency key = new EbCurrency();
        key.setCurrencyId(currencyId);
        int rows = getSqlMapClientTemplate().delete("EB_CURRENCY.deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_CURRENCY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int countByExample(EbCurrencyExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EB_CURRENCY.countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_CURRENCY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int updateByExampleSelective(EbCurrency record, EbCurrencyExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EB_CURRENCY.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table EB_CURRENCY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    public int updateByExample(EbCurrency record, EbCurrencyExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EB_CURRENCY.updateByExample", parms);
        return rows;
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table EB_CURRENCY
     *
     * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
     */
    private static class UpdateByExampleParms extends EbCurrencyExample {
        private Object record;

        public UpdateByExampleParms(Object record, EbCurrencyExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}