/**
 *
 * Copyright (C) 2009 UFGOV
 * 
 * 修订历史记录：
 * 
 * Revision	1.0	 2009-4-8  hpj_inter  创建。
 * 
 */

package com.ufgov.gk.server.console.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ufgov.gk.common.ebay.model.AppMenuItem;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.model.AsMenu;
import com.ufgov.gk.common.system.model.AsMenuCompo;
import com.ufgov.gk.common.system.model.AsMenuCompoExample;
import com.ufgov.gk.server.console.dao.IMenuDao;
import com.ufgov.gk.server.console.service.IMenuService;
import com.ufgov.gk.server.system.dao.AsMenuCompoDAO;
import com.ufgov.gk.server.system.dao.AsMenuDAO;

public class MenuService implements IMenuService {
  private static Logger logger = Logger.getLogger(MenuService.class);

  private IMenuDao menuDao;

  private AsMenuDAO asMenusDao;

  public AsMenuDAO getAsMenusDao() {
    return asMenusDao;
  }

  public void setAsMenusDao(AsMenuDAO asMenusDao) {
    this.asMenusDao = asMenusDao;
  }

  public AsMenuCompoDAO getAsMenuCompoDao() {
    return asMenuCompoDao;
  }

  public void setAsMenuCompoDao(AsMenuCompoDAO asMenuCompoDao) {
    this.asMenuCompoDao = asMenuCompoDao;
  }

  private AsMenuCompoDAO asMenuCompoDao;

  public IMenuDao getMenuDao() {
    return menuDao;
  }

  public void setMenuDao(IMenuDao menuDao) {
    this.menuDao = menuDao;
  }

  public List getMenuList(String systemCode, String roleCode) {
    return menuDao.getMenuList(systemCode, roleCode);
  }

  @Override
  public List<AppMenuItem> getMenus(RequestMeta requestMeta) {
    // TODO Auto-generated method stub

    List<AppMenuItem> items = new ArrayList<AppMenuItem>();

    List<AsMenu> rootMenus = asMenusDao.selectRootMenu();
    List<AsMenu> childMens = asMenusDao.selectChildMenu();
    AsMenuCompoExample asMenuCompoExample = new AsMenuCompoExample();
    List<AsMenuCompo> compos = asMenuCompoDao.selectByExample(asMenuCompoExample);

    Map childrenMap = new HashMap();

    for (int i = 0; i < childMens.size(); i++) {
      AsMenu child = childMens.get(i);
      AppMenuItem item = new AppMenuItem();
      item.setMenu(child);
      List childrenList = (List) childrenMap.get(child.getParentId());
      if (childrenList != null) {
        childrenList.add(item);
      } else {
        List tempList = new ArrayList();
        tempList.add(item);
        childrenMap.put(child.getParentId(), tempList);
      }
    }

    for (int i = 0; i < rootMenus.size(); i++) {
      AsMenu rootMenu = rootMenus.get(i);
      AppMenuItem it = new AppMenuItem();
      it.setMenu(rootMenu);
      setMenuChildren(it, childrenMap);
      items.add(it);
    }
    //挂接部件
    attachCompoToMenu(items, compos);

    return items;
  }

  private void attachCompoToMenu(List<AppMenuItem> menus, List<AsMenuCompo> compos) {
    // TODO Auto-generated method stub
    for (int i = 0; i < compos.size(); i++) {
      logger.debug("menuid=" + compos.get(i).getMenuId() + " compoid=" + compos.get(i).getCompoId());
      AppMenuItem menuItem = findMenu(menus, compos.get(i).getMenuId());
      if (menuItem != null) {
        AppMenuItem compoItem = new AppMenuItem();
        compoItem.setMenuCompo(compos.get(i));
        menuItem.getChildren().add(compoItem);
      }
    }
  }

  private AppMenuItem findMenu(List<AppMenuItem> menus, String menuId) {
    // TODO Auto-generated method stub
    for (int i = 0; i < menus.size(); i++) {
      AppMenuItem menuitem = menus.get(i);
      if (menuitem.getMenu() == null)
        continue;
      if (menuitem.getMenu().getMenuId().equals(menuId)) {
        return menuitem;
      } else {
        if (menuitem.getChildren() != null) {
          AppMenuItem menuitem2 = findMenu(menuitem.getChildren(), menuId);
          if (menuitem2 != null) {
            return menuitem2;
          } else {
            continue;
          }
        } else {
          continue;
        }
      }

    }
    return null;
  }

  private void setMenuChildren(AppMenuItem rootAppMenuItem, Map childrenMap) {

    List childrenList = (List) childrenMap.get(rootAppMenuItem.getMenu().getMenuId());
    if (childrenList != null) {
      rootAppMenuItem.setChildren(childrenList);
      for (int i = 0; i < childrenList.size(); i++) {
        AppMenuItem c = (AppMenuItem) childrenList.get(i);
        setMenuChildren(c, childrenMap);
      }
    }

  }

}
