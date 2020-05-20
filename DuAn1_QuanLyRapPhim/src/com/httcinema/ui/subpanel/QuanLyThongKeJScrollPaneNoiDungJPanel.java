package com.httcinema.ui.subpanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.httcinema.custom_jcomponents.CustomButton;
import com.httcinema.custom_jcomponents.CustomComboBox;
import com.httcinema.custom_jcomponents.CustomScrollPane;
import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.dao.PhimDAO;
import com.httcinema.dao.PhongChieuDAO;
import com.httcinema.dao.ThongKeDAO;
import com.httcinema.dao.VeDAO;
import com.httcinema.helper.DateHelper;
import com.httcinema.model.Phim;
import com.httcinema.model.PhongChieu;
import com.httcinema.model.Ve;
import com.httcinema.ui.ManHinhChinhJFrame;
import javax.swing.border.MatteBorder;

@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
public class QuanLyThongKeJScrollPaneNoiDungJPanel extends JPanel {
	
	private JLabel lblSoLuongPhim;
	private JLabel lblSoLuongLichChieu;
	private JLabel lblSoLuongVe;
	private JLabel lblSoLuongNhanVien;

	private JTable tblDoanhThuPhim;
	private JLabel lblNamP;
	private CustomComboBox cboNamP;
	private JLabel lblPhim;
	private CustomComboBox<Phim> cboPhim;
	private ActionListener loadTblDoanhThuPhimAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			loadTableP();
		}
	};
	
	private JTable tblDoanhThuPhongChieu;
	private JLabel lblNamPC;
	private CustomComboBox cboNamPC;
	private JLabel lblPhongChieu;
	private CustomComboBox<PhongChieu> cboPhongChieu;
	private ActionListener loadTblDoanhThuPhongChieuAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			loadTablePC();
		}
	};
	
	private JTable tblDoanhThuGioChieu;
	private CustomComboBox cboNgayBatDau;
	private CustomComboBox cboNgayKetThuc;
	private ActionListener loadTblDoanhThuGioChieuAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			loadTableGC();
		}
	};
	
	/**
	 * Create the panel.
	 */
	public QuanLyThongKeJScrollPaneNoiDungJPanel() {
		setBackground(Color.WHITE);
		
		JTabbedPane pnlQuanLyThongKe = new JTabbedPane(JTabbedPane.TOP);
		pnlQuanLyThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		pnlQuanLyThongKe.setFocusable(false);
		pnlQuanLyThongKe.setForeground(new Color(53, 60, 68));
		pnlQuanLyThongKe.setFont(new Font("Tahoma", Font.BOLD, 17));
		pnlQuanLyThongKe.setBackground(Color.WHITE);
		
		JPanel pnlBangDieuKhien = new JPanel();
		pnlBangDieuKhien.setBackground(Color.WHITE);
		pnlQuanLyThongKe.addTab("Bảng điều khiển", new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/icon-dashboard.png")), pnlBangDieuKhien, null);
		
		JPanel pnlThongTinChiTiet = new JPanel();
		pnlThongTinChiTiet.setBackground(Color.WHITE);
		
		GroupLayout gl_pnlBangDieuKhien = new GroupLayout(pnlBangDieuKhien);
		gl_pnlBangDieuKhien.setHorizontalGroup(
			gl_pnlBangDieuKhien.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBangDieuKhien.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlThongTinChiTiet, GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlBangDieuKhien.setVerticalGroup(
			gl_pnlBangDieuKhien.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBangDieuKhien.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlThongTinChiTiet, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel pnlThongKeSoLuong = new JPanel();
		pnlThongKeSoLuong.setBackground(Color.WHITE);
		
		JPanel pnlSoLuongPhim = new JPanel();
		pnlSoLuongPhim.setBorder(new MatteBorder(1, 1, 1, 0, Theme.darkWhite));
		pnlSoLuongPhim.setBackground(Color.WHITE);
		
		JPanel pnlSoLuongLichChieu = new JPanel();
		pnlSoLuongLichChieu.setBorder(new MatteBorder(1, 1, 1, 0, Theme.darkWhite));
		pnlSoLuongLichChieu.setBackground(Color.WHITE);
		
		JPanel pnlSoLuongVe = new JPanel();
		pnlSoLuongVe.setBorder(new MatteBorder(1, 1, 1, 0, Theme.darkWhite));
		pnlSoLuongVe.setBackground(Color.WHITE);
		
		JPanel pnlSoLuongNhanVien = new JPanel();
		pnlSoLuongNhanVien.setBorder(new LineBorder(Theme.darkWhite));
		pnlSoLuongNhanVien.setBackground(Color.WHITE);
		
		GroupLayout gl_pnlThongKeSoLuong = new GroupLayout(pnlThongKeSoLuong);
		gl_pnlThongKeSoLuong.setHorizontalGroup(
			gl_pnlThongKeSoLuong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlThongKeSoLuong.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlSoLuongPhim, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(0)
					.addComponent(pnlSoLuongLichChieu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(0)
					.addComponent(pnlSoLuongVe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(0)
					.addComponent(pnlSoLuongNhanVien, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_pnlThongKeSoLuong.setVerticalGroup(
			gl_pnlThongKeSoLuong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlThongKeSoLuong.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlThongKeSoLuong.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnlSoLuongNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlSoLuongVe, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlSoLuongLichChieu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlSoLuongPhim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		lblSoLuongNhanVien = new JLabel("3000");
		lblSoLuongNhanVien.setForeground(new Color(255, 151, 0));
		lblSoLuongNhanVien.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSoLuongNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblBieuTuongSoLuongNhanVien = new JLabel("");
		lblBieuTuongSoLuongNhanVien.setIcon(new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/icon-wave-orange.png")));
		lblBieuTuongSoLuongNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTieuDeSoLuongNhanVien = new JLabel("NHÂN VIÊN");
		lblTieuDeSoLuongNhanVien.setBackground(Color.DARK_GRAY);
		lblTieuDeSoLuongNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeSoLuongNhanVien.setForeground(Color.DARK_GRAY);
		lblTieuDeSoLuongNhanVien.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_pnlSoLuongNhanVien = new GroupLayout(pnlSoLuongNhanVien);
		gl_pnlSoLuongNhanVien.setHorizontalGroup(
			gl_pnlSoLuongNhanVien.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlSoLuongNhanVien.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlSoLuongNhanVien.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSoLuongNhanVien, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
						.addComponent(lblBieuTuongSoLuongNhanVien, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
						.addComponent(lblTieuDeSoLuongNhanVien, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnlSoLuongNhanVien.setVerticalGroup(
			gl_pnlSoLuongNhanVien.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSoLuongNhanVien.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTieuDeSoLuongNhanVien, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSoLuongNhanVien)
					.addGap(5)
					.addComponent(lblBieuTuongSoLuongNhanVien, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlSoLuongNhanVien.setLayout(gl_pnlSoLuongNhanVien);
		
		lblSoLuongVe = new JLabel("3000");
		lblSoLuongVe.setForeground(new Color(21, 202, 32));
		lblSoLuongVe.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSoLuongVe.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblBieuTuongSoLuongVe = new JLabel("");
		lblBieuTuongSoLuongVe.setIcon(new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/icon-wave-green.png")));
		lblBieuTuongSoLuongVe.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTieuDeSoLuongVe = new JLabel("VÉ");
		lblTieuDeSoLuongVe.setBackground(Color.DARK_GRAY);
		lblTieuDeSoLuongVe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeSoLuongVe.setForeground(Color.DARK_GRAY);
		lblTieuDeSoLuongVe.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_pnlSoLuongVe = new GroupLayout(pnlSoLuongVe);
		gl_pnlSoLuongVe.setHorizontalGroup(
			gl_pnlSoLuongVe.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlSoLuongVe.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlSoLuongVe.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSoLuongVe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
						.addComponent(lblBieuTuongSoLuongVe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
						.addComponent(lblTieuDeSoLuongVe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnlSoLuongVe.setVerticalGroup(
			gl_pnlSoLuongVe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSoLuongVe.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTieuDeSoLuongVe, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSoLuongVe, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblBieuTuongSoLuongVe, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlSoLuongVe.setLayout(gl_pnlSoLuongVe);
		
		lblSoLuongLichChieu = new JLabel("3000");
		lblSoLuongLichChieu.setForeground(new Color(253, 53, 80));
		lblSoLuongLichChieu.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSoLuongLichChieu.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblBieuTuongSoLuongLichChieu = new JLabel("");
		lblBieuTuongSoLuongLichChieu.setIcon(new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/icon-wave-red.png")));
		lblBieuTuongSoLuongLichChieu.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTieuDeSoLuongLichChieu = new JLabel("SUẤT CHIẾU");
		lblTieuDeSoLuongLichChieu.setBackground(Color.DARK_GRAY);
		lblTieuDeSoLuongLichChieu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeSoLuongLichChieu.setForeground(Color.DARK_GRAY);
		lblTieuDeSoLuongLichChieu.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_pnlSoLuongLichChieu = new GroupLayout(pnlSoLuongLichChieu);
		gl_pnlSoLuongLichChieu.setHorizontalGroup(
			gl_pnlSoLuongLichChieu.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlSoLuongLichChieu.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlSoLuongLichChieu.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSoLuongLichChieu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
						.addComponent(lblBieuTuongSoLuongLichChieu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
						.addComponent(lblTieuDeSoLuongLichChieu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnlSoLuongLichChieu.setVerticalGroup(
			gl_pnlSoLuongLichChieu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSoLuongLichChieu.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTieuDeSoLuongLichChieu, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSoLuongLichChieu)
					.addGap(5)
					.addComponent(lblBieuTuongSoLuongLichChieu, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlSoLuongLichChieu.setLayout(gl_pnlSoLuongLichChieu);
		
		JLabel lblTieuDeSoLuongPhim = new JLabel("PHIM");
		lblTieuDeSoLuongPhim.setBackground(Color.DARK_GRAY);
		lblTieuDeSoLuongPhim.setForeground(Color.DARK_GRAY);
		lblTieuDeSoLuongPhim.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTieuDeSoLuongPhim.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblSoLuongPhim = new JLabel("3000");
		lblSoLuongPhim.setForeground(new Color(0, 140, 255));
		lblSoLuongPhim.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSoLuongPhim.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblBieuTuongSoLuongPhim = new JLabel("");
		lblBieuTuongSoLuongPhim.setIcon(new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/icon-wave-blue.png")));
		lblBieuTuongSoLuongPhim.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_pnlSoLuongPhim = new GroupLayout(pnlSoLuongPhim);
		gl_pnlSoLuongPhim.setHorizontalGroup(
			gl_pnlSoLuongPhim.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlSoLuongPhim.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlSoLuongPhim.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSoLuongPhim, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
						.addComponent(lblBieuTuongSoLuongPhim, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
						.addComponent(lblTieuDeSoLuongPhim, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnlSoLuongPhim.setVerticalGroup(
			gl_pnlSoLuongPhim.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSoLuongPhim.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTieuDeSoLuongPhim)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSoLuongPhim)
					.addGap(5)
					.addComponent(lblBieuTuongSoLuongPhim, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlSoLuongPhim.setLayout(gl_pnlSoLuongPhim);
		pnlThongKeSoLuong.setLayout(gl_pnlThongKeSoLuong);
		GroupLayout gl_pnlThongTinChiTiet = new GroupLayout(pnlThongTinChiTiet);
		gl_pnlThongTinChiTiet.setHorizontalGroup(
			gl_pnlThongTinChiTiet.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlThongTinChiTiet.createSequentialGroup()
					.addComponent(pnlThongKeSoLuong, GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_pnlThongTinChiTiet.setVerticalGroup(
			gl_pnlThongTinChiTiet.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlThongTinChiTiet.createSequentialGroup()
					.addGap(22)
					.addComponent(pnlThongKeSoLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 0, Short.MAX_VALUE))
		);
		pnlThongTinChiTiet.setLayout(gl_pnlThongTinChiTiet);
		pnlBangDieuKhien.setLayout(gl_pnlBangDieuKhien);
		
		//-------------------------------------------------------------------------------
		// Doanh Thu Theo Phim
		
		JPanel pnlDoanhThuCuaPhim = new JPanel();
		pnlDoanhThuCuaPhim.setBackground(Color.WHITE);
		pnlQuanLyThongKe.addTab("Doanh thu theo phim", new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/icon-film.png")), pnlDoanhThuCuaPhim, null);
		
		JPanel pnlBangPhim = new JPanel();
		pnlBangPhim.setBackground(Color.WHITE);
		
		JScrollPane scrollPane_1 = new CustomScrollPane();
		tblDoanhThuPhim = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
//				return columnEditables[column];
			}
		};
		tblDoanhThuPhim.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã phim", "Tên phim", "Số lượng suất chiếu", "Số lượng vé bán ra", "Doanh thu của phim"
			}
		));
		Theme.setDefaultTableFormat(tblDoanhThuPhim);
		scrollPane_1.setViewportView(tblDoanhThuPhim);
		
		GroupLayout gl_pnlBangPhim = new GroupLayout(pnlBangPhim);
		gl_pnlBangPhim.setHorizontalGroup(
			gl_pnlBangPhim.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBangPhim.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlBangPhim.setVerticalGroup(
			gl_pnlBangPhim.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBangPhim.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlBangPhim.setLayout(gl_pnlBangPhim);
		
		JPanel pnlTimKiemPhim = new JPanel();
		pnlTimKiemPhim.setBackground(Color.WHITE);
		
		lblNamP = new JLabel("Năm");
		lblNamP.setIcon(new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/icon-calendar-2.png")));
		lblNamP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNamP.setForeground(new Color(53, 60, 68));
		lblNamP.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		cboNamP = new CustomComboBox();
		cboNamP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fillComboBoxNamP();
		cboNamP.setBorder(new LineBorder(new Color(53, 60, 68), 2));
		
		lblPhim = new JLabel("Phim");
		lblPhim.setIcon(new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/icon-film.png")));
		lblPhim.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhim.setForeground(new Color(53, 60, 68));
		lblPhim.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		cboPhim = new CustomComboBox<Phim>();
		cboPhim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fillComboBoxPhim();
		cboPhim.setBorder(new LineBorder((Theme.dark), 2));
		
		GroupLayout gl_pnlTimKiemPhim = new GroupLayout(pnlTimKiemPhim);
		gl_pnlTimKiemPhim.setHorizontalGroup(
			gl_pnlTimKiemPhim.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTimKiemPhim.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNamP)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cboNamP, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPhim)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cboPhim, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(297, Short.MAX_VALUE))
		);
		gl_pnlTimKiemPhim.setVerticalGroup(
			gl_pnlTimKiemPhim.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlTimKiemPhim.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addGroup(gl_pnlTimKiemPhim.createParallelGroup(Alignment.TRAILING)
						.addComponent(cboPhim, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPhim, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboNamP, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNamP, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pnlTimKiemPhim.setLayout(gl_pnlTimKiemPhim);
		GroupLayout gl_pnlDoanhThuCuaPhim = new GroupLayout(pnlDoanhThuCuaPhim);
		gl_pnlDoanhThuCuaPhim.setHorizontalGroup(
			gl_pnlDoanhThuCuaPhim.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlTimKiemPhim, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(pnlBangPhim, GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
		);
		gl_pnlDoanhThuCuaPhim.setVerticalGroup(
			gl_pnlDoanhThuCuaPhim.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDoanhThuCuaPhim.createSequentialGroup()
					.addComponent(pnlTimKiemPhim, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(pnlBangPhim, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlDoanhThuCuaPhim.setLayout(gl_pnlDoanhThuCuaPhim);
		
		//-------------------------------------------------------------------------------
		// Doanh Thu Theo Phòng Chiếu
		
		JPanel pnlDoanhThuCuaPhongChieu = new JPanel();
		pnlDoanhThuCuaPhongChieu.setBackground(Color.WHITE);
		pnlQuanLyThongKe.addTab("Doanh thu theo phòng chiếu", new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/icon-room.png")), pnlDoanhThuCuaPhongChieu, null);
		
		JPanel pnlBangPhongChieu = new JPanel();
		pnlBangPhongChieu.setBackground(Color.WHITE);
		
		JScrollPane scrollPane = new CustomScrollPane();
		tblDoanhThuPhongChieu = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
//				return columnEditables[column];
			}
		};
		tblDoanhThuPhongChieu.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã phòng chiếu", "Tên phòng chiếu", "Số lượng suất chiếu" ,"Số lượng vé bán ra", "Doanh thu"
			}
		));
		Theme.setDefaultTableFormat(tblDoanhThuPhongChieu);
		scrollPane.setViewportView(tblDoanhThuPhongChieu);
		
		GroupLayout gl_pnlBangPhongChieu = new GroupLayout(pnlBangPhongChieu);
		gl_pnlBangPhongChieu.setHorizontalGroup(
			gl_pnlBangPhongChieu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBangPhongChieu.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlBangPhongChieu.setVerticalGroup(
			gl_pnlBangPhongChieu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBangPhongChieu.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlBangPhongChieu.setLayout(gl_pnlBangPhongChieu);
		
		JPanel pnlTimKiemPhongChieu = new JPanel();
		pnlTimKiemPhongChieu.setBackground(Color.WHITE);
		
		lblNamPC = new JLabel("Năm");
		lblNamPC.setIcon(new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/icon-calendar-2.png")));
		lblNamPC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNamPC.setForeground(new Color(53, 60, 68));
		lblNamPC.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		cboNamPC = new CustomComboBox();
		fillComboBoxNamPC();
		cboNamPC.setBorder(new LineBorder((Theme.dark), 2));
		
		lblPhongChieu = new JLabel("Phòng chiếu");
		lblPhongChieu.setIcon(new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/icon-room.png")));
		lblPhongChieu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhongChieu.setForeground(new Color(53, 60, 68));
		lblPhongChieu.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		cboPhongChieu = new CustomComboBox<PhongChieu>();
		fillComboBoxPhongChieu();
		cboPhongChieu.setBorder(new LineBorder((Theme.dark), 2));
		
		GroupLayout gl_pnlTimKiemPhongChieu = new GroupLayout(pnlTimKiemPhongChieu);
		gl_pnlTimKiemPhongChieu.setHorizontalGroup(
			gl_pnlTimKiemPhongChieu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTimKiemPhongChieu.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNamPC)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cboNamPC, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPhongChieu)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cboPhongChieu, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(239, Short.MAX_VALUE))
		);
		gl_pnlTimKiemPhongChieu.setVerticalGroup(
			gl_pnlTimKiemPhongChieu.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlTimKiemPhongChieu.createSequentialGroup()
					.addContainerGap(8, Short.MAX_VALUE)
					.addGroup(gl_pnlTimKiemPhongChieu.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPhongChieu, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboPhongChieu, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboNamPC, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNamPC, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pnlTimKiemPhongChieu.setLayout(gl_pnlTimKiemPhongChieu);
		GroupLayout gl_pnlDoanhThuCuaPhongChieu = new GroupLayout(pnlDoanhThuCuaPhongChieu);
		gl_pnlDoanhThuCuaPhongChieu.setHorizontalGroup(
			gl_pnlDoanhThuCuaPhongChieu.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlBangPhongChieu, GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
				.addComponent(pnlTimKiemPhongChieu, GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
		);
		gl_pnlDoanhThuCuaPhongChieu.setVerticalGroup(
			gl_pnlDoanhThuCuaPhongChieu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDoanhThuCuaPhongChieu.createSequentialGroup()
					.addComponent(pnlTimKiemPhongChieu, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(pnlBangPhongChieu, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlDoanhThuCuaPhongChieu.setLayout(gl_pnlDoanhThuCuaPhongChieu);
		
		JPanel pnlNut = new JPanel();
		pnlNut.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnlQuanLyThongKe, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 704, Short.MAX_VALUE)
						.addComponent(pnlNut, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlNut, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(pnlQuanLyThongKe, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		CustomButton btnInThongKe = new CustomButton("  In thống kê");
		btnInThongKe.setForeground(Color.WHITE);
		btnInThongKe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInThongKe.setIcon(new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/icon-printer-3.png")));
		btnInThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyThongKeJScrollPaneNoiDungJPanelInJDialog.showDialog(ManHinhChinhJFrame.frameManHinhChinh, tblDoanhThuPhim, tblDoanhThuPhongChieu, tblDoanhThuGioChieu);
			}
		});
		Theme.setDefaultButtonFormat(btnInThongKe);
		btnInThongKe.setBackground(Theme.green);
		btnInThongKe.setHoverBackground(Theme.darkGreen);
		
		GroupLayout gl_pnlNut = new GroupLayout(pnlNut);
		gl_pnlNut.setHorizontalGroup(
			gl_pnlNut.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNut.createSequentialGroup()
					.addGap(0)
					.addComponent(btnInThongKe, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(600, Short.MAX_VALUE))
		);
		gl_pnlNut.setVerticalGroup(
			gl_pnlNut.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNut.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnInThongKe, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		pnlNut.setLayout(gl_pnlNut);
		
		JPanel pnlDoanhThuCuaGioChieu = new JPanel();
		pnlDoanhThuCuaGioChieu.setBackground(Color.WHITE);
		pnlQuanLyThongKe.addTab("Doanh thu theo giờ chiếu", new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/icon-clock-2.png")), pnlDoanhThuCuaGioChieu, null);
		
		JPanel pnlTimKiemGioChieu = new JPanel();
		pnlTimKiemGioChieu.setBackground(Color.WHITE);
		
		JLabel lblNgayBatDau = new JLabel("Ngày bắt đầu");
		lblNgayBatDau.setIcon(new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/icon-calendar-2.png")));
		lblNgayBatDau.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgayBatDau.setForeground(new Color(53, 60, 68));
		lblNgayBatDau.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		cboNgayBatDau = new CustomComboBox();
		fillComboBoxTuNgayBatDau();
		cboNgayBatDau.setBorder(new LineBorder((Theme.dark), 2));
		
		JLabel lblNgayKetThuc = new JLabel("Ngày kết thúc");
		lblNgayKetThuc.setIcon(new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/icon-calendar-2.png")));
		lblNgayKetThuc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgayKetThuc.setForeground(new Color(53, 60, 68));
		lblNgayKetThuc.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		cboNgayKetThuc = new CustomComboBox();
		fillComboBoxDenNgayKetThuc();
		cboNgayKetThuc.setBorder(new LineBorder((Theme.dark), 2));
		
		GroupLayout gl_pnlTimKiemGioChieu = new GroupLayout(pnlTimKiemGioChieu);
		gl_pnlTimKiemGioChieu.setHorizontalGroup(
			gl_pnlTimKiemGioChieu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTimKiemGioChieu.createSequentialGroup()
					.addGap(8)
					.addComponent(lblNgayBatDau)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cboNgayBatDau, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNgayKetThuc)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cboNgayKetThuc, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(264, Short.MAX_VALUE))
		);
		gl_pnlTimKiemGioChieu.setVerticalGroup(
			gl_pnlTimKiemGioChieu.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlTimKiemGioChieu.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addGroup(gl_pnlTimKiemGioChieu.createParallelGroup(Alignment.LEADING)
						.addComponent(cboNgayKetThuc, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNgayKetThuc, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboNgayBatDau, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNgayBatDau, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pnlTimKiemGioChieu.setLayout(gl_pnlTimKiemGioChieu);
		
		JPanel pnlBangGioChieu = new JPanel();
		pnlBangGioChieu.setBackground(Color.WHITE);
		GroupLayout gl_pnlDoanhThuCuaGioChieu = new GroupLayout(pnlDoanhThuCuaGioChieu);
		gl_pnlDoanhThuCuaGioChieu.setHorizontalGroup(
			gl_pnlDoanhThuCuaGioChieu.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlTimKiemGioChieu, GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
				.addComponent(pnlBangGioChieu, GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
		);
		gl_pnlDoanhThuCuaGioChieu.setVerticalGroup(
			gl_pnlDoanhThuCuaGioChieu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDoanhThuCuaGioChieu.createSequentialGroup()
					.addComponent(pnlTimKiemGioChieu, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(pnlBangGioChieu, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JScrollPane scrollPane_2 = new CustomScrollPane();
		tblDoanhThuGioChieu = new JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
//				return columnEditables[column];
			}
		};
		tblDoanhThuGioChieu.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Giờ chiếu", "Số lượng vé bán ra", "Doanh thu"
			}
		));
		Theme.setDefaultTableFormat(tblDoanhThuGioChieu);
		scrollPane_2.setViewportView(tblDoanhThuGioChieu);
		
		GroupLayout gl_pnlBangGioChieu = new GroupLayout(pnlBangGioChieu);
		gl_pnlBangGioChieu.setHorizontalGroup(
			gl_pnlBangGioChieu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBangGioChieu.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlBangGioChieu.setVerticalGroup(
			gl_pnlBangGioChieu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBangGioChieu.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlBangGioChieu.setLayout(gl_pnlBangGioChieu);
		pnlDoanhThuCuaGioChieu.setLayout(gl_pnlDoanhThuCuaGioChieu);
		setLayout(groupLayout);
		
		fillPnlSoLuongs();
		loadTableP();
		loadTablePC();
		loadTableGC();
	}
	
	//----------------------------------------------------------------------------------------
	
	private void fillPnlSoLuongs() {
		List<Object[]> list = new ThongKeDAO().getThongKeSoLuong();
		Object[] row = list.get(0);
		
		lblSoLuongPhim.setText(row[0] + "");
		lblSoLuongLichChieu.setText(row[1] + "");
		lblSoLuongVe.setText(row[2] + "");
		lblSoLuongNhanVien.setText(row[3] + "");
	}
	
	private void refreshTab0() {
		fillPnlSoLuongs();
	}
	
	//----------------------------------------------------------------------------------------
	
	private void fillComboBoxNamP() {
		cboNamP.removeActionListener(loadTblDoanhThuPhimAction);
		
		DefaultComboBoxModel modelP = (DefaultComboBoxModel) cboNamP.getModel();
		modelP.removeAllElements();
		
		List<Ve> list = new VeDAO().select();
		for (Ve ve : list) {
			@SuppressWarnings("deprecation")
			int namP = ve.getNgayTao().getYear() + 1900;
			if (modelP.getIndexOf(namP) < 0) {
				modelP.addElement(namP);
			}
		}
		
		cboNamP.setSelectedIndex(0);
		cboNamP.addActionListener(loadTblDoanhThuPhimAction);
	}
	
	private void fillComboBoxPhim() {
		cboPhim.removeActionListener(loadTblDoanhThuPhimAction);
		
		DefaultComboBoxModel<Phim> modelP = (DefaultComboBoxModel<Phim>) cboPhim.getModel();
		modelP.removeAllElements();
		
		Phim phimDauTien = new Phim();
		phimDauTien.setMaPhim(0);
		phimDauTien.setTenPhim("Tất cả");
		modelP.addElement(phimDauTien);
		
		List<Phim> list = new PhimDAO().selectOrderByName(false);
		for (Phim phim : list) {
			modelP.addElement(phim);
		}
		
		cboPhim.setSelectedIndex(0);
		cboPhim.addActionListener(loadTblDoanhThuPhimAction);
	}
	
	private void loadTableP() {
		DefaultTableModel modelP = (DefaultTableModel) tblDoanhThuPhim.getModel();
		modelP.setRowCount(0);
		
		int namP = (int) cboNamP.getSelectedItem();
		int maPhim = ((Phim) cboPhim.getSelectedItem()).getMaPhim();
		List<Object[]> list = new ThongKeDAO().getDoanhThuPhim(namP, maPhim);
		for (Object[] row : list) {
			modelP.addRow(row);
		}
	}
	
	private void refreshTab1() {
		fillComboBoxNamP();
		fillComboBoxPhim();
		loadTableP();
	}
	
	//----------------------------------------------------------------------------------------
	
	private void fillComboBoxNamPC() {
		cboNamPC.removeActionListener(loadTblDoanhThuPhongChieuAction);
		
		DefaultComboBoxModel modelPC = (DefaultComboBoxModel) cboNamPC.getModel();
		modelPC.removeAllElements();
		
		List<Ve> list = new VeDAO().select();
		for (Ve ve : list) {
			@SuppressWarnings("deprecation")
			int namPC = ve.getNgayTao().getYear() + 1900;
			if (modelPC.getIndexOf(namPC) < 0) {
				modelPC.addElement(namPC);
			}
		}
		
		cboNamPC.setSelectedIndex(0);
		cboNamPC.addActionListener(loadTblDoanhThuPhongChieuAction);
	}
	
	private void fillComboBoxPhongChieu() {
		cboPhongChieu.removeActionListener(loadTblDoanhThuPhongChieuAction);
		
		DefaultComboBoxModel<PhongChieu> modelPC = (DefaultComboBoxModel<PhongChieu>) cboPhongChieu.getModel();
		modelPC.removeAllElements();
		
		PhongChieu phongChieuDauTien = new PhongChieu();
		phongChieuDauTien.setMaPhongChieu(0);
		phongChieuDauTien.setTenPhongChieu("Tất cả");
		modelPC.addElement(phongChieuDauTien);
		
		List<PhongChieu> list = new PhongChieuDAO().select();
		for (PhongChieu phongChieu : list) {
			modelPC.addElement(phongChieu);
		}
		
		cboPhongChieu.setSelectedIndex(0);
		cboPhongChieu.addActionListener(loadTblDoanhThuPhongChieuAction);
	}
	
	private void loadTablePC() {
		DefaultTableModel modelPC = (DefaultTableModel) tblDoanhThuPhongChieu.getModel();
		modelPC.setRowCount(0);
		
		int namPC = (int) cboNamPC.getSelectedItem();
		int maPhongChieu = ((PhongChieu) cboPhongChieu.getSelectedItem()).getMaPhongChieu();
		List<Object[]> list = new ThongKeDAO().getDoanhThuPhongChieu(namPC, maPhongChieu);
		for (Object[] row : list) {
			modelPC.addRow(row);
		}
	}
	
	private void refreshTab2() {
		fillComboBoxNamPC();
		fillComboBoxPhongChieu();
		loadTablePC();
	}
	
	//-----------------------------------------------------------------------------------
	
	private void fillComboBoxTuNgayBatDau() {
		cboNgayBatDau.removeActionListener(loadTblDoanhThuGioChieuAction);
		
		DefaultComboBoxModel modelGC = (DefaultComboBoxModel) cboNgayBatDau.getModel();
		modelGC.removeAllElements();
		
		List<Ve> list = new VeDAO().selectOrderByDate(false);
		for (Ve ve : list) {
			String ngayBatDau = DateHelper.toString(ve.getNgayTao(), "dd-MM-yyyy");
			if (modelGC.getIndexOf(ngayBatDau) < 0) {
				modelGC.addElement(ngayBatDau);
			}
		}
		
		cboNgayBatDau.setSelectedIndex(0);
		cboNgayBatDau.addActionListener(loadTblDoanhThuGioChieuAction);
	}
	
	private void fillComboBoxDenNgayKetThuc() {
		cboNgayKetThuc.removeActionListener(loadTblDoanhThuGioChieuAction);
		
		DefaultComboBoxModel modelGC = (DefaultComboBoxModel) cboNgayKetThuc.getModel();
		modelGC.removeAllElements();
		
		List<Ve> list = new VeDAO().selectOrderByDate(true);
		for (Ve ve : list) {
			String ngayKetThuc = DateHelper.toString(ve.getNgayTao(), "dd-MM-yyyy");
			if (modelGC.getIndexOf(ngayKetThuc) < 0) {
				modelGC.addElement(ngayKetThuc);
			}
		}
		
		cboNgayKetThuc.setSelectedIndex(0);
		cboNgayKetThuc.addActionListener(loadTblDoanhThuGioChieuAction);
	}
	
	private void loadTableGC() {
		DefaultTableModel modelPC = (DefaultTableModel) tblDoanhThuGioChieu.getModel();
		modelPC.setRowCount(0);
		
		String ngayBatDau = (String) cboNgayBatDau.getSelectedItem();
		String ngayKetThuc = (String) cboNgayKetThuc.getSelectedItem();
		List<Object[]> list = new ThongKeDAO().getDoanhThuGioChieu(DateHelper.toDate(ngayBatDau, "dd-MM-yyyy"), DateHelper.toDate(ngayKetThuc,  "dd-MM-yyyy"));
		for (Object[] row : list) {
			modelPC.addRow(row);
		}
	}
	
	private void refreshTab3() {
		fillComboBoxTuNgayBatDau();
		fillComboBoxDenNgayKetThuc();
		loadTableGC();
	}
	
	public void refreshAll() {
		refreshTab0();
		refreshTab1();
		refreshTab2();
		refreshTab3();
	}
}
