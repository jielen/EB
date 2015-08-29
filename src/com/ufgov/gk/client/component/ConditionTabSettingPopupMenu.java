package com.ufgov.gk.client.component;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public abstract class ConditionTabSettingPopupMenu extends ConditionSettingPopupMenu {
  
  JMenuItem tabSettingMenuItem = new JMenuItem("…Ë÷√“≥«©");

  public ConditionTabSettingPopupMenu(Component target) {
    super(target);
    
    tabSettingMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        openPageDialog();
      }
    });
    this.add(tabSettingMenuItem);
  }

  public abstract void openPageDialog();

}
