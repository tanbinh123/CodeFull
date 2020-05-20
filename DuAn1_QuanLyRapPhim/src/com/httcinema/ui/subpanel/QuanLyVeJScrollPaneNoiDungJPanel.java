package com.httcinema.ui.subpanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.httcinema.custom_jcomponents.CustomComboBox;
import com.httcinema.custom_jcomponents.CustomTableStyler;
import com.httcinema.custom_jcomponents.CustomScrollPane;
import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.dao.GiaVeDAO;
import com.httcinema.dao.VeDAO;
import com.httcinema.helper.DateHelper;
import com.httcinema.helper.DialogHelper;
import com.httcinema.helper.ShareHelper;
import com.httcinema.model.GiaVe;
import com.httcinema.model.Ve;
import com.httcinema.ui.ChaoJPanel;
import com.httcinema.ui.ManHinhChinhJFrame;

@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
public class QuanLyVeJScrollPaneNoiDungJPanel extends JPanel {

	private JTable tblDanhSach;
	
	private JComboBox cboTu;
	private JComboBox cboDen;
	private CustomComboBox cboLoaiVe;
	
	private JLabel lblDoanhThu;
	
	private double doanhThu;
	
	/**
	 * Create the panel.
	 */
	public QuanLyVeJScrollPaneNoiDungJPanel() {
		setBackground(Color.WHITE);
		
		JPanel pnlBang = new JPanel();
		pnlBang.setBackground(Color.WHITE);
		
		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(this);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnlTimKiem, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
						.addComponent(pnlBang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlTimKiem, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(pnlBang, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		CustomScrollPane scrollPane = new CustomScrollPane();
		tblDanhSach = new JTable() {
			boolean[] columnEditables = new boolean[] {
					false,
					false,
					false,
					false,
					false,
//					false,
					false,
					true
					};

			@Override
			public boolean isCellEditable(int row, int column) {
//				return false;
				return columnEditables[column];
			}
		};
		tblDanhSach.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent evt) {
				if (tblDanhSach.columnAtPoint(evt.getPoint()) == tblDanhSach.getColumnCount() - 1) {
					tblDanhSach.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				} else {
					tblDanhSach.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				}
			}
		});
		tblDanhSach.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Mã vé",
						"Mã lịch chiếu",
						"Mã ghế",
						"Tên đăng nhập",
						"Ngày tạo",
//						"Mã giá vé",
						"Giá vé",
						""
						}));
		Theme.setDefaultTableFormat(tblDanhSach);
		scrollPane.setViewportView(tblDanhSach);
		GroupLayout gl_pnlBang = new GroupLayout(pnlBang);
		gl_pnlBang.setHorizontalGroup(
			gl_pnlBang.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pnlBang.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlBang.setVerticalGroup(
			gl_pnlBang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBang.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlBang.setLayout(gl_pnlBang);
		
		JLabel lblTu = new JLabel("Ngày tạo từ");
		lblTu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTu.setForeground(Theme.dark);
		
		JLabel lblDen = new JLabel("đến");
		lblDen.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDen.setForeground(Theme.dark);
		
		JLabel lblLoaiVe = new JLabel("Loại vé");
		lblLoaiVe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoaiVe.setForeground(Theme.dark);
		
		cboTu = new CustomComboBox();
		cboTu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboTu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(true);
			}
		});
		cboTu.setBorder(new LineBorder(new Color(53, 60, 68), 2));
		
		cboDen = new CustomComboBox();
		cboDen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboDen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(true);
			}
		});
		cboDen.setBorder(new LineBorder(new Color(53, 60, 68), 2));
		
		cboLoaiVe = new CustomComboBox();
		cboLoaiVe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboLoaiVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(true);
			}
		});
		cboLoaiVe.setBorder(new LineBorder(new Color(53, 60, 68), 2));
		
		lblDoanhThu = new JLabel();
		lblDoanhThu.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblDoanhThu.setIcon(new ImageIcon(QuanLyVeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/icon-revenue.png")));
		lblDoanhThu.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDoanhThu.setForeground(Theme.dark);
		
		GroupLayout gl_pnlTimKiem = new GroupLayout(pnlTimKiem);
		gl_pnlTimKiem.setHorizontalGroup(
			gl_pnlTimKiem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTimKiem.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlTimKiem.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDoanhThu, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
						.addGroup(gl_pnlTimKiem.createSequentialGroup()
							.addComponent(lblTu)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cboTu, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblDen)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cboDen, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblLoaiVe)
							.addGap(4)
							.addComponent(cboLoaiVe, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pnlTimKiem.setVerticalGroup(
			gl_pnlTimKiem.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlTimKiem.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDoanhThu, GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_pnlTimKiem.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnlTimKiem.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblLoaiVe, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblDen, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
							.addComponent(cboDen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cboTu, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
							.addComponent(lblTu, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
						.addComponent(cboLoaiVe, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pnlTimKiem.setLayout(gl_pnlTimKiem);
		setLayout(gl_panel);
		
		fillComboBoxTuNgayBatDau();
		fillComboBoxDenNgayKetThuc();
		fillComboBoxLoaiVe();
		loadTable(false);
	}

	private void fillComboBoxTuNgayBatDau() {
		DefaultComboBoxModel model = (DefaultComboBoxModel) cboTu.getModel();
		model.removeAllElements();
		
		List<Ve> list = new VeDAO().selectOrderByDate(false);
		for (Ve ve : list) {
			String ngayBatDau = DateHelper.toString(ve.getNgayTao(), "dd-MM-yyyy");
			if (model.getIndexOf(ngayBatDau) < 0) {
				model.addElement(ngayBatDau);
			}
		}
		cboTu.setSelectedIndex(0);
	}
	
	private void fillComboBoxDenNgayKetThuc() {
		DefaultComboBoxModel model = (DefaultComboBoxModel) cboDen.getModel();
		model.removeAllElements();
		
		List<Ve> list = new VeDAO().selectOrderByDate(true);
		for (Ve ve : list) {
			String ngayKetThuc = DateHelper.toString(ve.getNgayTao(), "dd-MM-yyyy");
			if (model.getIndexOf(ngayKetThuc) < 0) {
				model.addElement(ngayKetThuc);
			}
		}
		cboDen.setSelectedIndex(0);
	}
	
	private void fillComboBoxLoaiVe() {
		DefaultComboBoxModel model = (DefaultComboBoxModel) cboLoaiVe.getModel();
		model.removeAllElements();
		
		GiaVe giaVeDauTien = new GiaVe();
		giaVeDauTien.setMaGiaVe(0);
		giaVeDauTien.setMoTa("Tất cả");
		model.addElement(giaVeDauTien);
		
		List<GiaVe> list = new GiaVeDAO().select();
		for (GiaVe loaiVe : list) {
			model.addElement(loaiVe);
		}
		cboLoaiVe.setSelectedIndex(0);
	}
	
	private void loadTable(boolean timKiemChiTiet) {
		DefaultTableModel model = (DefaultTableModel) tblDanhSach.getModel();
        model.setRowCount(0);
        doanhThu = 0;
        
        try {
        	List<Ve> list;
        	
        	if (timKiemChiTiet) {
        		Date ngayBatDau = DateHelper.toDate((String) cboTu.getSelectedItem(), "dd-MM-yyyy");
        		Date ngayKetThuc = DateHelper.toDate((String) cboDen.getSelectedItem(), "dd-MM-yyyy");
        		int maGiaVe = (GiaVe) cboLoaiVe.getSelectedItem() == null ? 0 :((GiaVe) cboLoaiVe.getSelectedItem()).getMaGiaVe();
        		list = new VeDAO().selectByDate(ngayBatDau, ngayKetThuc, maGiaVe);
            } else {
        		list = new VeDAO().selectOrderByDate(true);
        	}
        	
            for (Ve ve : list) {
                Object[] row = {
                		ve.getMaVe(),
                		ve.getMaLichChieu(),
                		ve.getMaGhe(),
                		ve.getTenDangNhap(),
                		DateHelper.toString(ve.getNgayTao(), "dd-MM-yyyy (EEE)"),
//                		ve.getMaGiaVe(),
                		new DecimalFormat("###,###,###,###,###,### VND").format(ve.getGiaVe()),
                		new ImageIcon(ChaoJPanel.class.getResource("/com/httcinema/icon/action-edit.png"))
                };
                model.addRow(row);
                doanhThu += ve.getGiaVe();
            }
            
            // hiện doanh thu
            String tongTien = new DecimalFormat("###,###,###,###,###,### VND").format(doanhThu);
            lblDoanhThu.setText("<html><strong>DOANH THU:</strong> " + tongTien + "</html>");
            
			// biến 2 cột cuối cùng thành hai nút xóa và cập nhật
			new CustomTableStyler(tblDanhSach, edit, tblDanhSach.getColumnCount() - 1, Theme.success, Theme.darkSuccess);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * this object is for deleting data from database
	 */
	Action delete = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			if (DialogHelper.confirm(ManHinhChinhJFrame.frameManHinhChinh, "Bạn thực sự muốn xóa?")) {
				int modelRow = Integer.valueOf(e.getActionCommand());
				
				String primaryKey = String.valueOf(tblDanhSach.getValueAt(modelRow, 0));
				try {
					new VeDAO().delete(primaryKey);
					ShareHelper.refreshAllTable();
					DialogHelper.success(ManHinhChinhJFrame.frameManHinhChinh, "Xóa thành công!");
				} catch (HeadlessException ex) {
					DialogHelper.error(ManHinhChinhJFrame.frameManHinhChinh, "Xóa thất bại!");
				}
			}
		}
	};
	
	/**
	 * this object is for action in edit button
	 */
	Action edit = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			int modelRow = Integer.valueOf(e.getActionCommand());
			
			int primaryKey = (int) tblDanhSach.getValueAt(modelRow, 0);
			Ve ve = new VeDAO().findById(primaryKey + "");
			
			QuanLyVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog.showDialog(ManHinhChinhJFrame.frameManHinhChinh, ve, QuanLyVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog.XEM_CHI_TIET);
		}
	};
	
	public void refreshAll() {
		fillComboBoxTuNgayBatDau();
		fillComboBoxDenNgayKetThuc();
		fillComboBoxLoaiVe();
		loadTable(false);
	}
}
