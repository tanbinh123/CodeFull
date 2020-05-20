package com.httcinema.ui.subpanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.httcinema.dao.GheDAO;
import com.httcinema.model.Ghe;
import com.httcinema.share.ShareResource;

@SuppressWarnings("serial")
public class LichChieuJScrollPanePhongChieuJDialogGheJPanel extends JPanel implements ShareResource {

	private String chkNormalIcon = "chair.png";
	private String chkDisabledIcon = "chair-disabled.png";
	private String chkSelectedIcon = "chair-selected-2.png";
	private String chkRollverIcon = "chair-rollover.png";
	
	public ArrayList<JCheckBox> chkGhes;
	
	/**
	 * Create the panel.
	 */
	public LichChieuJScrollPanePhongChieuJDialogGheJPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		ArrayList<Ghe> ghes = (ArrayList<Ghe>) new GheDAO().select(); // tẩt cả ghế
		
		ArrayList<Ghe> gheDaMuas = (ArrayList<Ghe>) new GheDAO().selectBought(LichChieuJScrollPanePhongChieuJDialog.lichChieu); // các ghế đã được mua
		Map<String,Ghe> gheDaMuaMap = new HashMap<String,Ghe>();
		for (Ghe i : gheDaMuas) gheDaMuaMap.put(i.getMaGhe(), i); // chuyển từ mảng danh sách sang bảng băm
		
		chkGhes = new ArrayList<JCheckBox>();
		
		int x = 0; // tọa độ x của ô checkbox
		int y = 0; // tọa độ y của ô checkbox
		int chkBoxSize = 50; 
		int soLuongTrongMotHang = 6;
		int j = 0; // theo dõi đang ở cột thứ mấy
		
		// vẽ các nút nhấn chọn ghế
		for (int i = 0; i < ghes.size(); i++) {
			JCheckBox chkBox = new JCheckBox(ghes.get(i).getMaGhe());
			setDefaultFormatCheckBox(chkBox);
			chkBox.setBounds(x, y, chkBoxSize, chkBoxSize);
			
			// kiểm tra ghế đã được mua chưa
			if (gheDaMuaMap.containsKey(chkBox.getText())) {
				chkBox.setEnabled(false);
			}
			
			x+=(chkBoxSize + 5);
			j++;
			add(chkBox);
			chkGhes.add(chkBox);
			
			// nếu đã đủ 5 ghế trong một hàng
			if (j == soLuongTrongMotHang) {
				j = 0; // reset biến theo dõi
				x = 0; // quay về cột đầu
				y+=(chkBoxSize + 10); // và xuống hàng
			}
		}
	}

	private void setDefaultFormatCheckBox(JCheckBox chkBox) {
    	chkBox.setHorizontalAlignment(SwingConstants.CENTER);
    	chkBox.setHorizontalTextPosition(SwingConstants.CENTER);
    	chkBox.setFocusable(false);
    	chkBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	chkBox.setFont(new Font("Tahoma", Font.BOLD, 18));
    	chkBox.setForeground(Color.WHITE);
    	chkBox.setBackground(Color.WHITE);
    	chkBox.setIcon(new ImageIcon(LichChieuJScrollPanePhongChieuJDialogGheJPanel.class.getResource(setImagePath(chkNormalIcon))));
        chkBox.setDisabledIcon(new ImageIcon(LichChieuJScrollPanePhongChieuJDialogGheJPanel.class.getResource(setImagePath(chkDisabledIcon))));
        chkBox.setDisabledSelectedIcon(new ImageIcon(LichChieuJScrollPanePhongChieuJDialogGheJPanel.class.getResource(setImagePath(chkDisabledIcon))));
        chkBox.setSelectedIcon(new ImageIcon(LichChieuJScrollPanePhongChieuJDialogGheJPanel.class.getResource(setImagePath(chkSelectedIcon))));
        chkBox.setPressedIcon(new ImageIcon(LichChieuJScrollPanePhongChieuJDialogGheJPanel.class.getResource(setImagePath(chkSelectedIcon))));
        chkBox.setRolloverSelectedIcon(new ImageIcon(LichChieuJScrollPanePhongChieuJDialogGheJPanel.class.getResource(setImagePath(chkSelectedIcon))));
        chkBox.setRolloverIcon(new ImageIcon(LichChieuJScrollPanePhongChieuJDialogGheJPanel.class.getResource(setImagePath(chkRollverIcon))));
    }
}
