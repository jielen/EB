package com.eb.client.component.test.image;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class PhotoFrame extends JFrame {

  private static final long serialVersionUID = -2216276219179107707L;

  private Container con;

  private ZPanel zPanel;

  private JScrollPane imgSp;

  private PhotoFrame() {
    con = getContentPane();

    zPanel = new ZPanel();
    zPanel.setImagePath(this.getClass().getResource("/img/test/1.jpg"));
    zPanel.setPreferredSize(new Dimension(zPanel.getImgWidth(), zPanel.getImgHeight()));

    imgSp = new JScrollPane();
    imgSp.setViewportView(zPanel);
    imgSp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    imgSp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    con.add(imgSp, BorderLayout.CENTER);

    finalSetting();
  }

  private void finalSetting() {
    setTitle("ZakiSoft ZFileRenamerV0.2");

    //    System.out.println(this.getClass().)
    Image image = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/test/3.jpg"));
    setIconImage(image);

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;
    int frameH = getHeight();
    int frameW = getWidth();
    setLocation((screenWidth - frameW) / 2 - 250, (screenHeight - frameH) / 2 - 250);
    setSize(500, 350);
    setVisible(true);
    setResizable(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    new PhotoFrame();
  }

}