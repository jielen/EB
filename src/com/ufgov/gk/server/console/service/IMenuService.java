/**
 *
 * Copyright (C) 2009 UFGOV
 * 
 * �޶���ʷ��¼��
 * 
 * Revision	1.0	 2009-4-8  hpj_inter  ������
 * 
 */

package com.ufgov.gk.server.console.service;

import java.util.List;

import com.ufgov.gk.common.ebay.model.AppMenuItem;
import com.ufgov.gk.common.system.RequestMeta;

public interface IMenuService {

  List getMenuList(String systemCode, String roleCode);

  List<AppMenuItem> getMenus(RequestMeta requestMeta);

}
