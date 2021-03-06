package com.ufgov.gk.server.system.dao.ibatis;

import com.ufgov.gk.common.system.model.AsMenuCompo;
import com.ufgov.gk.common.system.model.AsMenuCompoExample;
import com.ufgov.gk.common.system.model.AsMenuCompoKey;
import com.ufgov.gk.server.system.dao.AsMenuCompoDAO;

import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AsMenuCompoDAOImpl extends SqlMapClientDaoSupport implements AsMenuCompoDAO {

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_MENU_COMPO
     *
     * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
     */
    public AsMenuCompoDAOImpl() {
        super();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_MENU_COMPO
     *
     * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
     */
    public void insert(AsMenuCompo record) {
        getSqlMapClientTemplate().insert("AS_MENU_COMPO.insert", record);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_MENU_COMPO
     *
     * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
     */
    public int updateByPrimaryKey(AsMenuCompo record) {
        int rows = getSqlMapClientTemplate().update("AS_MENU_COMPO.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_MENU_COMPO
     *
     * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
     */
    public int updateByPrimaryKeySelective(AsMenuCompo record) {
        int rows = getSqlMapClientTemplate().update("AS_MENU_COMPO.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_MENU_COMPO
     *
     * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
     */
    public List selectByExample(AsMenuCompoExample example) {
        List list = getSqlMapClientTemplate().queryForList("AS_MENU_COMPO.selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_MENU_COMPO
     *
     * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
     */
    public AsMenuCompo selectByPrimaryKey(AsMenuCompoKey key) {
        AsMenuCompo record = (AsMenuCompo) getSqlMapClientTemplate().queryForObject("AS_MENU_COMPO.selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_MENU_COMPO
     *
     * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
     */
    public int deleteByExample(AsMenuCompoExample example) {
        int rows = getSqlMapClientTemplate().delete("AS_MENU_COMPO.deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_MENU_COMPO
     *
     * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
     */
    public int deleteByPrimaryKey(AsMenuCompoKey key) {
        int rows = getSqlMapClientTemplate().delete("AS_MENU_COMPO.deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_MENU_COMPO
     *
     * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
     */
    public int countByExample(AsMenuCompoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("AS_MENU_COMPO.countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_MENU_COMPO
     *
     * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
     */
    public int updateByExampleSelective(AsMenuCompo record, AsMenuCompoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("AS_MENU_COMPO.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_MENU_COMPO
     *
     * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
     */
    public int updateByExample(AsMenuCompo record, AsMenuCompoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("AS_MENU_COMPO.updateByExample", parms);
        return rows;
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table AS_MENU_COMPO
     *
     * @abatorgenerated Sat Jun 23 09:24:11 CST 2012
     */
    private static class UpdateByExampleParms extends AsMenuCompoExample {
        private Object record;

        public UpdateByExampleParms(Object record, AsMenuCompoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}