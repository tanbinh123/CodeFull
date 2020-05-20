package com.httcinema.ui.subpanel;

import com.httcinema.custom_jcomponents.CustomScrollPane;
import com.httcinema.helper.ShareHelper;

public class QuanLyNhanVienJScrollPane extends CustomScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1388674760865625215L;

	/**
	 * Create the panel.
	 */
	public QuanLyNhanVienJScrollPane() {
		QuanLyNhanVienJScrollPaneNoiDungJPanel panel = new QuanLyNhanVienJScrollPaneNoiDungJPanel();
		setViewportView(panel);
		
		ShareHelper.pnlQuanLyNhanVien = panel;
	}
}
