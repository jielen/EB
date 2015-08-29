package com.ufgov.gk.client.component.tablelayout;


import java.awt.Insets;

public class CellConstraints {
  private int fromRowIndex;
  private int fromColumnIndex;
  private int toRowIndex;
  private int toColumnIndex;
  private Insets insets;

  public CellConstraints(int fromRowIndex, int fromColumnIndex, int toRowIndex,
    int toColumnIndex, Insets insets) {
    super();
    this.fromRowIndex = fromRowIndex;
    this.fromColumnIndex = fromColumnIndex;
    this.toRowIndex = toRowIndex;
    this.toColumnIndex = toColumnIndex;
    this.insets = insets;
  }

  public CellConstraints(int fromRowIndex, int fromColumnIndex, int toRowIndex,
    int toColumnIndex) {
    this( fromRowIndex,  fromColumnIndex,  toRowIndex,
       toColumnIndex, new Insets(0,0,0,0));
  }

  public int getFromRowIndex() {
    return fromRowIndex;
  }

  public int getFromColumnIndex() {
    return fromColumnIndex;
  }

  public int getToRowIndex() {
    return toRowIndex;
  }

  public int getToColumnIndex() {
    return toColumnIndex;
  }

  public Insets getInsets() {
    return insets;
  }

}