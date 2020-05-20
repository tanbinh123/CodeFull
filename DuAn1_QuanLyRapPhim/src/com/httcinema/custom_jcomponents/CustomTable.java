/**
 * @author: Dinh Dat Thong
 * */

package com.httcinema.custom_jcomponents;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import com.httcinema.custom_jcomponents.theme.Theme;

public class CustomTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2769908688058876409L;

	public CustomTable() {
		super();
		
		setDefaultRenderer(Object.class, new EvenOddRenderer());
	}
	
	private class EvenOddRenderer implements TableCellRenderer {
		public final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			((JLabel) renderer).setOpaque(true);
			((JLabel) renderer).setHorizontalAlignment(JLabel.CENTER);
			
			Color foreground, background;
			// nếu trạng thái là đang được chọn
			if (isSelected) {
				foreground = Theme.white;
				background = Theme.green;
			} else {
				// nếu hàng hiện tại là hàng chẵn
				if (row % 2 == 0) {
					foreground = Theme.dark;
					background = Theme.white;
				} else {
					foreground = Theme.dark;
					background = new Color(240, 240, 240);
				}
			}
			renderer.setForeground(foreground);
			renderer.setBackground(background);
			return renderer;
		}
	}

}
