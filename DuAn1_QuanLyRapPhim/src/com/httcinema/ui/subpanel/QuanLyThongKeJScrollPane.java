package com.httcinema.ui.subpanel;

import com.httcinema.custom_jcomponents.CustomScrollPane;
import com.httcinema.helper.ShareHelper;

@SuppressWarnings("serial")
public class QuanLyThongKeJScrollPane extends CustomScrollPane {

	/**
	 * Create the panel.
	 */
	public QuanLyThongKeJScrollPane() {
		QuanLyThongKeJScrollPaneNoiDungJPanel panel = new QuanLyThongKeJScrollPaneNoiDungJPanel();
		setViewportView(panel);
		
		ShareHelper.pnlQuanLyThongKe = panel;
	}
}
