/**   
* @(#) project: GK
* @(#) file: TreeNodeSelectionListener.java
* 
* Copyright 2010 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.zc.tree;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
* @ClassName: TreeNodeSelectionListener
* @Description: ͨ�����ڵ�ѡ���¼������࣬�ṩĬ�ϵ�������ѡ�����Ҽ��¼�����ӿڡ���Ҫ����Ҽ��������Ҫ��ʹ��ʱ�Լ�����ʵ����ҵ����
* @date: 2010-4-26 ����04:36:35
* @version: V1.0 
* @since: 1.0
* @author: tianly
* @modify: 
*/
public class TreeNodeSelectionListener extends MouseAdapter {
  protected JTree tree;

  private boolean needDoRightMouseClick = false;

  public TreeNodeSelectionListener(JTree tree) {
    this.tree = tree;
  }

  public void setNeedDoRightMouseClick(boolean needDoRightMouseClick) {
    this.needDoRightMouseClick = needDoRightMouseClick;
  }

  public void mouseClicked(MouseEvent e) {
    if (SwingUtilities.isRightMouseButton(e)) {
      if (needDoRightMouseClick) {
        doRightMouseClick(e);
      } else {
        doLeftMouseClick(e);
      }
    } else {
      if (e.getClickCount() == 2) {
        doLeftMouseDoubleClick(e);
      }
      if (e.getClickCount() == 1) {
        doLeftMouseClick(e);
      }
    }
  }

  protected void doRightMouseClick(MouseEvent e) {

  }

  protected void doLeftMouseDoubleClick(MouseEvent e) {

  }

  protected void doLeftMouseClick(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    int row = tree.getRowForLocation(x, y);
    TreePath path = tree.getPathForRow(row);
    doLeftMouseClick(path);
  }

  protected void doLeftMouseClick(TreePath path) {
    if (path != null) {
      JTreeNode node = (JTreeNode) path.getLastPathComponent();
      boolean isSelected = !(node.isSelected());
      doSelectNode(node, isSelected);
      repaintTree(node);
    }
  }

  protected void doSelectNode(JTreeNode node, boolean isSelected) {
    node.setSelected(isSelected);
    if (node.getSelectionMode() == JTreeNode.DIG_IN_SELECTION) {
      JTreeNode parent = (JTreeNode) node.getParent();
      if (isSelected) {
        selectChild(parent, isSelected);
      } else {
        notSelectChild(parent, isSelected);
      }
    }
  }

  protected void selectChild(JTreeNode parent, boolean isSelected) {
    if (null != parent) {
      //����ýڵ�ĸ��ڵ��µ����нڵ㼴�ýڵ���ֵܽڵ㶼��ѡ�У�����丸�ڵ�Ҳѡ��
      if (childAllSelected(parent)) {
        parent.setSelected(isSelected);
      }
    }
  }

  protected void notSelectChild(JTreeNode parent, boolean isSelected) {
    if (null != parent) {
      //����ýڵ�ĸ��ڵ��µ����нڵ㼴�ýڵ���ֵܽڵ㶼δ��ѡ�У�����丸�ڵ�Ҳ����Ϊδѡ��
      if (childAllNotSelected(parent)) {
        parent.setSelected(isSelected);
      }
    }
  }

  protected void repaintTree(JTreeNode node) {
    ((DefaultTreeModel) tree.getModel()).nodeChanged(node);
    tree.revalidate();
    tree.repaint();
  }

  protected boolean childAllNotSelected(JTreeNode parent) {
    if (parent != null) {
      Enumeration<?> enumeration = parent.children();
      boolean allNotSelected = true;
      while (enumeration.hasMoreElements()) {
        JTreeNode node = (JTreeNode) enumeration.nextElement();
        if (node.isSelected()) {
          allNotSelected = false;
          break;
        }
      }
      return allNotSelected;
    }
    return false;
  }

  protected boolean childAllSelected(JTreeNode parent) {
    if (parent != null) {
      Enumeration<?> enumeration = parent.children();
      boolean allSelected = true;
      while (enumeration.hasMoreElements()) {
        JTreeNode node = (JTreeNode) enumeration.nextElement();
        if (!node.isSelected()) {
          allSelected = false;
          break;
        }
      }
      return allSelected;
    }
    return false;
  }
}
