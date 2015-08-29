/**
 * EbGroupSellerDialog.java
 * com.eb.client.component.ebCandidateItem
 * Administrator
 * Sep 5, 2012
 */
package com.eb.client.component.ebCandidateItem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.MyTableModel;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.client.common.converter.EbSellerToTableModelConverter;
import com.ufgov.gk.client.component.IForeignEntityHandler;
import com.ufgov.gk.client.component.JTablePanel;
import com.ufgov.gk.client.component.table.BeanTableModel;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.ForeignEntityFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.gk.common.ebay.model.EbCandidateItem;
import com.ufgov.gk.common.ebay.model.EbSeller;
import com.ufgov.gk.common.ebay.model.EbSellerGroup;
import com.ufgov.gk.common.ebay.publish.IEbayServiceDelegate;
import com.ufgov.gk.common.system.constants.ZcElementConstants;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.smartclient.component.table.fixedtable.JPageableFixedTable;

/**
 * @author Administrator
 *
 */
public class EbGroupSellerDialog extends JDialog {
  private EbCandidateItemEditPanel parent;

  private EbCandidateItem candidateItem;

  private EbSellerGroup existGroup = new EbSellerGroup();

  private EbSellerGroup newGroup = new EbSellerGroup();

  ForeignEntityFieldEditor sellerGroupField = null;

  TextFieldEditor fieldId = null;

  TextFieldEditor fieldName = null;

  TextFieldEditor fieldRemark = null;

  JTablePanel tablePanel = new JTablePanel();

  JRadioButton oldGroupButton = null;

  JRadioButton newGroupButton = null;

  List<AbstractFieldEditor> fieldLst = new ArrayList<AbstractFieldEditor>();

  private IEbayServiceDelegate ebayServiceDelegate = (IEbayServiceDelegate) ServiceFactory.create(IEbayServiceDelegate.class, "ebayServiceDelegate");

  public EbGroupSellerDialog(EbCandidateItemEditPanel ebCandidateItemEditPanel, EbCandidateItem item) {
    super(ebCandidateItemEditPanel.getOwner());
    this.parent = ebCandidateItemEditPanel;
    this.candidateItem = item;
    init();
  }

  private void init() {
    // TODO Auto-generated method stub
    initSwing();
    setData();
  }

  private void setData() {
    // TODO Auto-generated method stub
    sellerGroupField.setEditObject(existGroup);
    for (AbstractFieldEditor field : fieldLst) {
      field.setEditObject(newGroup);
    }
    refreshSubTableData(this.parent.getSellerInfo());
  }

  private void refreshSubTableData(List sellerLst) {
    EbSellerToTableModelConverter mc = new EbSellerToTableModelConverter();
    tablePanel.getTable().setShowCheckedColumn(true);
    tablePanel.setTableModel(mc.convertEbSellerToBeanTableModel(this.parent.getSellerInfo()));
    //    setTableProperty(tablePanel.getTable());
  }

  private void initSwing() {
    this.getContentPane().setLayout(new BorderLayout());
    //    this.getContentPane().
    this.getContentPane().add(createGroupPanel(), BorderLayout.NORTH);
    this.getContentPane().add(createSellerPanel(), BorderLayout.CENTER);
    this.getContentPane().add(createButtonPanel(), BorderLayout.SOUTH);
    this.setTitle("卖家集合");
  }

  private JPanel createButtonPanel() {
    // TODO Auto-generated method stub
    JPanel p = new JPanel();
    JButton confirmBtm = new JButton("确定");
    confirmBtm.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        doConfirm();
      }
    });
    JButton cancelBtm = new JButton("取消");
    cancelBtm.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        doCancel();
      }
    });
    p.add(confirmBtm);
    p.add(cancelBtm);
    return p;
  }

  protected void doCancel() {
    // TODO Auto-generated method stub
    this.dispose();

  }

  protected void doConfirm() {
    // TODO Auto-generated method stub
    EbSellerGroup _group = saveSellerGroup();
    if (_group != null) {
      updatePanels(_group);
      this.dispose();
    }
    this.dispose();
  }

  private void updatePanels(EbSellerGroup _group) {
    // TODO Auto-generated method stub
    this.parent.setGroupBtnStyle(this.parent.getDefaultBtnColor(), this.parent.getDefaultBtnFont());
    //更新任务表上的卖家信息
    this.parent.updateTaskInfoWithGroup(_group);
  }

  private EbSellerGroup saveSellerGroup() {
    // TODO Auto-generated method stub
    String actionType = ZcSettingConstants.PAGE_STATUS_BROWSE;
    EbSellerGroup _group = new EbSellerGroup();
    if (!oldGroupButton.isSelected() && !newGroupButton.isSelected()) {
      JOptionPane.showMessageDialog(this, "请选择卖家集合！", "提示", JOptionPane.INFORMATION_MESSAGE);
      return null;
    }
    if (oldGroupButton.isSelected()) {
      if (existGroup.getGroupId() == null) {
        JOptionPane.showMessageDialog(this, "请选择卖家集合！", "提示", JOptionPane.INFORMATION_MESSAGE);
        return null;
      }
      _group = this.existGroup;
    }
    if (newGroupButton.isSelected()) {
      if (newGroup.getGroupId() == null || newGroup.getName() == null) {
        JOptionPane.showMessageDialog(this, "请完善卖家集合信息！", "提示", JOptionPane.INFORMATION_MESSAGE);
        return null;
      }
      actionType = ZcSettingConstants.PAGE_STATUS_NEW;
      _group = newGroup;
    }
    JPageableFixedTable table = tablePanel.getTable();

    Integer[] selectedRows = table.getCheckedRows();
    if (selectedRows.length == 0) {
      JOptionPane.showMessageDialog(this, "没有选择卖家！", "提示", JOptionPane.INFORMATION_MESSAGE);
      return null;
    }
    BeanTableModel tableModel = ((BeanTableModel) table.getModel());

    int[] selRows = new int[selectedRows.length];

    for (int i = 0; i < selRows.length; i++) {
      selRows[i] = table.convertRowIndexToModel(selectedRows[i]);
    }
    Arrays.sort(selRows);
    EbSeller seller;
    for (int i = selRows.length - 1; i >= 0; i--) {
      seller = (EbSeller) tableModel.getBean(selRows[i]);
      seller.setGroupId(_group.getGroupId());
      _group.getSellerLst().add(seller);
    }
    this.ebayServiceDelegate.saveEbSellGroup(_group, WorkEnv.getInstance().getRequestMeta(), actionType);
    JOptionPane.showMessageDialog(this, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
    return _group;

  }

  //创建卖家面板
  private JComponent createSellerPanel() {
    // TODO Auto-generated method stub
    JTabbedPane tabPane = new JTabbedPane();
    tablePanel = new JTablePanel();
    tablePanel.init();
    tablePanel.setTablePreferencesKey(this.getClass().getName() + "_table");
    tablePanel.getTable().setShowCheckedColumn(false);
    tablePanel.getTable().getTableRowHeader().setPreferredSize(new Dimension(50, 0));
    //    setTableCell(tablePanel.getTable());
    tabPane.addTab("卖家信息", tablePanel);
    //
    //    JFuncToolBar subPackTableToolbar = new JFuncToolBar();
    //    JButton addBtn1 = new JButton("添加");
    //    JButton insertBtn1 = new JButton("插入");
    //    JButton delBtn1 = new JButton("删除");
    //    subPackTableToolbar.add(addBtn1);
    //    subPackTableToolbar.add(insertBtn1);
    //    subPackTableToolbar.add(delBtn1);
    //    tablePanel.add(subPackTableToolbar, BorderLayout.SOUTH);

    return tabPane;
  }

  //创建卖家集合面板
  private JPanel createGroupPanel() {
    // TODO Auto-generated method stub

    //创建卖家集合面板
    oldGroupButton = new JRadioButton("选择集合");
    newGroupButton = new JRadioButton("新建集合");
    ButtonGroup btgp = new ButtonGroup();
    btgp.add(oldGroupButton);
    btgp.add(newGroupButton);

    String columNames[] = { "集合编号", "集合名称", "备注" };

    SellerGroupFnHandler groupHandler = new SellerGroupFnHandler(columNames);

    ElementConditionDto dto = new ElementConditionDto();

    sellerGroupField = new ForeignEntityFieldEditor("EB_SELLER_GROUP.selectByDto", dto, 20,

    groupHandler, columNames, "卖家集合", "groupId");

    //    fieldLst.add(sellerGroupField);

    fieldId = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_GROUP_GROUP_ID), "groupId");
    fieldLst.add(fieldId);
    fieldName = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_GROUP_NAME), "name");
    fieldLst.add(fieldName);
    fieldRemark = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_GROUP_REMARK), "remark");
    fieldLst.add(fieldRemark);

    JPanel groupPanel = new JPanel();
    groupPanel.setBorder(new TitledBorder(null, "卖家集合", TitledBorder.CENTER, TitledBorder.TOP));
    groupPanel.setLayout(new GridBagLayout());
    int row = 0, col = 0;

    //1
    oldGroupButton.setPreferredSize(new Dimension(150, 26));
    groupPanel.add(oldGroupButton, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(4,
      0, 4, 4), 0, 0));
    JLabel label = new JLabel(sellerGroupField.getName());
    groupPanel.add(label, new GridBagConstraints(++col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE,
      new Insets(4, 0, 4, 4), 0, 0));
    groupPanel.add(sellerGroupField, new GridBagConstraints(++col, row, sellerGroupField.getOccCol(), sellerGroupField.getOccRow(), 1.0, 1.0,
      GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(4, 0, 4, 4), 0, 0));
    //2
    col = 0;
    ++row;
    newGroupButton.setPreferredSize(new Dimension(150, 26));
    groupPanel.add(newGroupButton, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(4,
      0, 4, 4), 0, 0));
    label = new JLabel(fieldId.getName());
    groupPanel.add(label, new GridBagConstraints(++col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE,
      new Insets(4, 0, 4, 4), 0, 0));
    groupPanel.add(fieldId, new GridBagConstraints(++col, row, fieldId.getOccCol(), fieldId.getOccRow(), 1.0, 1.0, GridBagConstraints.WEST,
      GridBagConstraints.HORIZONTAL, new Insets(4, 0, 4, 4), 0, 0));
    label = new JLabel(fieldName.getName());
    groupPanel.add(label, new GridBagConstraints(++col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE,
      new Insets(4, 0, 4, 4), 0, 0));
    groupPanel.add(fieldName, new GridBagConstraints(++col, row, fieldName.getOccCol(), fieldName.getOccRow(), 1.0, 1.0, GridBagConstraints.WEST,
      GridBagConstraints.HORIZONTAL, new Insets(4, 0, 4, 4), 0, 0));
    //3
    col = 1;
    ++row;
    label = new JLabel(fieldRemark.getName());
    groupPanel.add(label, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(4, 0, 4, 4),
      0, 0));
    groupPanel.add(fieldRemark, new GridBagConstraints(++col, row, 3, fieldRemark.getOccRow(), 1.0, 1.0, GridBagConstraints.WEST,
      GridBagConstraints.HORIZONTAL, new Insets(4, 0, 4, 4), 0, 0));

    oldGroupButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        doOldGroupButtonSelect();
      }
    });
    newGroupButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        doNewGroupButtonSelect();
      }
    });
    return groupPanel;
  }

  private void setEditObject() {
    // TODO Auto-generated method stub
    for (AbstractFieldEditor field : fieldLst) {
      //      System.out.println("====" + field.getFieldName());
      field.setEditObject(newGroup);
    }
  }

  protected void doNewGroupButtonSelect() {
    // TODO Auto-generated method stub
    for (AbstractFieldEditor field : fieldLst) {
      //      System.out.println("====" + field.getFieldName());
      field.setEnabled(true);
    }
    sellerGroupField.setEnabled(false);

  }

  protected void doOldGroupButtonSelect() {
    // TODO Auto-generated method stub
    for (AbstractFieldEditor field : fieldLst) {
      //      System.out.println("====" + field.getFieldName());
      field.setEnabled(false);
    }
    sellerGroupField.setEnabled(true);
  }

  private class SellerGroupFnHandler implements IForeignEntityHandler {
    private String columNames[];

    public SellerGroupFnHandler(String columNames[]) {

      this.columNames = columNames;

    }

    @Override
    public void excute(List selectedDatas) {
      // TODO Auto-generated method stub

      for (Object object : selectedDatas) {
        existGroup = (EbSellerGroup) object;
        sellerGroupField.setEditObject(existGroup);
      }

    }

    @Override
    public boolean isMultipleSelect() {
      // TODO Auto-generated method stub
      return false;
    }

    @Override
    public TableModel createTableModel(List showDatas) {
      // TODO Auto-generated method stub

      Object data[][] = new Object[showDatas.size()][columNames.length];

      for (int i = 0; i < showDatas.size(); i++) {

        EbSellerGroup rowData = (EbSellerGroup) showDatas.get(i);

        int col = 0;

        data[i][col++] = rowData.getGroupId();

        data[i][col++] = rowData.getName();

        data[i][col++] = rowData.getRemark();

      }

      MyTableModel model = new MyTableModel(data, columNames) {

        public boolean isCellEditable(int row, int colum) {

          return false;

        }

      };

      return model;
    }

  }
}
