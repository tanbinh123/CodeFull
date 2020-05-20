package com.httcinema.custom_jcomponents.theme;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class Theme {
	
	// general colors
	public static Color dark = new Color(53, 60, 68); // #353c44
	
	public static Color white = new Color(255, 255, 255); // #ffffff
	public static Color darkWhite = new Color(212, 212, 212); // #d4d4d4
	
	public static Color green = new Color(46, 158, 158); // #2e9e9e
	public static Color darkGreen = new Color(13, 110, 110); // #0d6e6e
	
	public static Color danger = new Color(231, 76, 60); // #e74c3c
	public static Color darkDanger = new Color(189, 34, 34); // #bd2222
	public static Color lightDanger = new Color(240, 112, 98); // #f07062
	
	public static Color success = new Color(60, 231, 106); // #3ce76a
	public static Color darkSuccess =  new Color(34, 189, 75); // #22bd4b
	
	public static Color info = new Color(60, 185, 231); // #3cb9e7
	public static Color darkInfo = new Color(34, 148, 189); // #2294bd
	
	public static Color pink = new Color(231, 60, 111); // #e73c6f
	public static Color darkPink = new Color(189, 34, 80); // #bd2250
	
	// button
	public static Color buttonText = new Color(255, 255, 255);
	public static Font buttonFont = new Font("Tahoma", Font.BOLD, 20);
	public static Color buttonBackground = new Color(53, 60, 68);
	public static Color buttonHoverBackground = new Color(46, 158, 158);
	public static Color buttonHoverForeground = new Color(255, 255, 255);
	
	public static void setDefaultButtonFormat(JButton btn) {
		btn.setFocusable(false);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setBackground(buttonBackground);
		btn.setForeground(buttonText);
		btn.setFont(buttonFont);
	}
	
	public static Color mainLabel = new Color(53, 60, 68);
		
	// table style
	public static Color headerTextColor = white; 
	public static Color headerBackgroundColor = green; 
	public static Font headerFont = new Font("Tahoma", Font.BOLD, 17);
	
	public static Color cellTextColor = white;
	public static Color cellBackgroundColor = dark;
	public static Font cellFont = new Font("Tahoma", Font.PLAIN, 16);
	
	public static Color rowSelection = green;
	
	public static void setDefaultTableFormat(JTable tbl) {
		// header
		tbl.getTableHeader().setForeground(headerTextColor);
		tbl.getTableHeader().setBackground(headerBackgroundColor);
		tbl.getTableHeader().setOpaque(false);
		tbl.getTableHeader().setFont(headerFont);

		// cell
		tbl.setForeground(cellTextColor);
		tbl.setBackground(cellBackgroundColor);
		tbl.setFont(cellFont);
		
		// custom style
		tbl.getTableHeader().setReorderingAllowed(false);
		tbl.setSelectionBackground(rowSelection);
		tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl.setRequestFocusEnabled(false);
		tbl.setShowGrid(false);
		tbl.setFocusable(true);
		tbl.setGridColor(rowSelection);
		tbl.setShowVerticalLines(false);
		tbl.setShowHorizontalLines(false);
		tbl.setRowHeight(50);
		tbl.setIntercellSpacing(new Dimension(0, 0));
		tbl.setRowMargin(4);
		
		tbl.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

				setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
				UIManager.put("TableHeader.background", new ColorUIResource(Theme.dark));
				UIManager.put("TableHeader.focusCellBackground", new ColorUIResource(Theme.dark));			
				setOpaque(true);
				setForeground(headerTextColor);
				setBackground(headerBackgroundColor);
				setFont(headerFont);
				setPreferredSize(new Dimension(150, 50));
				setHorizontalAlignment(JLabel.CENTER);
				return this;
			}
		});
		tbl.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setHorizontalAlignment(JLabel.CENTER);
				return this;
			}
		});
	}
}
