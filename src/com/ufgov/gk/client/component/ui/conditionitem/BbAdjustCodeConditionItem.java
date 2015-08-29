/**
 * 
 */
package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;

/**
 * @author liubo
 *
 */
public class BbAdjustCodeConditionItem extends AbstractSearchConditionItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6100840449408322085L;
	
	private JComboBox comboBox;
	
	public BbAdjustCodeConditionItem(String displayName) {
		init(displayName);
	}

	/* (non-Javadoc)
	 * @see com.ufgov.gk.client.component.ui.conditionitem.AbstractSearchConditionItem#createEditorComponent()
	 */
	@Override
	protected JComponent createEditorComponent() {
		// TODO Auto-generated method stub
		comboBox = new JComboBox();
		comboBox.addItem(new MyEntry("����", "100"));
		comboBox.addItem(new MyEntry("�˿�", "200"));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				fireSearch();
				fireValueChanged();
			}
		});
		comboBox.revalidate();
		comboBox.repaint();
		return comboBox;
	}

	/* (non-Javadoc)
	 * @see com.ufgov.gk.client.component.ui.conditionitem.AbstractSearchConditionItem#getValue()
	 */
	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		MyEntry entry = (MyEntry)comboBox.getSelectedItem();
		return entry.getValue();
	}

	/* (non-Javadoc)
	 * @see com.ufgov.gk.client.component.ui.conditionitem.AbstractSearchConditionItem#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub
	}
	
	class MyEntry {
		private String label;
		private Object value;
		
		public MyEntry(String label, Object value) {
			this.label = label;
			this.value = value;
		}
		
		public String getLabel() {
			return label;
		}
		
		public Object getValue() {
			return value;
		}
		
		public String toString() {
			return this.label;
		}
	}

}
