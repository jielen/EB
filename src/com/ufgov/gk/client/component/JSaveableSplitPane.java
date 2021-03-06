package com.ufgov.gk.client.component;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

import com.ufgov.gk.client.util.UserPreferencesUtil;

public class JSaveableSplitPane extends JSplitPane {

  private String preferKey = "";

  public String getPreferKey() {
    return preferKey;
  }

  public void setPreferKey(String preferKey) {
    this.preferKey = preferKey;
  }

  public JSaveableSplitPane() {
    this(JSaveableSplitPane.HORIZONTAL_SPLIT, false, new JButton(UIManager
      .getString("SplitPane.leftButtonText")), new JButton(UIManager.getString("SplitPane.rightButtonText")));

  }

  public JSaveableSplitPane(int newOrientation) {
    this(newOrientation, false);
  }

  public JSaveableSplitPane(int newOrientation, boolean newContinuousLayout) {
    this(newOrientation, newContinuousLayout, null, null);
  }

  public JSaveableSplitPane(int newOrientation, Component newLeftComponent, Component newRightComponent) {
    this(newOrientation, false, newLeftComponent, newRightComponent);
  }

  public JSaveableSplitPane(int newOrientation, boolean newContinuousLayout, Component newLeftComponent,
    Component newRightComponent) {
    super(newOrientation, newContinuousLayout, newLeftComponent, newRightComponent);
  }

  public void setDividerLocation(int location) {
    super.setDividerLocation(location);
    if (preferKey != null && !"".equals(preferKey.trim())) {
      UserPreferencesUtil.getInstance().putInt(preferKey, location);
    }
  }

  /**
   * 设置DividerLocation默认值 使用这个函数
   * @param location
   */
  public void setDividerDefaultLocation(int location) {
    super.setDividerLocation(UserPreferencesUtil.getInstance().getInt(preferKey, location));
  }

  public void setDividerDefaultLocation(String preferKey, int location) {
    this.preferKey = preferKey;
    super.setDividerLocation(UserPreferencesUtil.getInstance().getInt(preferKey, location));
  }

  public void setDividerDefaultLocation(double proportionalLocation) {
    if (proportionalLocation < 0.0 || proportionalLocation > 1.0) {
      throw new IllegalArgumentException("proportional location must " + "be between 0.0 and 1.0.");
    }
    if (getOrientation() == VERTICAL_SPLIT) {
      setDividerLocation((int) ((double) (getHeight() - getDividerSize()) * proportionalLocation));
    } else {
      setDividerLocation((int) ((double) (getWidth() - getDividerSize()) * proportionalLocation));
    }
  }

  public void setDividerDefaultLocation(String preferKey, double proportionalLocation) {
    this.preferKey = preferKey;
    if (proportionalLocation < 0.0 || proportionalLocation > 1.0) {
      throw new IllegalArgumentException("proportional location must " + "be between 0.0 and 1.0.");
    }
    if (getOrientation() == VERTICAL_SPLIT) {
      setDividerLocation((int) ((double) (getHeight() - getDividerSize()) * proportionalLocation));
    } else {
      setDividerLocation((int) ((double) (getWidth() - getDividerSize()) * proportionalLocation));
    }
  }

}