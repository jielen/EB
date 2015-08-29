package com.eb.client.component.test;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GridBagLayoutInstance extends JPanel {
  public GridBagLayoutInstance() {
    this.setLayout(new GridBagLayout());
    this.setOpaque(true);//the component should be opaque透明的。
    GridBagConstraints c = new GridBagConstraints();
    JButton b = new JButton("Button One");
    c.gridx = 0;//控件左上角坐标
    c.gridy = 0;
    c.gridwidth = 2;//所占cell个数
    c.gridheight = 1;
    this.add(b, c);//button 1 added

    c.gridy++;
    b = new JButton("Button Two");
    this.add(b, c);

    c.gridx = 2;
    c.gridy = 0;
    c.gridwidth = 1;
    c.gridheight = 2;
    b = new JButton("Button Three");
    this.add(b, c);

    c.gridx = 3;
    c.gridy = 0;
    c.gridwidth = 1;
    c.gridheight = 2;
    //c.insets.top=10;
    //c.insets.left=10;
    //c.fill=GridBagConstraints.HORIZONTAL;
    //c.anchor=GridBagConstraints.ABOVE_BASELINE;
    b = new JButton("Button Fourth");
    this.add(b, c);

    c.gridx = 0;
    c.gridy = 2;
    c.gridwidth = 4;
    c.gridheight = 1;
    this.add(new JTextField(35), c);
  }

  public static void main(String[] args) {
    JFrame f = new JFrame("GridBagLayout Instance ");
    JPanel p = new GridBagLayoutInstance();
    f.getContentPane().add(p);
    f.pack();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    //f.setSize(300,400);
    f.setVisible(true);
  }
}