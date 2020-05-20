package com.httcinema.ui.subpanel;

import javax.swing.JPanel;

import com.httcinema.custom_jcomponents.CustomScrollPane;

@SuppressWarnings("serial")
public class LichChieuJScrollPanePhongChieuJDialogXemLaiJScrollPane extends CustomScrollPane {

	/**
	 * Create the panel.
	 */
	public LichChieuJScrollPanePhongChieuJDialogXemLaiJScrollPane() {
		setBorder(null);
		
		JPanel panel = new LichChieuJScrollPanePhongChieuJDialogXemLaiJScrollPaneNoiDungJPanel();
		setViewportView(panel);
	}
}
