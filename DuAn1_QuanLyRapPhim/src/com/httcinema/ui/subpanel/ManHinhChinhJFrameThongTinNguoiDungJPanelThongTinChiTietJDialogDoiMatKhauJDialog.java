package com.httcinema.ui.subpanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.httcinema.custom_jcomponents.CustomButton;
import com.httcinema.custom_jcomponents.CustomDialog;
import com.httcinema.custom_jcomponents.CustomPasswordField;
import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.dao.TaiKhoanDAO;
import com.httcinema.helper.DialogHelper;
import com.httcinema.helper.ShareHelper;
import com.httcinema.helper.ValidationHelper;
import com.httcinema.model.TaiKhoan;

public class ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialogDoiMatKhauJDialog extends CustomDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1802872144400241604L;

	private CustomPasswordField txtMatKhauCu;
	private CustomPasswordField txtNhapLaiMatKhauCu;
	private CustomPasswordField txtMatKhauMoi;
	private CustomButton btnDong;
	private CustomButton btnHoanTat;

	public static void showDialog(Component owner, TaiKhoan taiKhoan) {
		ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialogDoiMatKhauJDialog dialog;
		if (owner instanceof JDialog) {
			dialog = new ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialogDoiMatKhauJDialog((Dialog) owner);
		}
		else {
			dialog = new ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialogDoiMatKhauJDialog((Frame) owner);
		}
		
		dialog.init(taiKhoan);
		dialog.setLocationRelativeTo(owner);
		dialog.fadeIn(dialog);
	}

	public ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialogDoiMatKhauJDialog(Frame owner) {
		super(owner);
	}
	
	public ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialogDoiMatKhauJDialog(Dialog owner) {
		super(owner);
	}

	public ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialogDoiMatKhauJDialog() {
		setUndecorated(true);
		init(null);
	}
	
	/**
	 * Create the dialog.
	 */
	public void init(TaiKhoan taiKhoan) {
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 436, 307);
		getContentPane().setLayout(null);
		
		JPanel pnlChinh = new JPanel();
		pnlChinh.setBorder(new LineBorder(Theme.dark));
		pnlChinh.setBackground(Color.WHITE);
		pnlChinh.setBounds(0, 0, 436, 307);
		getContentPane().add(pnlChinh);
		pnlChinh.setLayout(null);
		
		JLabel lblTieuDe = new JLabel("ĐỔI MẬT KHẨU");
		lblTieuDe.setForeground(Theme.dark);
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTieuDe.setBounds(10, 11, 416, 58);
		pnlChinh.add(lblTieuDe);
		
		JPanel pnlForm = new JPanel();
		pnlForm.setBackground(Color.WHITE);
		pnlForm.setBounds(10, 80, 416, 160);
		pnlChinh.add(pnlForm);
		pnlForm.setLayout(null);
		
		JLabel lblMatKhauCu = new JLabel("Mật khẩu cũ");
		lblMatKhauCu.setForeground(Theme.dark);
		lblMatKhauCu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMatKhauCu.setBounds(10, 11, 170, 30);
		pnlForm.add(lblMatKhauCu);
		
		txtMatKhauCu = new CustomPasswordField(30);
		txtMatKhauCu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMatKhauCu.setBounds(213, 11, 193, 30);
		txtMatKhauCu.setEchoChar('*');
		pnlForm.add(txtMatKhauCu);
		txtMatKhauCu.setColumns(10);
		
		JLabel lblMatKhauCuXacNhan = new JLabel("Nhập lại mật khẩu cũ");
		lblMatKhauCuXacNhan.setForeground(Theme.dark);
		lblMatKhauCuXacNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMatKhauCuXacNhan.setBounds(10, 52, 170, 30);
		pnlForm.add(lblMatKhauCuXacNhan);
		
		txtNhapLaiMatKhauCu = new CustomPasswordField(30);
		txtNhapLaiMatKhauCu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNhapLaiMatKhauCu.setBounds(213, 52, 193, 30);
		txtNhapLaiMatKhauCu.setEchoChar('*');
		pnlForm.add(txtNhapLaiMatKhauCu);
		txtNhapLaiMatKhauCu.setColumns(10);
		
		JLabel lblMatKhauMoi = new JLabel("Mật khẩu mới");
		lblMatKhauMoi.setForeground(Theme.dark);
		lblMatKhauMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMatKhauMoi.setBounds(10, 93, 170, 30);
		pnlForm.add(lblMatKhauMoi);
		
		txtMatKhauMoi = new CustomPasswordField(30);
		txtMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMatKhauMoi.setBounds(213, 93, 193, 30);
		txtMatKhauMoi.setEchoChar('*');
		pnlForm.add(txtMatKhauMoi);
		txtMatKhauMoi.setColumns(10);
		
		btnDong = new CustomButton("Đóng");
		btnDong.setForeground(Color.WHITE);
		Theme.setDefaultButtonFormat(btnDong);
		btnDong.setBackground(new Color(36, 36, 36));
		btnDong.setHoverBackground(Color.BLACK);
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fadeOut();
			}
		});
		btnDong.setBounds(10, 251, 100, 45);
		pnlChinh.add(btnDong);
		
		btnHoanTat = new CustomButton("Hoàn tất");
		btnHoanTat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hoanTat();
			}
		});
		Theme.setDefaultButtonFormat(btnHoanTat);
		btnHoanTat.setBackground(new Color(13, 94, 94));
		btnHoanTat.setHoverBackground(Theme.green);
		btnHoanTat.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHoanTat.setBounds(284, 251, 142, 45);
		pnlChinh.add(btnHoanTat);
		
		ShareHelper.addKeyBind(pnlChinh, "pressed ENTER", btnHoanTatClick, "btnHoanTat");
	}
	
	/**
	 * handle btnHoanTat click event
	 * */
	void hoanTat() {
		if (ValidationHelper.isEmpty(txtMatKhauCu) || ValidationHelper.isEmpty(txtMatKhauMoi) || ValidationHelper.isEmpty(txtNhapLaiMatKhauCu)) {
			DialogHelper.warning(this, "Bạn chưa nhập đủ thông tin!");
			return;
		}
		
		if (checkOldPassword() == false) {
			DialogHelper.error(this, "Mật khẩu hiện tại không đúng!");
			txtMatKhauCu.requestFocus();
			return;
		}
		
		String matKhauMoi = new String(txtMatKhauMoi.getPassword());
		String xacNhan = new String(txtNhapLaiMatKhauCu.getPassword());
		if (matKhauMoi.equals(xacNhan) == false) {
			DialogHelper.error(this, "Mật khẩu xác nhận không đúng!");
			return;
		}
		
		ShareHelper.USER.setMatKhau(matKhauMoi);
		
		new TaiKhoanDAO().update(ShareHelper.USER);
		
		DialogHelper.success(this, "Đổi mật khẩu thành công!");
		fadeOut();
	}
	
	/**
	 * check for old password
	 * */
	boolean checkOldPassword() {
		if (ShareHelper.USER.getMatKhau().equals(new String(txtMatKhauCu.getPassword()))) {
			return true;
		}
		return false;
	}
	
	/**
	 * This object is used for handles ENTER pressed event
	 * */
	@SuppressWarnings("serial")
	private Action btnHoanTatClick = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnHoanTat.doClick();
		}
	};
}
