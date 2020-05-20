package com.httcinema.ui.subpanel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.dao.VaiTroDAO;
import com.httcinema.helper.ShareHelper;
import com.httcinema.model.TaiKhoan;
import com.httcinema.ui.ManHinhChinhJFrame;

public class ManHinhChinhJFrameThongTinNguoiDungJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6525545787696014579L;
	private JPanel pnlVienHinh;
	private JLabel lblHinhTaiKhoan;
	private TaiKhoan taiKhoan;
	private JLayeredPane pnlLayerHinhTaiKhoan;

	/**
	 * Create the panel.
	 */
	public ManHinhChinhJFrameThongTinNguoiDungJPanel(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
		setBackground(Theme.dark);
		setLayout(null);
		String tenVaiTro = new VaiTroDAO().findById(taiKhoan.getMaVaiTro()).getTenVaiTro();
		
		pnlLayerHinhTaiKhoan = new JLayeredPane();
		pnlLayerHinhTaiKhoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialog.showDialog(ManHinhChinhJFrame.frameManHinhChinh, ShareHelper.USER, ManHinhChinhJFrameThongTinNguoiDungJPanelThongTinChiTietJDialog.CAP_NHAT);
				refresh();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlVienHinh.setBackground(Theme.white);
				pnlLayerHinhTaiKhoan.repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlVienHinh.setBackground(new Color(212, 212, 212));
				pnlLayerHinhTaiKhoan.repaint();
			}
		});
		pnlLayerHinhTaiKhoan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlLayerHinhTaiKhoan.setBounds(10, 11, 100, 100);
		add(pnlLayerHinhTaiKhoan);
		
		lblHinhTaiKhoan = new JLabel(new ImageIcon(roundAvatar()));
		lblHinhTaiKhoan.setBounds(0, 0, 100, 100);
		lblHinhTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		pnlLayerHinhTaiKhoan.add(lblHinhTaiKhoan);
		pnlLayerHinhTaiKhoan.setLayer(lblHinhTaiKhoan, 1);
		
		pnlVienHinh = new CirclePanel();
		pnlVienHinh.setBackground(new Color(212, 212, 212));
		pnlVienHinh.setBounds(0, 0, 100, 100);
		pnlVienHinh.setBorder(null);
		pnlLayerHinhTaiKhoan.add(pnlVienHinh);
		pnlLayerHinhTaiKhoan.setLayer(pnlVienHinh, 0);
		
		JLabel lblTenDangNhap = new JLabel(" " + taiKhoan.getTenDangNhap());
		lblTenDangNhap.setIcon(new ImageIcon(ManHinhChinhJFrameThongTinNguoiDungJPanel.class.getResource("/com/httcinema/icon/icon-user.png")));
		lblTenDangNhap.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenDangNhap.setForeground(Theme.white);
		lblTenDangNhap.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenDangNhap.setBounds(120, 39, 144, 28);
		add(lblTenDangNhap);
		
		JLabel lblVaiTro = new JLabel(" " + tenVaiTro);
		lblVaiTro.setIcon(new ImageIcon(ManHinhChinhJFrameThongTinNguoiDungJPanel.class.getResource("/com/httcinema/icon/icon-role.png")));
		lblVaiTro.setHorizontalAlignment(SwingConstants.LEFT);
		lblVaiTro.setForeground(Theme.white);
		lblVaiTro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVaiTro.setBounds(120, 11, 144, 28);
		add(lblVaiTro);
	}
	
	private BufferedImage roundAvatar() {
		// đọc ảnh
		BufferedImage master = null;
		try {
			master = ImageIO.read(new File("hinhTaiKhoan/" + this.taiKhoan.getHinh()));
		} catch (IOException e) {
			// nếu người dùng chưa có hình trong thư mục thì chọn hình mặc định
			try {
				// nếu người dùng là nam
				if (this.taiKhoan.isGioiTinh()) {
//					master = ImageIO.read(new File("hinhTaiKhoan/default-avatar-male.png"));
					master = ImageIO.read(new File("hinhTaiKhoan/default-avatar-male-2.png"));
				}
				// nữ
				else {
//					master = ImageIO.read(new File("hinhTaiKhoan/default-avatar-female.png"));
					master = ImageIO.read(new File("hinhTaiKhoan/default-avatar-female-2.png"));
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		// thay đổi kích cỡ ảnh và vẽ lại hình
		int width = 95;
		int height = 95;
		Image tmp = master.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		master = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = master.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		
		// tạo đường kính hình tròn và vẽ lớp mặt nạ
		int diameter = Math.min(master.getWidth(), master.getHeight());
	    BufferedImage mask = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);
	    g2d = mask.createGraphics();
	    applyQualityRenderingHints(g2d);
	    g2d.fillOval(0, 0, diameter - 1, diameter - 1);
	    g2d.dispose();

	    // đặt lớp mặt nạ lên trên hình
	    BufferedImage masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
	    g2d = masked.createGraphics();
	    applyQualityRenderingHints(g2d);
	    int x = (diameter - master.getWidth()) / 2;
	    int y = (diameter - master.getHeight()) / 2;
	    g2d.drawImage(tmp, x, y, null);
	    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
	    g2d.drawImage(mask, 0, 0, null);
	    g2d.dispose();
	    
	    return masked;
	}
	
	public static void applyQualityRenderingHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    }
	
	public void refresh() {
		this.taiKhoan = ShareHelper.USER;
		lblHinhTaiKhoan.setIcon(new ImageIcon(roundAvatar()));
	}
}
