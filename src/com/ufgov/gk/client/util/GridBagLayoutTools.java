package com.ufgov.gk.client.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ufgov.gk.client.common.BillElementMeta;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.NewLineFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.TextAreaFieldEditor;
import com.ufgov.gk.common.commonbiz.fieldmap.FieldMapRegister;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.commonbiz.model.BillElement;

public class GridBagLayoutTools {
  private int colCount = 3;

  private List<AbstractFieldEditor> fieldEditorList = null;

  private Object currEditingObject = null;

  private Object oldObject = null;

  public void layoutFieldEditorPanel(JPanel edPanel) {
    int row = 0;
    int col = 0;

    edPanel.setLayout(new GridBagLayout());
    for (int i = 0; i < fieldEditorList.size(); i++) {
      AbstractFieldEditor comp = (AbstractFieldEditor) fieldEditorList.get(i);
      if (comp instanceof NewLineFieldEditor) {
        row++;
        col = 0;
      } else if (comp.isVisible() && !(comp instanceof TextAreaFieldEditor)) {
        JLabel label = new JLabel(comp.getName());
        comp.setPreferredSize(new Dimension(150, comp.getOccRow() * 26));
        edPanel.add(label, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5),
          0, 0));
        edPanel.add(comp, new GridBagConstraints(col + 1, row, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5,
          0, 5, 5), 0, 0));
        if (col == colCount * 2 - 2) {
          row++;
          col = 0;
        } else {
          col += 2;
        }
      } else if (comp.isVisible() && comp instanceof TextAreaFieldEditor) {
        //转到新的一行
        row++;
        col = 0;
        String labelText = getLabelText(comp);
        JLabel label = new JLabel(labelText);
        comp.setPreferredSize(new Dimension(150, comp.getOccRow() * 26));
        edPanel.add(label, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(4, 0, 4, 4),
          0, 0));
        edPanel.add(comp, new GridBagConstraints(col + 1, row, comp.getOccCol(), comp.getOccRow(), 1.0, 1.0, GridBagConstraints.WEST,
          GridBagConstraints.HORIZONTAL, new Insets(4, 0, 4, 4), 0, 0));
        //将当前所占的行空间偏移量计算上
        row += comp.getOccRow();
        col = 0;
      }
    }
  }

  private String getLabelText(AbstractFieldEditor comp) {
    StringBuffer buff = new StringBuffer();
    buff.append("<html><a>&nbsp;");
    buff.append(comp.getName());
    if (comp.getMaxContentSize() == 0) {
      buff.append("</a></html>");
    } else {
      buff.append("<br>(");
      buff.append(comp.getMaxContentSize());
      buff.append("字内)</a></html>");
    }
    return buff.toString();
  }

  public void layoutFieldEditorPanel(JPanel edPanel, BaseBill model, String compoId) {
    int row = 0;
    int col = 0;
    BillElementMeta eleMeta = BillElementMeta.getBillElementMetaWithoutNd(compoId);
    Class billClass = model.getClass();
    List<BillElement> notNullFields = eleMeta.getNotNullBillElement();

    edPanel.setLayout(new GridBagLayout());
    for (int i = 0; i < fieldEditorList.size(); i++) {
      AbstractFieldEditor comp = (AbstractFieldEditor) fieldEditorList.get(i);
      if (comp instanceof NewLineFieldEditor) {
        row++;
        col = 0;
      } else if (comp.isVisible() && !(comp instanceof TextAreaFieldEditor)) {
        JLabel label = new JLabel(comp.getName());
        if (isNotNullField(billClass, comp.getFieldName(), notNullFields)) {
          label = new JLabel();//new AsteriskLabel(comp.getName() + "*");
          label.setText(comp.getName() + "*");
          label.setForeground(new Color(254, 70, 1));
          label.setFont(new Font("宋体", Font.BOLD, 12));
        }
        comp.setPreferredSize(new Dimension(140, comp.getOccRow() * 26));
        edPanel.add(label, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5),
          0, 0));

        edPanel.add(comp, new GridBagConstraints(col + 1, row, 1 * comp.getOccCol(), 1, 1.0, 1.0, GridBagConstraints.WEST,
          GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 5), 0, 0));
        if (col == colCount * 2 - 2) {
          row++;
          col = 0;
        } else {
          col += 2;
        }
        if (comp.getOccCol() > 1) {
          col += comp.getOccCol() - 1;
        }
      } else if (comp.isVisible() && comp instanceof TextAreaFieldEditor) {
        //转到新的一行
        row++;
        col = 0;
        String labelText = getLabelText(comp);
        JLabel label = new JLabel(labelText);
        if (isNotNullField(billClass, comp.getFieldName(), notNullFields)) {
          String text = comp.getName();
          if (comp.getMaxContentSize() > 0) {
            text = comp.getName() + "\n(" + comp.getMaxContentSize() + "字内)" + "*";
          }
          label = new JLabel(text);//new AsteriskLabel(text);
          //label.setText(comp.getName() + "*");
          label.setForeground(new Color(254, 70, 1));
          label.setFont(new Font("宋体", Font.BOLD, 12));
        }
        comp.setPreferredSize(new Dimension(150, comp.getOccRow() * 26));
        edPanel.add(label, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(4, 0, 4, 4),
          0, 0));
        edPanel.add(comp, new GridBagConstraints(col + 1, row, comp.getOccCol(), comp.getOccRow(), 1.0, 1.0, GridBagConstraints.WEST,
          GridBagConstraints.HORIZONTAL, new Insets(4, 0, 4, 4), 0, 0));
        //将当前所占的行空间偏移量计算上
        row += comp.getOccRow();
        col = 0;
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

  public void setCurrEditingObject(Object currEditingObject) {
    this.currEditingObject = currEditingObject;
    updateFieldEditors();
  }

  protected void updateFieldEditors() {
    for (AbstractFieldEditor editor : fieldEditorList) {
      editor.setEditObject(currEditingObject);
    }
  }

  public int getColCount() {
    return colCount;
  }

  public void setColCount(int colCount) {
    this.colCount = colCount;
  }

  public List<AbstractFieldEditor> getFieldEditorList() {
    return fieldEditorList;
  }

  public void setFieldEditorList(List<AbstractFieldEditor> fieldEditorList) {
    this.fieldEditorList = fieldEditorList;
  }

  public Object getOldObject() {
    return oldObject;
  }

  public void setOldObject(Object oldObject) {
    this.oldObject = oldObject;
  }

  public Object getCurrEditingObject() {
    return currEditingObject;
  }
}
