package com.ufgov.gk.client.component.tree;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.tree.TreeCellRenderer;

public class CheckBoxTreeCellRenderer extends JCheckBox implements TreeCellRenderer {

  private static final long serialVersionUID = -6432020851855339311L;

  public CheckBoxTreeCellRenderer() {
    setOpaque(false);
  }

  public Component getTreeCellRendererComponent(JTree tree, Object value,
    boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
    if (value instanceof CheckBoxTreeNode) {
      CheckBoxTreeNode node = ((CheckBoxTreeNode) value); // ��ȡ���ڵ����
      setText(node.toString()); // ����CheckBox��չʾ���ı���

      // �����ڵ㱻����Ϊ��ѡʱ����ýڵ��Ӧ��CheckBox����ѡ�ϣ�����ȡ����ѡ��
      if (node.isChecked()) {
        setSelected(true);
        setForeground(Color.BLUE);
      } else {
        setSelected(false);
        setForeground(tree.getForeground());
      }
    }

    return this;
  }
}
