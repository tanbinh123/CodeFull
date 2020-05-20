package com.httcinema.custom_jcomponents;

import javax.swing.JTextArea;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import com.httcinema.custom_jcomponents.theme.Theme;

@SuppressWarnings("serial")
public class CustomTextArea extends JTextArea {
	private int maxLength = 0;

	protected PlainDocument customTextAreaFilter;

	public CustomTextArea(int maxLen) {
		setMaxLength(maxLen);
		setSelectionColor(Theme.green);
		customTextAreaFilter = new CustomTextFieldFilter();
		super.setDocument(customTextAreaFilter);
	}

	public CustomTextArea() {
		this(100);
	}

	public void setMaxLength(int maxLen) {
		if (maxLen > 0)
			maxLength = maxLen;
		else
			maxLength = 0;
	}

	public int getMaxLength() {
		return maxLength;
	}

	class CustomTextFieldFilter extends PlainDocument {
		private static final long serialVersionUID = 1L;

		public CustomTextFieldFilter() {
			super();
		}

		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			String text = getText(0, offset) + str + getText(offset, (getLength() - offset));

			if (str == null || text == null)
				return;

			int precisionLength = 0, dotLength = 0, minusLength = 0;
			int textLength = text.length();

			if (maxLength < (textLength - dotLength - precisionLength - minusLength))
				return;

			super.insertString(offset, str, attr);
		}
	}

}
