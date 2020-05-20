package com.httcinema.ui.subpanel;

import com.httcinema.custom_jcomponents.CustomScrollPane;
import com.httcinema.helper.ShareHelper;

public class QuanLyPhimJScrollPane extends CustomScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8990321818509064920L;

	/**
	 * Create the panel.
	 */
	public QuanLyPhimJScrollPane() {
		QuanLyPhimJScrollPanelNoiDungJPanel panel = new QuanLyPhimJScrollPanelNoiDungJPanel();
		setViewportView(panel);
		
		ShareHelper.pnlQuanLyPhim = panel;
	}
}

