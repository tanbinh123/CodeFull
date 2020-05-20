package com.httcinema.ui.subpanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.httcinema.custom_jcomponents.CustomButton;
import com.httcinema.custom_jcomponents.CustomComboBox;
import com.httcinema.custom_jcomponents.CustomDialog;
import com.httcinema.custom_jcomponents.CustomTextField;
import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.dao.LichChieuDAO;
import com.httcinema.dao.PhimDAO;
import com.httcinema.dao.PhongChieuDAO;
import com.httcinema.helper.DateHelper;
import com.httcinema.helper.DialogHelper;
import com.httcinema.helper.ShareHelper;
import com.httcinema.helper.ValidationHelper;
import com.httcinema.model.LichChieu;
import com.httcinema.model.Phim;
import com.httcinema.model.PhongChieu;

@SuppressWarnings("serial")
public class QuanLyLichChieuJScrollPaneNoiDungJPanelThongTinChiTietJDialog extends CustomDialog {

	public final static int THEM = 1;
	public final static int CAP_NHAT = 2;
	private int trangThai;
	
	private JDialog thisDialog;
	
	private JLabel lblTieuDe;
	
	private CustomTextField txtMaLichChieu;
	private CustomComboBox<Phim> cboPhim;
	private CustomComboBox<PhongChieu> cboPhongChieu;
	private CustomTextField txtNgayChieu;
	private CustomComboBox<Time> cboGioChieu;

	private JLabel lblHinh;
	private JLabel lblTenPhim;
	private CustomButton btnDong;
	private CustomButton btnThaoTac;
	
	public static void showDialog(Component owner, LichChieu lichChieu, int trangThai) {
		QuanLyLichChieuJScrollPaneNoiDungJPanelThongTinChiTietJDialog dialog;
		if (owner instanceof JDialog) {
			dialog = new QuanLyLichChieuJScrollPaneNoiDungJPanelThongTinChiTietJDialog((Dialog) owner);
		}
		else {
			dialog = new QuanLyLichChieuJScrollPaneNoiDungJPanelThongTinChiTietJDialog((Frame) owner);
		}
		
		dialog.init(lichChieu, trangThai);
		dialog.setLocationRelativeTo(owner);
		dialog.fadeIn(dialog);
	}

	public QuanLyLichChieuJScrollPaneNoiDungJPanelThongTinChiTietJDialog(Frame owner) {
		super(owner);
	}
	
	public QuanLyLichChieuJScrollPaneNoiDungJPanelThongTinChiTietJDialog(Dialog owner) {
		super(owner);
	}

	public QuanLyLichChieuJScrollPaneNoiDungJPanelThongTinChiTietJDialog() {
		setUndecorated(true);
		init(null, 1);
	}
	
	/**
	 * Create the dialog.
	 */
	public void init(LichChieu lichChieu, int trangThai) {
		this.thisDialog = this;
		this.trangThai = trangThai;
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 800, 550);
		getContentPane().setLayout(null);
		
		JPanel pnlChinh = new JPanel();
		pnlChinh.setBorder(new LineBorder(Color.WHITE));
		pnlChinh.setBackground(Theme.dark);
		pnlChinh.setBounds(0, 0, 800, 550);
		getContentPane().add(pnlChinh);
		pnlChinh.setLayout(null);
		
		lblTieuDe = new JLabel("");
		lblTieuDe.setForeground(Theme.white);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setBounds(10, 11, 780, 30);
		pnlChinh.add(lblTieuDe);
		
		JPanel pnlForm = new JPanel();
		pnlForm.setBackground(Color.WHITE);
		pnlForm.setBorder(new LineBorder(Theme.green, 0));
		pnlForm.setBounds(10, 94, 780, 389);
		pnlChinh.add(pnlForm);
		pnlForm.setLayout(null);
		
		JPanel pnlTrai = new JPanel();
		pnlTrai.setBounds(10, 11, 258, 367);
		pnlForm.add(pnlTrai);
		pnlTrai.setBackground(Theme.dark);
		pnlTrai.setLayout(null);
		
		lblHinh = new JLabel("");
		lblHinh.setOpaque(true);
		lblHinh.setBackground(Theme.dark);
		lblHinh.setBounds(0, 0, 258, 315);
		pnlTrai.add(lblHinh);
		lblHinh.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblTenPhim = new JLabel("Poster");
		lblTenPhim.setBounds(10, 326, 238, 30);
		pnlTrai.add(lblTenPhim);
		lblTenPhim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenPhim.setForeground(Color.WHITE);
		lblTenPhim.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel pnlPhai = new JPanel();
		pnlPhai.setBackground(Color.WHITE);
		pnlPhai.setBounds(278, 11, 492, 367);
		pnlForm.add(pnlPhai);
		pnlPhai.setLayout(null);
		
		JLabel lblMaLichChieu = new JLabel("Mã lịch chiếu");
		lblMaLichChieu.setForeground(new Color(53, 60, 68));
		lblMaLichChieu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaLichChieu.setBounds(10, 11, 150, 30);
		pnlPhai.add(lblMaLichChieu);
		
		JLabel lblPhim = new JLabel("Phim");
		lblPhim.setForeground(new Color(53, 60, 68));
		lblPhim.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhim.setBounds(10, 52, 150, 30);
		pnlPhai.add(lblPhim);
		
		JLabel lblPhongChieu = new JLabel("Phòng chiếu");
		lblPhongChieu.setForeground(new Color(53, 60, 68));
		lblPhongChieu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhongChieu.setBounds(10, 93, 150, 30);
		pnlPhai.add(lblPhongChieu);
		
		JLabel lblNgayChieu = new JLabel("Ngày chiếu");
		lblNgayChieu.setForeground(new Color(53, 60, 68));
		lblNgayChieu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgayChieu.setBounds(10, 134, 150, 30);
		pnlPhai.add(lblNgayChieu);
		
		JLabel lblGioChieu = new JLabel("Giờ chiếu");
		lblGioChieu.setForeground(new Color(53, 60, 68));
		lblGioChieu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGioChieu.setBounds(10, 175, 150, 30);
		pnlPhai.add(lblGioChieu);
		
		txtMaLichChieu = new CustomTextField();
		txtMaLichChieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaLichChieu.setBounds(170, 11, 312, 30);
		pnlPhai.add(txtMaLichChieu);
		txtMaLichChieu.setColumns(10);
		
		cboPhim = new CustomComboBox<Phim>();
		cboPhim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboPhim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Phim phim = (Phim) cboPhim.getSelectedItem();
				
				lblHinh.setIcon(new ImageIcon(ShareHelper.readMovieImage(phim, lblHinh.getWidth(), lblHinh.getHeight())));
				lblHinh.setToolTipText(phim.getHinh());
			}
		});
		cboPhim.setBounds(170, 52, 312, 30);
		pnlPhai.add(cboPhim);
		
		cboPhongChieu = new CustomComboBox<PhongChieu>();
		cboPhongChieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboPhongChieu.setBounds(170, 93, 312, 30);
		pnlPhai.add(cboPhongChieu);
		
		txtNgayChieu = new CustomTextField(10);
		txtNgayChieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNgayChieu.setBounds(170, 134, 150, 30);
		pnlPhai.add(txtNgayChieu);
		txtNgayChieu.setColumns(10);
		
		cboGioChieu = new CustomComboBox<Time>();
		cboGioChieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboGioChieu.setBounds(170, 175, 312, 30);
		pnlPhai.add(cboGioChieu);
		
		lblChuThichNgay = new JLabel("(dd-MM-yyyy)");
		lblChuThichNgay.setForeground(Theme.dark);
		lblChuThichNgay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChuThichNgay.setBounds(330, 134, 152, 30);
		pnlPhai.add(lblChuThichNgay);
		
		btnDong = new CustomButton("Đóng");
		Theme.setDefaultButtonFormat(btnDong);
		btnDong.setForeground(Color.WHITE);
		btnDong.setBounds(10, 494, 125, 45);
		btnDong.setBackground(new Color(36, 36, 36));
		btnDong.setHoverBackground(Color.BLACK);
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fadeOut();
			}
		});
		pnlChinh.add(btnDong);
		
		btnThaoTac = new CustomButton("");
		Theme.setDefaultButtonFormat(btnThaoTac);
		btnThaoTac.setBounds(615, 494, 175, 45);
		btnThaoTac.setBackground(new Color(13, 94, 94));
		btnThaoTac.setHoverBackground(Theme.green);
		btnThaoTac.setFont(new Font("Tahoma", Font.BOLD, 17));
		pnlChinh.add(btnThaoTac);
		
		fillToComboBoxPhim();
		fillToComboBoxPhongChieu();
		fillToComboBoxGioChieu();

		setState(lichChieu);
	}
	
	private void setState(LichChieu model) {
		if (trangThai == THEM) {
			lblTieuDe.setText("THÊM LỊCH CHIẾU MỚI");
			txtMaLichChieu.setEditable(false);
			txtNgayChieu.setText(DateHelper.toString(DateHelper.add(1), "dd-MM-yyyy"));
			btnThaoTac.setText("Thêm");
			btnThaoTac.addActionListener(insertListener);
			clear();
		}
		else if (trangThai == CAP_NHAT) {
			lblTieuDe.setText("XEM THÔNG TIN CHI TIẾT LỊCH CHIẾU");
			txtMaLichChieu.setEditable(false);
			cboPhim.setEnabled(false);
			cboPhongChieu.setEnabled(false);
			txtNgayChieu.setEditable(false);
			cboGioChieu.setEnabled(false);
			
			btnThaoTac.setText("Cập nhật");
			btnThaoTac.addActionListener(updateListener);
			btnThaoTac.setVisible(false);
			setModel(model);
		}
	}
	
	private void clear() {
		txtMaLichChieu.setText("");
		cboPhim.setSelectedIndex(0);
		cboPhongChieu.setSelectedIndex(0);
//		txtNgayChieu.setText(DateHelper.toString(DateHelper.now()));
		cboGioChieu.setSelectedIndex(0);
	}
	
	private void setModel(LichChieu model) {
		Phim phim = new PhimDAO().findById(model.getMaPhim() + "");
		PhongChieu phongChieu = new PhongChieuDAO().findById(model.getMaPhongChieu() + "");
		
		txtMaLichChieu.setText(model.getMaLichChieu() + "");
		cboPhim.setSelectedItem(phim);
		cboPhongChieu.setSelectedItem(phongChieu);
		txtNgayChieu.setText(DateHelper.toString(model.getNgayChieu(), "dd-MM-yyyy"));
		cboGioChieu.setSelectedItem(model.getGioChieu() + "");
	}
	
	private LichChieu getModel() {
		LichChieu model = new LichChieu();
		
		if (txtMaLichChieu.getText().trim().equals("") == false) {
			model.setMaLichChieu(Integer.parseInt(txtMaLichChieu.getText().trim()));
		}
		model.setMaPhim( ((Phim) cboPhim.getSelectedItem()).getMaPhim() );
		model.setMaPhongChieu(((PhongChieu) cboPhongChieu.getSelectedItem()).getMaPhongChieu());
		model.setNgayChieu(DateHelper.toDate(txtNgayChieu.getText().trim(), "dd-MM-yyyy"));
		model.setGioChieu((Time)(cboGioChieu.getSelectedItem()));
		return model;
	}
	
	/**
	 * this method is for inserting data into database
	 */
	private void insert() {
		LichChieu model = getModel();
		
		try {
			new LichChieuDAO().insert(model);
			ShareHelper.refreshAllTable();
			clear();
			DialogHelper.success(this, "Đã thêm thành công!");
		} catch (Exception e) {
			String erroMsg = e.getMessage().substring(e.getMessage().indexOf(" "), e.getMessage().length()).trim();
			DialogHelper.error(this, "Trùng với lịch chiếu có mã " + erroMsg);
			ShareHelper.pnlQuanLyLichChieu.getTxtTimKiem().setText(erroMsg);
		}
	}
	
	/**
	 * this method is for updating data from database
	 */
	private void update() {
		LichChieu model = getModel();
		
		try {
			new LichChieuDAO().update(model);
			setModel(model);
			DialogHelper.success(this, "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			DialogHelper.error(this, "Cập nhật thất bại!");
		}
	}
	
	ActionListener insertListener = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if (isValidData() == false) {
				return;
			}
			
			if (DialogHelper.confirm(thisDialog, "Tiến hành thêm?")) {
				insert();
			}
		}
	};
	
	ActionListener updateListener = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if (isValidData() == false) {
				return;
			}
			
			if (DialogHelper.confirm(thisDialog, "Tiến hành cập nhật?")) {
				update();
			}
		}
	};
	private JLabel lblChuThichNgay;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void fillToComboBoxPhim() {
		DefaultComboBoxModel model = (DefaultComboBoxModel) cboPhim.getModel();
		model.removeAllElements();
		
		List<Phim> list = new PhimDAO().selectOrderByName(false);
		for (Phim phim : list) {
			model.addElement(phim);
		}
		cboPhim.setSelectedIndex(0);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void fillToComboBoxPhongChieu() {
		DefaultComboBoxModel model = (DefaultComboBoxModel) cboPhongChieu.getModel();
		model.removeAllElements();
		
		List<PhongChieu> list = new PhongChieuDAO().select();
		for (PhongChieu phongChieu : list) {
			model.addElement(phongChieu);
		}
		cboPhongChieu.setSelectedIndex(0);
	}
	
	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	private void fillToComboBoxGioChieu() {
		DefaultComboBoxModel model = (DefaultComboBoxModel) cboGioChieu.getModel();
		model.removeAllElements();
		
		Time[] list = {new Time(8, 30, 00), new Time(11, 00, 00), new Time(13, 30, 00), new Time(15, 00, 00), new Time(17, 30, 00), new Time(20, 00, 00), new Time(22, 30, 00)};
		for (Time gc : list) {
			model.addElement(gc);
		}
		cboGioChieu.setSelectedIndex(0);
	}
	
	/**
	 * check for validation of data
	 * */
	private boolean isValidData() {
		//-----
		if (ValidationHelper.isEmpty(txtNgayChieu)) {
			DialogHelper.warning(this, "Ngày sinh không được trống");
			txtNgayChieu.requestFocus();
			return false;
		}
		
		if (DateHelper.toDate(txtNgayChieu.getText().trim(), "dd-MM-yyyy") == null) {
			DialogHelper.warning(this, "Định dạng ngày phải là dd-MM-yyyy");
			txtNgayChieu.requestFocus();
			return false;
		}
		
		if ((DateHelper.toDate(txtNgayChieu.getText().trim(), "dd-MM-yyyy").compareTo(DateHelper.now())) < 0) {
			DialogHelper.warning(this, "Ngày chiếu phải sau ngày hôm nay");
			txtNgayChieu.requestFocus();
			return false;
		}
		
		return true;
	}
}
