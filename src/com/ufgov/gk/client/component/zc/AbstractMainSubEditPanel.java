package com.ufgov.gk.client.component.zc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.ufgov.gk.client.common.BillElementMeta;
import com.ufgov.gk.client.common.ListCursor;
import com.ufgov.gk.client.component.JFuncToolBar;
import com.ufgov.gk.client.component.JTablePanel;
import com.ufgov.gk.client.component.button.FuncButton;
import com.ufgov.gk.client.component.table.BeanTableModel;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.NewLineFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.TextAreaFieldEditor;
import com.ufgov.gk.client.util.ZcUtil;
import com.ufgov.gk.common.commonbiz.fieldmap.FieldMapRegister;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.commonbiz.model.BillElement;
import com.ufgov.gk.common.commonbiz.model.WfAware;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.util.Utils;
import com.ufgov.smartclient.component.table.fixedtable.JPageableFixedTable;

@SuppressWarnings({ "unchecked", "serial" })
public abstract class AbstractMainSubEditPanel extends JPanel {

  protected JFuncToolBar toolBar = new JFuncToolBar();

  protected final JPanel workPanel = new JPanel();

  protected Object editingObject;

  protected List<AbstractFieldEditor> fieldEditors;

  protected JPanel fieldEditorPanel = new JPanel();

  public Class billClass;

  public BillElementMeta eleMeta;

  public abstract void initToolBar(JFuncToolBar toolBar);

  public abstract List<AbstractFieldEditor> createFieldEditors();

  public abstract JComponent createSubBillPanel();

  public AbstractMainSubEditPanel() {
  }

  public AbstractMainSubEditPanel(BaseBill model, String compoId) {
    this(model.getClass(), BillElementMeta.getBillElementMetaWithoutNd(compoId));
  }

  public AbstractMainSubEditPanel(Class billClass, BillElementMeta eleMeta) {
    this.billClass = billClass;
    this.eleMeta = eleMeta;
  }

  protected void init() {
    this.initToolBar(toolBar);
    this.setLayout(new BorderLayout());
    this.add(toolBar, BorderLayout.NORTH);

    this.add(workPanel, BorderLayout.CENTER);

    if (this.billClass != null && this.eleMeta != null) {
      initFieldEditorPanel(this.billClass, this.eleMeta);
    } else {
      initFieldEditorPanel();
    }

    workPanel.setLayout(new BorderLayout());
    workPanel.add(fieldEditorPanel, BorderLayout.NORTH);
    JComponent subBillPanel = createSubBillPanel();
    if (subBillPanel != null) {
      workPanel.add(subBillPanel, BorderLayout.CENTER);
    }
  }

  protected int colCount = 2;

  protected void initFieldEditorPanel() {
    fieldEditors = createFieldEditors();
    int row = 0;
    int col = 0;

    fieldEditorPanel.setLayout(new GridBagLayout());
    for (int i = 0; i < fieldEditors.size(); i++) {
      AbstractFieldEditor comp = fieldEditors.get(i);
      if (comp.isVisible()) {
        if (comp instanceof NewLineFieldEditor) {
          row++;
          col = 0;
          continue;
        } else if (comp instanceof TextAreaFieldEditor) {
          //ת���µ�һ��
          row++;
          col = 0;
          JLabel label = new JLabel(getLabelText(comp));
          comp.setPreferredSize(new Dimension(150 * comp.getOccCol(), comp.getOccRow() * 26));
          fieldEditorPanel.add(label, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(
            4, 0, 4, 4), 0, 0));
          fieldEditorPanel.add(comp, new GridBagConstraints(col + 1, row, comp.getOccCol(), comp.getOccRow(), 1.0, 1.0, GridBagConstraints.WEST,
            GridBagConstraints.HORIZONTAL, new Insets(4, 0, 4, 4), 0, 0));
          //����ǰ��ռ���пռ�ƫ����������
          row += comp.getOccRow();
          col = 0;
          continue;
        }
        JLabel label = new JLabel(comp.getName());
        comp.setPreferredSize(new Dimension(150, 23));
        fieldEditorPanel.add(label, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5,
          0, 5, 5), 0, 0));
        fieldEditorPanel.add(comp, new GridBagConstraints(col + 1, row, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
          new Insets(5, 0, 5, 5), 0, 0));
        if (col == colCount * 2 - 2) {
          row++;
          col = 0;
        } else {
          col += 2;
        }
      }
    }
  }

  protected String getLabelText(AbstractFieldEditor comp) {
    StringBuffer buff = new StringBuffer();
    buff.append("<html><a>&nbsp;");
    buff.append(comp.getName());
    if (comp.getMaxContentSize() <= 0) {
      buff.append("</a></html>");
    } else {
      if (comp.getOccRow() >= 2) {
        buff.append("<br>(");
      } else {
        buff.append("(");
      }
      buff.append(comp.getMaxContentSize());
      buff.append("����)</a></html>");
    }
    return buff.toString();
  }

  /**
   * 
   * @param zcBaseBill
   * @param compoId
   * Administrator
   * 2010-5-12
   */
  protected void initFieldEditorPanel(BaseBill zcBaseBill, String compoId) {
    BillElementMeta eleMeta = BillElementMeta.getBillElementMetaWithoutNd(compoId);
    this.initFieldEditorPanel(zcBaseBill.getClass(), eleMeta);
  }

  protected void initFieldEditorPanel(Class billClass, BillElementMeta eleMeta) {
    fieldEditors = createFieldEditors();
    int row = 0;
    int col = 0;

    List<BillElement> notNullFields = eleMeta.getNotNullBillElement();
    fieldEditorPanel.setLayout(new GridBagLayout());
    for (int i = 0; i < fieldEditors.size(); i++) {
      AbstractFieldEditor comp = fieldEditors.get(i);
      if (comp.isVisible()) {
        if (comp instanceof NewLineFieldEditor) {
          row++;
          col = 0;
          continue;
        } else if (comp instanceof TextAreaFieldEditor) {
          //ת���µ�һ��
          row++;
          col = 0;
          JLabel label = new JLabel(getLabelText(comp));
          if (isNotNullField(billClass, comp.getFieldName(), notNullFields)) {
            label.setText(comp.getName() + "*");
            if (comp.getMaxContentSize() != 9999) {
              label.setText(comp.getName() + "(" + comp.getMaxContentSize() + "����)" + "*");
            }
            label.setForeground(new Color(254, 70, 1));
            label.setFont(new Font("����", Font.BOLD, 12));
          }
          comp.setPreferredSize(new Dimension(150, comp.getOccRow() * 26));
          fieldEditorPanel.add(label, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(
            4, 0, 4, 4), 0, 0));
          fieldEditorPanel.add(comp, new GridBagConstraints(col + 1, row, comp.getOccCol(), comp.getOccRow(), 1.0, 1.0, GridBagConstraints.WEST,
            GridBagConstraints.HORIZONTAL, new Insets(4, 0, 4, 4), 0, 0));
          //����ǰ��ռ���пռ�ƫ����������
          row += comp.getOccRow();
          col = 0;
          continue;
        }
        JLabel label = new JLabel(comp.getName());
        if (isNotNullField(billClass, comp.getFieldName(), notNullFields)) {
          //label = new AsteriskLabel(comp.getName() + "*");
          //label.setText("<html><a>" + comp.getName() + "<font color='red'>*</font></a></html>");
          label.setText(comp.getName() + "*");
          label.setForeground(new Color(254, 70, 1));
          label.setFont(new Font("����", Font.BOLD, 12));
        }
        comp.setPreferredSize(new Dimension(150, 23));
        fieldEditorPanel.add(label, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5,
          0, 5, 5), 0, 0));
        fieldEditorPanel.add(comp, new GridBagConstraints(col + 1, row, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
          new Insets(5, 0, 5, 5), 0, 0));
        if (col == colCount * 2 - 2) {
          row++;
          col = 0;
        } else {
          col += 2;
        }
      }
    }
  }

  private boolean isNotNullField(Class billClass, String fieldName, List<BillElement> notNullFields) {
    for (BillElement billElement : notNullFields) {
      String name = null;
      try {
        name = (String) FieldMapRegister.get(billClass).get(billElement.getElementCode());
        if (name == null || "".equals(name.trim())) {
          name = ZcUtil.convertColumnToField(billElement.getElementCode());
        }
      } catch (RuntimeException e) {
        name = ZcUtil.convertColumnToField(billElement.getElementCode());
      }
      if (name.equalsIgnoreCase(fieldName))
        return true;
    }
    return false;
  }

  protected boolean validateData(BaseBill currentModel, String compoId) {
    BillElementMeta eleMeta = BillElementMeta.getBillElementMetaWithoutNd(compoId);
    List<BillElement> notNullFields = eleMeta.getNotNullBillElement();
    String str = ZcUtil.validateBillElementNull(currentModel, notNullFields);
    if (str != null && str.trim().length() > 0) {
      JOptionPane.showMessageDialog(this, str, "��ʾ", JOptionPane.INFORMATION_MESSAGE);
      return false;
    }
    return true;
  }

  public Object getEditingObject() {
    return editingObject;
  }

  public void setEditingObject(WfAware editingObject) {
    this.editingObject = editingObject;
    updateFieldEditors();
  }

  protected void updateFieldEditors() {
    for (AbstractFieldEditor editor : fieldEditors) {
      editor.setEditObject(editingObject);
    }
  }

  protected Map wfCanEditFieldMap;

  private boolean isEdit;

  protected void updateWFEditorEditable(WfAware baseBill, RequestMeta requestMeta) {
    Long processInstId = baseBill.getProcessInstId();
    isEdit = false;
    if (processInstId != null && processInstId.longValue() > 0) {
      // �������ĵ���
      wfCanEditFieldMap = BillElementMeta.getWfCanEditField(baseBill, requestMeta);
      for (AbstractFieldEditor editor : fieldEditors) {
        //�������ж���ɱ༭���ֶ�
        if (wfCanEditFieldMap != null && wfCanEditFieldMap.containsKey(Utils.getDBColNameByFieldName(editor.getEditObject(), editor.getFieldName()))) {
          isEdit = true;
          editor.setEnabled(true);
        } else {
          editor.setEnabled(false);
        }
      }
      // �ӱ������
      updateWFSubTableEditable();
    }
  }

  protected void setWFSubTableEditable(JTablePanel tablePanel, boolean isEnabled) {
    BeanTableModel tablemodel = (BeanTableModel) tablePanel.getTable().getModel();
    tablemodel.setEditable(isEnabled);
    Component[] components = tablePanel.getComponents();
    for (Component component : components) {
      if (component instanceof JFuncToolBar) {
        component.setEnabled(isEnabled);
      }
    }
  }

  protected JTablePanel[] getSubTables() {
    return null;
  }

  protected void fitTable() {
    JTablePanel[] tablePanel = this.getSubTables();
    if (tablePanel != null) {
      for (int i = 0; i < tablePanel.length; i++) {
        final JPageableFixedTable table = tablePanel[i].getTable();
        tablePanel[i].getScrollPane().getHorizontalScrollBar().setValue(0);
        tablePanel[i].getScrollPane().getVerticalScrollBar().setValue(0);
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            try {
              fitColumnWidth(table);
            } catch (Exception e) {
            }
          }
        });
      }
    }
  }

  protected void updateFieldEditorsEditable() {

  }

  protected void updateWFSubTableEditable() {
    // Ĭ�ϵķ������ж�isEdit���ԣ��������Ƿ���ڿɱ༭�ֶΣ�,��������д��ڿɱ༭�ֶΣ������ôӱ��ֶζ��ɱ༭.
    // �������߼����㲻��ҵ�񣬿�����ʵ�����︲��updateWFSubTableEditable�������Լ����ж�.
    if (getSubTables() != null) {
      if (isEdit) {
        for (JTablePanel tablePanel : getSubTables()) {
          setWFSubTableEditable(tablePanel, true);
        }
      } else {
        for (JTablePanel tablePanel : getSubTables()) {
          setWFSubTableEditable(tablePanel, false);
        }
      }
    }
  }

  protected void setButtonStatus(WfAware baseBill, RequestMeta requestMeta, ListCursor listCursor) {
    Long processInstId = baseBill.getProcessInstId();
    if (processInstId == null || processInstId.longValue() < 0) {
      // ��������,�ݸ嵥�ݻ򲻹ҽӹ������ĵ���
      Component[] funcs = toolBar.getComponents();
      String funcId;
      for (Component func : funcs) {
        funcId = ((FuncButton) func).getFuncId();
        if ("fauditfinal" == funcId || "fcallback" == funcId || "fautocommit" == funcId || "funaudit" == funcId || "funtread" == funcId
          || "fshowinstancetrace" == funcId || "f_uncollectcreate" == funcId || "fnew" == funcId || "fconfirmsup" == funcId
          || "fmanualcommit" == funcId || funcId != null && funcId.startsWith("fmanualcommit")) {
          func.setVisible(false);
        }

      }
    } else {
      // �����Ѿ�����
      List enableFuncs = this.getWFNodeEnableFunc(baseBill, requestMeta);
      ZcUtil.setWfNodeEnableFunc(toolBar, enableFuncs, processInstId, requestMeta);
    }
    if (listCursor == null || listCursor.getDataList() == null || listCursor.getDataList().size() <= 1) {
      // ���listCursor��ֻ��һ����¼����������һ����һ����ť
      FuncButton previousButton = toolBar.getButtonByDefaultText("��һ��");
      FuncButton nextButton = toolBar.getButtonByDefaultText("��һ��");
      if (previousButton != null) {
        previousButton.setVisible(false);
      }
      if (nextButton != null) {
        nextButton.setVisible(false);
      }
    }
  }

  protected List getWFNodeEnableFunc(WfAware baseBill, RequestMeta requestMeta) {
    return BillElementMeta.getWfNodeEnableFunc(baseBill, requestMeta);
  }

  protected void fitColumnWidth(JPageableFixedTable table) {
    for (int j = 0; j < table.getColumnModel().getColumnCount(); j++) {
      table.getTableHeader().fitColumnWidth(j);
    }
  }

  /*
   * �ӱ������з���
   */
  protected int addSub(JTablePanel tablePanel, Serializable bean) {
    tablePanel.getTable().clearSelection();
    if (tablePanel.getTable().isEditing()) {
      tablePanel.getTable().getCellEditor().stopCellEditing();
    }
    BeanTableModel editTableModel = (BeanTableModel) tablePanel.getTable().getModel();
    editTableModel.insertRow(editTableModel.getRowCount(), bean);
    fitColumnWidth(tablePanel.getTable());
    return editTableModel.getRowCount() - 1;
  }

  /*
   * �ӱ�Ĳ����з���
   */
  protected int insertSub(JTablePanel tablePanel, Serializable bean) {
    if (tablePanel.getTable().isEditing()) {
      tablePanel.getTable().getCellEditor().stopCellEditing();
    }
    BeanTableModel editTableModel = (BeanTableModel) tablePanel.getTable().getModel();
    int selectedRow = tablePanel.getTable().getSelectedRow();
    if (selectedRow != -1) {
      editTableModel.insertRow(selectedRow + 1, bean);
      selectedRow = selectedRow + 1;
    } else {
      editTableModel.insertRow(editTableModel.getRowCount(), bean);
      selectedRow = editTableModel.getRowCount() - 1;
    }
    fitColumnWidth(tablePanel.getTable());
    return selectedRow;
  }

  /*
   * �ӱ��ɾ���з���
   */
  protected Integer[] deleteSub(JTablePanel tablePanel) {
    JPageableFixedTable table = tablePanel.getTable();
    Integer[] checkedRows;
    // �Ƿ���ʾ��ѡ���
    if (tablePanel.getTable().isShowCheckedColumn()) {
      checkedRows = table.getCheckedRows();
    } else {
      int[] selectedRows = table.getSelectedRows();
      checkedRows = new Integer[selectedRows.length];
      for (int i = 0; i < checkedRows.length; i++) {
        checkedRows[i] = selectedRows[i];
      }
    }

    if (checkedRows.length == 0) {
      JOptionPane.showMessageDialog(this, "û��ѡ�����ݣ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
    } else {
      if (table.isEditing()) {
        table.getCellEditor().stopCellEditing();
      }

      BeanTableModel tableModel = (BeanTableModel) table.getModel();

      int[] selRows = new int[checkedRows.length];

      for (int i = 0; i < selRows.length; i++) {
        selRows[i] = table.convertRowIndexToModel(checkedRows[i]);
      }
      Arrays.sort(selRows);
      for (int i = selRows.length - 1; i >= 0; i--) {
        tableModel.deleteRow(selRows[i]);
      }
    }
    fitColumnWidth(tablePanel.getTable());
    return checkedRows;
  }
}