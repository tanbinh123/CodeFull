package com.httcinema.custom_jcomponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import com.httcinema.custom_jcomponents.theme.Theme;

/**
 * A custom combo box with its own renderer and editor.
 * @author wwww.codejava.net
 * @remaker Dinh Dat Thong
 */
@SuppressWarnings({ "serial", "rawtypes" })
public class CustomComboBox<T> extends JComboBox<T> {
//	private DefaultComboBoxModel<T> model;
	
	@SuppressWarnings("unchecked")
	public CustomComboBox() {
		super();
//		model = new DefaultComboBoxModel<T>();
//		setModel(model);
		setUI((ComboBoxUI) MyComboBoxUI.createUI(this));
		setRenderer(new CountryItemRenderer());
		setEditor(new CountryItemEditor());
		setEditable(true);
		setFocusable(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	/**
	 * Add an array items to this combo box.
	 * Each item is an array of two String elements:
	 * - first element is country name.
	 * - second element is path of an image file for country flag.
	 * @param items
	 */
	
	/********************************************************/
	static class MyComboBoxUI extends BasicComboBoxUI {
		public static ComponentUI createUI(JComponent c) {
			return new MyComboBoxUI();
		}

		protected JButton createArrowButton() {
			CustomButton btn = new CustomButton("\u25BC");
			btn.setBorder(null);
			btn.setFont(new Font("Tahoma", Font.BOLD, 18));
			btn.setBackground(Theme.white);
			btn.setForeground(Theme.dark);
			btn.setHoverForeground(new Color(53, 219, 219));
			return btn;
		}
		
		protected ComboPopup createPopup() {
            return new BasicComboPopup(comboBox) {
                @Override
                protected JScrollPane createScroller() {
                    CustomScrollPane scroller = new CustomScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                    return scroller;
                }
            };
        }
	}
	
	/********************************************************/
	private class CountryItemRenderer extends JPanel implements ListCellRenderer {
		private JLabel labelItem = new JLabel();

		public CountryItemRenderer() {
			setLayout(new GridBagLayout());
			GridBagConstraints constraints = new GridBagConstraints();
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.weightx = 4.0;
			constraints.insets = new Insets(2, 2, 2, 0);

			labelItem.setOpaque(true);
			labelItem.setHorizontalAlignment(JLabel.LEFT);
			labelItem.setFont(new Font("Tahoma", Font.PLAIN, 17));

			add(labelItem, constraints);
			setBackground(Theme.dark);
		}

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			// set country name
			labelItem.setText(value.toString());

			if (isSelected) {
				labelItem.setBackground(Theme.green);
				labelItem.setForeground(Theme.white);
			} else {
				labelItem.setForeground(Theme.white);
				labelItem.setBackground(Theme.dark);
			}

			return this;
		}
	}
	
	/********************************************************/
	class CountryItemEditor extends BasicComboBoxEditor {
		private JPanel panel = new JPanel();
		private JLabel labelItem = new JLabel();
		private Object selectedValue;
		
		public CountryItemEditor() {
			panel.setLayout(new GridBagLayout());
			GridBagConstraints constraints = new GridBagConstraints();
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.weightx = 1.0;
			constraints.insets = new Insets(2, 2, 2, 0);
			
			labelItem.setOpaque(false);
			labelItem.setHorizontalAlignment(JLabel.LEFT);
			labelItem.setForeground(Theme.dark);
			labelItem.setFont(new Font("Tahoma", Font.PLAIN, 17));
			
			panel.add(labelItem, constraints);
			panel.setBackground(Theme.white);		
		}
		
		public Component getEditorComponent() {
			return this.panel;
		}
		
		public Object getItem() {
			return this.selectedValue;
		}
		
		public void setItem(Object item) {
			if (item == null) {
				return;
			}
			selectedValue = item;
			labelItem.setText(selectedValue.toString());
		}	
	}
}