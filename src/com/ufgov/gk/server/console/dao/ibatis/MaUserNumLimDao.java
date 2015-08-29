package com.ufgov.gk.server.console.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.server.console.dao.IMaUserNumLimDao;
import com.ufgov.gk.common.console.model.MaUserNumLim;

public class MaUserNumLimDao extends SqlMapClientDaoSupport implements IMaUserNumLimDao {

	public List getMaUserNumLim(String userId, String compoId, String funcId, String ctrlField) {
		Map map = new HashMap();
		map.put("user_id", userId);
		map.put("compo_id", compoId);
		map.put("func_id", funcId);
		map.put("ctrl_field", ctrlField);
		return this.getSqlMapClientTemplate().queryForList(
				"MaUserNumLim.getMaUserNumLim", map);
	}
	
	public int deleteMaUserNumLim(String userId, String compoId, String funcId, String ctrlField) {
		Map map = new HashMap();
		map.put("user_id", userId);
		map.put("compo_id", compoId);
		map.put("func_id", funcId);
		map.put("ctrl_field", ctrlField);
		return this.getSqlMapClientTemplate().delete(
				"MaUserNumLim.deleteMaUserNumLim", map);
	}

	public MaUserNumLim insertMaUserNumLim(MaUserNumLim maUserNumLim) {
		return (MaUserNumLim)this.getSqlMapClientTemplate().insert(
				"MaUserNumLim.insertMaUserNumLim", maUserNumLim);
	}

	public void insertMaUserNumLimList(final List maUserNumLimList) {
	    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				executor.startBatch();
				for (int i = 0; i < maUserNumLimList.size(); i++) {
					MaUserNumLim maUser = (MaUserNumLim) maUserNumLimList.get(i);
					executor.insert("MaUserNumLim.insertMaUserNumLim", maUser);
				}
				executor.executeBatch();
				return null;
			}
		});
	}

}
