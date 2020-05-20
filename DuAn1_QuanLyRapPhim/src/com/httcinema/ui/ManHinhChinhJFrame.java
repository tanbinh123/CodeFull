package com.httcinema.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import com.httcinema.custom_jcomponents.CustomButton;
//import diu.swe.habib.JPanelSlider.JPanelSlider;
import com.httcinema.custom_jcomponents.CustomSlidePanel;
import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.helper.ComponentResizer;
import com.httcinema.helper.DialogHelper;
import com.httcinema.helper.ShareHelper;
import com.httcinema.share.ShareResource;
import com.httcinema.ui.subpanel.LichChieuJScrollPane;
import com.httcinema.ui.subpanel.ManHinhChinhJFrameThongTinNguoiDungJPanel;
import com.httcinema.ui.subpanel.QuanLyGiaVeJScrollPane;
import com.httcinema.ui.subpanel.QuanLyLichChieuJScrollPane;
import com.httcinema.ui.subpanel.QuanLyNhanVienJScrollPane;
import com.httcinema.ui.subpanel.QuanLyPhimJScrollPane;
import com.httcinema.ui.subpanel.QuanLyThongKeJScrollPane;
import com.httcinema.ui.subpanel.QuanLyVeJScrollPane;

public class ManHinhChinhJFrame extends JFrame implements ShareResource {

	private static final long serialVersionUID = 5689868505608343836L;

	public static ManHinhChinhJFrame frameManHinhChinh;
	
	private boolean fullManHinh = false;
	private int toaDoX, toaDoY;
	private Dimension kichThuoc = null;
	private ComponentResizer cr = new ComponentResizer();
	private int chieuRongMacDinh = 950;
	private int chieuCaoMacDinh = 700;
	
	private CustomButton btnAnChuongTrinh;
	private CustomButton btnMoRongCuaSo;
	private CustomButton btnThoatChuongTrinh;
	
	private GroupLayout gl_pnlPhu;
	private JPanel pnlPhu;
	private JPanel pnlActive;
	private JPanel pnlSubActive;
	private CustomButton btnQuanLyNhanVien;
	private CustomButton btnQuanLyThongKe;
	private CustomButton btnQuanLyVe;
	private CustomButton btnQuanLyLichChieu;
	private CustomButton btnQuanLyGiaVe;
	private CustomButton btnQuanLyPhim;
	private CustomButton btnLichChieu;
	private CustomButton btnDangXuat;
	
	private CustomSlidePanel pnlLopHienThi;
	private JPanel pnlParentLichChieu;
	private JPanel pnlParentQuanLyPhim;
	private JPanel pnlParentQuanLyGiaVe;
	private JPanel pnlParentQuanLyLichChieu;
	private JPanel pnlParentQuanLyVe;
	private JPanel pnlParentQuanLyNhanVien;
	private JPanel pnlParentQuanLyThongKe;
	private JScrollPane pnlLichChieu;
	private JScrollPane pnlQuanLyPhim;
	private JScrollPane pnlQuanLyGiaVe;
	private JScrollPane pnlQuanLyLichChieu;
	private JScrollPane pnlQuanLyHoaDonVe;
	private JScrollPane pnlQuanLyNhanVien;
	private JScrollPane pnlQuanLyThongKe;
	
	private ArrayList<CustomButton> btnMenus = new ArrayList<CustomButton>();

	private JPanel pnlThanhCongCu;
	private ManHinhChinhJFrameThongTinNguoiDungJPanel pnlThongTinNguoiDung;
	private JPanel pnlMenu;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			@SuppressWarnings("static-access")
//			public void run() {
//				try {
//					try {
//						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//						UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 18));
//					} catch (ClassNotFoundException e) {
//						e.printStackTrace();
//					} catch (InstantiationException e) {
//						e.printStackTrace();
//					} catch (IllegalAccessException e) {
//						e.printStackTrace();
//					} catch (UnsupportedLookAndFeelException e) {
//						e.printStackTrace();
//					}
//					ManHinhChinhJFrame window = new ManHinhChinhJFrame();
//					window.frameManHinhChinh.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ManHinhChinhJFrame() {
		initialize();
		clockOn(btnDongHo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameManHinhChinh = this;
		setTitle("HTT - Quản lý rạp phim");
		setUndecorated(true);
		setForeground(new Color(212, 212, 212));
		setBackground(Theme.dark);
		getContentPane().setBackground(Theme.dark);
		setBounds(100, 100, chieuRongMacDinh, chieuCaoMacDinh);
		setIconImage(returnAppIcon());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		fullManHinh = true;
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	if (DialogHelper.confirm(frameManHinhChinh, "Bạn muốn thoát chương trình không?")) {
					System.exit(0);
				}
            }
        });
		addWindowStateListener(new WindowAdapter() {
			public void windowStateChanged(WindowEvent evt) {
				int oldState = evt.getOldState();
				int newState = evt.getNewState();

				if ((oldState & Frame.MAXIMIZED_BOTH) == 0 && (newState & Frame.MAXIMIZED_BOTH) != 0) {
					// khi vừa full screen xong
					btnMoRongCuaSo.setText("\uD83D\uDDD7");
					cr.deregisterComponent(frameManHinhChinh);
					fullManHinh = true;
				} else if ((oldState & Frame.MAXIMIZED_BOTH) != 0 && (newState & Frame.MAXIMIZED_BOTH) == 0) {
					// ngược lại
					toaDoX = frameManHinhChinh.getLocation().x;
					toaDoY = frameManHinhChinh.getLocation().y;
					if (kichThuoc == null) {
						kichThuoc = new Dimension(chieuRongMacDinh, chieuCaoMacDinh);
					}
					else {
						kichThuoc = frameManHinhChinh.getSize();
					}
					
					btnMoRongCuaSo.setText("\uD83D\uDDD6");
					cr.registerComponent(frameManHinhChinh);
					fullManHinh = false;
				}
			}
		});
		cr.setSnapSize(new Dimension(10, 10));
		cr.setMinimumSize(new Dimension(chieuRongMacDinh, chieuCaoMacDinh));
		
		pnlChinh = new JPanel();
		pnlChinh.setBackground(Theme.dark);
		pnlChinh.setBorder(null);
		GroupLayout groupLayout = new GroupLayout(frameManHinhChinh.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlChinh, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlChinh, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
		);
		
		JPanel pnlThanhDieuHuong = new JPanel();
		pnlThanhDieuHuong.setBorder(null);
		pnlThanhDieuHuong.setBackground(Theme.dark);
		pnlThanhDieuHuong.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent m) {
				if (fullManHinh == false) {
					toaDoX = m.getX();
					toaDoY = m.getY();
				}
			}

		});
		pnlThanhDieuHuong.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent m) {
				if (fullManHinh == false) {
					frameManHinhChinh.setLocation(m.getXOnScreen() - toaDoX, m.getYOnScreen() - toaDoY);
				}
			}
		});
		
		btnThoatChuongTrinh = new CustomButton("X");
		btnThoatChuongTrinh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThoatChuongTrinh.setOpaque(false);
		btnThoatChuongTrinh.setForeground(Theme.white);
		btnThoatChuongTrinh.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnThoatChuongTrinh.setContentAreaFilled(false);
		btnThoatChuongTrinh.setBorderPainted(false);
		btnThoatChuongTrinh.setBackground(new Color(255, 255, 255, 0));
		btnThoatChuongTrinh.setHoverForeground(new Color(250, 132, 132));
		btnThoatChuongTrinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DialogHelper.confirm(frameManHinhChinh, "Bạn muốn thoát chương trình không?")) {
					System.exit(0);
				}
			}
		});
		
		btnMoRongCuaSo = new CustomButton("\uD83D\uDDD7");
		btnMoRongCuaSo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMoRongCuaSo.setOpaque(false);
		btnMoRongCuaSo.setForeground(Theme.white);
		btnMoRongCuaSo.setFont(new Font("", Font.PLAIN, 18));
		btnMoRongCuaSo.setContentAreaFilled(false);
		btnMoRongCuaSo.setBorderPainted(false);
		btnMoRongCuaSo.setBackground(new Color(255, 255, 255, 0));
		btnMoRongCuaSo.setHoverForeground(new Color(122, 240, 238));
		btnMoRongCuaSo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// nếu chưa full screen
				if (fullManHinh == false) {
					toaDoX = frameManHinhChinh.getLocation().x;
					toaDoY = frameManHinhChinh.getLocation().y;
					if (kichThuoc == null) {
						kichThuoc = new Dimension(chieuRongMacDinh, chieuCaoMacDinh);
					}
					else {
						kichThuoc = frameManHinhChinh.getSize();
					}
							
					frameManHinhChinh.setExtendedState(JFrame.MAXIMIZED_BOTH);
					btnMoRongCuaSo.setText("\uD83D\uDDD6");
					cr.deregisterComponent(frameManHinhChinh);
					fullManHinh = true;
				}
				// nếu đang full screen
				else {
					if (kichThuoc == null) {
						kichThuoc = new Dimension(chieuRongMacDinh, chieuCaoMacDinh);
					}
					frameManHinhChinh.setSize(kichThuoc);

					if (toaDoX == 0 && toaDoY == 0) {
						frameManHinhChinh.setLocationRelativeTo(null);
					} else {
						frameManHinhChinh.setLocation(toaDoX, toaDoY);
					}

					btnMoRongCuaSo.setText("\uD83D\uDDD7");
					cr.registerComponent(frameManHinhChinh);
					fullManHinh = false;
				}
			}
		});
		
		btnAnChuongTrinh = new CustomButton("\uD83D\uDDD5");
		btnAnChuongTrinh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnChuongTrinh.setText("-");
		btnAnChuongTrinh.setOpaque(false);
		btnAnChuongTrinh.setForeground(Theme.white);
		btnAnChuongTrinh.setFont(new Font("Segoe UI Black", Font.BOLD, 31));
		btnAnChuongTrinh.setContentAreaFilled(false);
		btnAnChuongTrinh.setBorderPainted(false);
		btnAnChuongTrinh.setBackground(new Color(255, 255, 255, 0));
		btnAnChuongTrinh.setHoverForeground(new Color(122, 240, 238));
		btnAnChuongTrinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameManHinhChinh.setState(JFrame.ICONIFIED);
			}
		});
		
		JLabel lblBieuTuongUngDung = new JLabel("");
		lblBieuTuongUngDung.setToolTipText("Hướng dẫn sử dụng");
		lblBieuTuongUngDung.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBieuTuongUngDung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URL("https://httcinema.netlify.com").toURI());
				} catch (Exception ex) {
				}
			}
		});
		lblBieuTuongUngDung.setHorizontalAlignment(SwingConstants.CENTER);
		lblBieuTuongUngDung.setIcon(new ImageIcon(ManHinhChinhJFrame.class.getResource("/com/httcinema/icon/app-icon-small-4.png")));
		
		GroupLayout gl_pnlThanhDieuHuong = new GroupLayout(pnlThanhDieuHuong);
		gl_pnlThanhDieuHuong.setHorizontalGroup(
			gl_pnlThanhDieuHuong.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlThanhDieuHuong.createSequentialGroup()
					.addComponent(lblBieuTuongUngDung)
					.addPreferredGap(ComponentPlacement.RELATED, 438, Short.MAX_VALUE)
					.addComponent(btnAnChuongTrinh, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMoRongCuaSo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnThoatChuongTrinh, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnlThanhDieuHuong.setVerticalGroup(
			gl_pnlThanhDieuHuong.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlThanhDieuHuong.createSequentialGroup()
					.addGroup(gl_pnlThanhDieuHuong.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBieuTuongUngDung, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
						.addComponent(btnAnChuongTrinh, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThoatChuongTrinh, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
						.addComponent(btnMoRongCuaSo, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
					.addContainerGap())
		);
		pnlThanhDieuHuong.setLayout(gl_pnlThanhDieuHuong);
		
		pnlPhu = new JPanel();
		pnlPhu.setBackground(Color.WHITE);
		GroupLayout gl_pnlChinh = new GroupLayout(pnlChinh);
		gl_pnlChinh.setHorizontalGroup(
			gl_pnlChinh.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlThanhDieuHuong, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
				.addComponent(pnlPhu, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
		);
		gl_pnlChinh.setVerticalGroup(
			gl_pnlChinh.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlChinh.createSequentialGroup()
					.addComponent(pnlThanhDieuHuong, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(pnlPhu, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
		);
		
		
		pnlThanhCongCu = new JPanel();
		pnlThanhCongCu.setBorder(null);
		pnlThanhCongCu.setBackground(new Color(53, 60, 68));
		
		pnlLopHienThi = new CustomSlidePanel();
		pnlLopHienThi.setBackground(Color.WHITE);
		pnlLopHienThi.setBorder(null);

		gl_pnlPhu = new GroupLayout(pnlPhu);
		gl_pnlPhu.setHorizontalGroup(
			gl_pnlPhu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPhu.createSequentialGroup()
					.addComponent(pnlThanhCongCu, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(pnlLopHienThi, GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlPhu.setVerticalGroup(
			gl_pnlPhu.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlPhu.createSequentialGroup()
					.addGroup(gl_pnlPhu.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlPhu.createSequentialGroup()
							.addContainerGap()
							.addComponent(pnlLopHienThi, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
							.addGap(11))
						.addComponent(pnlThanhCongCu, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE))
					.addGap(0))
		);
//		pnlLopHienThi.setLayout(new CardLayout(0, 0));
		
		pnlParentLichChieu = new JPanel();
		pnlParentLichChieu.setName("pnlParentLichChieu");
		pnlLopHienThi.add(pnlParentLichChieu, pnlParentLichChieu.getName());
		
		pnlLichChieu = new LichChieuJScrollPane();
		pnlLichChieu.setBorder(null);
		GroupLayout gl_pnlParentLichChieu = new GroupLayout(pnlParentLichChieu);
		gl_pnlParentLichChieu.setHorizontalGroup(
			gl_pnlParentLichChieu.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlLichChieu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		gl_pnlParentLichChieu.setVerticalGroup(
			gl_pnlParentLichChieu.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlLichChieu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
		);
		pnlParentLichChieu.setLayout(gl_pnlParentLichChieu);
		
		pnlParentQuanLyPhim = new JPanel();
		pnlParentQuanLyPhim.setName("pnlParentQuanLyPhim");
		pnlLopHienThi.add(pnlParentQuanLyPhim, pnlParentQuanLyPhim.getName());
		
		pnlQuanLyPhim = new QuanLyPhimJScrollPane();
		pnlQuanLyPhim.setBorder(null);
		GroupLayout gl_pnlParentQuanLyPhim = new GroupLayout(pnlParentQuanLyPhim);
		gl_pnlParentQuanLyPhim.setHorizontalGroup(
			gl_pnlParentQuanLyPhim.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlQuanLyPhim, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
		);
		gl_pnlParentQuanLyPhim.setVerticalGroup(
			gl_pnlParentQuanLyPhim.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlQuanLyPhim, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
		);
		pnlParentQuanLyPhim.setLayout(gl_pnlParentQuanLyPhim);
		
		pnlParentQuanLyGiaVe = new JPanel();
		pnlParentQuanLyGiaVe.setName("pnlParentQuanLyGiaVe");
		pnlLopHienThi.add(pnlParentQuanLyGiaVe, pnlParentQuanLyGiaVe.getName());
		
		pnlQuanLyGiaVe = new QuanLyGiaVeJScrollPane();
		pnlQuanLyGiaVe.setBorder(null);
		GroupLayout gl_pnlParentQuanLyGiaVe = new GroupLayout(pnlParentQuanLyGiaVe);
		gl_pnlParentQuanLyGiaVe.setHorizontalGroup(
			gl_pnlParentQuanLyGiaVe.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlQuanLyGiaVe, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
		);
		gl_pnlParentQuanLyGiaVe.setVerticalGroup(
			gl_pnlParentQuanLyGiaVe.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlQuanLyGiaVe, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
		);
		pnlParentQuanLyGiaVe.setLayout(gl_pnlParentQuanLyGiaVe);
		
		pnlParentQuanLyLichChieu = new JPanel();
		pnlParentQuanLyLichChieu.setName("pnlParentQuanLyLichChieu");
		pnlLopHienThi.add(pnlParentQuanLyLichChieu, pnlParentQuanLyLichChieu.getName());
		
		pnlQuanLyLichChieu = new QuanLyLichChieuJScrollPane();
		pnlQuanLyLichChieu.setBorder(null);
		GroupLayout gl_pnlParentQuanLyLichChieu = new GroupLayout(pnlParentQuanLyLichChieu);
		gl_pnlParentQuanLyLichChieu.setHorizontalGroup(
			gl_pnlParentQuanLyLichChieu.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlQuanLyLichChieu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
		);
		gl_pnlParentQuanLyLichChieu.setVerticalGroup(
			gl_pnlParentQuanLyLichChieu.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlQuanLyLichChieu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
		);
		pnlParentQuanLyLichChieu.setLayout(gl_pnlParentQuanLyLichChieu);
		
		pnlParentQuanLyVe = new JPanel();
		pnlParentQuanLyVe.setName("pnlParentQuanLyVe");
		pnlLopHienThi.add(pnlParentQuanLyVe, pnlParentQuanLyVe.getName());
		
		pnlQuanLyHoaDonVe = new QuanLyVeJScrollPane();
		pnlQuanLyHoaDonVe.setBorder(null);
		GroupLayout gl_pnlParentQuanLyHoaDonVe = new GroupLayout(pnlParentQuanLyVe);
		gl_pnlParentQuanLyHoaDonVe.setHorizontalGroup(
			gl_pnlParentQuanLyHoaDonVe.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlQuanLyHoaDonVe, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
		);
		gl_pnlParentQuanLyHoaDonVe.setVerticalGroup(
			gl_pnlParentQuanLyHoaDonVe.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlQuanLyHoaDonVe, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
		);
		pnlParentQuanLyVe.setLayout(gl_pnlParentQuanLyHoaDonVe);
		
		pnlParentQuanLyNhanVien = new JPanel();
		pnlParentQuanLyNhanVien.setName("pnlParentQuanLyNhanVien");
		pnlLopHienThi.add(pnlParentQuanLyNhanVien, pnlParentQuanLyNhanVien.getName());
		
		pnlQuanLyNhanVien = new QuanLyNhanVienJScrollPane();
		pnlQuanLyNhanVien.setBorder(null);
		GroupLayout gl_pnlParentQuanLyNhanVien = new GroupLayout(pnlParentQuanLyNhanVien);
		gl_pnlParentQuanLyNhanVien.setHorizontalGroup(
			gl_pnlParentQuanLyNhanVien.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlQuanLyNhanVien, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
		);
		gl_pnlParentQuanLyNhanVien.setVerticalGroup(
			gl_pnlParentQuanLyNhanVien.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlQuanLyNhanVien, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
		);
		pnlParentQuanLyNhanVien.setLayout(gl_pnlParentQuanLyNhanVien);
		
		pnlParentQuanLyThongKe = new JPanel();
		pnlParentQuanLyThongKe.setName("pnlParentQuanLyThongKe");
		pnlLopHienThi.add(pnlParentQuanLyThongKe, pnlParentQuanLyThongKe.getName());
		
		pnlQuanLyThongKe = new QuanLyThongKeJScrollPane();
		pnlQuanLyThongKe.setBorder(null);
		GroupLayout gl_pnlParentQuanLyThongKe = new GroupLayout(pnlParentQuanLyThongKe);
		gl_pnlParentQuanLyThongKe.setHorizontalGroup(
			gl_pnlParentQuanLyThongKe.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlQuanLyThongKe, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
		);
		gl_pnlParentQuanLyThongKe.setVerticalGroup(
			gl_pnlParentQuanLyThongKe.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlQuanLyThongKe, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
		);
		pnlParentQuanLyThongKe.setLayout(gl_pnlParentQuanLyThongKe);
		
		pnlThongTinNguoiDung = new ManHinhChinhJFrameThongTinNguoiDungJPanel(ShareHelper.USER);
		
		pnlMenu = new JPanel();
		pnlMenu.setBackground(pnlThanhCongCu.getBackground());
		pnlMenu.setLayout(null);
		
		pnlActive = new JPanel();
		pnlActive.setBounds(0, 0, 264, 50);
		pnlMenu.add(pnlActive);
		pnlActive.setBorder(null);
		pnlActive.setBackground(new Color(255, 255, 255, 80));
		pnlActive.setLayout(null);
		
		pnlSubActive = new JPanel();
		pnlSubActive.setBackground(Theme.white);
		pnlSubActive.setBounds(0, 0, 5, 50);
		pnlActive.add(pnlSubActive);
		
		btnLichChieu = new CustomButton("  Lịch chiếu");
		btnLichChieu.setIcon(new ImageIcon(ManHinhChinhJFrame.class.getResource("/com/httcinema/icon/button-lich-chieu.png")));
		btnLichChieu.setBounds(0, 0, 264, 50);
		pnlMenu.add(btnLichChieu);
		btnLichChieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				slidePane(pnlParentLichChieu, btnLichChieu);
			}
		});
		btnLichChieu.setHorizontalAlignment(SwingConstants.LEFT);
		Theme.setDefaultButtonFormat(btnLichChieu);
		btnLichChieu.setForeground(new Color(212, 212, 212));
		btnLichChieu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLichChieu.setHoverForeAndBackground(Theme.white, Theme.green);
		btnMenus.add(btnLichChieu);
		
		// Các chức năng chỉ dành cho quản lý
		if (ShareHelper.USER.getMaVaiTro().equals(ROLE_MANAGER)) {
			btnQuanLyPhim = new CustomButton("  Quản lý phim");
			btnQuanLyPhim.setIcon(new ImageIcon(ManHinhChinhJFrame.class.getResource("/com/httcinema/icon/button-quan-ly-phim.png")));
			btnQuanLyPhim.setBounds(0, 50, 264, 50);
			pnlMenu.add(btnQuanLyPhim);
			btnQuanLyPhim.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					slidePane(pnlParentQuanLyPhim, btnQuanLyPhim);
				}
			});
			btnQuanLyPhim.setHorizontalAlignment(SwingConstants.LEFT);
			Theme.setDefaultButtonFormat(btnQuanLyPhim);
			btnQuanLyPhim.setForeground(new Color(212, 212, 212));
			btnQuanLyPhim.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnQuanLyPhim.setHoverForeAndBackground(Theme.white, Theme.green);
			btnMenus.add(btnQuanLyPhim);
			
			btnQuanLyGiaVe = new CustomButton("  Quản lý giá vé");
			btnQuanLyGiaVe.setIcon(new ImageIcon(ManHinhChinhJFrame.class.getResource("/com/httcinema/icon/button-quan-ly-gia-ve.png")));
			btnQuanLyGiaVe.setBounds(0, 100, 264, 50);
			pnlMenu.add(btnQuanLyGiaVe);
			btnQuanLyGiaVe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					slidePane(pnlParentQuanLyGiaVe, btnQuanLyGiaVe);
				}
			});
			btnQuanLyGiaVe.setHorizontalAlignment(SwingConstants.LEFT);
			Theme.setDefaultButtonFormat(btnQuanLyGiaVe);
			btnQuanLyGiaVe.setForeground(new Color(212, 212, 212));
			btnQuanLyGiaVe.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnQuanLyGiaVe.setHoverForeAndBackground(Theme.white, Theme.green);
			btnMenus.add(btnQuanLyGiaVe);
			
			btnQuanLyLichChieu = new CustomButton("  Quản lý lịch chiếu");
			btnQuanLyLichChieu.setIcon(new ImageIcon(ManHinhChinhJFrame.class.getResource("/com/httcinema/icon/button-quan-ly-lich-chieu.png")));
			btnQuanLyLichChieu.setBounds(0, 150, 264, 50);
			pnlMenu.add(btnQuanLyLichChieu);
			btnQuanLyLichChieu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					slidePane(pnlParentQuanLyLichChieu, btnQuanLyLichChieu);
				}
			});
			btnQuanLyLichChieu.setHorizontalAlignment(SwingConstants.LEFT);
			Theme.setDefaultButtonFormat(btnQuanLyLichChieu);
			btnQuanLyLichChieu.setForeground(new Color(212, 212, 212));
			btnQuanLyLichChieu.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnQuanLyLichChieu.setHoverForeAndBackground(Theme.white, Theme.green);
			btnMenus.add(btnQuanLyLichChieu);
			
			btnQuanLyVe = new CustomButton("  Quản lý vé");
			btnQuanLyVe.setIcon(new ImageIcon(ManHinhChinhJFrame.class.getResource("/com/httcinema/icon/button-quan-ly-ve.png")));
			btnQuanLyVe.setBounds(0, 200, 264, 50);
			pnlMenu.add(btnQuanLyVe);
			btnQuanLyVe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					slidePane(pnlParentQuanLyVe, btnQuanLyVe);
				}
			});
			btnQuanLyVe.setHorizontalAlignment(SwingConstants.LEFT);
			Theme.setDefaultButtonFormat(btnQuanLyVe);
			btnQuanLyVe.setForeground(new Color(212, 212, 212));
			btnQuanLyVe.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnQuanLyVe.setHoverForeAndBackground(Theme.white, Theme.green);
			btnMenus.add(btnQuanLyVe);
			
			btnQuanLyNhanVien = new CustomButton("  Quản lý nhân viên");
			btnQuanLyNhanVien.setIcon(new ImageIcon(ManHinhChinhJFrame.class.getResource("/com/httcinema/icon/button-quan-ly-nhan-vien.png")));
			btnQuanLyNhanVien.setBounds(0, 250, 264, 50);
			pnlMenu.add(btnQuanLyNhanVien);
			btnQuanLyNhanVien.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					slidePane(pnlParentQuanLyNhanVien, btnQuanLyNhanVien);
				}
			});
			btnQuanLyNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
			Theme.setDefaultButtonFormat(btnQuanLyNhanVien);
			btnQuanLyNhanVien.setForeground(new Color(212, 212, 212));
			btnQuanLyNhanVien.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnQuanLyNhanVien.setHoverForeAndBackground(Theme.white, Theme.green);
			btnMenus.add(btnQuanLyNhanVien);
			
			btnQuanLyThongKe = new CustomButton("  Quản lý thống kê");
			btnQuanLyThongKe.setIcon(new ImageIcon(ManHinhChinhJFrame.class.getResource("/com/httcinema/icon/button-quan-ly-thong-ke.png")));
			btnQuanLyThongKe.setBounds(0, 300, 264, 50);
			pnlMenu.add(btnQuanLyThongKe);
			btnQuanLyThongKe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					slidePane(pnlParentQuanLyThongKe, btnQuanLyThongKe);
				}
			});
			btnQuanLyThongKe.setHorizontalAlignment(SwingConstants.LEFT);
			Theme.setDefaultButtonFormat(btnQuanLyThongKe);
			btnQuanLyThongKe.setForeground(new Color(212, 212, 212));
			btnQuanLyThongKe.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnQuanLyThongKe.setHoverForeAndBackground(Theme.white, Theme.green);
			btnMenus.add(btnQuanLyThongKe);
		}
		
		btnDangXuat = new CustomButton("Đăng xuất");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (DialogHelper.confirm(frameManHinhChinh, "Bạn có chắc sẽ đăng xuất?")) {
					frameManHinhChinh.dispose();
					ShareHelper.USER = null;
					DangNhapJFrame.main(null);
				}
			}
		});
		Theme.setDefaultButtonFormat(btnDangXuat);
		btnDangXuat.setForeground(Theme.lightDanger);
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDangXuat.setHoverForeAndBackground(Theme.white, Theme.danger);
		
		btnDongHo = new CustomButton("");
		btnDongHo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDongHo.setForeground(Color.WHITE);
		btnDongHo.setBackground(Theme.dark);
//		btnDongHo.setEnabled(false);
		
		GroupLayout gl_pnlThanhCongCu = new GroupLayout(pnlThanhCongCu);
		gl_pnlThanhCongCu.setHorizontalGroup(
			gl_pnlThanhCongCu.createParallelGroup(Alignment.LEADING)
				.addComponent(btnDangXuat, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
				.addComponent(pnlThongTinNguoiDung, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(pnlMenu, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
				.addComponent(btnDongHo, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
		);
		gl_pnlThanhCongCu.setVerticalGroup(
			gl_pnlThanhCongCu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlThanhCongCu.createSequentialGroup()
					.addComponent(pnlThongTinNguoiDung, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(pnlMenu, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addComponent(btnDongHo, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDangXuat, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
		);
		pnlThanhCongCu.setLayout(gl_pnlThanhCongCu);
		
		pnlPhu.setLayout(gl_pnlPhu);
		pnlChinh.setLayout(gl_pnlChinh);
		
		frameManHinhChinh.getContentPane().setLayout(groupLayout);
		slidePane(pnlParentLichChieu, btnLichChieu);
	}
	
	private Timer timerActivePanel;
	private CustomButton btnDongHo;
	private JPanel pnlChinh;
	private void slidePane(JPanel pnl, JButton btn) {
		setInactiveMenuButtons(btn);
		
		if (timerActivePanel != null) {
			timerActivePanel.stop();
			timerActivePanel = null;
		}
		
//		pnlLopHienThi.nextPanel(15, 15, pnl, JPanelSlider.right);
		
		// lướt con trỏ đến nút
		pnlActive.setLocation(btn.getLocation().x, btn.getLocation().y);
		pnlLopHienThi.nextPanel(pnl);
	}
	
	private void setInactiveMenuButtons(JButton btn) {
		for (int i = 0; i < btnMenus.size(); i++) {
			btnMenus.get(i).setEnabled(true);
		}
		btn.setEnabled(false);
	}
	
	/**
	 * this method turns on the clock and shows it to a JLabel object
	 * 
	 * @param btn location where the clock will be shown
	 */
	public void clockOn(JButton btn) {
		// we create a thread object and define run() method
		Thread thread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						// we get current time from system by create an object of type Date and set the
						// pattern for time by an object of type SimpleDateFormat
						Date now = new Date();
						SimpleDateFormat formater = new SimpleDateFormat();

						// set the pattern for time format
						formater.applyPattern("HH:mm:ss");
						String time = formater.format(now);

						formater.applyPattern("dd-MM-yyyy (EEE)");
						String date = formater.format(now);
						
						btn.setText("<html><center>" + time + "<br>" + date + "</center></html>");

						// pause thread for 10 second
						Thread.sleep(1000);
					} catch (Exception ex) {

					}
				}
			}
		};

		// after having thread, we start that thread
		thread.start();
	}
	// end of clockOn
}
