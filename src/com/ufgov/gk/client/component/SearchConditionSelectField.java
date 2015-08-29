package com.ufgov.gk.client.component;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ufgov.gk.common.commonbiz.model.SearchCondition;

public class SearchConditionSelectField extends JButtonTextField {

  private static final long serialVersionUID = -4615301973947335637L;

  private String type;

  public SearchConditionSelectField(int col,String type) {
    super(col);
    this.type = type;
    this.initGUI();
  }

  public SearchConditionSelectField(int col,Dialog owner,String type) {
    super(col);
    this.owner=owner;
    this.type = type;
    this.initGUI();
  }

  private void initGUI() {
    this.selectDialog = new SearchConditionSelectDialog(owner, true, this,type);
  }


  public void setSearchCondition(SearchCondition value) {
    this.setValue(value);
  }

  public SearchCondition getSearchCondition() {
    return (SearchCondition) this.getValue();
  }

  @Override
  public void setValue(Object value) {
    this.value = value;
    if (value != null) {
      SearchCondition data = (SearchCondition) value;
      this.setText(data.getConditionName());
      this.setToolTipText("[" + data.getConditionId() + "]" + data.getConditionName());
    } else {
      this.setText("");
      this.setToolTipText(null);
    }
    this.fireValueChanged();

  }

  @Override
  public void handleClick(JButtonTextField buttonTextField) {
    this.selectDialog.setVisible(true);
  }

  public static void main(String[] args) {

    JFrame f = new JFrame();
    SearchConditionSelectField textField = new SearchConditionSelectField(20,"condition");

    textField.setEditable(false);
    textField.setEnabled(false);
    textField.setEnabled(true);
    JPanel panel = new JPanel();
    panel.add(textField);
    f.getContentPane().add(panel, BorderLayout.NORTH);
    // f.pack();
    // SwingUtilities.updateComponentTreeUI(panel);
    f.setSize(400, 300);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
    f.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}
