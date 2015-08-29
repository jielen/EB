package com.ufgov.gk.client.component.tree;

import javax.swing.tree.DefaultMutableTreeNode;

public class CheckBoxTreeNode extends DefaultMutableTreeNode {

  private static final long serialVersionUID = 3195314943599939279L;

  private boolean isChecked = false;

  public CheckBoxTreeNode(Object userObject) {
    super(userObject);
  }

  public boolean isChecked() {
    return isChecked;
  }

  public void setChecked(boolean isChecked) {
    this.isChecked = isChecked;
  }
}
