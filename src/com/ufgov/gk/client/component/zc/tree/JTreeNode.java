/**   
* @(#) project: GK
* @(#) file: JTreeNode.java
* 
* Copyright 2010 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.zc.tree;

import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;

/**
* @ClassName: JTreeNode
* @Description: 通用树节点对象。该对象节点只存放object对象，使用者自己做转型处理。
* @date: 2010-4-26 下午04:21:10
* @version: V1.0 
* @since: 1.0
* @author: tianly
* @modify: 
*/
public class JTreeNode extends DefaultMutableTreeNode {

  private static final long serialVersionUID = -7817921961386497522L;

  private int selectionMode;

  private boolean isSelected;

  protected String code;

  protected String parentCode;

  protected String name;

  public final static int SINGLE_SELECTION = 0;

  public final static int DIG_IN_SELECTION = 4;
  public boolean getLeaf() {
    return leaf;
  }

  public void setLeaf(boolean leaf) {
    this.leaf = leaf;
  }
  private boolean leaf;

  public JTreeNode() {
    this(null);
    setSelectionMode(DIG_IN_SELECTION);
  }

  public JTreeNode(Object userObject) {
    this(userObject, true, false);
  }

  public JTreeNode(Object userObject, boolean allowsChildren, boolean isSelected) {
    super(userObject, allowsChildren);
    if (userObject != null) 
      this.isSelected = ((JTreeNode) userObject).isSelected();
      setSelectionMode(DIG_IN_SELECTION);
    
  }

  public int getSelectionMode() {
    return selectionMode;
  }

  public void setSelectionMode(int selectionMode) {
    this.selectionMode = selectionMode;
  }

  public boolean isSelected() {
    return isSelected;
  }

  public void setSelected(boolean isSeleted) {
    this.isSelected = isSeleted;
    if ((this.selectionMode == DIG_IN_SELECTION) && (children != null)) {
      Enumeration<?> enumeration = children.elements();
      while (enumeration.hasMoreElements()) {
        JTreeNode node = (JTreeNode) enumeration.nextElement();
        node.setSelected(isSelected);
      }
    }
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getParentCode() {
    return parentCode;
  }

  public void setParentCode(String parentCode) {
    this.parentCode = parentCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public String toString() {
//    if(name.length()>10){
//      return name==null?"":name.substring(0, 9)+"...";
//    }
    return name == null ? "" : name;
  }

}
