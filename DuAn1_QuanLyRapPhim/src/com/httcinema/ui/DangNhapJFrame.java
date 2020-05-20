/**
 * This jframe is for login tasks
 * 
 * @author: Dinh Dat Thong
 * @version: 1.0
 */

package com.httcinema.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;

import com.httcinema.custom_jcomponents.CustomButton;
import com.httcinema.custom_jcomponents.CustomPasswordField;
import com.httcinema.custom_jcomponents.CustomTextField;
import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.dao.TaiKhoanDAO;
import com.httcinema.helper.DialogHelper;
import com.httcinema.helper.ShareHelper;
import com.httcinema.model.TaiKhoan;
import com.httcinema.share.DangNhapJFrameResource;

import diu.swe.habib.JPanelSlider.JPanelSlider;

public class DangNhapJFrame implements DangNhapJFrameResource {

	/* instance's variables */
	private JFrame frameDangNhap;
	
	private JPanel pnlChinh;
	private JPanelSlider pnlSlide;
	private JPanel pnlDangNhap;
	private ChaoJPanel pnlChao;
	
	private JLabel lblAnHienMatKhau;
	private JLabel lblOTrong;
	private JLabel lblHinhTenTaiKhoan;
	private JLabel lblHinhMatKhau;
	
	private CustomTextField txtTenTaiKhoan;
	private CustomPasswordField txtMatKhau;
	
	private CustomButton btnThoatChuongTrinh;
	private CustomButton btnAnChuongTrinh;
	private CustomButton btnDangNhap;
	
	private boolean hienMatKhau = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ShareHelper.setAppReady();
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("TextField.inactiveBackground", new ColorUIResource(new Color(247, 247, 247)));
			UIManager.put("TextArea.inactiveBackground", new ColorUIResource(new Color(247, 247, 247)));
			UIManager.put("PasswordField.inactiveBackground", new ColorUIResource(new Color(247, 247, 247)));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		DangNhapJFrame window = new DangNhapJFrame();
		window.frameDangNhap.setVisible(true);
	}
	
	public JFrame getFrameDangNhap() {
		return frameDangNhap;
	}
	
	private int tx, ty;
	public void setFrameDangNhap(JFrame frameDangNhap) {
		this.frameDangNhap = frameDangNhap;
		frameDangNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent m) {
				tx = m.getX();
				ty = m.getY();
			}
		});
		frameDangNhap.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent m) {
				frameDangNhap.setLocation(m.getXOnScreen() - tx, m.getYOnScreen() - ty);
			}
		});
		frameDangNhap.setUndecorated(true);
	}

	/**
	 * Create the application.
	 */
	public DangNhapJFrame() {
		initialize();
		getFrameDangNhap().setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrameDangNhap(new JFrame("Đăng nhập"));
		getFrameDangNhap().setResizable(false);
		getFrameDangNhap().getContentPane().setBackground(new Color(53, 60, 68));
		getFrameDangNhap().setIconImage(returnAppIcon());
		getFrameDangNhap().setBounds(100, 100, 930, 627);
		getFrameDangNhap().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getFrameDangNhap().setLocationRelativeTo(null);
		getFrameDangNhap().getContentPane().setLayout(null);
		getFrameDangNhap().setFocusable(true);
		getFrameDangNhap().getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		getFrameDangNhap().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	if (DialogHelper.confirm(frameDangNhap, "Bạn muốn thoát chương trình không?")) {
					System.exit(0);
				}
            }
        });
		UIManager.put("Button.background",Color.white);
		
		pnlChinh = new JPanel();
		pnlChinh.setBorder(null);
		pnlChinh.setSize(414, 421);
		int x = (getFrameDangNhap().getWidth() - pnlChinh.getWidth()) / 2;
		int y = (getFrameDangNhap().getHeight() - pnlChinh.getHeight()) / 2;
		pnlChinh.setLocation(x, y);
		pnlChinh.setBackground(new Color(255, 255, 255, 255));
		frameDangNhap.getContentPane().add(pnlChinh);
		pnlChinh.setLayout(null);
		
		pnlSlide = new JPanelSlider();
		pnlSlide.setBorder(null);
		pnlSlide.setBounds(0, 195, 414, 226);
		pnlChinh.add(pnlSlide);
		pnlSlide.setLayout(new CardLayout(0, 0));
		
		pnlDangNhap = new JPanel();
		pnlSlide.add(pnlDangNhap, "name_496111436185506");
		pnlDangNhap.setBorder(null);
		pnlDangNhap.setBackground(new Color(255, 255, 255));
		pnlDangNhap.setLayout(null);
		
		pnlChao = new ChaoJPanel();
		pnlSlide.add(pnlChao, "name_496278158550455");
		
		/* label */
		JLabel lblTieuDe = new JLabel("", SwingConstants.CENTER);
		lblTieuDe.setIcon(new ImageIcon(DangNhapJFrame.class.getResource(setImagePath(LOGIN_IMAGE_APP_LOGO))));
		lblTieuDe.setBounds(10, 11, 394, 173);
		pnlChinh.add(lblTieuDe);
		lblTieuDe.setOpaque(true);
		lblTieuDe.setForeground(Theme.mainLabel);
		lblTieuDe.setBackground(new Color(255, 255, 255, 0));
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		lblHinhTenTaiKhoan = new JLabel("");
		lblHinhTenTaiKhoan.setIcon(new ImageIcon(DangNhapJFrame.class.getResource(setImagePath(LOGIN_IMAGE_ICON_USERNAME))));
		lblHinhTenTaiKhoan.setBounds(56, 11, 50, 50);
		pnlDangNhap.add(lblHinhTenTaiKhoan);
		
		lblHinhMatKhau = new JLabel("");
		lblHinhMatKhau.setIcon(new ImageIcon(DangNhapJFrame.class.getResource(setImagePath(LOGIN_IMAGE_ICON_PASS))));
		lblHinhMatKhau.setBounds(56, 72, 50, 50);
		pnlDangNhap.add(lblHinhMatKhau);
		
		lblAnHienMatKhau = new JLabel("");
		lblAnHienMatKhau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (hienMatKhau == true) {
					txtMatKhau.setEchoChar('*');
					lblAnHienMatKhau.setIcon(new ImageIcon(DangNhapJFrame.class.getResource(setImagePath(LOGIN_IMAGE_ICON_PASS_HIDE))));
					hienMatKhau = false;
				}
				else {
					txtMatKhau.setEchoChar((char)0);
					lblAnHienMatKhau.setIcon(new ImageIcon(DangNhapJFrame.class.getResource(setImagePath(LOGIN_IMAGE_ICON_PASS_SHOW))));
					hienMatKhau = true;
				}
			}
		});
		lblAnHienMatKhau.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAnHienMatKhau.setIcon(new ImageIcon(DangNhapJFrame.class.getResource(setImagePath(LOGIN_IMAGE_ICON_PASS_HIDE))));
		lblAnHienMatKhau.setBounds(308, 72, 50, 50);
		pnlDangNhap.add(lblAnHienMatKhau);
		
		lblOTrong = new JLabel("");
		lblOTrong.setIcon(new ImageIcon(DangNhapJFrame.class.getResource(setImagePath(LOGIN_IMAGE_ICON_EMPTY))));
		lblOTrong.setBounds(308, 11, 50, 50);
		pnlDangNhap.add(lblOTrong);
		/* end of label */
		
		/* text fields */
		txtTenTaiKhoan = new CustomTextField();
		txtTenTaiKhoan.setBorder(new LineBorder(Theme.green, 1));
		txtTenTaiKhoan.setBounds(106, 11, 202, 50);
		pnlDangNhap.add(txtTenTaiKhoan);
		txtTenTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenTaiKhoan.setBackground(Theme.white);
		txtTenTaiKhoan.setForeground(Theme.dark);
		txtTenTaiKhoan.setCaretColor(Theme.dark);
		txtTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtTenTaiKhoan.setPlaceholder("Tên đăng nhập");
		txtTenTaiKhoan.setColumns(10);
		
		txtMatKhau = new CustomPasswordField();
		txtMatKhau.setBorder(new LineBorder(Theme.green, 1));
		txtMatKhau.setBounds(106, 72, 202, 50);
		pnlDangNhap.add(txtMatKhau);
		txtMatKhau.setForeground(Theme.dark);
		txtMatKhau.setHorizontalAlignment(JLabel.CENTER);
		txtMatKhau.setEchoChar('*');
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtMatKhau.setPlaceholder("Mật khẩu");
		/* end of text fields */
		
		/* buttons */
		btnThoatChuongTrinh = new CustomButton("X");
		btnThoatChuongTrinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DialogHelper.confirm(frameDangNhap, "Bạn muốn thoát chương trình không?")) {
					System.exit(0);
				}
			}
		});
		btnThoatChuongTrinh.setOpaque(false);
		btnThoatChuongTrinh.setContentAreaFilled(false);
		btnThoatChuongTrinh.setBorderPainted(false);
		btnThoatChuongTrinh.setForeground(Color.WHITE);
		btnThoatChuongTrinh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThoatChuongTrinh.setBackground(new Color(255, 255, 255, 0));
		btnThoatChuongTrinh.setHoverForeground(new Color(137, 240, 240));
		btnThoatChuongTrinh.setSize(50, 50);
		btnThoatChuongTrinh.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		x = getFrameDangNhap().getWidth() - btnThoatChuongTrinh.getWidth();
		btnThoatChuongTrinh.setLocation(x, 0);
		frameDangNhap.getContentPane().add(btnThoatChuongTrinh);
		ShareHelper.addKeyBind(pnlChinh, "control W", btnThoatChuongTrinhClick, "btnThoatChuongTrinh");
		
		btnAnChuongTrinh = new CustomButton("\uD83D\uDDD5");
		btnAnChuongTrinh.setText("-");
		btnAnChuongTrinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameDangNhap.setState(JFrame.ICONIFIED);
			}
		});
		btnAnChuongTrinh.setOpaque(false);
		btnAnChuongTrinh.setContentAreaFilled(false);
		btnAnChuongTrinh.setBorderPainted(false);
		btnAnChuongTrinh.setForeground(Color.WHITE);
		btnAnChuongTrinh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnChuongTrinh.setBackground(new Color(255, 255, 255, 0));
		btnAnChuongTrinh.setHoverForeground(new Color(137, 240, 240));
		btnAnChuongTrinh.setSize(50, 50);
		btnAnChuongTrinh.setFont(new Font("Segoe UI Black", Font.BOLD, 31));
		x = getFrameDangNhap().getWidth() - btnAnChuongTrinh.getWidth() - btnThoatChuongTrinh.getWidth();
		btnAnChuongTrinh.setLocation(x, 0);
		frameDangNhap.getContentPane().add(btnAnChuongTrinh);
		
		btnDangNhap = new CustomButton("Đăng nhập");
		Theme.setDefaultButtonFormat(btnDangNhap);
		btnDangNhap.setBounds(56, 153, 302, 45);
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(new Runnable() {
					public void run() {
						try {
							btnDangNhapHandler();
						} catch (Exception e) {
							DialogHelper.error(frameDangNhap, "Có lỗi xảy ra");
							e.printStackTrace();
						}
					}
				}).start();
			}
		});
		btnDangNhap.setBackground(Theme.green);
		btnDangNhap.setHoverBackground(Theme.darkGreen);
		pnlDangNhap.add(btnDangNhap);
		ShareHelper.addKeyBind(pnlChinh, "pressed ENTER", btnDangNhapClick, "btnDangNhap");
		/* end of button */
		
		/* background */
		JLabel lblHinhNen = new JLabel("");
		lblHinhNen.setIcon(new ImageIcon(DangNhapJFrame.class.getResource(setImagePath(LOGIN_IMAGE_BACKGROUND))));
		lblHinhNen.setBounds(0, 0, 930, 627);
		frameDangNhap.getContentPane().add(lblHinhNen);
		/* end of background */
	}
	
	/** 
	 * this function checks for the input emptiness
	 * 
	 * @return	a boolean value
	 */
	private boolean isEmpty() {
		// check txtTenTaiKhoan
		if (txtTenTaiKhoan.getText().trim().equals("")) {
			DialogHelper.warning(getFrameDangNhap(), format(LOGIN_FAIL_EMPTY_USERNAME));
			txtTenTaiKhoan.requestFocus();
			return true;
		}
		
		// check txtMatKhau
		if (new String(txtMatKhau.getPassword()).equals("")) {
			DialogHelper.warning(getFrameDangNhap(), format(LOGIN_FAIL_EMPTY_PASS));
			txtMatKhau.requestFocus();
			return true;
		}
		
		return false;
	}
	
	/** 
	 * this function handles event click for btnDangNhap
	 */
	private void btnDangNhapHandler() {
		if (isEmpty()) {
			return;
		}
		
		TaiKhoan taiKhoan = new TaiKhoanDAO().findById(txtTenTaiKhoan.getText().trim());
		
		// tài khoản không tồn tại
		if (taiKhoan == null) {
			DialogHelper.error(getFrameDangNhap(), format(LOGIN_FAIL_WRONG_USERNAME));
			txtTenTaiKhoan.requestFocus();
			return;
		}
		
		String a = new String(txtMatKhau.getPassword());
		
		// đúng tên đăng nhập nhưng sai mật khẩu
		if (a.equals(taiKhoan.getMatKhau()) == false) {
			DialogHelper.warning(getFrameDangNhap(), format(LOGIN_FAIL_WRONG_PASS));
			txtMatKhau.requestFocus();
			return;
		}

		ShareHelper.USER = taiKhoan;
		// đăng nhập thành công
		if (taiKhoan.getMaVaiTro().equals(ROLE_MANAGER)) {
//			DialogHelper.success(getFrameDangNhap(), format(LOGIN_SUCCESS_MANAGER, nhanVien.getHoTen()));
		}
		else if (taiKhoan.getMaVaiTro().equals(ROLE_STAFF)) {
//			DialogHelper.success(getFrameDangNhap(), format(LOGIN_SUCCESS_STAFF, nhanVien.getHoTen()));
		}
		else {
			DialogHelper.inform(getFrameDangNhap(), format(LOGIN_SUCCESS_UNDEFINED, taiKhoan.getHoTen()));
			return;
		}
		
		pnlSlide.nextPanel(15, 15, pnlChao, JPanelSlider.left);
		pnlChao.load(frameDangNhap, new ManHinhChinhJFrame());
	}
	
	/**
	 * This object is used for handles ENTER pressed event
	 * */
	@SuppressWarnings("serial")
	private Action btnDangNhapClick = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnDangNhap.doClick();
		}
	};
	
	/**
	 * This object is used for handles CTRL + W pressed event
	 * */
	@SuppressWarnings("serial")
	private Action btnThoatChuongTrinhClick = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnThoatChuongTrinh.doClick();
		}
	};
}
