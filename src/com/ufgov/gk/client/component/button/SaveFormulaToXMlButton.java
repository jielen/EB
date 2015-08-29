package com.ufgov.gk.client.component.button;

public class SaveFormulaToXMlButton extends FuncButton{
  private static final long serialVersionUID = -2564446291342163428L;

  public SaveFormulaToXMlButton() {
    super();
  }

  protected void init() {
    this.funcId = "fsaveFormulaToXml";
    this.defaultText = "导出评标规则";
    this.iconName="save.jpg";
    super.init();
  }
}
