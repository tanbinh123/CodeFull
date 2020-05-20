package com.httcinema.ui.subpanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.httcinema.custom_jcomponents.CustomButton;
import com.httcinema.custom_jcomponents.CustomComboBox;
import com.httcinema.custom_jcomponents.CustomTableStyler;
import com.httcinema.custom_jcomponents.CustomScrollPane;
import com.httcinema.custom_jcomponents.CustomTextField;
import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.dao.LichChieuDAO;
import com.httcinema.dao.PhimDAO;
import com.httcinema.helper.DateHelper;
import com.httcinema.helper.DialogHelper;
import com.httcinema.helper.ShareHelper;
import com.httcinema.model.LichChieu;
import com.httcinema.model.Phim;
import com.httcinema.ui.ChaoJPanel;
import com.httcinema.ui.ManHinhChinhJFrame;

@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
public class QuanLyLichChieuJScrollPaneNoiDungJPanel extends JPanel {
	
	private JPanel pnlBang;
	private JTable tblDanhSach;
	private JLabel lblTimKiem;
	private CustomTextField txtTimKiem;
	
	public CustomTextField getTxtTimKiem() {
		return txtTimKiem;
	}

	public void setTxtTimKiem(CustomTextField txtTimKiem) {
		this.txtTimKiem = txtTimKiem;
	}
	
	private CustomComboBox cboPhim;
	private CustomComboBox cboNgay;
	private CustomComboBox cboGio;
	
	private CustomButton btnThem;

	/**
	 * Create the panel.
	 */
	public QuanLyLichChieuJScrollPaneNoiDungJPanel() {
		setBackground(Color.WHITE);
		
		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(Color.WHITE);
		
		pnlBang = new JPanel();
		pnlBang.setBackground(Color.WHITE);
		
		lblTimKiem = new JLabel("");
		lblTimKiem.setIcon(new ImageIcon(QuanLyGiaVeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/action-search.png")));
		
		txtTimKiem = new CustomTextField();
		txtTimKiem.setBorder(new LineBorder(new Color(46, 158, 158), 2));
		txtTimKiem.setColumns(10);
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimKiem.setPlaceholder("Tìm mã lịch chiếu...");
		txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				warn();
			}

			public void removeUpdate(DocumentEvent e) {
				warn();
			}

			public void insertUpdate(DocumentEvent e) {
				warn();
			}

			public void warn() {
				loadTable(true);
			}
		});
		
		btnThem = new CustomButton("Thêm");
		btnThem.setIcon(new ImageIcon(QuanLyGiaVeJScrollPaneNoiDungJPanel.class.getResource("/com/httcinema/icon/action-add.png")));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyLichChieuJScrollPaneNoiDungJPanelThongTinChiTietJDialog.showDialog(ManHinhChinhJFrame.frameManHinhChinh, null, QuanLyLichChieuJScrollPaneNoiDungJPanelThongTinChiTietJDialog.THEM);
			}
		});
		Theme.setDefaultButtonFormat(btnThem);
		btnThem.setBackground(Theme.green);
		btnThem.setHoverBackground(Theme.darkGreen);
		
		cboPhim = new CustomComboBox();
		cboPhim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboPhim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(true);
			}
		});
		cboPhim.setBorder(new LineBorder(new Color(53, 60, 68), 2));
		
		cboNgay = new CustomComboBox();
		cboNgay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboNgay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(true);
			}
		});
		cboNgay.setBorder(new LineBorder(new Color(53, 60, 68), 2));
		
		cboGio = new CustomComboBox();
		cboGio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboGio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(true);
			}
		});
		cboGio.setBorder(new LineBorder(new Color(53, 60, 68), 2));
		
		JLabel lblNgay = new JLabel("Ngày");
		lblNgay.setForeground(Theme.dark);
		lblNgay.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblGio = new JLabel("Giờ");
		lblGio.setForeground(Theme.dark);
		lblGio.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblPhim = new JLabel("Phim");
		lblPhim.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		GroupLayout gl_pnlTimKiem = new GroupLayout(pnlTimKiem);
		gl_pnlTimKiem.setHorizontalGroup(
			gl_pnlTimKiem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTimKiem.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTimKiem, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPhim)
					.addGap(4)
					.addComponent(cboPhim, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNgay)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cboNgay, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblGio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cboGio, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_pnlTimKiem.setVerticalGroup(
			gl_pnlTimKiem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTimKiem.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlTimKiem.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlTimKiem.createSequentialGroup()
							.addComponent(cboPhim, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_pnlTimKiem.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnlTimKiem.createSequentialGroup()
								.addComponent(lblPhim, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_pnlTimKiem.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlTimKiem.createSequentialGroup()
									.addComponent(lblGio, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(gl_pnlTimKiem.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnlTimKiem.createSequentialGroup()
										.addComponent(lblNgay, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addGroup(gl_pnlTimKiem.createSequentialGroup()
										.addGroup(gl_pnlTimKiem.createParallelGroup(Alignment.LEADING)
											.addComponent(txtTimKiem, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
											.addComponent(cboGio, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
											.addComponent(cboNgay, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_pnlTimKiem.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblTimKiem, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
												.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)))
										.addGap(20)))))))
		);
		pnlTimKiem.setLayout(gl_pnlTimKiem);
		
		GroupLayout gl_panel = new GroupLayout(this);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnlTimKiem, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
						.addComponent(pnlBang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlTimKiem, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(pnlBang, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
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
					true,
					true,
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
				if (tblDanhSach.columnAtPoint(evt.getPoint()) == tblDanhSach.getColumnCount() - 1 || tblDanhSach.columnAtPoint(evt.getPoint()) == tblDanhSach.getColumnCount() - 2) {
					tblDanhSach.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				} else {
					tblDanhSach.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				}
			}
		});
		tblDanhSach.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Mã lịch chiếu",
						"Mã phim",
						"Mã phòng",
						"Ngày chiếu",
						"Giờ chiếu",
						"",
						""
						}));
		Theme.setDefaultTableFormat(tblDanhSach);
		scrollPane.setViewportView(tblDanhSach);
		
		GroupLayout gl_pnlBang = new GroupLayout(pnlBang);
		gl_pnlBang.setHorizontalGroup(
			gl_pnlBang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBang.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_pnlBang.setVerticalGroup(
			gl_pnlBang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBang.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
					.addGap(11))
		);
		pnlBang.setLayout(gl_pnlBang);
		setLayout(gl_panel);
		
		fillComboBoxPhim();
		fillComboBoxNgay();
		fillComboBoxGio();
		loadTable(false);
	}

	private void fillComboBoxPhim() {
		DefaultComboBoxModel model = (DefaultComboBoxModel) cboPhim.getModel();
		model.removeAllElements();
		
		Phim phimDauTien = new Phim();
		phimDauTien.setMaPhim(0);
		phimDauTien.setTenPhim("Tất cả");
		model.addElement(phimDauTien);
		
		List<Phim> list = new PhimDAO().selectOrderByName(false);
		for (Phim phim : list) {
			model.addElement(phim);
		}
		cboPhim.setSelectedIndex(0);
	}
	
	private void fillComboBoxNgay() {
		DefaultComboBoxModel model = (DefaultComboBoxModel) cboNgay.getModel();
		model.removeAllElements();
		
		String ngayDauTien = "Tất cả";
		model.addElement(ngayDauTien);
		
		List<Date> list = new LichChieuDAO().selectOrderByDate(false);
		for (Date ngay : list) {
			String ngayString = DateHelper.toString(ngay, "dd-MM-yyyy");
			model.addElement(ngayString);
		}
		cboNgay.setSelectedIndex(0);
	}
	
	private void fillComboBoxGio() {
		DefaultComboBoxModel model = (DefaultComboBoxModel) cboGio.getModel();
		model.removeAllElements();
		
		String[] list = {"Tất cả", "08:30", "11:00", "13:30", "15:00", "17:30", "20:00", "22:30"};
		for (String gio : list) {
			model.addElement(gio);
		}
		cboGio.setSelectedIndex(0);
	}
	
	private void loadTable(boolean timKiemChiTiet) {
		DefaultTableModel model = (DefaultTableModel) tblDanhSach.getModel();
		model.setRowCount(0);
		
        try {
        	List<LichChieu> list;
        	String keyword = txtTimKiem.getText().trim();
        	
        	if (timKiemChiTiet) {
        		int maPhim = (Phim) cboPhim.getSelectedItem() == null ? 0 : ((Phim) cboPhim.getSelectedItem()).getMaPhim();
        		String ngay = cboNgay.getSelectedIndex() == 0 ? "" : DateHelper.toString(DateHelper.toDate((String) cboNgay.getSelectedItem(), "dd-MM-yyyy"), "yyyy-MM-dd");
        		String gio = cboGio.getSelectedIndex() == 0 ? "" : (String) cboGio.getSelectedItem();
        		list = new LichChieuDAO().selectByIdMovieDateTime(keyword, maPhim, ngay, gio);
            } else {
        		list = new LichChieuDAO().selectByKeyword(keyword);
        	}
			
            for (LichChieu lichChieu : list) {
                Object[] row = {
            		lichChieu.getMaLichChieu(),
            		lichChieu.getMaPhim(),
            		lichChieu.getMaPhongChieu(),
            		DateHelper.toString(lichChieu.getNgayChieu(), "dd-MM-yyyy (EEE)"),
            		DateHelper.toString(lichChieu.getGioChieu(), "HH:mm"),
            		new ImageIcon(ChaoJPanel.class.getResource("/com/httcinema/icon/action-delete.png")),
            		new ImageIcon(ChaoJPanel.class.getResource("/com/httcinema/icon/action-edit.png"))
		        };
		        model.addRow(row);
            }
            
            // biến 2 cột cuối cùng thành hai nút xóa và cập nhật
            new CustomTableStyler(tblDanhSach, delete, tblDanhSach.getColumnCount() - 2, Theme.danger, Theme.darkDanger);
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
			int modelRow = Integer.valueOf(e.getActionCommand());
			
			String primaryKey = String.valueOf(tblDanhSach.getValueAt(modelRow, 0));
			if (new LichChieuDAO().findInTicket(primaryKey) != null) {
				DialogHelper.error(ManHinhChinhJFrame.frameManHinhChinh, "Lịch chiếu này đã có người mua vé!");
				return;
			}
			
			if (DialogHelper.confirm(ManHinhChinhJFrame.frameManHinhChinh, "Bạn thực sự muốn xóa?")) {
				try {
					new LichChieuDAO().delete(primaryKey);
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
			LichChieu LichChieu = new LichChieuDAO().findById(primaryKey + "");
			
			QuanLyLichChieuJScrollPaneNoiDungJPanelThongTinChiTietJDialog.showDialog(ManHinhChinhJFrame.frameManHinhChinh, LichChieu, QuanLyLichChieuJScrollPaneNoiDungJPanelThongTinChiTietJDialog.CAP_NHAT);
		}
	};
	
	public void refreshAll() {
		fillComboBoxPhim();
		fillComboBoxNgay();
		fillComboBoxGio();
		loadTable(false);
	}
}
