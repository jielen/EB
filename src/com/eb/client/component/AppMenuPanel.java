package com.eb.client.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.apache.log4j.Logger;

import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.ebay.model.AppMenuItem;
import com.ufgov.gk.common.system.RequestMeta;

public class AppMenuPanel extends JPanel {
  private static Logger log = Logger.getLogger(AppMenuPanel.class);

  EbMain ebMain;

  AppMenuList menuList;

  AppMenuTree menuTree;

  List<AppMenuItem> menus;

  private IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class,
    "baseDataServiceDelegate");

  public AppMenuPanel(EbMain ebMain) {
    // TODO Auto-generated constructor stub
    this.ebMain = ebMain;
    setLayout(new BorderLayout());
    //    menuList = new AppMenuList(parent);
    menuTree = new AppMenuTree(ebMain);
    getMenus();
    createTree();
    initSwing();
    expandAllMenus();
  }

  private void expandAllMenus() {
    // TODO Auto-generated method stub
    DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.menuTree.getModel().getRoot();
    expandAll(new TreePath(root), true);
  }

  private void initSwing() {
    // TODO Auto-generated method stub
    JScrollPane sc = new JScrollPane(this.menuTree);
    this.add(sc, BorderLayout.CENTER);
  }

  private void createTree() {
    // TODO Auto-generated method stub
    DefaultMutableTreeNode root = new DefaultMutableTreeNode();
    DefaultTreeModel treeModel = new DefaultTreeModel(root);

    for (int i = 0; i < this.menus.size(); i++) {
      AppMenuItem item = menus.get(i);
      DefaultMutableTreeNode node = new DefaultMutableTreeNode();
      node.setUserObject(item);
      root.add(node);
      addChild(node, item);
    }
    DefaultTreeModel model = new DefaultTreeModel(root);
    this.menuTree.setModel(model);

    // 设置树的选择模式：只能单选
    DefaultTreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
    selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    this.menuTree.setSelectionModel(selectionModel);
    this.menuTree.setRootVisible(false);
    this.menuTree.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
          selectMenu(e);
        }
      }
    });
  }

  protected void selectMenu(MouseEvent e) {
    // TODO Auto-generated method stub
    //    log.debug("you click me");
    TreePath path = this.menuTree.getPathForLocation(e.getX(), e.getY());
    if (path == null) {
      return;
    }
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
    if (node == null) {
      return;
    }
    AppMenuItem item = (AppMenuItem) node.getUserObject();
    this.ebMain.actionPerformMenuTreeDoubleClick(item);
  }

  private void addChild(DefaultMutableTreeNode node, AppMenuItem item) {
    // TODO Auto-generated method stub
    for (int i = 0; i < item.getChildren().size(); i++) {
      AppMenuItem childItem = item.getChildren().get(i);
      DefaultMutableTreeNode childNode = new DefaultMutableTreeNode();
      childNode.setUserObject(childItem);
      node.add(childNode);
      addChild(childNode, childItem);
    }
  }

  private void getMenus() {
    // TODO Auto-generated method stub
    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();
    this.menus = this.baseDataServiceDelegate.getMenus(requestMeta);
  }

  /**
   * 遍历parent的所有子节点并展开
   * @param parent
   * @param expand
   */
  private void expandAll(TreePath parent, boolean expand) {
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) parent.getLastPathComponent();
    if (node.getChildCount() >= 0) {
      for (Enumeration e = node.children(); e.hasMoreElements();) {
        DefaultMutableTreeNode n = (DefaultMutableTreeNode) e.nextElement();
        TreePath path = parent.pathByAddingChild(n);
        expandAll(path, expand);
      }
    }
    if (expand) {
      this.menuTree.expandPath(parent);
    } else {
      this.menuTree.collapsePath(parent);
    }
  }

  public Dimension getPreferredSize() {
    return new Dimension(150, super.getPreferredSize().height);
  }
}
