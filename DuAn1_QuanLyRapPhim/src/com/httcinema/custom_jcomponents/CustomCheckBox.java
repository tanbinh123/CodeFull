package com.httcinema.custom_jcomponents;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class CustomCheckBox extends JCheckBox {
	
	public CustomCheckBox(String str) {
		super(str);
		setFocusable(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setSelectedIcon(new ImageIcon(CustomRadioButton.class.getResource("radio_icon/radio-button-selected.png")));
		setIcon(new ImageIcon(CustomRadioButton.class.getResource("radio_icon/radio-button-normal.png")));
	}
	
	public CustomCheckBox() {
		super();
		setFocusable(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setSelectedIcon(new ImageIcon(CustomRadioButton.class.getResource("radio_icon/radio-button-selected.png")));
		setIcon(new ImageIcon(CustomRadioButton.class.getResource("radio_icon/radio-button-normal.png")));
	}
}
