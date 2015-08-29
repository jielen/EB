package com.ufgov.gk.client.component;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import org.apache.log4j.Logger;

import com.ufgov.gk.common.commonbiz.model.BaseElement;

public abstract class JTreeSelectDialog extends GkBaseDialog {

  protected Logger log = Logger.getLogger(this.getClass());

  protected JTreeSelectDialog self = this;

  protected JButtonTextField triggerField;

  private JPanel bottomPanel = new JPanel();

  private JPanel centerPanel = new JPanel();

  private JButton okButton = new JButton("确定");

  private JButton clearButton = new JButton("清空");

  private JButton cancelButton = new JButton("关闭");

  protected JTree selectTree = new JTree();

  protected List dataBufferList = new ArrayList();

  protected List numLimDataList = new ArrayList();

  protected String sqlMapSelectedId;

  protected boolean isSelectTailTag;

  /**
   * 
   */
  private static final long serialVersionUID = -3594849692436568807L;

  protected void init() {
    new Thread() {
      public void run() {
        initDataBufferList();
        getTriggerField().countDown();
      }
    }.start();
    this.initTitle();
    this.initSearchBar();
    this.initCenterPanel();
    this.initBottomPanel();

    this.getContentPane().setLayout(new BorderLayout());
    this.add(searchBar, BorderLayout.NORTH);
    this.add(centerPanel, BorderLayout.CENTER);
    this.add(bottomPanel, BorderLayout.SOUTH);

    selectTree.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
          
            int rowLocation = selectTree.getRowForLocation(e.getX(),e.getY()); 
            TreePath treepath = selectTree.getPathForRow(rowLocation); 
            if (treepath == null) {
            	return; 
            } 
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) treepath.getLastPathComponent();
            
            if(!isSelectTailTag){
	            if (node.getUserObject() instanceof String) { 
	            	return; 
	            }
	            triggerField.setValue(node.getUserObject());
	            closeDialog();
            }
           
          //DefaultMutableTreeNode node = (DefaultMutableTreeNode) selectTree.getLastSelectedPathComponent();
          if (node.getChildCount() > 0) {

          } else {
            doOK();
          }
        }
      }
    });

    this.setSize(550, 500);
    this.moveToScreenCenter();
  }

  protected JPanel searchBar = new JPanel() {
    {
      // this.setFloatable(false);
      this.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

  };

  private JLabel searchLabel = new JLabel("查找：");

  protected JTextField searchField = new JTextField(30);

  protected JButton searchButton = new JButton("查找");

  protected Map<Object, DefaultMutableTreeNode> treeNodeMap = new HashMap<Object, DefaultMutableTreeNode>();

  private void initSearchBar() {

    searchBar.add(searchLabel);
    searchBar.add(searchField);
    searchBar.add(searchButton);

    searchField.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          doSearch();
        }
      }
    });

    searchButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        doSearch();
      }
    });

  }

  protected void doSearch() {
    int rowCount = selectTree.getRowCount();

    String searchString = this.searchField.getText().trim();
    if (searchString.equals("") || searchString.equals("[") || searchString.equals("]")) {
      return;
    }

    DefaultMutableTreeNode node = (DefaultMutableTreeNode) selectTree.getLastSelectedPathComponent();
    if (node == null || node.getNextNode() == null) {
      node = (DefaultMutableTreeNode) selectTree.getModel().getRoot();
    }
    DefaultMutableTreeNode currentNode = node;
    node = node.getNextNode();
    if (node == null)
      return;

    while (node != currentNode) {
      Object object = node.getUserObject();
      if (object.toString().indexOf(searchString) >= 0) {
        for (int i = rowCount - 1; i > 0; i--) {
          selectTree.collapseRow(i);
        }
        selectTree.setSelectionPath(new TreePath(node.getPath()));
        // /
        int[] selectedRows = selectTree.getSelectionRows();

        if (selectedRows.length > 0) {
          selectTree.scrollRowToVisible(selectedRows[0]);
        }
        return;
      }
      node = node.getNextNode();

      if (node == null)
        node = (DefaultMutableTreeNode) selectTree.getModel().getRoot();
    }
    // 在采购目录中输入关键字，如果没有匹配数据，弹出没有记录提示框—guoss
    if (node.getUserObject().toString().indexOf(searchString) <= 0) {
      JOptionPane.showMessageDialog(self, "没有记录!", "提示", JOptionPane.INFORMATION_MESSAGE);
    }
    // if (node == currentNode) {
    // JOptionPane.showMessageDialog(self, "没有记录!", "提示",
    // JOptionPane.INFORMATION_MESSAGE);
    // }
  }

  // protected void doSearch2() {
  //
  // int rowCount = selectTree.getRowCount();
  // for (int i = rowCount - 1; i > 0; i--) {
  // selectTree.collapseRow(i);
  // }
  // selectTree.clearSelection();
  //
  // String searchString = this.searchField.getText().trim();
  // if (searchString.equals("") || searchString.equals("[")
  // || searchString.equals("]")) {
  // return;
  // }
  // DefaultMutableTreeNode
  // rootNode=(DefaultMutableTreeNode)selectTree.getModel().getRoot();
  // Enumeration enu=rootNode.preorderEnumeration();
  // Set<Object> keyset = treeNodeMap.keySet();
  // List<DefaultMutableTreeNode> matchNodes = new
  // ArrayList<DefaultMutableTreeNode>();
  //    
  // while (enu.hasMoreElements()) {
  // DefaultMutableTreeNode node=(DefaultMutableTreeNode)enu.nextElement();
  // Object object=node.getUserObject();
  // if (object.toString().indexOf(searchString) >= 0) {
  // matchNodes.add(node);
  // }
  // }
  //    
  // if(matchNodes.size()>500){
  // matchNodes=matchNodes.subList(0, 500);
  // }
  //    
  // TreePath[] matchTreePaths = new TreePath[matchNodes.size()];
  // for (int i = 0; i < matchTreePaths.length; i++) {
  // matchTreePaths[i] = new TreePath(matchNodes.get(i).getPath());
  // }
  // selectTree.setSelectionPaths(matchTreePaths);
  //    
  // int[] selectedRows=selectTree.getSelectionRows() ;
  //    
  // if(selectedRows.length>0){
  // selectTree. scrollRowToVisible(selectedRows[0]);
  // }
  // }

  protected JTree getSelectTree() {
    return selectTree;
  }

  protected void setSelectTree(JTree selectTree) {
    this.selectTree = selectTree;
  }

  protected abstract void initTitle();

  protected abstract void initDataBufferList();

  protected abstract void initSelectTree();

  public synchronized void setVisible(boolean b) {

    if (b) {
      initSelectTree();
      initSelection();
    }
    super.setVisible(b);

  }

  private void initSelection() {
    Object oldValue = this.getTriggerField().getValue();
    TreePath path = null;
    if (oldValue != null && treeNodeMap.get(oldValue) != null) {
      path = new TreePath((treeNodeMap.get(oldValue)).getPath());
      this.getSelectTree().setSelectionPath(path);
    }
  }

  private void initCenterPanel() {
    centerPanel.setLayout(new BorderLayout());
    centerPanel.add(new JScrollPane(selectTree), BorderLayout.CENTER);
  }

  private void initBottomPanel() {

    cancelButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        self.closeDialog();
      }

    });
    okButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        self.doOK();
      }
    });

    clearButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        self.triggerField.setValue(null);
        self.selectTree.clearSelection();
        closeDialog();
      }
    });

    bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    bottomPanel.add(okButton);
    bottomPanel.add(clearButton);
    bottomPanel.add(cancelButton);

  }

  public void doOK() {

    DefaultMutableTreeNode node = (DefaultMutableTreeNode) selectTree.getLastSelectedPathComponent();

    int selected = selectTree.getSelectionCount();

    if (selected == 0) {
      JOptionPane.showMessageDialog(self, "请选择数据!", "提示", JOptionPane.INFORMATION_MESSAGE);
      return;
    } else if (selected > 1) {
      JOptionPane.showMessageDialog(self, "只能选择一条数据！", "提示", JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    if (node.getUserObject() instanceof String) {
      return;
    }

    if (node.getChildCount() > 0 && isSelectTailTag) {
      JOptionPane.showMessageDialog(self, "请选择末级节点!", "提示", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    triggerField.setValue(node.getUserObject());
    closeDialog();

  }

  public JTreeSelectDialog(Dialog owner, boolean modal, JButtonTextField triggerField) {
    super(owner, modal);
    this.triggerField = triggerField;

    init();
  }

  public JTreeSelectDialog(Dialog owner, boolean modal, JButtonTextField triggerField, boolean isSelectTailTag) {
    super(owner, modal);
    this.triggerField = triggerField;
    this.isSelectTailTag = isSelectTailTag;

    init();
  }

  public JTreeSelectDialog(Dialog owner, boolean modal, JButtonTextField triggerField, String sqlMapSelectedId, String title) {
    super(owner, title, modal);
    this.triggerField = triggerField;
    this.sqlMapSelectedId = sqlMapSelectedId;
    init();
  }

  public JButtonTextField getTriggerField() {
    return triggerField;
  }

  public void setTriggerField(JButtonTextField triggerField) {
    this.triggerField = triggerField;
  }

  protected boolean isNumLimContain(BaseElement element) {
    boolean flag = false;
    if (this.numLimDataList.contains(element)) {
      flag = true;
    } else {
      for (Object o : element.getChildren()) {
        BaseElement c = (BaseElement) o;
        if (isNumLimContain(c)) {
          flag = true;
        }
      }
    }
    return flag;
  }

  public Map<Object, DefaultMutableTreeNode> getTreeNodeMap() {
    return treeNodeMap;
  }

  public void setTreeNodeMap(Map<Object, DefaultMutableTreeNode> treeNodeMap) {
    this.treeNodeMap = treeNodeMap;
  }

}
