/**
 * AppMenuTreeNode.java
 * com.eb.client.component
 * Administrator
 * Jun 24, 2012
 */
package com.eb.client.component;

import javax.swing.tree.DefaultMutableTreeNode;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.common.ebay.model.AppMenuItem;

/**
 * @author Administrator
 *
 */
public class AppMenuTreeNode extends DefaultMutableTreeNode {

  /**
   * 
   */
  private static final long serialVersionUID = -3312501437417049544L;

  @Override
  public String toString() {
    AppMenuItem item = getUserObject();

    if (item.getMenuCompo() != null) {
      return LangTransMeta.translate(item.getMenuCompo().getCompoId());
    }
    if (item.getMenu() != null) {
      return LangTransMeta.translate(item.getMenu().getMenuId());
    }
    return getUserObject().toString();
  }

  @Override
  public AppMenuItem getUserObject() {
    return (AppMenuItem) super.getUserObject();
  }
}
