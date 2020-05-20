package com.httcinema.ui.subpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.httcinema.custom_jcomponents.CustomButton;
import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.dao.LichChieuDAO;
import com.httcinema.dao.TheLoaiPhimDAO;
import com.httcinema.helper.DateHelper;
import com.httcinema.helper.ShareHelper;
import com.httcinema.model.LichChieu;
import com.httcinema.model.Phim;
import com.httcinema.model.TheLoaiPhim;
import com.httcinema.ui.ManHinhChinhJFrame;

@SuppressWarnings("serial")
public class LichChieuJScrollPaneDanhSachPhimJPanelPhimJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public LichChieuJScrollPaneDanhSachPhimJPanelPhimJPanel(Phim phim, Date ngayChieu) {
		TheLoaiPhim tlp = new TheLoaiPhimDAO().findById(phim.getMaTheLoai() + "");
		setBackground(Theme.white);
		
		JLabel lblHinhPhim = new JLabel("");
		lblHinhPhim.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHinhPhim.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinhPhim.setIcon(new ImageIcon(ShareHelper.readMovieImage(phim, 166, 234)));
		
		JLabel lblTenPhim = new JLabel(phim.getTenPhim());
		lblTenPhim.setBorder(null);
		lblTenPhim.setForeground(Theme.darkGreen);
		lblTenPhim.setFont(new Font("Tahoma", Font.BOLD, 26));
		
		JPanel pnlGioChieu = new JPanel();
		pnlGioChieu.setBackground(Theme.white);
		pnlGioChieu.setBorder(null);
		
		JLabel lblThoiLuong = new JLabel(" Thời lượng: " + phim.getThoiLuong() + " phút");
		lblThoiLuong.setForeground(Theme.darkGreen);
		lblThoiLuong.setIcon(new ImageIcon(LichChieuJScrollPaneDanhSachPhimJPanelPhimJPanel.class.getResource("/com/httcinema/icon/icon-clock.png")));
		lblThoiLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTheLoai = new JLabel(" Thể loại: " + tlp.getTenTheLoai());
		lblTheLoai.setForeground(Theme.darkGreen);
		lblTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTheLoai.setIcon(new ImageIcon(LichChieuJScrollPaneDanhSachPhimJPanelPhimJPanel.class.getResource("/com/httcinema/icon/icon-category.png")));
		
		JLabel lblKhoiChieu = new JLabel(" Khởi chiếu: " + DateHelper.toString(phim.getNgayCongChieu(), "dd-MM-yyyy"));
		lblKhoiChieu.setForeground(Theme.darkGreen);
		lblKhoiChieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKhoiChieu.setIcon(new ImageIcon(LichChieuJScrollPaneDanhSachPhimJPanelPhimJPanel.class.getResource("/com/httcinema/icon/icon-calendar.png")));
		
		JLabel lblNhaSanXuat = new JLabel("<html><strong>Nhà sản xuất: </strong>" + phim.getNhaSanXuat() + "</html>");
		lblNhaSanXuat.setForeground(Theme.dark);
		lblNhaSanXuat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDoTuoi = new JLabel("<html><strong>Độ tuổi: </strong>" + phim.getDoTuoi() + "+</html>");;
		if (phim.getDoTuoi() == 1) {
			lblDoTuoi = new JLabel("<html><strong>Độ tuổi: </strong>mọi lứa tuổi</html>");
		}
		lblDoTuoi.setForeground(Theme.dark);
		lblDoTuoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTenPhim, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblHinhPhim, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlGioChieu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblDoTuoi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblThoiLuong, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblTheLoai, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblKhoiChieu, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNhaSanXuat, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(lblTenPhim, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblThoiLuong, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblTheLoai, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
									.addComponent(lblKhoiChieu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addComponent(lblNhaSanXuat, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDoTuoi, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(pnlGioChieu, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHinhPhim, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
					.addContainerGap())
		);
		pnlGioChieu.setLayout(null);
		
		// truy vấn các giờ chiếu dựa vào ngày và phim 
		ArrayList<LichChieu> lichChieuCuaPhims = (ArrayList<LichChieu>) new LichChieuDAO().selectByMovieAndDate(phim.getMaPhim() + "", ngayChieu);
		
		// tạo mảng gồm các nút bấm
		CustomButton[] buttons = new CustomButton[lichChieuCuaPhims.size()];
		for (int i = 0; i < buttons.length; i++) {
			String str = (lichChieuCuaPhims.get(i).getGioChieu() + "").substring(0, 5);
			CustomButton btn = new CustomButton(str);
			buttons[i] = btn;
		}
		
		int x = 0;
		for (int i = 0; i < buttons.length; i++) {
			CustomButton btn = buttons[i];

			btn.setBounds(x, 11, 80, 30);
			Theme.setDefaultButtonFormat(btn);
			btn.setBorder(new LineBorder(Theme.dark, 1));
			btn.setBackground(Theme.green);
			btn.setHoverBackground(Theme.darkGreen);
			btn.setFont(new Font("Tahoma", Font.BOLD, 15));
			int a = i;
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LichChieuJScrollPanePhongChieuJDialog.showDialog(ManHinhChinhJFrame.frameManHinhChinh, phim, lichChieuCuaPhims.get(a));
				}
			});
			pnlGioChieu.add(btn);
			
			x+=99;
		}
		
		setLayout(groupLayout);
	}
}
