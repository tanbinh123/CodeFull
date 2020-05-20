package com.httcinema.ui.subpanel;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JPanel;

import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.model.Phim;

public class LichChieuJScrollPaneDanhSachPhimJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5980168244653605946L;

	/**
	 * Create the panel.
	 */
	public LichChieuJScrollPaneDanhSachPhimJPanel(ArrayList<Phim> phimTrongNgays, Date ngayChieu) {
		setBackground(Theme.white);
		
		// tạo group layout
		GroupLayout groupLayout = new GroupLayout(this);
		
		// nhóm cho hàng ngang
		ParallelGroup hParallelGroup = groupLayout.createParallelGroup(Alignment.LEADING);
		
		// nhóm cho hàng dọc
		ParallelGroup vParallelGroup = groupLayout.createParallelGroup(Alignment.LEADING);
		SequentialGroup vSequentialGroup = groupLayout.createSequentialGroup();
		
		for (int i = 0; i < phimTrongNgays.size(); i++) {
			JPanel panel = new LichChieuJScrollPaneDanhSachPhimJPanelPhimJPanel(phimTrongNgays.get(i), ngayChieu);
			hParallelGroup.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
			vSequentialGroup.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(6);
		}
		
		groupLayout.setHorizontalGroup(hParallelGroup);
		vParallelGroup.addGroup(vSequentialGroup);
		groupLayout.setVerticalGroup(vParallelGroup);
		
		setLayout(groupLayout);
	}
}
