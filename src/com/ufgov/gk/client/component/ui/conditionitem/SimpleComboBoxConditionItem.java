package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import com.ufgov.gk.common.system.dto.ElementConditionDto;

/**
 * 
 * @author liubo 简单组合下拉框
 */
public class SimpleComboBoxConditionItem extends AbstractSearchConditionItem {

	private static final long serialVersionUID = -3749506836206565655L;

	private JComboBox comboBox;

	private List selectItems;

	public SimpleComboBoxConditionItem(String displayName) {
		init(displayName);
	}

	public SimpleComboBoxConditionItem(String displayName, Object defaultValue) {
		init(displayName);
		if (defaultValue != null)
			setValue(defaultValue);
	}

	public SimpleComboBoxConditionItem(String displayName, List selecteItems,
			Object defaultValue) {
		this.selectItems = selecteItems;
		init(displayName);
		if (defaultValue != null)
			setValue(defaultValue);
	}
	
	public int getSelectIndex() {
		return comboBox.getSelectedIndex();
	}

	@Override
	protected JComponent createEditorComponent() {
		if (comboBox == null) {
			comboBox = new JComboBox();
		}
		if (selectItems != null && selectItems.size() > 0) {
			for (int i = 0; i < selectItems.size(); i++) {
				comboBox.addItem(selectItems.get(i));
			}
		}
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireSearch();
				fireValueChanged();
			}
		});
		return comboBox;
	}

	@Override
	public Object getValue() {
		return comboBox.getSelectedIndex();
	}

	@Override
	public void setValue(Object value) {
		comboBox.setSelectedItem(value);
	}

	@Override
	public void putToElementConditionDto(ElementConditionDto element) {
	}

}
