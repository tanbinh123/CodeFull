package com.httcinema.ui.subpanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import com.httcinema.custom_jcomponents.CustomButton;
import com.httcinema.custom_jcomponents.CustomDialog;
import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.helper.DateHelper;
import com.httcinema.helper.DialogHelper;
import com.httcinema.helper.ShareHelper;
import com.httcinema.helper.ThreadHelper;
import com.httcinema.model.Ghe;
import com.httcinema.model.LichChieu;
import com.httcinema.model.Phim;
import com.httcinema.model.Ve;
import com.httcinema.ui.ChaoJPanel;

import diu.swe.habib.JPanelSlider.JPanelSlider;

public class LichChieuJScrollPanePhongChieuJDialog extends CustomDialog {

	private JDialog thisDialog;
	private static String duongDanFile = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8836826428938084902L;
	private JPanel pnlThongTinXuatChieu;
	
	private JPanel pnlParentChonGia;
	private JPanel pnlParentXemLai;

	private JPanel pnlParentChonGhe;
	private CardLayout pnlThongTinChiTietLayout;
	private JPanelSlider pnlThongTinChiTiet;

	public static ArrayList<Ghe> gheDuocMuas = new ArrayList<Ghe>();
	public static ArrayList<Ve> ves = new ArrayList<Ve>();
	public static Phim phim;
	public static LichChieu lichChieu;
	public static double tongCong;
	
	private LichChieuJScrollPanePhongChieuJDialogGheJPanel pnlGhe;
	private JScrollPane pnlChonGia;
	private JScrollPane pnlXemLai;
	
	private CustomButton btnChonGia;
	private CustomButton btnTiepTuc;
	private CustomButton btnInVe;
	private CustomButton btnQuayLai;
	private CustomButton btnHuy;

	public static void showDialog(Component owner, Phim phim, LichChieu lichChieu) {
		LichChieuJScrollPanePhongChieuJDialog dialog;
		if (owner instanceof JDialog) {
			dialog = new LichChieuJScrollPanePhongChieuJDialog((Dialog) owner);
		}
		else {
			dialog = new LichChieuJScrollPanePhongChieuJDialog((Frame) owner);
		}
		
		dialog.init(phim, lichChieu);
		dialog.setLocationRelativeTo(owner);
		dialog.fadeIn(dialog);
	}

	public LichChieuJScrollPanePhongChieuJDialog(Frame owner) {
		super(owner);
	}
	
	public LichChieuJScrollPanePhongChieuJDialog(Dialog owner) {
		super(owner);
	}

	public LichChieuJScrollPanePhongChieuJDialog() {
		setUndecorated(true);
		init(null, null);
	}

	/**
	 * Create the dialog.
	 */
	public void init(Phim phim, LichChieu lichChieu) {
		LichChieuJScrollPanePhongChieuJDialog.phim = phim;
		LichChieuJScrollPanePhongChieuJDialog.lichChieu = lichChieu;
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 810, 491);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		thisDialog = this;
		
		pnlThongTinXuatChieu = new JPanel();
		pnlThongTinXuatChieu.setBorder(new LineBorder(Color.WHITE));
		pnlThongTinXuatChieu.setBackground(Theme.dark);
		pnlThongTinXuatChieu.setBounds(0, 0, 810, 491);
		getContentPane().add(pnlThongTinXuatChieu);
		pnlThongTinXuatChieu.addMouseListener(mouseAdapter);
		pnlThongTinXuatChieu.addMouseMotionListener(mouseMotionAdapter);
		pnlThongTinXuatChieu.setLayout(null);
		
		btnChonGia = new CustomButton("Chọn giá");
		btnChonGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// reset lại mảng chứa các ghế được mua
				gheDuocMuas.clear();
				
				// quét từng ghế, nếu ghế được chọn thì đẩy vào mảng chứa các ghế được mua
				for (int i = 0; i < pnlGhe.chkGhes.size(); i++) {
					if (pnlGhe.chkGhes.get(i).isSelected()) {
						gheDuocMuas.add(new Ghe(pnlGhe.chkGhes.get(i).getText()));
					}
				}
				
				if (gheDuocMuas.size() == 0) {
					DialogHelper.error(thisDialog, "Chưa ghế nào được chọn");
					return;
				}
				
				refreshPnlParentChonGia();
				currentPane = 2;
				setState();
				pnlThongTinChiTiet.nextPanel(15, 15, pnlParentChonGia, JPanelSlider.left);
			}
		});
		Theme.setDefaultButtonFormat(btnChonGia);
		btnChonGia.setBackground(new Color(13, 94, 94));
		btnChonGia.setHoverBackground(Theme.green);
		btnChonGia.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnChonGia.setBounds(630, 431, 160, 40);
		pnlThongTinXuatChieu.add(btnChonGia);
		
		btnTiepTuc = new CustomButton("Tiếp tục");
		btnTiepTuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshPnlParentXemLai();
				currentPane = 3;
				setState();
				pnlThongTinChiTiet.nextPanel(15, 15, pnlParentXemLai, JPanelSlider.left);
			}
		});
		Theme.setDefaultButtonFormat(btnTiepTuc);
		btnTiepTuc.setBackground(new Color(13, 94, 94));
		btnTiepTuc.setHoverBackground(Theme.green);
		btnTiepTuc.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnTiepTuc.setBounds(630, 431, 160, 40);
		pnlThongTinXuatChieu.add(btnTiepTuc);
		
		btnInVe = new CustomButton("In vé");
		btnInVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (DialogHelper.confirm(thisDialog, "Bắt đầu in tất cả vé?")) {
					ShareHelper.setAppReady();
					Window win = SwingUtilities.getWindowAncestor((AbstractButton) arg0.getSource());
					
					ThreadHelper.showWaitDialog(
							win,
							() -> {
								duongDanFile = LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPaneDanhSachVeJPanel.insertVe();
							}, 
							() -> {
								DialogHelper.success(thisDialog, "In vé thành công");
								
								// hỏi người dùng có muốn mở các vé đã in không
								if (DialogHelper.confirm(thisDialog, "Bạn có muốn xem các vé đã in?")) {
									try {
										Desktop.getDesktop().open(new File(duongDanFile));
									} catch (IOException e) {
										DialogHelper.error(thisDialog, "Mở file thất bại");
									}
								}
								
								fadeOut();
							});
				}
			}
		});
		Theme.setDefaultButtonFormat(btnInVe);
		btnInVe.setBackground(new Color(13, 94, 94));
		btnInVe.setHoverBackground(Theme.green);
		btnInVe.setBounds(630, 431, 160, 40);
		btnInVe.setVisible(false);
		btnInVe.setFont(new Font("Tahoma", Font.BOLD, 17));
		pnlThongTinXuatChieu.add(btnInVe);
		
		btnHuy = new CustomButton("Hủy");
		Theme.setDefaultButtonFormat(btnHuy);
		btnHuy.setBackground(new Color(36, 36, 36));
		btnHuy.setHoverBackground(Color.BLACK);
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (DialogHelper.confirm(thisDialog, "Xóa hết thao tác và quay về màn hình chính?")) {
					fadeOut();
				}
			}
		});
		btnHuy.setBounds(20, 431, 160, 40);
		pnlThongTinXuatChieu.add(btnHuy);
		
		btnQuayLai = new CustomButton("Quay lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentPane == 2) {
					currentPane = 1;
					setState();
					pnlThongTinChiTiet.nextPanel(15, 15, pnlParentChonGhe, JPanelSlider.right);
				}
				else if (currentPane == 3) {
					refreshPnlParentChonGia();
					currentPane = 2;
					setState();
					pnlThongTinChiTiet.nextPanel(15, 15, pnlParentChonGia, JPanelSlider.right);
				}
			}
		});
		Theme.setDefaultButtonFormat(btnQuayLai);
		btnQuayLai.setBackground(new Color(36, 36, 36));
		btnQuayLai.setHoverBackground(Color.BLACK);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnQuayLai.setBounds(190, 431, 160, 40);
		btnQuayLai.setVisible(false);
		pnlThongTinXuatChieu.add(btnQuayLai);
		
		JPanel pnlThongTinXuatVe = new JPanel();
		pnlThongTinXuatVe.setBackground(Theme.dark);
		pnlThongTinXuatVe.setBounds(10, 11, 790, 407);
		pnlThongTinXuatChieu.add(pnlThongTinXuatVe);
		pnlThongTinXuatVe.setLayout(null);
		
		pnlThongTinChiTietLayout = new CardLayout(0, 0);	
		
		pnlThongTinChiTiet = new JPanelSlider();
		pnlThongTinChiTiet.setBorder(null);
		pnlThongTinChiTiet.setBackground(Color.WHITE);
		pnlThongTinChiTiet.setBounds(352, 11, 428, 385);
		pnlThongTinXuatVe.add(pnlThongTinChiTiet);
		pnlThongTinChiTiet.setLayout(pnlThongTinChiTietLayout);
		
		pnlParentChonGhe = new JPanel();
		pnlParentChonGhe.setBackground(Color.WHITE);
		pnlThongTinChiTiet.add(pnlParentChonGhe, "name_1610660837309694");
		pnlParentChonGhe.setLayout(null);
		
		pnlGhe = new LichChieuJScrollPanePhongChieuJDialogGheJPanel();
		pnlGhe.setBounds(93, 84, 325, 290);
		pnlParentChonGhe.add(pnlGhe);
		
		JLabel lblManHinh = new JLabel("Màn hình");
		lblManHinh.setBounds(93, 11, 325, 30);
		pnlParentChonGhe.add(lblManHinh);
		lblManHinh.setForeground(Color.WHITE);
		lblManHinh.setBackground(Theme.dark);
		lblManHinh.setOpaque(true);
		lblManHinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblManHinh.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblLoiVao = new JLabel("");
		lblLoiVao.setBounds(10, 11, 30, 30);
		pnlParentChonGhe.add(lblLoiVao);
		lblLoiVao.setIcon(new ImageIcon(LichChieuJScrollPanePhongChieuJDialog.class.getResource("/com/httcinema/icon/arrow-right-green.png")));
		lblLoiVao.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblLoiRa = new JLabel("");
		lblLoiRa.setBounds(10, 344, 30, 30);
		pnlParentChonGhe.add(lblLoiRa);
		lblLoiRa.setIcon(new ImageIcon(LichChieuJScrollPanePhongChieuJDialog.class.getResource("/com/httcinema/icon/arrow-left-dark.png")));
		lblLoiRa.setHorizontalAlignment(SwingConstants.LEFT);
		
		pnlParentChonGia = new JPanel();
		pnlParentChonGia.setBackground(Color.WHITE);
		pnlThongTinChiTiet.add(pnlParentChonGia, "name_1610756837250039");
		
		pnlChonGia = new LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPane(lichChieu, phim);
		
		GroupLayout gl_pnlParentChonGia = new GroupLayout(pnlParentChonGia);
		gl_pnlParentChonGia.setHorizontalGroup(
			gl_pnlParentChonGia.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlChonGia, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
		);
		gl_pnlParentChonGia.setVerticalGroup(
			gl_pnlParentChonGia.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlChonGia, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
		);
		pnlParentChonGia.setLayout(gl_pnlParentChonGia);
		
		pnlParentXemLai = new JPanel();
		pnlParentXemLai.setBackground(Theme.green);
		pnlThongTinChiTiet.add(pnlParentXemLai, "name_91368621922370");
		pnlParentXemLai.setLayout(null);
		
		pnlXemLai = new LichChieuJScrollPanePhongChieuJDialogXemLaiJScrollPane();
		pnlXemLai.setBounds(0, 96, 428, 289);
		pnlParentXemLai.add(pnlXemLai);
		
		JPanel pnlThongTinPhim = new JPanel();
		pnlThongTinPhim.setBorder(null);
		pnlThongTinPhim.setBackground(Theme.dark);
		pnlThongTinPhim.setBounds(10, 11, 332, 385);
		pnlThongTinXuatVe.add(pnlThongTinPhim);
		pnlThongTinPhim.setLayout(null);
		
		JLabel lblHinhPhim = new JLabel("");
		lblHinhPhim.setBorder(new LineBorder(Theme.white, 1));
		lblHinhPhim.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinhPhim.setBounds(91, 11, 150, 192);
		Image image = ShareHelper.resizeImage(ShareHelper.readImage(phim.getHinh(), ShareHelper.thuMucHinhPhim), lblHinhPhim.getWidth(), lblHinhPhim.getHeight());
		lblHinhPhim.setIcon(new ImageIcon(image));
		pnlThongTinPhim.add(lblHinhPhim);
		
		JLabel lblNgayChieu = new JLabel("Ngày chiếu:");
		lblNgayChieu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgayChieu.setForeground(Color.WHITE);
		lblNgayChieu.setBounds(10, 262, 120, 30);
		pnlThongTinPhim.add(lblNgayChieu);
		
		JLabel lblGioChieu = new JLabel("Giờ chiếu:");
		lblGioChieu.setForeground(Color.WHITE);
		lblGioChieu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGioChieu.setBounds(10, 303, 120, 30);
		pnlThongTinPhim.add(lblGioChieu);
		
		JLabel lblPhongChieu = new JLabel("Phòng chiếu:");
		lblPhongChieu.setForeground(Color.WHITE);
		lblPhongChieu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhongChieu.setBounds(10, 344, 120, 30);
		pnlThongTinPhim.add(lblPhongChieu);
		
		JLabel lblTenPhim = new JLabel(phim.getTenPhim());
		lblTenPhim.setForeground(Color.WHITE);
		lblTenPhim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenPhim.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhim.setBounds(10, 214, 312, 37);
		pnlThongTinPhim.add(lblTenPhim);
		
		JLabel lblGiaTriNgayChieu = new JLabel(DateHelper.toString(lichChieu.getNgayChieu(), "dd-MM-yyyy"));
		lblGiaTriNgayChieu.setForeground(Color.WHITE);
		lblGiaTriNgayChieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaTriNgayChieu.setBounds(140, 262, 182, 30);
		pnlThongTinPhim.add(lblGiaTriNgayChieu);
		
		JLabel lblGiaTriGioChieu = new JLabel((lichChieu.getGioChieu() + "").substring(0, 5));
		lblGiaTriGioChieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaTriGioChieu.setForeground(Color.WHITE);
		lblGiaTriGioChieu.setBounds(140, 303, 182, 30);
		pnlThongTinPhim.add(lblGiaTriGioChieu);
		
		JLabel lblGiaTriPhongChieu = new JLabel(lichChieu.getMaPhongChieu() + "");
		lblGiaTriPhongChieu.setForeground(Color.WHITE);
		lblGiaTriPhongChieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaTriPhongChieu.setBounds(140, 346, 182, 30);
		pnlThongTinPhim.add(lblGiaTriPhongChieu);
	}

	private void refreshPnlParentChonGia() {
		pnlParentChonGia = new JPanel();
		pnlParentChonGia.setBackground(Color.WHITE);
		pnlThongTinChiTiet.add(pnlParentChonGia, "name_1610756837250039");
		pnlParentChonGia.setLayout(null);

		pnlChonGia = new LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPane(lichChieu, phim);
		pnlChonGia.setBounds(0, 0, 428, 385);
		pnlParentChonGia.add(pnlChonGia);
	}
	
	private void refreshPnlParentXemLai() {
		pnlParentXemLai = new JPanel();
		pnlParentXemLai.setBackground(Theme.green);
		pnlThongTinChiTiet.add(pnlParentXemLai, "name_1610756837250039");
		pnlParentXemLai.setLayout(null);

		pnlXemLai = new LichChieuJScrollPanePhongChieuJDialogXemLaiJScrollPane();
		pnlXemLai.setBounds(0, 96, 428, 289);
		pnlParentXemLai.add(pnlXemLai);
		
		JLabel lblSoLuongVe = new JLabel(LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPaneDanhSachVeJPanel.pnlVes.size() + " vé");
		lblSoLuongVe.setForeground(Theme.white);
		lblSoLuongVe.setBounds(10, 11, 115, 74);
		lblSoLuongVe.setFont(new Font("Tahoma", Font.BOLD, 17));
		pnlParentXemLai.add(lblSoLuongVe);
		
		String tongCongStr = new DecimalFormat("###,###,###,###,###,### VND").format(tongCong);
		JLabel lblTongCong = new JLabel("<html><strong>Tổng cộng: </strong>" + tongCongStr + "</html>");
		lblTongCong.setForeground(Theme.white);
		lblTongCong.setIcon(new ImageIcon(ChaoJPanel.class.getResource("/com/httcinema/icon/icon-money.png")));
		lblTongCong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTongCong.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTongCong.setBounds(135, 11, 283, 74);
		pnlParentXemLai.add(lblTongCong);
	}
	
	private int currentPane = 1;

	/**
	 * đặt các trạng thái cho nút nhấn khi chuyển Panel
	 * */
	private void setState() {
		// nếu đang ở panel chọn ghế
		if (currentPane == 1) {
			btnChonGia.setVisible(true);
			btnTiepTuc.setVisible(false);
			btnInVe.setVisible(false);
			
			btnQuayLai.setVisible(false);
		}
		
		// nếu đang ở panel chọn giá
		else if (currentPane == 2) {
			btnChonGia.setVisible(false);
			btnTiepTuc.setVisible(true);
			btnInVe.setVisible(false);
			
			btnQuayLai.setVisible(true);
		}
		
		// nếu đang ở panel xem lại
		else if (currentPane == 3) {
			btnChonGia.setVisible(false);
			btnTiepTuc.setVisible(false);
			btnInVe.setVisible(true);
			
			btnQuayLai.setVisible(true);
		}
	}
}