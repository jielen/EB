package com.ufgov.gk.client.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;

import com.ufgov.gk.client.common.UIConstants;

public class DefaultProgressBar extends JWindow {
  private static final long serialVersionUID = -4506756112542009980L;

  private JProgressBar progressbar;

  private JLabel label;

  private Timer timer;

  private Timer timer2;

  private Timer timer3;

  private Window owner;

  public DefaultProgressBar(Window owner) {
    this.owner = owner;
    initComponents();
  }

  private void initComponents() {

    Container contentPane = this.getContentPane();

    label = new JLabel(" ", JLabel.CENTER);
    progressbar = new JProgressBar();
    progressbar.setOrientation(JProgressBar.HORIZONTAL);
    progressbar.setMinimum(0);
    progressbar.setMaximum(100);
    progressbar.setValue(5);
    //    progressbar.setForeground(Color.red);
    progressbar.setBackground(Color.GREEN);
    progressbar.setStringPainted(true);
    //    progressbar.addChangeListener(new ChangeListener() {
    //      public void stateChanged(ChangeEvent e) {
    //        int value = progressbar.getValue();
    //        label.setText("目前已完成：" + Integer.toString(value) + " %");
    //      }
    //    });

    timer = new Timer(100, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int value = progressbar.getValue();
        if (value < 35) {
          value++;
          progressbar.setValue(value);
        } else {
          timer.stop();
          timer2.start();
        }
      }
    });
    timer2 = new Timer(1000, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int value = progressbar.getValue();
        if (value < 65) {
          value++;
          progressbar.setValue(value);
        } else {
          timer2.stop();
          timer3.start();
        }
      }
    });
    timer3 = new Timer(2000, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int value = progressbar.getValue();
        if (value < 95) {
          value++;
          progressbar.setValue(value);
        } else {
          timer3.stop();
        }
      }
    });

    contentPane.add(progressbar, BorderLayout.CENTER);
    //    contentPane.add(label, BorderLayout.SOUTH);

    this.setSize((int) (UIConstants.SCREEN_WIDTH * 0.38),
      (int) (UIConstants.SCREEN_WIDTH * 0.022));
    this.setLocationRelativeTo(owner);
    this.setAlwaysOnTop(true);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        dispose();
      }
    });

  }

  public void start() {
    this.setVisible(true);

    timer.start();
  }

  public void end() {
    timer.stop();
    timer2.stop();
    timer3.stop();
    progressbar.setValue(100);
    try {
      Thread.sleep(30);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    this.dispose();
  }
}
