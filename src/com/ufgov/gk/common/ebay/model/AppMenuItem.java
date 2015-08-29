/**
 * AppMenuItem.java
 * com.eb.client.component
 * Administrator
 * Jun 23, 2012
 */
package com.ufgov.gk.common.ebay.model;

import java.util.ArrayList;
import java.util.List;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.common.system.model.AsMenu;
import com.ufgov.gk.common.system.model.AsMenuCompo;

/**
 * @author Administrator
 *
 */
public class AppMenuItem {

  private AsMenu menu;

  private AsMenuCompo menuCompo;

  private List<AppMenuItem> children = new ArrayList<AppMenuItem>();

  public boolean isLeaf() {
    if (menuCompo != null)
      return true;
    return false;
  }

  public void addChild(AppMenuItem child) {
    this.children.add(child);
  }

  public AsMenu getMenu() {
    return menu;
  }

  public void setMenu(AsMenu menu) {
    this.menu = menu;
  }

  public AsMenuCompo getMenuCompo() {
    return menuCompo;
  }

  public void setMenuCompo(AsMenuCompo menuCompo) {
    this.menuCompo = menuCompo;
  }

  public List<AppMenuItem> getChildren() {
    return children;
  }

  public void setChildren(List<AppMenuItem> children) {
    this.children = children;
  }

  public String toString() {

    if (getMenuCompo() != null) {
      return LangTransMeta.translate(getMenuCompo().getCompoId());
    }
    if (getMenu() != null) {
      return LangTransMeta.translate(getMenu().getMenuId());
    }
    return super.toString();
  }
}
