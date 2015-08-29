/**
 *
 * Copyright (C) 2009 UFGOV
 * 
 * �޶���ʷ��¼��
 * 
 * Revision	1.0	 2009-4-8  hpj_inter  ������
 * 
 */

package com.ufgov.gk.server.console.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.console.dao.IMenuDao;

public class MenuDao extends SqlMapClientDaoSupport implements IMenuDao {

	public List getMenuList(String systemCode, String roleCode) {
		Map map = new HashMap();
		map.put("parentCode", systemCode);
		map.put("roleCode", roleCode);

		return this.getSqlMapClientTemplate().queryForList(
				"Menu.selectMenuList", map);
	}
}
