/**
 * 
 */
package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.AsValComboBox;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.common.system.model.AsVal;

/**
 * @author liubo
 *
 */
public class BankTypeConditionItem extends AbstractSearchConditionItem {
  public final static String GH_TYPE_CODE = "102";
  public final static String JH_TYPE_CODE = "105";

	/**
	 * 
	 */
	private static final long serialVersionUID = -6100840449408322085L;
	
	//private JComboBox comboBox;
	
	private AsValComboBox comboBox;
	
	public BankTypeConditionItem(String displayName) {
		init(displayName);
	}

	/* (non-Javadoc)
	 * @see com.ufgov.gk.client.component.ui.conditionitem.AbstractSearchConditionItem#createEditorComponent()
	 */
	@Override
	protected JComponent createEditorComponent() {
		// TODO Auto-generated method stub
//		comboBox = new JComboBox();
//    comboBox.addItem(new MyEntry("", null));
//		comboBox.addItem(new MyEntry("中国工商银行", GH_TYPE_CODE));
//		comboBox.addItem(new MyEntry("中国建设银行", JH_TYPE_CODE));
//		comboBox.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent event) {
//				fireSearch();
//				fireValueChanged();
//			}
//		});
//		comboBox.revalidate();
//		comboBox.repaint();
    if (comboBox == null) {
      comboBox = new AsValComboBox("VS_TX_BANK_TYPE", true);
    }
    comboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireSearch();
        fireValueChanged();
      }
    });
    return comboBox;
	}

//	/* (non-Javadoc)
//	 * @see com.ufgov.gk.client.component.ui.conditionitem.AbstractSearchConditionItem#getValue()
//	 */
//	@Override
//	public Object getValue() {
//		// TODO Auto-generated method stub
//		MyEntry entry = (MyEntry)comboBox.getSelectedItem();
//		return entry.getValue();
//	}
//
//	/* (non-Javadoc)
//	 * @see com.ufgov.gk.client.component.ui.conditionitem.AbstractSearchConditionItem#setValue(java.lang.Object)
//	 */
//	@Override
//	public void setValue(Object value) {
//		// TODO Auto-generated method stub
//	}
	
  @Override
  public Object getValue() {
    AsVal val = (AsVal) comboBox.getSelectedItem();
    if (val == null) return null;
    return val.getValId();
  }

  @Override
  public void setValue(Object value) {
    comboBox.setSelectedItem(value);
  }

  public AsValComboBox getAsValComboBox(){
   return  this.comboBox;
  }
  
  @Override
  public void putToElementConditionDto(ElementConditionDto element) {
    AsVal asVal = (AsVal) getValue();
    element.setAdjustCode(asVal.getValId());
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
