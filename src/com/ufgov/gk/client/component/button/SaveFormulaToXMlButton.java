package com.ufgov.gk.client.component.button;

public class SaveFormulaToXMlButton extends FuncButton{
  private static final long serialVersionUID = -2564446291342163428L;

  public SaveFormulaToXMlButton() {
    super();
  }

  protected void init() {
    this.funcId = "fsaveFormulaToXml";
    this.defaultText = "�����������";
    this.iconName="save.jpg";
    super.init();
  }
}
