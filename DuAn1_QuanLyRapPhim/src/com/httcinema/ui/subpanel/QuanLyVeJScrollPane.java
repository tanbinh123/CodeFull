package com.httcinema.ui.subpanel;

import com.httcinema.custom_jcomponents.CustomScrollPane;
import com.httcinema.helper.ShareHelper;

public class QuanLyVeJScrollPane extends CustomScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1461742448468610177L;
	
	/**
	 * Create the panel.
	 */
	public QuanLyVeJScrollPane() {
		QuanLyVeJScrollPaneNoiDungJPanel panel = new QuanLyVeJScrollPaneNoiDungJPanel();
		setViewportView(panel);
		
		ShareHelper.pnlQuanLyVe = panel;
	}
}
