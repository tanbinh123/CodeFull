package com.httcinema.ui.subpanel;

import javax.swing.JPanel;

import com.httcinema.custom_jcomponents.CustomScrollPane;
import com.httcinema.model.LichChieu;
import com.httcinema.model.Phim;

@SuppressWarnings("serial")
public class LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPane extends CustomScrollPane {

	/**
	 * Create the panel.
	 */
	public LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPane(LichChieu lichChieu, Phim phim) {
		setBorder(null);
		
		JPanel panel = new LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPaneDanhSachVeJPanel(LichChieuJScrollPanePhongChieuJDialog.gheDuocMuas);
		setViewportView(panel);
	}
}
