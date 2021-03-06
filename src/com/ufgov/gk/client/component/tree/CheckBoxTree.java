package com.ufgov.gk.client.component.tree;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JTree;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 *CheckBoxTree Ҫ���CheckBoxTreeNodeʹ��
 */
public class CheckBoxTree extends JTree {

  private static final long serialVersionUID = -217950037507321241L;
  
  public CheckBoxTree() {
    init();
  }


  public CheckBoxTree(TreeModel newModel) {
    super(newModel);
    init();
  }

  public CheckBoxTree(TreeModel newModel, boolean autoCheckChildren) {
    super(newModel);
    init();
  }

  private void init() {
    setCellRenderer(new CheckBoxTreeCellRenderer());
    addCheckingListener();
  }

  private boolean autoCheckChildren;

  public boolean isAutoCheckChildren() {
    return autoCheckChildren;
  }

  public void setAutoCheckChildren(boolean autoCheckChildren) {
    this.autoCheckChildren = autoCheckChildren;
  }

  private void addCheckingListener() {
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        int row = getRowForLocation(e.getX(), e.getY());
        TreePath treePath = getPathForRow(row);
        if (treePath == null) {
          return;
        }
        CheckBoxTreeNode node = ((CheckBoxTreeNode) treePath.getLastPathComponent());
        boolean checking = !node.isChecked();
        checkNode(node, checking);
        repaint();
      }

      private void checkNode(CheckBoxTreeNode node, boolean checking) {
        node.setChecked(checking);
        if (!node.isLeaf()) {
          if (autoCheckChildren) {
            Enumeration<CheckBoxTreeNode> children = node.children();
            while (children.hasMoreElements()) {
              checkNode(children.nextElement(), checking);
            }
          }
        }
      }
    });
  }

  public List getCheckedObjects() {
    List checkedList = new ArrayList();
    CheckBoxTreeNode root = (CheckBoxTreeNode) this.getModel().getRoot();
    Enumeration e = root.depthFirstEnumeration();
    while (e.hasMoreElements()) {
      CheckBoxTreeNode node = (CheckBoxTreeNode) e.nextElement();
      if (node.isChecked()) {
        checkedList.add(node.getUserObject());
      }
    }
    return checkedList;
  }
}
