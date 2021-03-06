package com.ufgov.gk.client.component.element;

import java.util.ArrayList;
import java.util.List;

import com.ufgov.gk.client.common.BillElementMeta;
import com.ufgov.smartclient.component.JComboBoxEx;
import java.util.concurrent.CountDownLatch;

public abstract class EditCtrlComboBox extends JComboBoxEx {
  private CountDownLatch latch = new CountDownLatch(1);

  protected List dataBufferList = new ArrayList();

  protected List numLimDataList = new ArrayList();

  protected String compoId;

  protected String prefix = "";

  protected boolean randomEdit = true;

  protected boolean levelCtrl = false;

  protected int ctrlLevelNum;

  protected String elementCode;

  public void setBillElementMeta(BillElementMeta bem) {
    if (elementCode != null && !elementCode.trim().equals("") && bem != null) {
      setRandomEdit(bem.isElementRandomEdit(elementCode));
      setCtrlLevelNum(bem.getCtrlLevelNum(elementCode));
      setEnabled(bem.isElementEditable(elementCode));
    }
  }

  public int getCtrlLevelNum() {
    return ctrlLevelNum;
  }

  public void setCtrlLevelNum(int ctrlLevelNum) {
    this.ctrlLevelNum = ctrlLevelNum;
    if (ctrlLevelNum > 0) {
      levelCtrl = true;
    } else {
      levelCtrl = false;
    }
  }

  public boolean isLevelCtrl() {
    return levelCtrl;
  }

  public void setLevelCtrl(boolean levelCtrl) {
    this.levelCtrl = levelCtrl;
  }

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public boolean isRandomEdit() {
    return randomEdit;
  }

  public void setRandomEdit(boolean randomEdit) {
    this.randomEdit = randomEdit;
  }

  public CountDownLatch getLatch() {
    return latch;
  }

  public void setLatch(CountDownLatch latch) {
    this.latch = latch;
  }

  public abstract void initComboBox();

}
