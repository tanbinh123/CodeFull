package com.httcinema.ui.subpanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.httcinema.custom_jcomponents.CustomButton;
import com.httcinema.custom_jcomponents.CustomDialog;
import com.httcinema.custom_jcomponents.CustomFileChooser;
import com.httcinema.custom_jcomponents.CustomPasswordField;
import com.httcinema.custom_jcomponents.CustomRadioButton;
import com.httcinema.custom_jcomponents.CustomScrollPane;
import com.httcinema.custom_jcomponents.CustomTextArea;
import com.httcinema.custom_jcomponents.CustomTextField;
import com.httcinema.custom_jcomponents.JNumberTextField;
import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.dao.TaiKhoanDAO;
import com.httcinema.dao.VaiTroDAO;
import com.httcinema.helper.DateHelper;
import com.httcinema.helper.DialogHelper;
import com.httcinema.helper.ShareHelper;
import com.httcinema.helper.ValidationHelper;
import com.httcinema.model.TaiKhoan;
import com.httcinema.model.VaiTro;

@SuppressWarnings("serial")
public class ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialog extends CustomDialog {

	public final static int THEM = 1;
	public final static int CAP_NHAT = 2;
	private int trangThai;
	
	private JDialog thisDialog;
	private VaiTro vaiTro;
	
	private JPanel pnlChinh;
	private JLabel lblTieuDe;
	
	private JPanel pnlTrai;
	
	private CustomTextField txtTenDangNhap;
	private CustomPasswordField txtMatKhau;
	private CustomButton btnDoiMatKhau;
	private CustomTextField txtHoTen;
	private CustomRadioButton rdoGioiTinh;
	private CustomTextField txtNgaySinh;
	private JNumberTextField txtSoDienThoai;
	private CustomTextArea txtDiaChi;
	private JLabel lblHinh;
	private JPanel pnlGlass;
	private CustomButton btnDoiHinh;
	private JLabel lblHoTen;
	private JLabel lblVaiTro;
	private CustomButton btnDong;
	private CustomButton btnThaoTac;
	
	private File imageFile;
	
	public static void showDialog(Component owner, TaiKhoan taiKhoan, int trangThai) {
		ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialog dialog;
		if (owner instanceof JDialog) {
			dialog = new ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialog((Dialog) owner);
		}
		else {
			dialog = new ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialog((Frame) owner);
		}
		
		dialog.init(taiKhoan, trangThai);
		dialog.setLocationRelativeTo(owner);
		dialog.fadeIn(dialog);
	}

	public ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialog(Frame owner) {
		super(owner);
	}
	
	public ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialog(Dialog owner) {
		super(owner);
	}

	public ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialog() {
		setUndecorated(true);
		init(null, 1);
	}
	
	/**
	 * Create the dialog.
	 */
	public void init(TaiKhoan taiKhoan, int trangThai) {
		this.thisDialog = this;
		this.trangThai = trangThai;
		vaiTro = (new VaiTroDAO().findById(taiKhoan.getMaVaiTro()));
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 800, 550);
		getContentPane().setLayout(null);
		
		pnlChinh = new JPanel();
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
		
		pnlTrai = new JPanel();
		pnlTrai.setBounds(10, 11, 258, 367);
		pnlForm.add(pnlTrai);
		pnlTrai.setBackground(Theme.dark);
		pnlTrai.setLayout(null);
		
		pnlGlass = new JPanel();
		pnlGlass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				pnlGlass.setVisible(false);
			}
		});
		pnlGlass.setBackground(new Color(255, 255, 255, 150));
		pnlGlass.setBounds(0, 0, 258, 274);
		pnlGlass.setVisible(false);
		pnlGlass.setLayout(null);
		pnlTrai.add(pnlGlass);
		
		btnDoiHinh = new CustomButton("Đổi");
		btnDoiHinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlGlass.setVisible(false);
				CustomFileChooser fc = new CustomFileChooser();
				fc.setImageChooseStyle("jpg", "png");
		        int returnVal = fc.showOpenDialog(thisDialog);

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		        	imageFile = fc.getSelectedFile();
					try {
						BufferedImage currentImage = ImageIO.read(imageFile);
						lblHinh.setIcon(new ImageIcon(ShareHelper.resizeImage(new ImageIcon(currentImage), lblHinh.getWidth(), lblHinh.getHeight())));
						lblHinh.setToolTipText(taiKhoan.getTenDangNhap() + ShareHelper.getFileExtension(imageFile));
					}
		    		catch (IOException ex) {
		    			DialogHelper.error(thisDialog, "Có lỗi xảy ra trong quá trình đọc");
		    			ex.printStackTrace();
		    		}
		        }
			}
		});
		Theme.setDefaultButtonFormat(btnDoiHinh);
		btnDoiHinh.setHoverBackground(Theme.green);
		btnDoiHinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDoiHinh.setBounds(79, 117, 100, 40);
		pnlGlass.add(btnDoiHinh);
		
		lblHinh = new JLabel("");
		lblHinh.setOpaque(true);
		lblHinh.setBackground(Theme.dark);
		lblHinh.setBounds(0, 0, 258, 274);
		lblHinh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlGlass.setVisible(true);
			}
		});
		pnlTrai.add(lblHinh);
		lblHinh.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblHoTen = new JLabel();
		lblHoTen.setBounds(10, 285, 238, 30);
		pnlTrai.add(lblHoTen);
		lblHoTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoTen.setForeground(Color.WHITE);
		lblHoTen.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblVaiTro = new JLabel();
		lblVaiTro.setBounds(10, 326, 238, 23);
		pnlTrai.add(lblVaiTro);
		lblVaiTro.setHorizontalAlignment(SwingConstants.CENTER);
		lblVaiTro.setForeground(Color.WHITE);
		lblVaiTro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel pnlPhai = new JPanel();
		pnlPhai.setBackground(Color.WHITE);
		pnlPhai.setBounds(278, 11, 492, 367);
		pnlForm.add(pnlPhai);
		pnlPhai.setLayout(null);
		
		JLabel lblTenDangNhap = new JLabel("Tên đăng nhập");
		lblTenDangNhap.setForeground(new Color(53, 60, 68));
		lblTenDangNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenDangNhap.setBounds(10, 11, 150, 30);
		pnlPhai.add(lblTenDangNhap);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setForeground(new Color(53, 60, 68));
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMatKhau.setBounds(10, 52, 150, 30);
		pnlPhai.add(lblMatKhau);
		
		JLabel lblHoTenTaiKhoan = new JLabel("Họ tên");
		lblHoTenTaiKhoan.setForeground(new Color(53, 60, 68));
		lblHoTenTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHoTenTaiKhoan.setBounds(10, 93, 150, 30);
		pnlPhai.add(lblHoTenTaiKhoan);
		
		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setForeground(new Color(53, 60, 68));
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGioiTinh.setBounds(10, 134, 150, 30);
		pnlPhai.add(lblGioiTinh);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setForeground(new Color(53, 60, 68));
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgaySinh.setBounds(10, 175, 150, 30);
		pnlPhai.add(lblNgaySinh);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setForeground(new Color(53, 60, 68));
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDiaChi.setBounds(10, 216, 150, 90);
		pnlPhai.add(lblDiaChi);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setForeground(new Color(53, 60, 68));
		lblSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoDienThoai.setBounds(10, 317, 150, 30);
		pnlPhai.add(lblSoDienThoai);
		
		txtTenDangNhap = new CustomTextField();
		txtTenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenDangNhap.setBounds(170, 11, 312, 30);
		pnlPhai.add(txtTenDangNhap);
		txtTenDangNhap.setColumns(10);
		
		txtMatKhau = new CustomPasswordField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMatKhau.setBounds(170, 52, 232, 30);
		txtMatKhau.setEchoChar('*');
		pnlPhai.add(txtMatKhau);
		txtMatKhau.setColumns(10);
		
		btnDoiMatKhau = new CustomButton("Đổi");
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialogDoiMatKhauJDialog.showDialog(thisDialog, taiKhoan);
				setModel(ShareHelper.USER);
			}
		});
		Theme.setDefaultButtonFormat(btnDoiMatKhau);
		btnDoiMatKhau.setHoverBackground(Theme.green);
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDoiMatKhau.setBounds(412, 52, 70, 30);
		pnlPhai.add(btnDoiMatKhau);
		
		txtHoTen = new CustomTextField(50);
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHoTen.setBounds(170, 93, 312, 30);
		pnlPhai.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		rdoGioiTinh = new CustomRadioButton();
		rdoGioiTinh.setBackground(Color.WHITE);
		rdoGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdoGioiTinh.setHorizontalAlignment(SwingConstants.LEFT);
		rdoGioiTinh.setBounds(170, 134, 90, 30);
		rdoGioiTinh.setCustomListener("Nam", "Nữ");
		pnlPhai.add(rdoGioiTinh);
		
		txtNgaySinh = new CustomTextField(10);
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNgaySinh.setBounds(170, 175, 150, 30);
		pnlPhai.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		CustomScrollPane pnlScrollDiaChi = new CustomScrollPane();
		pnlScrollDiaChi.setBounds(170, 216, 312, 90);
		pnlPhai.add(pnlScrollDiaChi);
		txtDiaChi = new CustomTextArea(100);
		txtDiaChi.setSelectionColor(Theme.green);
		pnlScrollDiaChi.setViewportView(txtDiaChi);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDiaChi.setLineWrap(true);
		txtDiaChi.setWrapStyleWord(true);
		txtDiaChi.setBorder(UIManager.getBorder("Button.border"));
		
		txtSoDienThoai = new JNumberTextField();
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSoDienThoai.setBounds(170, 317, 312, 30);
		txtSoDienThoai.setFormat(JNumberTextField.NUMERIC);
		txtSoDienThoai.setMaxLength(12);
		pnlPhai.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);
		
		lblNewLabel = new JLabel("(dd-MM-yyyy)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(330, 175, 152, 30);
		pnlPhai.add(lblNewLabel);
		
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
		
		setState(taiKhoan);
	}
	
	private void setState(TaiKhoan model) {
		if (ShareHelper.USER.getMaVaiTro().equals("NV")) {
			txtTenDangNhap.setEditable(false);
			txtMatKhau.setEditable(false);
			txtHoTen.setEditable(false);
			rdoGioiTinh.setEnabled(false);
			txtNgaySinh.setEditable(false);
			txtDiaChi.setEditable(false);
			txtSoDienThoai.setEditable(false);
			btnThaoTac.setVisible(false);
			pnlTrai.remove(pnlGlass);
		}
		
		if (trangThai == THEM) {
			lblTieuDe.setText("THÊM TÀI KHOẢN MỚI");
			txtTenDangNhap.setEditable(true);
			txtMatKhau.setEditable(true);
			btnThaoTac.setText("Thêm");
			btnThaoTac.addActionListener(insertListener);
			clear();
		}
		else if (trangThai == CAP_NHAT) {
			lblTieuDe.setText("CẬP NHẬT THÔNG TIN TÀI KHOẢN");
			txtTenDangNhap.setEditable(false);
			txtMatKhau.setEditable(false);
			btnThaoTac.setText("Cập nhật");
			btnThaoTac.addActionListener(updateListener);
			setModel(model);
		}
	}
	
	private void clear() {
		txtTenDangNhap.setText("");
		txtMatKhau.setText("");
		txtHoTen.setText("");
		rdoGioiTinh.setSelected(true);
		txtNgaySinh.setText("");
		txtDiaChi.setText("");
		txtSoDienThoai.setText("");
		lblHinh.setIcon(null);
		lblHinh.setToolTipText("");
		
		lblHoTen.setText("");
		lblVaiTro.setText("");
	}
	
	private void setModel(TaiKhoan model) {
		txtTenDangNhap.setText(model.getTenDangNhap());
		txtMatKhau.setText(model.getMatKhau());
		txtHoTen.setText(model.getHoTen());
		rdoGioiTinh.setSelected(model.isGioiTinh());
		txtNgaySinh.setText(DateHelper.toString(model.getNgaySinh(), "dd-MM-yyyy"));
		txtDiaChi.setText(model.getDiaChi());
		txtSoDienThoai.setText(model.getSoDienThoai());
		lblHinh.setIcon(new ImageIcon(ShareHelper.readUserImage(model, lblHinh.getWidth(), lblHinh.getHeight())));
		lblHinh.setToolTipText(model.getHinh());
		
		lblHoTen.setText(model.getHoTen());
		lblVaiTro.setText(vaiTro + "");
	}
	
	private TaiKhoan getModel() {
		TaiKhoan model = new TaiKhoan();
		
		model.setTenDangNhap(txtTenDangNhap.getText().trim());
		model.setMatKhau(new String(txtMatKhau.getPassword()));
		model.setHoTen(ValidationHelper.toTitleCase(txtHoTen.getText()));
		model.setGioiTinh(rdoGioiTinh.isSelected());
		model.setNgaySinh(DateHelper.toDate(txtNgaySinh.getText().trim(), "dd-MM-yyyy"));
		model.setDiaChi(txtDiaChi.getText().trim());
		model.setSoDienThoai(txtSoDienThoai.getText().trim());
		model.setHinh(lblHinh.getToolTipText());
		model.setMaVaiTro(vaiTro.getMaVaiTro());
		
		return model;
	}
	
	/**
	 * this method is for inserting data into database
	 */
	private void insert() {
		if (isValidData() == false) {
			return;
		}
		TaiKhoan model = getModel();
		
		try {
			new TaiKhoanDAO().insert(model);
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
		if (isValidData() == false) {
			return;
		}
		TaiKhoan model = getModel();
		
		try {
			if (imageFile != null) {
				ShareHelper.saveUserImage(imageFile, model.getTenDangNhap() + ShareHelper.getFileExtension(imageFile));
				
			}
			new TaiKhoanDAO().update(model);
			ShareHelper.USER = model;
			setModel(ShareHelper.USER);
			DialogHelper.success(this, "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			DialogHelper.error(this, "Cập nhật thất bại!");
		}
	}
	
	ActionListener insertListener = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if (DialogHelper.confirm(thisDialog, "Tiến hành thêm?")) {
				insert();
			}
		}
	};
	
	ActionListener updateListener = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if (DialogHelper.confirm(thisDialog, "Tiến hành cập nhật?")) {
				update();
			}
		}
	};
	private JLabel lblNewLabel;
	
	/**
	 * check for validation of data
	 * */
	private boolean isValidData() {
		//-----
		if (ValidationHelper.isID(txtTenDangNhap, 3) == false) {
			DialogHelper.warning(this, "Tên đăng nhập ít nhất có 3 ký tự");
			txtTenDangNhap.requestFocus();
			return false;
		}
		
		//-----
		if (ValidationHelper.isEmpty(txtHoTen)) {
			DialogHelper.warning(this, "Họ tên không được trống");
			txtHoTen.requestFocus();
			return false;
		}
		
		if (ValidationHelper.isName(txtHoTen) == false) {
			DialogHelper.warning(this, "Họ tên chỉ được chứa chữ cái và ký tự khoảng trắng");
			txtHoTen.requestFocus();
			return false;
		}
		
		//-----
		if (ValidationHelper.isEmpty(txtNgaySinh)) {
			DialogHelper.warning(this, "Ngày sinh không được trống");
			txtNgaySinh.requestFocus();
			return false;
		}
		
		if (DateHelper.toDate(txtNgaySinh.getText().trim()) == null) {
			DialogHelper.warning(this, "Định dạng ngày phải là dd-MM-yyyy");
			txtNgaySinh.requestFocus();
			return false;
		}
		
		if (DateHelper.calculateAge(DateHelper.toDate(txtNgaySinh.getText().trim())) < 16) {
			DialogHelper.warning(this, "Tài khoản chưa đủ 16 tuổi");
			txtNgaySinh.requestFocus();
			return false;
		}
		
		//-----
		if (ValidationHelper.isPhoneNumber(txtSoDienThoai) == false) {
			DialogHelper.warning(this, "Số điện thoại phải từ 11 đến 12 số");
			txtSoDienThoai.requestFocus();
			return false;
		}
		
		return true;
	}
}
