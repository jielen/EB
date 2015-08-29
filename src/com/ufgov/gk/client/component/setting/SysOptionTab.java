package com.ufgov.gk.client.component.setting;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

public class SysOptionTab  extends OptionTab{

  private Window owner;

  public SysOptionTab(Window owner){

    this.owner=owner;
    List<AbstractOption> optionList = new ArrayList<AbstractOption>();

    AbstractOption ao= new SysSettingDefaultStyleOption();
     optionList.add(ao);

     ao= new SysUseFreeStyleDialogOption();
     optionList.add(ao);

     ao= new SysFontSizeComboBoxOption();
     optionList.add(ao);

     ao= new SysShowProgressBarThresholdOption();
     optionList.add(ao);


     ao= new LookAndFeelComboBoxOption();
     optionList.add(ao);

     ao = new SysColorPanelOption();
     optionList.add(ao);

    this.init("systemOptionTab", "����ϵͳѡ��", optionList);
  }

  @Override
  protected void doCancel() {
    owner.dispose();
  }

}
