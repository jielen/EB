/**
 *
 * Copyright (C) 2009 UFGOV
 * 
 * �޶���ʷ��¼��
 * 
 * Revision	1.0	 2009-4-8  hpj_inter  ������
 * 
 */

package com.ufgov.gk.server.console.dao;

import java.util.List;

public interface IMenuDao {

	List getMenuList(String systemCode, String roleCode);
}
