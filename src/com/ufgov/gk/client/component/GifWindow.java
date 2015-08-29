package com.ufgov.gk.client.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import com.ufgov.gk.client.util.GifDecoder;

public class GifWindow extends JWindow implements ActionListener {
  /**
   * 
   */
  private static final long serialVersionUID = 1743855194240540203L;

  private JPanel loadPanel;

  private JLabel label;

  private GifDecoder gifDecoder;

  private Timer timer;

  private int currentFrame = 0;

  private int totalFrame;

  private int width = 100;

  private int height = 100;

  private int delay = 100;

  public GifWindow(int w, int h, int d) {
    super();
    this.width = w;
    this.height = h;
    this.delay = d;
    this.setSize(new Dimension(w, h + 20));//h + 20
    this.getContentPane().setLayout(new BorderLayout());
    init();
  }

  public void setImageResource(InputStream input) {
    try {
      gifDecoder = new GifDecoder();
      gifDecoder.read(input);
      this.totalFrame = gifDecoder.getFrameCount();
    } catch (Exception ex) {
      throw new RuntimeException(ex.getMessage(), ex);
    }
  }

  public void setBackGround(Color color) {
    loadPanel.setBackground(color);
  }

  public void setMessage(String mess) {
    this.label.setText(mess);
  }

  public void start() {
    if (timer != null) {
      timer.start();
    }
    this.setVisible(true);
    this.setLocationRelativeTo(null);
  }

  public void stop() {
    if (timer != null) {
      timer.stop();
    }
    this.setMessage("");
    this.dispose();
  }

  public void actionPerformed(ActionEvent event) {
    loadPanel.getGraphics().drawImage(gifDecoder.getFrame(currentFrame), 0, 0, this.width, this.height,
      loadPanel);
    currentFrame++;
    currentFrame %= totalFrame;
  }

  private void init() {
    try {
      loadPanel = new JPanel();
      this.getContentPane().add(loadPanel, BorderLayout.CENTER);
      label = new JLabel();
      label.setPreferredSize(new Dimension(this.width, 20));
      label.setHorizontalTextPosition(SwingConstants.CENTER);
      label.setHorizontalAlignment(SwingConstants.CENTER);
      this.getContentPane().add(label, BorderLayout.SOUTH);
      timer = new Timer(this.delay, this);
    } catch (Exception ex) {
      throw new RuntimeException(ex.getMessage(), ex);
    }
  }

}
