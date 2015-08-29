package com.ufgov.gk.client.component;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public abstract class ConditionSettingPopupMenu extends JPopupMenuEx {

  JMenuItem defaultValueSettingMenuItem = new JMenuItem("����Ĭ��ֵ");

  JMenuItem conditionSettingMenuItem = new JMenuItem("���ò�ѯ����");

  public ConditionSettingPopupMenu(Component target) {
    super(target);

    defaultValueSettingMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        openDefaultValueDialog();
      }
    });
//    this.add(defaultValueSettingMenuItem);

    conditionSettingMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        openSearchDialog();
      }
    });
    this.add(conditionSettingMenuItem);
  }

  public abstract void openDefaultValueDialog();

  public abstract void openSearchDialog();

}
