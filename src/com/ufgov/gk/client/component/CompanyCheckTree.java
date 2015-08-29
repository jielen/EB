package com.ufgov.gk.client.component;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.datacache.CompanyDataCache;
import com.ufgov.gk.common.commonbiz.model.Company;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;

public class CompanyCheckTree extends JTree {

  private List companyList;

  private List<Company> selectedCompanyList;

  private IBaseDataServiceDelegate baseDataServiceDelegate;

  private String baseDataServiceDelegateName = "baseDataServiceDelegate";

  private final int DEFAULT_ROWHEIGHT = 20; // 默认行高

  /**
   * @param showData 是否打开时就显示数据
   */
  public CompanyCheckTree(boolean showData) {
    super();
    init();
    if (showData) {
      refreshCompanyList();
      createTree();
    }
  }

  private void init() {
    baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(
      IBaseDataServiceDelegate.class, baseDataServiceDelegateName);
    selectedCompanyList = new ArrayList<Company>();

    this.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        // 取出点击的节点路径，为null时未点中
        int x = e.getX();
        int y = e.getY();
        int row = getRowForLocation(x, y);
        TreePath path = getPathForRow(row);
        if(path==null)
          return;
        CheckNode node = (CheckNode) getLastSelectedPathComponent();
        if (node == null)
          return;
        node.setSelected(!node.isSelected());
        repaint();
      }
    });

    this.setRowHeight(DEFAULT_ROWHEIGHT);
  }

  public List getCompanyList() {
    return companyList;
  }

  public void setCompanyList(List companyList) {
    this.companyList = companyList;
  }

  /**
   * 返回勾选中的单位list
   * @return
   */
  public List getSelectedCompanyList() {
    selectedCompanyList.clear();
    CheckNode root = (CheckNode) this.getModel().getRoot();
    Enumeration e = root.depthFirstEnumeration();
    while (e.hasMoreElements()) {
      CheckNode node = (CheckNode) e.nextElement();
      if(node==root)
        continue;
      if (node.isSelected()) {
        Company company = (Company) node.getUserObject();
        selectedCompanyList.add(company);
      }
    }
    return selectedCompanyList;
  }

  /**
   * 返回勾选中的末级单位list
   * @return
   */
  public List getSelectedLeafCompanyList() {
    selectedCompanyList.clear();
    CheckNode root = (CheckNode) this.getModel().getRoot();
    CheckNode node = (CheckNode)root.getFirstLeaf();
    while (node!=null) {
      if (node.isSelected()) {
        Company company = (Company) node.getUserObject();
        selectedCompanyList.add(company);
      }
      node = (CheckNode)node.getNextLeaf();
    }
    return selectedCompanyList;
  }

  /**
   * 设置需要勾选的单位节点
   * @param selectedCompanyList
   * @param strict 是否严格判断（为否时只判断单位代码）
   */
  public void setSelectedCompanyList(List selectedCompanyList, boolean strict) {
    CheckNode root = (CheckNode) this.getModel().getRoot();
    Enumeration e = root.depthFirstEnumeration();
    while (e.hasMoreElements()) {
      CheckNode node = (CheckNode) e.nextElement();
      Company company = (Company) node.getUserObject();
      node.setSelectionMode(CheckNode.SINGLE_SELECTION);
      if (selectedCompanyList == null)
        node.setSelected(false);
      else if (strict) {
        if (selectedCompanyList.contains(company))
          node.setSelected(true);
        else
          node.setSelected(false);
      } else if (!strict) {
        boolean hasCode = false;
        for (Object o : selectedCompanyList) {
          Company tmpCompany = (Company) o;
          if (company.getCode().equals(tmpCompany.getCode())) {
            hasCode = true;
            break;
          }
        }
        node.setSelected(hasCode);
      }
      node.setSelectionMode(CheckNode.DIG_IN_SELECTION);
    }
    repaint();
  }
  
  /**
   * 设置需要勾选的叶节点
   * @param selectedCompanyList
   * @param strict
   */
  public void setSelectedLeafCompanyList(List selectedCompanyList, boolean strict) {
    CheckNode root = (CheckNode) this.getModel().getRoot();
    CheckNode node = (CheckNode)root.getFirstLeaf();
    while (node!=null) {
      Company company = (Company) node.getUserObject();
      if (selectedCompanyList == null)
        node.setSelected(false);
      else if (strict) {
        if (selectedCompanyList.contains(company))
          node.setSelected(true);
        else
          node.setSelected(false);
      } else if (!strict) {
        boolean hasCode = false;
        for (Object o : selectedCompanyList) {
          Company tmpCompany = (Company) o;
          if (company.getCode().equals(tmpCompany.getCode())) {
            hasCode = true;
            break;
          }
        }
        node.setSelected(hasCode);
      }
      node = (CheckNode)node.getNextLeaf();
    }
    repaint();
  }

  /**
   * 刷新单位数据
   */
  public void refreshCompanyList() {
//    ElementConditionDto dto = new ElementConditionDto();
//    dto.setNd(WorkEnv.getInstance().getTransNd());
//    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();
//    companyList = baseDataServiceDelegate.getCompany(dto, requestMeta);
    companyList = CompanyDataCache.getCompany();
  }

  /**
   * 构建单位树
   */
//  public void createTree() {
//    //创建根节点
//    Company companyRoot = new Company();
//    companyRoot.setCode("");
//    companyRoot.setName("单位");
//    CheckNode root = new CheckNode(companyRoot);
//    CheckNode priorNode = root;
//    for (Object o : companyList) {
//      Company company = (Company) o;
//      CheckNode node = new CheckNode(company);
//      Company priorCompany = (Company) priorNode.getUserObject();
//      if ((company.getParentCode() == null)
//        || (company.getParentCode().equalsIgnoreCase("")))
//        root.add(node);
//      else if (company.getParentCode().equals(priorCompany.getCode()))
//        priorNode.add(node);
//      else {
//        // 循环取上个节点的父节点，从树深处退出
//        while (priorNode.getParent() != null) {
//          priorNode = (CheckNode) priorNode.getParent();
//          priorCompany = (Company) priorNode.getUserObject();
//          if (company.getParentCode().equals(priorCompany.getCode()))
//            priorNode.add(node);
//        }
//      }
//      priorNode = node;
//    }
//    this.setModel(new DefaultTreeModel(root));
//    this.setCellRenderer(new CheckRenderer());
//    // 单选
//    DefaultTreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
//    selectionModel.setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
//    this.setSelectionModel(selectionModel);
//  }
//  
  
  public void createTree() {
    //创建根节点
    Company companyRoot = new Company();
    companyRoot.setCode("");
    companyRoot.setName("单位");
    CheckNode root = new CheckNode(companyRoot);

    List companyTreeList = genTreeData();

    for (Object o : companyTreeList) {
      Company company = (Company) o;

      CheckNode node = new CheckNode(company);
      root.add(node);
      this.setChildNode(company, node);
    }
    this.setModel(new DefaultTreeModel(root));
    this.setCellRenderer(new CheckRenderer());
    DefaultTreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
   selectionModel.setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
  this.setSelectionModel(selectionModel);
  }
  
  ////////////////
  
  
  private List genTreeData() {
    
    List rootCompanyList = new ArrayList();
    List childrenCompanyList = new ArrayList();
    
    Map dataMap = new HashMap();
    
    for (Object o : companyList) {
      Company cpy = (Company) o;
      dataMap.put(cpy.getCode(), cpy);
    }
    
    for (Object o : companyList) {
      Company cpy = (Company) o;
      if (dataMap.get(cpy.getParentCode()) == null) {
        rootCompanyList.add(cpy);
      } else {
        childrenCompanyList.add(cpy);
      }
    }
    Map childrenMap = new HashMap();

    for (int i = 0; i < childrenCompanyList.size(); i++) {
      Company child = (Company) childrenCompanyList.get(i);

      List childrenList = (List) childrenMap.get(child.getParentCode());
      if (childrenList != null) {
        childrenList.add(child);
      } else {
        List tempList = new ArrayList();
        tempList.add(child);
        childrenMap.put(child.getParentCode(), tempList);
      }
    }
    for (int i = 0; i < rootCompanyList.size(); i++) {
      Company company = (Company) rootCompanyList.get(i);
      this.setCompanyChildren(company, childrenMap);
    }
    return rootCompanyList;
  }


  private void setCompanyChildren(Company company, Map childrenMap) {
    List childrenList = (List) childrenMap.get(company.getCode());
    if (childrenList != null) {
      company.setChildren(childrenList);
      for (int i = 0; i < childrenList.size(); i++) {
        Company c = (Company) childrenList.get(i);
        setCompanyChildren(c, childrenMap);
      }
    }
  }


  private void setChildNode(Company company, CheckNode node) {
    if (company.getChildren().size() > 0) {
      for (Object o : company.getChildren()) {
        Company c = (Company) o;
        CheckNode childNode = new CheckNode(c);
        node.add(childNode);
        setChildNode(c, childNode);
      }
    }
  }
  
  ////////////////
  
  

  public void expandAll(boolean expand) {
    DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.getModel().getRoot();
    expandAll(new TreePath(root), expand);
  }

  /**
   * 遍历parent的所有子节点并展开
   * @param parent
   * @param expand
   */
  public void expandAll(TreePath parent, boolean expand) {
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) parent
      .getLastPathComponent();
    if (node.getChildCount() >= 0) {
      for (Enumeration e = node.children(); e.hasMoreElements();) {
        DefaultMutableTreeNode n = (DefaultMutableTreeNode) e.nextElement();
        TreePath path = parent.pathByAddingChild(n);
        expandAll(path, expand);
      }
    }
    if (expand) {
      this.expandPath(parent);
    } else {
      this.collapsePath(parent);
    }
  }

  public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    CompanyCheckTree tree = new CompanyCheckTree(true);
    tree.expandRow(1);
    JFrame f = new JFrame();
    f.getContentPane().add(new JScrollPane(tree));
    f.setSize(400, 600);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

}
