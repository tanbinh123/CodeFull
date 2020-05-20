package com.httcinema.ui.subpanel;

import com.httcinema.custom_jcomponents.CustomScrollPane;
import com.httcinema.helper.ShareHelper;

public class QuanLyLichChieuJScrollPane extends CustomScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6297966243791089179L;

	/**
	 * Create the panel.
	 */
	public QuanLyLichChieuJScrollPane() {
		QuanLyLichChieuJScrollPaneNoiDungJPanel panel = new QuanLyLichChieuJScrollPaneNoiDungJPanel();
		setViewportView(panel);
		
		ShareHelper.pnlQuanLyLichChieu = panel;
	}
}
