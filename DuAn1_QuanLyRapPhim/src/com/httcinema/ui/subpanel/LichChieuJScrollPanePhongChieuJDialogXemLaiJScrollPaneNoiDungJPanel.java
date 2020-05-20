package com.httcinema.ui.subpanel;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JPanel;

import com.httcinema.custom_jcomponents.CustomComboBox;
import com.httcinema.model.GiaVe;

@SuppressWarnings("serial")
public class LichChieuJScrollPanePhongChieuJDialogXemLaiJScrollPaneNoiDungJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public LichChieuJScrollPanePhongChieuJDialogXemLaiJScrollPaneNoiDungJPanel() {
		ArrayList<LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPaneDanhSachVeJPanelVeJPanel> pnlVes = LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPaneDanhSachVeJPanel.pnlVes;
		LichChieuJScrollPanePhongChieuJDialog.tongCong = 0;
		setBackground(Color.WHITE);
		
		// tạo group layout
		GroupLayout groupLayout = new GroupLayout(this);

		// nhóm cho hàng ngang
		ParallelGroup hParallelGroup = groupLayout.createParallelGroup(Alignment.LEADING);

		// nhóm cho hàng dọc
		ParallelGroup vParallelGroup = groupLayout.createParallelGroup(Alignment.LEADING);
		SequentialGroup vSequentialGroup = groupLayout.createSequentialGroup();

		for (int i = 0; i < pnlVes.size(); i++) {
			hParallelGroup.addComponent(pnlVes.get(i), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
			vSequentialGroup.addComponent(pnlVes.get(i), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(6);
		
			CustomComboBox<GiaVe> cbo = pnlVes.get(i).getCboGiaVe();
			cbo.setEnabled(false);
			
			LichChieuJScrollPanePhongChieuJDialog.tongCong += ((GiaVe) cbo.getSelectedItem()).getGiaVe();
		}

		groupLayout.setHorizontalGroup(hParallelGroup);
		vParallelGroup.addGroup(vSequentialGroup);
		groupLayout.setVerticalGroup(vParallelGroup);

		setLayout(groupLayout);
	}
}
