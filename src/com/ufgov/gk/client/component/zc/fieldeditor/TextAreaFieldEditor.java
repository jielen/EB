/**   
 * @(#) project: GK
 * @(#) file: TextAreaFieldEditor.java
 * 
 * Copyright 2010 UFGOV, Inc. All rights reserved.
 * UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 */
package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.ufgov.gk.client.component.RegexDocument;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.util.BeanUtil;

/**
 * @ClassName: TextAreaFieldEditor
 * @Description: �ı��༭��
 * @date: 2010-4-28 ����03:20:14
 * @version: V1.0
 * @since: 1.0
 * @author: fanpl
 * @modify:
 */
public class TextAreaFieldEditor extends AbstractFieldEditor {

  private JTextArea field;

  private String fieldName;

  private JPopupMenu popMenu;

  public TextAreaFieldEditor(String name, String fieldName) {
    this.fieldName = fieldName;
    init(name);
  }

  public TextAreaFieldEditor(String name, String fieldName, int maxChar, int occRow, int occCol) {
    this.fieldName = fieldName;
    this.occCol = occCol;
    this.occRow = occRow;
    if (maxChar > 0) {
      this.maxContentSize = maxChar;
    }
    init(name);
  }

  public Object getValue() {
    return field.getText();
  }

  protected JComponent createEditorComponent() {
    field = new JTextArea();
    field.setColumns(10);
    field.setBackground(Color.WHITE);
    field.setRows(this.occRow);
    RegexDocument rd = new RegexDocument();
    field.setDocument(rd);
    field.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        if (field.getText().length() > maxContentSize) {
          field.setText(field.getText().substring(0, maxContentSize));
          return;
        }
        syncEditObject();
      }
    });
    field.setLineWrap(true);
    JScrollPane js = new JScrollPane(field);
    return js;
  }

  public void setValue(Object value) { // ��ѡ���������з����ı��ʱ�����������¼�
    if (value == null) {
      field.setText(null);
      field.setToolTipText(null);
    } else if (value instanceof BaseBill) {
      String v = (String) BeanUtil.get(fieldName, value);
      field.setText(v);
      if (v == null || v.trim().equals("")) {
        field.setToolTipText(null);
      } else {
        field.setToolTipText(v);
      }
    }
  }

  protected void syncEditObject() {
    if (getEditObject() != null) {
      BeanUtil.set(fieldName, field.getText(), getEditObject());
    }
    this.fireEditSynced();
  }

  public void setEnabled(boolean enabled) {
    field.setEditable(enabled);
    field.setEnabled(enabled);
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public void initMouseMenu(List<String> list) {
    popMenu = new JPopupMenu();
    for (Iterator iterator = list.iterator(); iterator.hasNext();) {
      String string = (String) iterator.next();
      JMenuItem menu = new JMenuItem(string);
      menu.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String str = e.getActionCommand();
          //field.insert(str, field.getCaret().getDot());
          field.replaceSelection(str);
          syncEditObject();
        }
      });
      popMenu.add(menu);
    }
    this.field.add(popMenu);
    this.field.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
          //getJPopupMenuEdicion();
          if (popMenu != null) {
            popMenu.show(field, e.getX(), e.getY());
          }
        }
      }
    });
  }
}
