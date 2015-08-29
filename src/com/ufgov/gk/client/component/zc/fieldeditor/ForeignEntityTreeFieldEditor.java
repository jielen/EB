/**
 * ForeignEntityTreeFieldEditor.java
 * com.ufgov.gk.client.component.zc.fieldeditor
 * Administrator
 * 2010-5-7
 */
package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.ufgov.gk.client.component.IForeignEntityTreeHandler;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.model.TreeNodeValueObject;
import com.ufgov.gk.common.system.util.BeanUtil;
import com.ufgov.smartclient.plaf.BlueLookAndFeel;

/**
 * @author Administrator
 *
 */
public class ForeignEntityTreeFieldEditor extends AbstractFieldEditor {

  private ForeignEntityTreeField field;

  private int col;

  private String name;

  public ForeignEntityTreeFieldEditor(String sqlMapSelectedId, int col, IForeignEntityTreeHandler handler, String title, String fieldName) {
    super(title, sqlMapSelectedId, handler);
    this.name = title;
    this.sqlMapSelectedId = sqlMapSelectedId;
    this.fieldName = fieldName;
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor#createEditorComponent()
   */
  @Override
  protected JComponent createEditorComponent() {
    // TODO Auto-generated method stub
    //  System.out.println("createEditorComponent "+this.sqlMapSelectedId);
    this.field = new ForeignEntityTreeField(this.sqlMapSelectedId, this.col, this.treeHandler, this.dialogTitle);
    field.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        syncEditObject();
      }
    });
    return this.field;
  }

  protected void syncEditObject() {
    if (getEditObject() != null) {
      BeanUtil.set(fieldName, field.getText(), getEditObject());
    }
    this.fireEditSynced();
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor#getValue()
   */
  @Override
  public Object getValue() {
    // TODO Auto-generated method stub
    return this.field.getText();
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor#setValue(java.lang.Object)
   */
  @Override
  public void setValue(Object value) {
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

  /**
   * @param args
   * Administrator
   * 2010-5-6
   */
  public static void main(String[] args) {

    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
          UIManager.setLookAndFeel(new BlueLookAndFeel());
        } catch (Exception e) {
          e.printStackTrace();
        }
        class TreeHandler implements IForeignEntityTreeHandler {

          @Override
          public void excute(List selectedDatas) {
            // TODO Auto-generated method stub
            for (Object obj : selectedDatas) {
              TreeNodeValueObject td = (TreeNodeValueObject) obj;
              System.out.println(td.getCode() + "\t" + td.getName());
            }
          }

          @Override
          public boolean isMultipleSelect() {
            // TODO Auto-generated method stub
            return false;
          }

          @Override
          public boolean isSelectLeaf() {
            // TODO Auto-generated method stub
            return true;
          }

        }
        //        UIManager.getDefaults().put("SplitPaneUI", BigButtonSplitPaneUI.class.getName());
        ForeignEntityTreeFieldEditor textField = new ForeignEntityTreeFieldEditor("ZcBCatalogue.getZcBCatalogue", 20, new TreeHandler(), "ƷĿѡ��",
          "name");

        JPanel panel = new JPanel();
        textField.setPreferredSize(new Dimension(150, 23));
        panel.add(textField);
        JFrame frame = new JFrame("ForeignEntityTreeFieldEditor test Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.setVisible(true);
      }
    });
  }
}
