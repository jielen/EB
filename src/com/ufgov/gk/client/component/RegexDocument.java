package com.ufgov.gk.client.component;

import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * 
 * @author shenjw Apr 30, 2008
 * 
 */
public class RegexDocument extends PlainDocument {

	private String regex;

	private int maxLength = -1;

	private Toolkit toolkit = null;

	public RegexDocument() {
		super();
		this.init();
	}

	public RegexDocument(Content c) {
		super(c);
		this.init();
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	private void init() {
		toolkit = Toolkit.getDefaultToolkit();
	}

	@Override
	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException, NumberFormatException {
		if (str == null) {
			return;
		}

		StringBuffer oldStr = new StringBuffer(this
				.getText(0, this.getLength()));

		StringBuffer newStr = oldStr.insert(offs, str);

		if (this.regex != null && !this.regex.trim().equals("")) {

			if (!newStr.toString().matches(this.regex)) {
				toolkit.beep();
				return;
			}

		}

		if (maxLength >= 0 && newStr.length() > maxLength) {
			toolkit.beep();
			return;
		}

		super.insertString(offs, str, a);
	}

}
