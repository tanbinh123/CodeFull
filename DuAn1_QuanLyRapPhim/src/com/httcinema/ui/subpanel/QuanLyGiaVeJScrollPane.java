package com.httcinema.ui.subpanel;

import com.httcinema.custom_jcomponents.CustomScrollPane;
import com.httcinema.helper.ShareHelper;

public class QuanLyGiaVeJScrollPane extends CustomScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 431632368802905535L;

	/**
	 * Create the panel.
	 */
	public QuanLyGiaVeJScrollPane() {
		QuanLyGiaVeJScrollPaneNoiDungJPanel panel = new QuanLyGiaVeJScrollPaneNoiDungJPanel();
		setViewportView(panel);
		
		ShareHelper.pnlQuanLyGiaVe = panel;
	}
}
