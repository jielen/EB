/**
 * TestGridBagLayOut.java
 * com.eb.client.component.test
 * Administrator
 * Jul 19, 2012
 */
package com.eb.client.component.test;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * ˵����GridBagLayoutֻ��һ���޲εĹ�������Ҫʹ�����ͱ�����setConstraints(Component comp,GridBagConstraints constraints)������GridBagConstraints������������GridBagLayout���޲ε�GridBagConstraints����ʱ����ʱ�����൱��һ��GridLayout��ֻ��������GridLayout���ֵ���������Ŵ��ڵı� ��С������ ��С������GridBagLayout ���ᣬ��ˣ����������ʹ��GridBagConstants�����ø���Լ��������Ŀ�ģ�


      �鿴API�ĵ������Ǿ�֪��GridBagConstraints��ʮһ�����ԣ����Ҹо�API�ĵ�������Щ�������ò��Ǻܺ���⣬����gridx �� gridy ����������һ������Щ����˵gridx��ʾ�У�gridy��ʾ�У�API�ĵ�������ǽ���һ��ѡ�
     ���ڣ��ṩ���˶���Щ���Ե���⣺

   1��   gridx�� ��ʾ��������Ե��������֮��ľ��룬���ѧ��HTML�Ļ�����ôgridx�� �൱��HTML �����leftmargin���ԡ�

   2��   gridy:   ��ʾ������ϱ�Ե�����񶥲�֮��ľ��룬�൱��HTML�����topmargin���ԣ�
  
   3,    ipadx:   ��ʾ�����Ĭ�ϵĴ�С�ϣ���ˮƽ�������ټ��϶������صĴ�С��
  
   4��   ipady:   ��ʾ�����Ĭ�ϵĴ�С�ϣ�����ֱ�������ټ��϶������صĴ�С��

   5,     fill:   �����û�пռ��ʱ��������ȷ���Ƿ����ռ�!

   6,   anchor:   �����û�пռ��ʱ��������ȷ������ʾ�����з��������λ�ã�

   7�� insets:   �������֮��˴˵ļ�࣬�����ĸ��������ֱ����ϣ����£��ң�

Ĭ��ֵΪ(0,0,0,0)  

            
   8��weightx:   �������õ����ڱ��ʱ���������ˮƽ������ű��ı���������Խ�󣬱�ʾ����ܵõ��Ŀռ�Խ��

   9��weighty:   �������õ����ڱ��ʱ��������ش�ֱ������ű��ı���������Խ�󣬱�ʾ����ܵ�                  ���Ŀռ�Խ��

10��gridwidth   �������������ռ�ĵ�λ���ȣ�Ĭ��ֵΪ1��

11��gridheight �������������ռ�ĵ�λ�߶ȣ�Ĭ��ֵΪ1��  


   ��gridwidth��gridheight�����޸ĺ󣬱���ǵ�Ҫ��fill��������Ӧ���޸ģ������������ʾ�Ĵ�С     ����ԭ���Ĵ�С��
  
===========================================================================================
      ���飺����GridBagLayout���ֲ��ַ�ʽʱ���Ƚ��ʺ��ڰ����е����Χ��һ���ı��Ρ����ԣ�������������ֲ��ַ�ʽǰ����������ֽ�ϻ�һ��ÿ������Ĵ��λ�ã�Ȼ��֤ÿһ�еĳ��ȣ���ÿһ�е�gridwidth֮�ͣ�����ȣ���ÿһ�еĳ���(��ÿһ�е�gridheight֮��)Ҳ��ȣ����������ܰ�����Ҫ����ͼ���õ�ʵ�֣� ���⣬��Щ������Ҫ������һЩ���Դ������õģ�ֻ�а�����ϵ�����Զ�������Ӧ���޸ģ����ǲ��ܿ����仯������˵������˵����gridwidth��gridheight������fill�������������ò��ܿ��������

��������ʵ�ʵ����ӣ�
 * @author Administrator
 *
 */
public class TestGridBagLayOut {

  public static void main(String[] args) {
    JFrame f = new JFrame("Test");

    JButton b1 = new JButton("Button1");
    JButton b2 = new JButton("Button2");
    JButton b3 = new JButton("Button3");
    JButton b4 = new JButton("Button4");
    JButton b5 = new JButton("Button5");
    JButton b6 = new JButton("Button6");
    JButton b7 = new JButton("Button7");

    GridBagConstraints c = new GridBagConstraints();
    GridBagLayout g = new GridBagLayout();

    f.setLayout(g);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    f.add(b1); //�������Զ���Ĭ��ֵ��ǰ��İ�Ĭ��ֵ�����룡
    f.add(b2);
    f.add(b3);
    //c.gridx = 2; //��ʾ���ǵ�Ԫ��ˮƽ�������Ŀ
    c.gridy = 1; //��ʾ����ı����Ŀ   Ĭ��ֵΪ0  ��ʾ�ڵ�һ��   ��ֱ����ĵ�Ԫ����Ŀ
    c.gridwidth = 3; //�޸���gridwidthֵ      ��ʾռ�ݶ��ٸ���Ԫ��Ŀ��
    c.fill = GridBagConstraints.BOTH; //��������Ҫ����Ӧ���޸Ĳ��ܰ�gridwidth��ֵ����ʾ
    g.setConstraints(b4, c);
    f.add(b4);

    c = new GridBagConstraints();
    c.gridy = 2;
    g.setConstraints(b5, c);
    f.add(b5);

    c = new GridBagConstraints();
    c.gridy = 3;
    g.setConstraints(b6, c);
    f.add(b6);

    c = new GridBagConstraints();
    c.gridx = 1;
    c.gridy = 2;
    c.gridwidth = 2;
    c.gridheight = 2;
    c.fill = GridBagConstraints.BOTH; //ͬ�����ע��
    g.setConstraints(b7, c);
    f.add(b7);

    f.pack();
    f.setVisible(true);
  }
}
