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
 * 说明：GridBagLayout只有一个无参的构造器，要使用它就必须用setConstraints(Component comp,GridBagConstraints constraints)将它和GridBagConstraints关联起来！当GridBagLayout与无参的GridBagConstraints关联时，此时它就相当于一个GridLayout，只不过，用GridLayout布局的组件会随着窗口的变 大（小）而变 大（小）。但GridBagLayout 不会，因此，这就是我们使用GridBagConstants来设置各个约束条件的目的！


      查看API文档，我们就知道GridBagConstraints有十一个属性！自我感觉API文档里面有些东西讲得不是很好理解，就象gridx 与 gridy 这两个属性一样，有些书上说gridx表示行，gridy表示列！API文档里面更是讲了一大堆。
     现在，提供本人对这些属性的理解：

   1，   gridx： 表示组件的左边缘与网格左部之间的距离，如果学过HTML的话，那么gridx就 相当于HTML 里面的leftmargin属性。

   2，   gridy:   表示组件的上边缘与网格顶部之间的距离，相当于HTML里面的topmargin属性！
  
   3,    ipadx:   表示组件在默认的大小上，往水平方向上再加上多少像素的大小！
  
   4，   ipady:   表示组件在默认的大小上，往垂直方向上再加上多少像素的大小！

   5,     fill:   当组件没有空间大时。它可以确定是否填充空间!

   6,   anchor:   当组件没有空间大时。它可以确定在显示区域中放置组件的位置！

   7， insets:   设置组件之间彼此的间距，它有四个参数，分别是上，左，下，右，

默认值为(0,0,0,0)  

            
   8，weightx:   用来设置当窗口变大时，各组件沿水平方向跟着变大的比例，数字越大，表示组件能得到的空间越大

   9，weighty:   用来设置当窗口变大时，各组件沿垂直方向跟着变大的比例，数字越大，表示组件能得                  到的空间越大

10，gridwidth   用来设置组件所占的单位长度，默认值为1。

11，gridheight 用来设置组件所占的单位高度，默认值为1。  


   对gridwidth与gridheight做了修改后，必须记得要对fill属性做相应的修改，否则组件所显示的大小     还是原来的大小。
  
===========================================================================================
      建议：运用GridBagLayout这种布局方式时，比较适合于把所有的组件围成一个四边形。所以，我们在设计这种布局方式前，可以先在纸上画一下每个组件的大概位置，然后保证每一行的长度（即每一行的gridwidth之和）都相等，且每一列的长度(即每一列的gridheight之和)也相等，这样，就能按我们要的蓝图而得到实现！ 另外，有些属性是要跟另外一些属性搭配着用的，只有把相联系的属性都做了相应的修改，我们才能看到变化！比如说上面所说到的gridwidth与gridheight必须与fill属性联合起来用才能看到结果！

下面来个实际的例子：
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

    f.add(b1); //由于属性都有默认值，前面的按默认值来加入！
    f.add(b2);
    f.add(b3);
    //c.gridx = 2; //表示的是单元格水平方向的数目
    c.gridy = 1; //表示上面的表格数目   默认值为0  表示在第一行   垂直方向的单元格数目
    c.gridwidth = 3; //修改了gridwidth值      表示占据多少个单元格的宽度
    c.fill = GridBagConstraints.BOTH; //所以这里要做相应的修改才能按gridwidth的值来显示
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
    c.fill = GridBagConstraints.BOTH; //同上面的注释
    g.setConstraints(b7, c);
    f.add(b7);

    f.pack();
    f.setVisible(true);
  }
}
