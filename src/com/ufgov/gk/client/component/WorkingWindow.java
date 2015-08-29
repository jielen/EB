package com.ufgov.gk.client.component;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class WorkingWindow extends JWindow {
  /**
   * 
   */
  private static final long serialVersionUID = 1743855194240540203L;

  private JProgressBar progressBar;

  private int maxValue;

  public WorkingWindow(int w, int h) {
    this.getContentPane().setLayout(new BorderLayout());
    this.setSize(new Dimension(w, h));
    this.setAlwaysOnTop(true);
    progressBar = new JProgressBar();
    progressBar.setStringPainted(true);
    progressBar.setValue(0);
    this.getContentPane().add(progressBar);
  }
  
  public int getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(int maxValue) {
    this.maxValue = maxValue;
    progressBar.setMaximum(maxValue);
  }

  public void setValue(int value) {
    progressBar.setValue(value);
    if (value == maxValue) {
      this.stop();
    }
  }

  public void start() {
    progressBar.setValue(0);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
  }

  public void stop() {
    this.dispose();
  }

}
