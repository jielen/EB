package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;

public class BillElement implements Serializable {

  public static String GRID_RENDER = "1";

  public static String TEXTFIELD_RENDER = "2";

  public static String COMBOBOX_RENDER = "3";

  public static String TREE_RENDER = "4";

  public static String NUMFIELD_RENDER ="5";

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private String elementId;

  private int nd;

  private String billTypeCode;

  private String elementCode;

  private String elementName;

  private String include;

  private String inherit;

  private String edit;

  private String decFlag;

  private String randomEdit;

  private int levelCtrl;

  private String levelStr;

  private String nullable;

  private String renderType;

  private int displayOrderIndex;

  private int parentLevelCtrl;


  public int getParentLevelCtrl() {
    return parentLevelCtrl;
  }

  public void setParentLevelCtrl(int parentLevelCtrl) {
    this.parentLevelCtrl = parentLevelCtrl;
  }

  public String getElementId() {
    return elementId;
  }

  public void setElementId(String elementId) {
    this.elementId = elementId;
  }

  public int getNd() {
    return nd;
  }

  public void setNd(int nd) {
    this.nd = nd;
  }

  public String getBillTypeCode() {
    return billTypeCode;
  }

  public void setBillTypeCode(String billTypeCode) {
    this.billTypeCode = billTypeCode;
  }

  public String getElementCode() {
    return elementCode;
  }

  public void setElementCode(String elementCode) {
    this.elementCode = elementCode;
  }

  public String getElementName() {
    return elementName;
  }

  public void setElementName(String elementName) {
    this.elementName = elementName;
  }

  public String getInclude() {
    return include;
  }

  public void setInclude(String include) {
    this.include = include;
  }

  public String getInherit() {
    return inherit;
  }

  public void setInherit(String inherit) {
    this.inherit = inherit;
  }

  public String getEdit() {
    return edit;
  }

  public void setEdit(String edit) {
    this.edit = edit;
  }

  public String getDecFlag() {
    return decFlag;
  }

  public void setDecFlag(String decFlag) {
    this.decFlag = decFlag;
  }

  public String getRandomEdit() {
    return randomEdit;
  }

  public void setRandomEdit(String randomEdit) {
    this.randomEdit = randomEdit;
  }

  public String getNullable() {
    return nullable;
  }

  public void setNullable(String nullable) {
    this.nullable = nullable;
  }

  public String getRenderType() {
    return renderType;
  }

  public void setRenderType(String renderType) {
    this.renderType = renderType;
  }

  public int getLevelCtrl() {
    return levelCtrl;
  }

  public void setLevelCtrl(int levelCtrl) {
    this.levelCtrl = levelCtrl;
  }

  public String getLevelStr() {
    return levelStr;
  }

  public void setLevelStr(String levelStr) {
    this.levelStr = levelStr;
  }

  public int getDisplayOrderIndex() {
    return displayOrderIndex;
  }

  public void setDisplayOrderIndex(int displayOrderIndex) {
    this.displayOrderIndex = displayOrderIndex;
  }


}
