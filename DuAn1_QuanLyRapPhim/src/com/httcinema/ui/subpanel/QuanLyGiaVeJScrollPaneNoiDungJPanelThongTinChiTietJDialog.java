package com.httcinema.ui.subpanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.httcinema.custom_jcomponents.CustomButton;
import com.httcinema.custom_jcomponents.CustomDialog;
import com.httcinema.custom_jcomponents.CustomScrollPane;
import com.httcinema.custom_jcomponents.CustomTextArea;
import com.httcinema.custom_jcomponents.CustomTextField;
import com.httcinema.custom_jcomponents.JNumberTextField;
import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.dao.GiaVeDAO;
import com.httcinema.helper.DialogHelper;
import com.httcinema.helper.ShareHelper;
import com.httcinema.helper.ValidationHelper;
import com.httcinema.model.GiaVe;

@SuppressWarnings("serial")
public class QuanLyGiaVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog extends CustomDialog {

	public final static int THEM = 1;
	public final static int CAP_NHAT = 2;
	private int trangThai;
	
	private JDialog thisDialog;
	
	private JLabel lblTieuDe;
	
	private CustomTextField txtMaGiaVe;
	private JNumberTextField txtGiaVe;
	private CustomTextArea txtMoTa;
	private CustomButton btnDong;
	private CustomButton btnThaoTac;
	
	public static void showDialog(Component owner, GiaVe giaVe, int trangThai) {
		QuanLyGiaVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog dialog;
		if (owner instanceof JDialog) {
			dialog = new QuanLyGiaVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog((Dialog) owner);
		}
		else {
			dialog = new QuanLyGiaVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog((Frame) owner);
		}
		
		dialog.init(giaVe, trangThai);
		dialog.setLocationRelativeTo(owner);
		dialog.fadeIn(dialog);
	}

	public QuanLyGiaVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog(Frame owner) {
		super(owner);
	}
	
	public QuanLyGiaVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog(Dialog owner) {
		super(owner);
	}

	public QuanLyGiaVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog() {
		setUndecorated(true);
		init(null, 1);
	}
	
	/**
	 * Create the dialog.
	 */
	public void init(GiaVe giaVe, int trangThai) {
		this.thisDialog = this;
		this.trangThai = trangThai;
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 532, 377);
		getContentPane().setLayout(null);
		
		JPanel pnlChinh = new JPanel();
		pnlChinh.setBorder(new LineBorder(Color.WHITE));
		pnlChinh.setBackground(Theme.dark);
		pnlChinh.setBounds(0, 0, 532, 377);
		getContentPane().add(pnlChinh);
		pnlChinh.setLayout(null);
		
		lblTieuDe = new JLabel("");
		lblTieuDe.setForeground(Theme.white);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setBounds(10, 11, 512, 30);
		pnlChinh.add(lblTieuDe);
		
		JPanel pnlForm = new JPanel();
		pnlForm.setBackground(Color.WHITE);
		pnlForm.setBorder(new LineBorder(Theme.green, 0));
		pnlForm.setBounds(10, 94, 512, 216);
		pnlChinh.add(pnlForm);
		pnlForm.setLayout(null);
		
		JPanel pnlPhai = new JPanel();
		pnlPhai.setBackground(Color.WHITE);
		pnlPhai.setBounds(10, 11, 492, 194);
		pnlForm.add(pnlPhai);
		pnlPhai.setLayout(null);
		
		JLabel lblMaGiaVe = new JLabel("Mã giá vé");
		lblMaGiaVe.setForeground(new Color(53, 60, 68));
		lblMaGiaVe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaGiaVe.setBounds(10, 11, 150, 30);
		pnlPhai.add(lblMaGiaVe);
		
		JLabel lblGiaVe = new JLabel("Giá vé");
		lblGiaVe.setForeground(new Color(53, 60, 68));
		lblGiaVe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGiaVe.setBounds(10, 52, 150, 30);
		pnlPhai.add(lblGiaVe);
		
		JLabel lblMoTa = new JLabel("Mô tả");
		lblMoTa.setForeground(new Color(53, 60, 68));
		lblMoTa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMoTa.setBounds(10, 93, 150, 90);
		pnlPhai.add(lblMoTa);
		
		txtMaGiaVe = new CustomTextField();
		txtMaGiaVe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaGiaVe.setBounds(170, 11, 312, 30);
		pnlPhai.add(txtMaGiaVe);
		txtMaGiaVe.setColumns(10);
		
		txtGiaVe = new JNumberTextField();
		txtGiaVe.setMaxLength(6);
		txtGiaVe.setFormat(JNumberTextField.DECIMAL);
		txtGiaVe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGiaVe.setBounds(170, 52, 312, 30);
		pnlPhai.add(txtGiaVe);
		txtGiaVe.setColumns(10);
		
		CustomScrollPane pnlScrollMoTa = new CustomScrollPane();
		pnlScrollMoTa.setBounds(170, 93, 312, 90);
		pnlPhai.add(pnlScrollMoTa);
		txtMoTa = new CustomTextArea(100);
		txtMoTa.setSelectionColor(Theme.green);
		pnlScrollMoTa.setViewportView(txtMoTa);
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMoTa.setLineWrap(true);
		txtMoTa.setWrapStyleWord(true);
		txtMoTa.setBorder(UIManager.getBorder("Button.border"));
		
		btnDong = new CustomButton("Đóng");
		Theme.setDefaultButtonFormat(btnDong);
		btnDong.setForeground(Color.WHITE);
		btnDong.setBounds(10, 321, 125, 45);
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
		btnThaoTac.setBounds(347, 321, 175, 45);
		btnThaoTac.setBackground(new Color(13, 94, 94));
		btnThaoTac.setHoverBackground(Theme.green);
		btnThaoTac.setFont(new Font("Tahoma", Font.BOLD, 17));
		pnlChinh.add(btnThaoTac);
		
		setState(giaVe);
	}
	
	private void setState(GiaVe model) {
		if (trangThai == THEM) {
			lblTieuDe.setText("THÊM GIÁ VÉ MỚI");
			txtMaGiaVe.setEditable(false);
			txtGiaVe.setEditable(true);
			btnThaoTac.setText("Thêm");
			btnThaoTac.addActionListener(insertListener);
			clear();
		}
		else if (trangThai == CAP_NHAT) {
			lblTieuDe.setText("CẬP NHẬT THÔNG TIN GIÁ VÉ");
			txtMaGiaVe.setEditable(false);
			txtGiaVe.setEditable(true);
			// hard code: không cho phép cập nhật mô tả của 4 hàng đầu
			if (model.getMaGiaVe() <= 4) {
				txtMoTa.setEditable(false);
			}
						
			btnThaoTac.setText("Cập nhật");
			btnThaoTac.addActionListener(updateListener);
			setModel(model);
		}
	}
	
	private void clear() {
		txtMaGiaVe.setText("");
		txtGiaVe.setText("");
		txtMoTa.setText("");
	}
	
	private void setModel(GiaVe model) {
		txtMaGiaVe.setText(model.getMaGiaVe() + "");
		txtGiaVe.setText(model.getGiaVe() + "");
		txtMoTa.setText(model.getMoTa());
	}
	
	private GiaVe getModel() {
		GiaVe model = new GiaVe();
		
		if (txtMaGiaVe.getText().trim().equals("") == false) {
			model.setMaGiaVe(Integer.parseInt(txtMaGiaVe.getText().trim()));
		}
		model.setGiaVe(Double.parseDouble(txtGiaVe.getText().trim()));
		model.setMoTa(txtMoTa.getText().trim());
		
		return model;
	}
	
	/**
	 * this method is for inserting data into database
	 */
	private void insert() {
		GiaVe model = getModel();

		try {
			new GiaVeDAO().insert(model);
			ShareHelper.refreshAllTable();
			clear();
			DialogHelper.success(this, "Đã thêm thành công!");
		} catch (Exception e) {
			DialogHelper.error(this, "Thêm mới thất bại!");
		}
	}
	
	/**
	 * this method is for updating data from database
	 */
	private void update() {
		GiaVe model = getModel();
		
		try {
			new GiaVeDAO().update(model);
			ShareHelper.refreshAllTable();
			DialogHelper.success(this, "Cập nhật thành công!");
		} catch (Exception e) {
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
	
	/**
	 * check for validation of data
	 * */
	private boolean isValidData() {
		
		if (ValidationHelper.isEmpty(txtGiaVe)) {
			DialogHelper.warning(thisDialog, "Giá vé không được trống");
			txtGiaVe.requestFocus();
			return false;
		}
		
		if (ValidationHelper.isEmpty(txtMoTa)) {
			DialogHelper.warning(thisDialog, "Mô tả giá vé không được trống");
			txtMoTa.requestFocus();
			return false;
		}
		
		return true;
	}
}
