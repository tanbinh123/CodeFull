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
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.httcinema.custom_jcomponents.CustomButton;
import com.httcinema.custom_jcomponents.CustomComboBox;
import com.httcinema.custom_jcomponents.CustomDialog;
import com.httcinema.custom_jcomponents.CustomFileChooser;
import com.httcinema.custom_jcomponents.CustomTextField;
import com.httcinema.custom_jcomponents.JNumberTextField;
import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.dao.PhimDAO;
import com.httcinema.dao.TheLoaiPhimDAO;
import com.httcinema.helper.DateHelper;
import com.httcinema.helper.DialogHelper;
import com.httcinema.helper.ShareHelper;
import com.httcinema.helper.ValidationHelper;
import com.httcinema.model.Phim;
import com.httcinema.model.TheLoaiPhim;

@SuppressWarnings("serial")
public class QuanLyPhimJScrollPaneNoiDungJPanelThongTinChiTietJDialog extends CustomDialog {

	public final static int THEM = 1;
	public final static int CAP_NHAT = 2;
	public final static int XEM_CHI_TIET = 3;
	private int trangThai;

	private JDialog thisDialog;
	
	private JLabel lblTieuDe;
	private JLabel lblThongBaoPhu;
	
	private JPanel pnlTrai;
	private JPanel pnlGlass;
	private CustomButton btnDoiHinh;
	
	private JComboBox<TheLoaiPhim> cboTheLoai;
	private CustomTextField txtMaPhim;
	private CustomButton btnDong;
	private CustomButton btnThaoTac;
	private File imageFile;
	
	private CustomTextField txtTenPhim;
	private CustomTextField txtNhaSanXuat;
	private JNumberTextField txtDoTuoi;
	private JNumberTextField txtThoiLuong;
	private CustomTextField txtNgayCongChieu;
	private CustomTextField txtTrailer;
	private JLabel lblHinh;
	
	public static void showDialog(Component owner, Phim phim, int trangThai) {
		QuanLyPhimJScrollPaneNoiDungJPanelThongTinChiTietJDialog dialog;
		if (owner instanceof JDialog) {
			dialog = new QuanLyPhimJScrollPaneNoiDungJPanelThongTinChiTietJDialog((Dialog) owner);
		}
		else {
			dialog = new QuanLyPhimJScrollPaneNoiDungJPanelThongTinChiTietJDialog((Frame) owner);
		}
		
		dialog.init(phim, trangThai);
		dialog.setLocationRelativeTo(owner);
		dialog.fadeIn(dialog);
	}

	public QuanLyPhimJScrollPaneNoiDungJPanelThongTinChiTietJDialog(Frame owner) {
		super(owner);
	}
	
	public QuanLyPhimJScrollPaneNoiDungJPanelThongTinChiTietJDialog(Dialog owner) {
		super(owner);
	}

	public QuanLyPhimJScrollPaneNoiDungJPanelThongTinChiTietJDialog() {
		setUndecorated(true);
		init(null, 1);
	}
	
	/**
	 * Create the dialog.
	 */
	public void init(Phim phim, int trangThai) {
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
		pnlGlass.setBounds(0, 0, 258, 308);
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
						if (trangThai == CAP_NHAT) {
							lblHinh.setToolTipText(phim.getTrailer() + ShareHelper.getFileExtension(imageFile));
						}
						else if (trangThai == THEM) {
							lblHinh.setToolTipText(imageFile.getName());
						}
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
		lblHinh.setBounds(0, 0, 258, 308);
		lblHinh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlGlass.setVisible(true);
			}
		});
		pnlTrai.add(lblHinh);
		lblHinh.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPoster = new JLabel("Poster");
		lblPoster.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoster.setForeground(Theme.white);
		lblPoster.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPoster.setBounds(10, 319, 238, 37);
		pnlTrai.add(lblPoster);
		
		JPanel pnlPhai = new JPanel();
		pnlPhai.setBackground(Color.WHITE);
		pnlPhai.setBounds(278, 11, 492, 367);
		pnlForm.add(pnlPhai);
		pnlPhai.setLayout(null);
		
		JLabel lblMaPhim = new JLabel("Mã phim");
		lblMaPhim.setForeground(new Color(53, 60, 68));
		lblMaPhim.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaPhim.setBounds(10, 11, 150, 30);
		pnlPhai.add(lblMaPhim);
		
		JLabel lblTenPhim = new JLabel("Tên phim");
		lblTenPhim.setForeground(new Color(53, 60, 68));
		lblTenPhim.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenPhim.setBounds(10, 52, 150, 30);
		pnlPhai.add(lblTenPhim);
		
		txtMaPhim = new CustomTextField();
		txtMaPhim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaPhim.setBounds(170, 11, 312, 30);
		pnlPhai.add(txtMaPhim);
		txtMaPhim.setColumns(10);
		
		JLabel lblTheLoai = new JLabel("Thể loại");
		lblTheLoai.setForeground(new Color(53, 60, 68));
		lblTheLoai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTheLoai.setBounds(10, 93, 150, 30);
		pnlPhai.add(lblTheLoai);
		
		JLabel lblNhaSX = new JLabel("Nhà sản xuất");
		lblNhaSX.setForeground(new Color(53, 60, 68));
		lblNhaSX.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNhaSX.setBounds(10, 134, 150, 30);
		pnlPhai.add(lblNhaSX);
		
		txtTenPhim = new CustomTextField(50);
		txtTenPhim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenPhim.setColumns(10);
		txtTenPhim.setBounds(170, 52, 312, 30);
		pnlPhai.add(txtTenPhim);
		
		txtNhaSanXuat = new CustomTextField(30);
		txtNhaSanXuat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNhaSanXuat.setColumns(10);
		txtNhaSanXuat.setBounds(170, 134, 312, 30);
		pnlPhai.add(txtNhaSanXuat);
		
		JLabel lblDoTuoi = new JLabel("Độ tuổi");
		lblDoTuoi.setForeground(new Color(53, 60, 68));
		lblDoTuoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDoTuoi.setBounds(10, 175, 150, 30);
		pnlPhai.add(lblDoTuoi);
		
		txtDoTuoi = new JNumberTextField();
		txtDoTuoi.setMaxLength(2);
		txtDoTuoi.setFormat(JNumberTextField.NUMERIC);
		txtDoTuoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDoTuoi.setColumns(10);
		txtDoTuoi.setBounds(170, 175, 312, 30);
		pnlPhai.add(txtDoTuoi);
		
		JLabel lblThoiLuong = new JLabel("Thời lượng");
		lblThoiLuong.setForeground(new Color(53, 60, 68));
		lblThoiLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThoiLuong.setBounds(10, 216, 150, 30);
		pnlPhai.add(lblThoiLuong);
		
		txtThoiLuong = new JNumberTextField();
		txtThoiLuong.setMaxLength(3);
		txtThoiLuong.setFormat(JNumberTextField.NUMERIC);
		txtThoiLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtThoiLuong.setColumns(10);
		txtThoiLuong.setBounds(170, 216, 150, 30);
		pnlPhai.add(txtThoiLuong);
		
		JLabel lblNgayCongChieu = new JLabel("Ngày công chiếu");
		lblNgayCongChieu.setForeground(new Color(53, 60, 68));
		lblNgayCongChieu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgayCongChieu.setBounds(10, 257, 150, 30);
		pnlPhai.add(lblNgayCongChieu);
		
		txtNgayCongChieu = new CustomTextField(10);
		txtNgayCongChieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNgayCongChieu.setColumns(10);
		txtNgayCongChieu.setBounds(170, 257, 150, 30);
		pnlPhai.add(txtNgayCongChieu);
		
		JLabel lblTrailer = new JLabel("Trailer");
		lblTrailer.setForeground(new Color(53, 60, 68));
		lblTrailer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrailer.setBounds(10, 298, 150, 30);
		pnlPhai.add(lblTrailer);
		
		txtTrailer = new CustomTextField(11);
		txtTrailer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTrailer.setColumns(10);
		txtTrailer.setBounds(371, 298, 111, 30);
		pnlPhai.add(txtTrailer);
		
		cboTheLoai = new CustomComboBox<TheLoaiPhim>();
		cboTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboTheLoai.setBounds(170, 93, 312, 30);
		pnlPhai.add(cboTheLoai);
		
		JLabel lblTrailerLink = new JLabel("www.youtube.com/watch?v=");
		lblTrailerLink.setForeground(Theme.dark);
		lblTrailerLink.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrailerLink.setBounds(170, 298, 191, 30);
		pnlPhai.add(lblTrailerLink);
		
		JLabel lblChuThichNgay = new JLabel("(dd-MM-yyyy)");
		lblChuThichNgay.setForeground(Theme.dark);
		lblChuThichNgay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChuThichNgay.setBounds(330, 257, 152, 30);
		pnlPhai.add(lblChuThichNgay);
		
		JLabel lblPhut = new JLabel("phút");
		lblPhut.setForeground(Theme.dark);
		lblPhut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhut.setBounds(330, 216, 152, 30);
		pnlPhai.add(lblPhut);
		
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
		
		lblThongBaoPhu = new JLabel("");
		lblThongBaoPhu.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongBaoPhu.setOpaque(true);
		lblThongBaoPhu.setBackground(Theme.dark);
		lblThongBaoPhu.setForeground(Theme.white);
		lblThongBaoPhu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongBaoPhu.setBounds(10, 52, 780, 31);
		pnlChinh.add(lblThongBaoPhu);
		
		fillComboBoxTheLoaiPhim();
		setState(phim);
	}
	
	private void fillComboBoxTheLoaiPhim() {
		DefaultComboBoxModel<TheLoaiPhim> model = (DefaultComboBoxModel<TheLoaiPhim>) cboTheLoai.getModel();
		model.removeAllElements();
		List<TheLoaiPhim> list = new TheLoaiPhimDAO().select();

		for (TheLoaiPhim theloai : list) {
			model.addElement(theloai);
		}
		cboTheLoai.setSelectedIndex(0);
	}
	
	private void setState(Phim model) {
		if (trangThai == THEM) {
			lblTieuDe.setText("THÊM PHIM MỚI");

			txtMaPhim.setEditable(false);
			
			btnThaoTac.setText("Thêm");
			btnThaoTac.addActionListener(insertListener);
			clear();
		}
		else if (trangThai == CAP_NHAT) {
			lblTieuDe.setText("CẬP NHẬT THÔNG TIN PHIM");
			
			txtMaPhim.setEditable(false);
			
			btnThaoTac.setText("Cập nhật");
			btnThaoTac.addActionListener(updateListener);
			setModel(model);
		}
		else if (trangThai == XEM_CHI_TIET) {
			lblTieuDe.setText("XEM CHI TIẾT PHIM");
			lblThongBaoPhu.setText("Không thể sửa thông tin vì phim này đã có người mua vé!!!");
			lblThongBaoPhu.setBackground(Theme.danger);
			
			txtMaPhim.setEditable(false);
			txtTenPhim.setEditable(false);
			cboTheLoai.setEnabled(false);
			txtNhaSanXuat.setEditable(false);
			txtDoTuoi.setEditable(false);
			txtThoiLuong.setEditable(false);
			txtNgayCongChieu.setEditable(false);
			txtTrailer.setEditable(false);;
		    pnlTrai.remove(pnlGlass);
		    
			btnThaoTac.setVisible(false);
			setModel(model);
		}
	}
	
	private void clear() {
		txtMaPhim.setText("");
		txtTenPhim.setText("");
		cboTheLoai.setSelectedIndex(0);
		txtNhaSanXuat.setText("");
		txtDoTuoi.setText("");
		txtThoiLuong.setText("");
		txtNgayCongChieu.setText("");
		txtTrailer.setText("");
		lblHinh.setIcon(null);
		lblHinh.setToolTipText("");
	}
	
	private void setModel(Phim model) {
		TheLoaiPhim tlp = new TheLoaiPhimDAO().findById(model.getMaTheLoai() + "");

		txtMaPhim.setText(model.getMaPhim() + "");
		txtTenPhim.setText(model.getTenPhim() + "");
		cboTheLoai.setSelectedItem(tlp);
		txtNhaSanXuat.setText(model.getNhaSanXuat() + "");
		txtDoTuoi.setText(model.getDoTuoi() + "");
		txtThoiLuong.setText(model.getThoiLuong() + "");
		txtNgayCongChieu.setText(DateHelper.toString(model.getNgayCongChieu(), "dd-MM-yyyy"));
		txtTrailer.setText(model.getTrailer() + "");
		
		lblHinh.setIcon(new ImageIcon(ShareHelper.readMovieImage(model, lblHinh.getWidth(), lblHinh.getHeight())));
		lblHinh.setToolTipText(model.getHinh());
	}
	
	private Phim getModel() {
		Phim model = new Phim();
		
		if (txtMaPhim.getText().trim().equals("") == false) {
			model.setMaPhim(Integer.parseInt(txtMaPhim.getText().trim()));
		}
		model.setTenPhim(txtTenPhim.getText().trim());
		model.setMaTheLoai(((TheLoaiPhim) cboTheLoai.getSelectedItem()).getMaTheLoai());
		model.setNhaSanXuat(txtNhaSanXuat.getText().trim());
		model.setDoTuoi(Integer.parseInt(txtDoTuoi.getText().trim()));
		model.setThoiLuong(Integer.parseInt(txtThoiLuong.getText().trim()));
		model.setNgayCongChieu(DateHelper.toDate(txtNgayCongChieu.getText().trim(), "dd-MM-yyyy"));
		model.setTrailer(txtTrailer.getText().trim());
		model.setHinh(lblHinh.getToolTipText());
		
		return model;
	}
	
	/**
	 * this method is for inserting data into database
	 */
	private void insert() {
		Phim model = getModel();
		
		try {
			if (imageFile != null) {
				ShareHelper.saveMovieImage(imageFile, model.getTrailer() + ShareHelper.getFileExtension(imageFile));
				lblHinh.setToolTipText(model.getTrailer() + ShareHelper.getFileExtension(imageFile));
			}
			new PhimDAO().insert(model);
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
		Phim model = getModel();
		
		try {
			if (imageFile != null) {
				ShareHelper.saveMovieImage(imageFile, model.getTrailer() + ShareHelper.getFileExtension(imageFile));
				lblHinh.setToolTipText(model.getTrailer() + ShareHelper.getFileExtension(imageFile));
			}
			
			new PhimDAO().update(model);
			ShareHelper.refreshAllTable();
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
	
	/**
	 * check for validation of data
	 * */
	private boolean isValidData() {
		//-----
//		if (ValidationHelper.isID(txtMaGiaVe, 3) == false) {
//			DialogHelper.warning(this, "Tên đăng nhập ít nhất có 3 ký tự");
//			txtMaGiaVe.requestFocus();
//			return false;
//		}
//		
		//-----
		if (ValidationHelper.isEmpty(txtTenPhim)) {
			DialogHelper.warning(this, "Tên phim không được để trống");
			txtTenPhim.requestFocus();
			return false;
		}
//		
//		if (ValidationHelper.isName(txtHoTen) == false) {
//			DialogHelper.warning(this, "Họ tên chỉ được chứa chữ cái và ký tự khoảng trắng");
//			txtHoTen.requestFocus();
//			return false;
//		}
//		
		if (ValidationHelper.isEmpty(txtNgayCongChieu)) {
			DialogHelper.warning(this, "Ngày chiếu không được để trống");
			txtNgayCongChieu.requestFocus();
			return false;
		}
		
		if (DateHelper.toDate(txtNgayCongChieu.getText().trim()) == null) {
			DialogHelper.warning(this, "Định dạng ngày phải là dd-MM-yyyy");
			txtNgayCongChieu.requestFocus();
			return false;
		}
//		
//		if (DateHelper.calculateAge(DateHelper.toDate(txtNgaySinh.getText().trim())) < 16) {
//			DialogHelper.warning(this, "Tài khoản chưa đủ 16 tuổi");
//			txtNgaySinh.requestFocus();
//			return false;
//		}
//		
		if (ValidationHelper.isEmpty(txtDoTuoi)) {
			DialogHelper.warning(this, "Độ tuổi không được để trống");
			txtDoTuoi.requestFocus();
			return false;
		}
		
		if (ValidationHelper.isEmpty(txtThoiLuong)) {
			DialogHelper.warning(this, "Thời lượng không được để trống");
			txtThoiLuong.requestFocus();
			return false;
		}
		
		if (ValidationHelper.isEmpty(txtTrailer)) {
			DialogHelper.warning(this, "Trailer không được để trống");
			txtTrailer.requestFocus();
			return false;
		}
		
		return true;
	}
}
