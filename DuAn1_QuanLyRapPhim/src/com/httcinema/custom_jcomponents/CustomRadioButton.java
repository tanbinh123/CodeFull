/**
 * @author: Dinh Dat Thong
 * */


package com.httcinema.custom_jcomponents;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class CustomRadioButton extends JRadioButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2380761791959985771L;

	private String trueStr;
	private String falseStr;
	
	public CustomRadioButton() {
		super();
		setFocusable(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setSelectedIcon(new ImageIcon(CustomRadioButton.class.getResource("radio_icon/radio-button-selected.png")));
		setIcon(new ImageIcon(CustomRadioButton.class.getResource("radio_icon/radio-button-normal.png")));
	}

	public CustomRadioButton(String str) {
		super(str);
		setFocusable(false);
		setSelectedIcon(new ImageIcon(CustomRadioButton.class.getResource("radio_icon/radio-button-selected.png")));
		setIcon(new ImageIcon(CustomRadioButton.class.getResource("radio_icon/radio-button-normal.png")));
	}
	
	@Override
	public void setSelected(boolean value) {
		super.setSelected(value);
		if (value) {
			setText(trueStr);
		}
		else {
			setText(falseStr);
		}
	}
	
	public void setCustomListener(String trueStr, String falseStr) {
		this.trueStr = trueStr;
		this.falseStr = falseStr;
		
		addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				if (isSelected()) {
					setText(trueStr);
				} else {
					setText(falseStr);
				}
			}
		});
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isSelected()) {
					setText(trueStr);
				} else {
					setText(falseStr);
				}
			}
		});
	}
}
