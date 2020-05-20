package com.httcinema.ui.subpanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.httcinema.custom_jcomponents.CustomButton;
import com.httcinema.custom_jcomponents.CustomDialog;
import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.dao.VeDAO;
import com.httcinema.helper.DateHelper;
import com.httcinema.helper.ShareHelper;
import com.httcinema.model.Ve;

@SuppressWarnings({ "unused", "serial" })
public class QuanLyVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog extends CustomDialog {
	
	public final static int THEM = 1;
	public final static int CAP_NHAT = 2;
	public final static int XEM_CHI_TIET = 3;
	private int trangThai;
	
	private JDialog thisDialog;

	private JLabel lblTenPhim;
	private JLabel lblNgayChieu;
	private JLabel lblGioChieu;
	private JLabel lblTenPhongChieu;
	private JLabel lblMaGhe;
	private JLabel lblGiaVe;
	private JLabel lblMoTa;
	private JLabel lblMaVe;
	private JLabel lblNgayTao;

	private CustomButton btnDong;
	
	public static void showDialog(Component owner, Ve ve, int trangThai) {
		QuanLyVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog dialog;
		if (owner instanceof JDialog) {
			dialog = new QuanLyVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog((Dialog) owner);
		}
		else {
			dialog = new QuanLyVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog((Frame) owner);
		}
		
		dialog.init(ve, trangThai);
		dialog.setLocationRelativeTo(owner);
		dialog.fadeIn(dialog);
	}

	public QuanLyVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog(Frame owner) {
		super(owner);
	}
	
	public QuanLyVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog(Dialog owner) {
		super(owner);
	}

	public QuanLyVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog() {
		setUndecorated(true);
		init(null, 1);
	}

	/**
	 * Create the dialog.
	 */
	public void init(Ve ve, int trangThai) {
		this.thisDialog = this;
		this.trangThai = trangThai;
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 720, 477);
		getContentPane().setLayout(null);
		
		JPanel pnlChinh = new JPanel();
		pnlChinh.setBorder(new LineBorder(Theme.dark, 3));
		pnlChinh.setBackground(Theme.white);
		pnlChinh.setBounds(0, 0, 720, 477);
		getContentPane().add(pnlChinh);
		pnlChinh.setLayout(null);
		{
			JPanel pnlVe = new JPanel();
			pnlVe.setBounds(10, 11, 700, 400);
			pnlChinh.add(pnlVe);
			pnlVe.setLayout(null);
			
			JPanel pnlHeader = new JPanel();
			pnlHeader.setBounds(0, 0, 700, 125);
			pnlVe.add(pnlHeader);
			pnlHeader.setBackground(new Color (53, 60, 68));
			pnlHeader.setLayout(null);
			{
				JLabel lbl_httcinema_netlify_com = new JLabel();
				lbl_httcinema_netlify_com.setFont(new Font("Tahoma", Font.BOLD, 14));
				lbl_httcinema_netlify_com.setForeground(new Color (46, 158, 158));
				lbl_httcinema_netlify_com.setText("httcinema.netlify.com");
				lbl_httcinema_netlify_com.setBounds(10, 10, 360, 20);
				pnlHeader.add(lbl_httcinema_netlify_com);
			}
			{
				JLabel lbl_HTT_CINEMA = new JLabel();
				lbl_HTT_CINEMA.setFont(new Font("SansSerif", Font.BOLD, 42));
				lbl_HTT_CINEMA.setForeground(new Color (46, 158, 158));
				lbl_HTT_CINEMA.setText("HTT CINEMA");
				lbl_HTT_CINEMA.setBounds(10, 30, 360, 70);
				pnlHeader.add(lbl_HTT_CINEMA);
			}
			{
				JLabel lbl_CONG_TY_TNHH_HTT_CINEMA = new JLabel();
				lbl_CONG_TY_TNHH_HTT_CINEMA.setForeground(Color.WHITE);
				lbl_CONG_TY_TNHH_HTT_CINEMA.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_CONG_TY_TNHH_HTT_CINEMA.setFont(new Font("SansSerif", Font.BOLD, 12));
				lbl_CONG_TY_TNHH_HTT_CINEMA.setText("CÔNG TY TNHH HTT CINEMA");
				lbl_CONG_TY_TNHH_HTT_CINEMA.setBounds(370, 10, 320, 20);
				pnlHeader.add(lbl_CONG_TY_TNHH_HTT_CINEMA);
			}
			{
				JLabel lbl_DiaChi = new JLabel();
				lbl_DiaChi.setFont(new Font("SansSerif", Font.PLAIN, 11));
				lbl_DiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_DiaChi.setForeground(Color.WHITE);
				lbl_DiaChi.setText("Số 260 Bình Quới, P. 28, Q. Bình Thạnh, TP. HCM");
				lbl_DiaChi.setBounds(370, 30, 320, 20);
				pnlHeader.add(lbl_DiaChi);
			}
			{
				JLabel lbl_SoDienThoai = new JLabel();
				lbl_SoDienThoai.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_SoDienThoai.setForeground(Color.WHITE);
				lbl_SoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 11));
				lbl_SoDienThoai.setText("Điện Thoại: (08) 28368489");
				lbl_SoDienThoai.setBounds(370, 49, 320, 20);
				pnlHeader.add(lbl_SoDienThoai);
			}
			{
				JLabel lbl_MaSoThue = new JLabel();
				lbl_MaSoThue.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_MaSoThue.setFont(new Font("SansSerif", Font.PLAIN, 11));
				lbl_MaSoThue.setForeground(Color.WHITE);
				lbl_MaSoThue.setText("Mã số thuế:  0154879653");
				lbl_MaSoThue.setBounds(370, 69, 320, 20);
				pnlHeader.add(lbl_MaSoThue);
			}
			{
				JPanel pnlChiTiet = new JPanel();
				pnlChiTiet.setBounds(0, 125, 700, 275);
				pnlVe.add(pnlChiTiet);
				pnlChiTiet.setBackground(new Color (53, 60, 68));
				pnlChiTiet.setLayout(null);
				{
					lblTenPhim = new JLabel();
					lblTenPhim.setText("@tenPhim");
					lblTenPhim.setForeground(Color.WHITE);
					lblTenPhim.setFont(new Font("SansSerif", Font.BOLD, 25));
					lblTenPhim.setBounds(40, 10, 390, 40);
					pnlChiTiet.add(lblTenPhim);
				}
				{
					lblNgayChieu = new JLabel();
					lblNgayChieu.setText("@ngayChieu");
					lblNgayChieu.setForeground(Color.WHITE);
					lblNgayChieu.setFont(new Font("SansSerif", Font.PLAIN, 16));
					lblNgayChieu.setBounds(40, 50, 190, 30);
					pnlChiTiet.add(lblNgayChieu);
				}
				{
					lblGioChieu = new JLabel();
					lblGioChieu.setText("@gioChieu");
					lblGioChieu.setForeground(Color.WHITE);
					lblGioChieu.setFont(new Font("SansSerif", Font.PLAIN, 16));
					lblGioChieu.setBounds(230, 50, 200, 30);
					pnlChiTiet.add(lblGioChieu);
				}
				{
					lblTenPhongChieu = new JLabel();
					lblTenPhongChieu.setText("@PC");
					lblTenPhongChieu.setForeground(Color.WHITE);
					lblTenPhongChieu.setFont(new Font("SansSerif", Font.BOLD, 25));
					lblTenPhongChieu.setBounds(40, 80, 50, 40);
					pnlChiTiet.add(lblTenPhongChieu);
				}
				{
					lblMaGhe = new JLabel();
					lblMaGhe.setText("@maGhe");
					lblMaGhe.setForeground(Color.WHITE);
					lblMaGhe.setFont(new Font("SansSerif", Font.BOLD, 25));
					lblMaGhe.setBounds(90, 80, 140, 40);
					pnlChiTiet.add(lblMaGhe);
				}
				{
					JLabel lblGhe = new JLabel();
					lblGhe.setForeground(Color.WHITE);
					lblGhe.setFont(new Font("SansSerif", Font.PLAIN, 16));
					lblGhe.setText("Ghế");
					lblGhe.setBounds(90, 120, 140, 30);
					pnlChiTiet.add(lblGhe);
				}
				{
					lblMaVe = new JLabel();
					lblMaVe.setText("@maVe");
					lblMaVe.setForeground(Color.WHITE);
					lblMaVe.setFont(new Font("SansSerif", Font.PLAIN, 19));
					lblMaVe.setBounds(110, 220, 320, 30);
					pnlChiTiet.add(lblMaVe);
				}
				{
					JLabel lblMaVe = new JLabel();
					lblMaVe.setText("Mã vé:");
					lblMaVe.setForeground(Color.WHITE);
					lblMaVe.setFont(new Font("SansSerif", Font.BOLD, 19));
					lblMaVe.setBounds(40, 220, 70, 30);
					pnlChiTiet.add(lblMaVe);
				}
				{
					JLabel lblRap = new JLabel();
					lblRap.setForeground(Color.WHITE);
					lblRap.setFont(new Font("SansSerif", Font.PLAIN, 16));
					lblRap.setText("Rạp");
					lblRap.setBounds(40, 120, 50, 30);
					pnlChiTiet.add(lblRap);
				}
				{
					lblGiaVe = new JLabel();
					lblGiaVe.setText("@giaVe");
					lblGiaVe.setForeground(Color.WHITE);
					lblGiaVe.setFont(new Font("SansSerif", Font.BOLD, 19));
					lblGiaVe.setBounds(40, 180, 120, 30);
					pnlChiTiet.add(lblGiaVe);
				}
				{
					lblMoTa = new JLabel();
					lblMoTa.setText("@moTa");
					lblMoTa.setForeground(Color.WHITE);
					lblMoTa.setFont(new Font("SansSerif", Font.BOLD, 19));
					lblMoTa.setBounds(170, 180, 260, 30);
					pnlChiTiet.add(lblMoTa);
				}
				{
					JLabel lblHinh = new JLabel();
					lblHinh.setHorizontalAlignment(SwingConstants.RIGHT);
					ImageIcon icon = new ImageIcon(QuanLyVeJScrollPaneNoiDungJPanelThongTinChiTietJDialog.class.getResource("/com/httcinema/icon/app-logo-3.png"));
					lblHinh.setIcon(new ImageIcon(ShareHelper.resizeImage(icon, 171, 200)));
					lblHinh.setBounds(430, 10, 260, 200);
					pnlChiTiet.add(lblHinh);
				}
				{
					lblNgayTao = new JLabel();
					lblNgayTao.setVerticalAlignment(SwingConstants.BOTTOM);
					lblNgayTao.setHorizontalAlignment(SwingConstants.RIGHT);
					lblNgayTao.setForeground(Color.WHITE);
					lblNgayTao.setFont(new Font("SansSerif", Font.BOLD, 11));
					lblNgayTao.setText("@ngayTao");
					lblNgayTao.setBounds(430, 235, 260, 30);
					pnlChiTiet.add(lblNgayTao);
				}
			}
		}
		
		btnDong = new CustomButton("Đóng");
		btnDong.setBounds(10, 421, 125, 45);
		pnlChinh.add(btnDong);
		Theme.setDefaultButtonFormat(btnDong);
		btnDong.setForeground(Color.WHITE);
		btnDong.setBackground(new Color(36, 36, 36));
		btnDong.setHoverBackground(Color.BLACK);
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fadeOut();
			}
		});
		
		list = new VeDAO().printTicket(ve.getMaVe() + "");
		
		setModel(list.get(0));
	}
	
	private List<Object[]> list;
	private void setModel(Object[] obj) {
		lblMaVe.setText(obj[0] + "");
		lblTenPhim.setText(obj[1] + "");
		lblTenPhongChieu.setText(obj[2] + "");
		lblMaGhe.setText(obj[3] + "");
		lblNgayChieu.setText(DateHelper.toString((Date)obj[4], "dd-MM-yyyy (EEE)"));
		lblGioChieu.setText(DateHelper.toString((Time)obj[5], "HH:mm"));
		lblMoTa.setText(obj[6] + "");
		lblGiaVe.setText(new DecimalFormat("###,###,###,###,###,### VND").format((double)obj[7]));
		lblNgayTao.setText(obj[8] + "");
	}
}
