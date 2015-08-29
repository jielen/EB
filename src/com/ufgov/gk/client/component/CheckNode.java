package com.ufgov.gk.client.component;

import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author longrm
 *  ����checktree�еĽڵ����ͣ��̳�DefaultMutableTreeNode��
 *  ����ʵ�������com.ufgov.gk.client.component.CompanyCheckTree
 */
public class CheckNode extends DefaultMutableTreeNode {

	public final static int SINGLE_SELECTION = 0;  // ��ѡʱֻѡ��ǰ�ڵ�
	public final static int DIG_IN_SELECTION = 4;  // ��ѡʱͬʱ��ѡ��ǰ�ڵ�������ӽڵ�

	protected int selectionMode;
	protected boolean isSelected;
	protected boolean expanded;
  
  private boolean parentSelected = true;
  
  private boolean childSelected = true;
  

  /**
   * @return the childSelected
   */
  public boolean isChildSelected() {
    return childSelected;
  }

  /**
   * @param childSelected the childSelected to set
   */
  public void setChildSelected(boolean childSelected) {
    this.childSelected = childSelected;
  }

  /**
   * @return the parentSelected
   */
  public boolean isParentSelected() {
    return parentSelected;
  }

  /**
   * @param parentSelected the parentSelected to set
   */
  public void setParentSelected(boolean parentSelected) {
    this.parentSelected = parentSelected;
  }

  public CheckNode() {
		this(null);
	}

	public CheckNode(Object userObject) {
		this(userObject, true, false);
	}

	public CheckNode(Object userObject, boolean allowsChildren,
			boolean isSelected) {
		super(userObject, allowsChildren);
		this.isSelected = isSelected;
		setSelectionMode(DIG_IN_SELECTION);
	}

	public void setSelectionMode(int mode) {
		selectionMode = mode;
	}

	public int getSelectionMode() {
		return selectionMode;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;

		if (isChildSelected() && (selectionMode == DIG_IN_SELECTION) && (children != null)) {
			Enumeration e = children.elements();
			while (e.hasMoreElements()) {
				CheckNode node = (CheckNode) e.nextElement();
				node.setSelected(isSelected);
			}
		}
    
    if(selectionMode == DIG_IN_SELECTION && isParentSelected()) {
      // ѭ���ݹ�ȡ���ڵ㣬�ж��Ƿ��ѡ��
      CheckNode parentNode = (CheckNode)parent;
      while(parentNode!=null) {
        Enumeration e = parentNode.children();
        // ��־��ǰ���ڵ��Ƿ���ѡ�е��ӽڵ�
        boolean hasSelectedChild = false;
        while(e.hasMoreElements()) {
          CheckNode node = (CheckNode) e.nextElement();
          if(node.isSelected) {
            hasSelectedChild = true;
            break;
          }
        }
        parentNode.setSelectionMode(SINGLE_SELECTION);
        parentNode.setSelected(hasSelectedChild);
        parentNode.setSelectionMode(DIG_IN_SELECTION);
        parentNode = (CheckNode)parentNode.parent;
      }
    }
	}

	public void setExpanded(boolean isExpanded) {
		this.expanded = isExpanded;

		if ((selectionMode == DIG_IN_SELECTION) && (children != null)) {
			Enumeration e = children.elements();
			while (e.hasMoreElements()) {
				CheckNode node = (CheckNode) e.nextElement();
				node.setExpanded(isExpanded);
			}
		}
	}

	public boolean isExpanded() {
		return expanded;
	}

	public boolean isSelected() {
		return isSelected;
	}
}