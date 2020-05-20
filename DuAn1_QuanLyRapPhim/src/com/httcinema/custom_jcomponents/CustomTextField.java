/**
 * @author: Dinh Dat Thong
 * */

package com.httcinema.custom_jcomponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import com.httcinema.custom_jcomponents.theme.Theme;
 
@SuppressWarnings("serial")
public class CustomTextField extends JTextField {
 
    private Font originalFont;
    private Color originalForeground;
    private Color placeholderForeground = new Color(160, 160, 160);
    private boolean textWrittenIn;
    private int maxLength = 0;
    
    protected PlainDocument customTextFieldFilter;
 
    public CustomTextField(int maxLen) {
		setMaxLength(maxLen);
		setSelectionColor(Theme.green);
		customTextFieldFilter = new CustomTextFieldFilter();
		super.setDocument(customTextFieldFilter);
	}
    
    public CustomTextField() {
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
    
    @Override
    public void setFont(Font f) {
        super.setFont(f);
        if (!isTextWrittenIn()) {
            originalFont = f;
        }
    }
 
    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        if (!isTextWrittenIn()) {
            originalForeground = fg;
        }
    }
 
    public Color getPlaceholderForeground() {
        return placeholderForeground;
    }
 
    public void setPlaceholderForeground(Color placeholderForeground) {
        this.placeholderForeground = placeholderForeground;
    }
 
    public boolean isTextWrittenIn() {
        return textWrittenIn;
    }
 
    public void setTextWrittenIn(boolean textWrittenIn) {
        this.textWrittenIn = textWrittenIn;
    }
 
    private String placeholder;
    
    public String getPlaceholder() {
    	return this.placeholder;
    }
    
    public void setPlaceholder(final String text) {
    	this.placeholder = text;
    	setTextWrittenIn(true);
        this.customizeText(text);
 
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }
 
            @Override
            public void removeUpdate(DocumentEvent e) {
                warn();
            }
 
            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();
            }
 
            public void warn() {
                if (getText().trim().length() != 0) {
                    setFont(originalFont);
                    setForeground(originalForeground);
                    setTextWrittenIn(true);
                }
 
            }
        });
 
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!isTextWrittenIn()) {
                    setText("");
                    setTextWrittenIn(true);
                }
            }
 
            @Override
            public void focusLost(FocusEvent e) {
                if (getText().trim().length() == 0) {
                    customizeText(text);
                }
            }
        });
    }
 
    private void customizeText(String text) {
        setText(text);
        /**If you change font, family and size will follow
         * changes, while style will always be italic**/
        setFont(new Font(getFont().getFamily(), Font.ITALIC, getFont().getSize()));
        setForeground(getPlaceholderForeground());
        setTextWrittenIn(false);
    }
    
    @Override
    public String getText() {
    	if (super.getText().equals(placeholder)) {
    		return "";
    	}
    	else {
    		return super.getText();
    	}
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
