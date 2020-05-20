package com.httcinema.ui.subpanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.httcinema.custom_jcomponents.CustomButton;
import com.httcinema.custom_jcomponents.CustomScrollPane;
import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.dao.PhimDAO;
import com.httcinema.helper.DateHelper;
import com.httcinema.helper.ShareHelper;
import com.httcinema.model.Phim;

public class LichChieuJScrollPane extends CustomScrollPane {
	
	public static JPanel pnlLichChieu;
	private JPanel pnlNgayChieu;
	private JPanel pnlDanhSachPhim;
	private ArrayList<CustomButton> btnNgayChieus;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2648888512828094929L;

	/**
	 * Create the panel.
	 */
	public LichChieuJScrollPane() {
		ShareHelper.pnlLichChieu = this;
		setBorder(null);
		setBackground(Theme.white);
		
		btnNgayChieus = new ArrayList<CustomButton>();
		Date ngayChieu;
		ngayChieu = DateHelper.toDate("15-7-2019", "dd-MM-yyyy");
//		ngayChieu = new Date();
		
		Date[] ngayChieus = new Date[7];
		for (int i = 0; i < ngayChieus.length; i++) {
			ngayChieus[i] = DateHelper.addDays(ngayChieu, i);
		}
		
		pnlLichChieu = new JPanel();
		pnlLichChieu.setBackground(Theme.white);
		pnlLichChieu.setBorder(null);
		setViewportView(pnlLichChieu);
		
		pnlNgayChieu = new JPanel();
		pnlNgayChieu.setBackground(Theme.white);
		pnlNgayChieu.setLayout(null);
		
		JLabel lblNgayChieu = new JLabel("Ngày chiếu");
		lblNgayChieu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNgayChieu.setForeground(Theme.dark);
		lblNgayChieu.setBounds(10, 0, 236, 44);
		pnlNgayChieu.add(lblNgayChieu);
		
		for (int i = 0; i <= 6; i++) {
			String dayOfWeek = DateHelper.toString(ngayChieus[i], "EEE");
			CustomButton btn = new CustomButton("<html><strong>" + dayOfWeek + "</strong><br>" + DateHelper.toString(ngayChieus[i], "dd-MM") + "</html>");
			Theme.setDefaultButtonFormat(btn);
			btn.setBorder(null);
			btn.setForeground(Theme.dark);
			btn.setBackground(Theme.white);
			btn.setActiveLineBorderColor(Theme.dark);
			btn.setHoverForeground(Theme.green);
			
			// nút ngày chủ nhật có giao diện khác
			if (dayOfWeek.equals("Sun")) {
				btn.setBorder(null);
				btn.setForeground(Theme.danger);
				btn.setBackground(Theme.white);
				btn.setActiveLineBorderColor(Theme.danger);
				btn.setHoverForeground(Theme.darkDanger);
			}
			
			// nút ngày happy-day có giao diện khác
			if (dayOfWeek.equals("Wed")) {
				btn.setText("<html><strong> \u2605 " + dayOfWeek + "</strong><br>" + DateHelper.toString(ngayChieus[i], "dd-MM") + "</html>");
				btn.setBorder(null);
				btn.setForeground(Theme.white);
				btn.setBackground(Theme.pink);
				btn.setActiveLineBorderColor(Theme.dark);
				btn.setHoverForeAndBackground(Theme.white, Theme.darkPink);
			}
			
			btn.setFont(new Font("", Font.PLAIN, 20));
			btn.setSize(90, 70);
			
			int a = i;
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setActiveButton(btnNgayChieus, btn);
					ArrayList<Phim> phimTrongNgay = (ArrayList<Phim>) new PhimDAO().selectByDate(ngayChieus[a]);
					if (pnlDanhSachPhim != null) {
						pnlLichChieu.remove(pnlDanhSachPhim);
					}
					pnlDanhSachPhim = new LichChieuJScrollPaneDanhSachPhimJPanel(phimTrongNgay, ngayChieus[a]);
					pnlLichChieu.add(pnlDanhSachPhim);
					pnlLichChieu.revalidate();
					pnlLichChieu.repaint();
					refreshDanhSachPhim();
				}
			});
			btnNgayChieus.add(btn);
		}
		
		int a = 10;
		for (int i = 0; i < btnNgayChieus.size(); i++) {
			CustomButton btn = btnNgayChieus.get(i);
			btn.setLocation(a, 55);
			pnlNgayChieu.add(btn);
			
			a+=120;
		}
		
		btnNgayChieus.get(0).doClick();
	}
	
	private void setActiveButton(ArrayList<CustomButton> arr, CustomButton btn) {
		for (int i = 0; i < arr.size(); i++) {
			arr.get(i).setActive(false);
		}
		btn.setActive(true);
	}
	
	private void refreshDanhSachPhim() {
		GroupLayout gl_pnlLichChieu = new GroupLayout(pnlLichChieu);
		gl_pnlLichChieu.setHorizontalGroup(
			gl_pnlLichChieu.createParallelGroup(Alignment.TRAILING)
				.addComponent(pnlDanhSachPhim, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
				.addComponent(pnlNgayChieu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
		);
		gl_pnlLichChieu.setVerticalGroup(
			gl_pnlLichChieu.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlLichChieu.createSequentialGroup()
					.addComponent(pnlNgayChieu, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlDanhSachPhim, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
					.addGap(0))
		);
		
		pnlLichChieu.setLayout(gl_pnlLichChieu);
	}
	
	public void refreshAll() {
		for (CustomButton btn : btnNgayChieus) {
			if (btn.isActive()) {
				btn.doClick();
			}
		}
	}
}
