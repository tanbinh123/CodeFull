package com.httcinema.ui.subpanel;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JPanel;

import com.httcinema.dao.VeDAO;
import com.httcinema.helper.DateHelper;
import com.httcinema.helper.JasperReportHelper;
import com.httcinema.helper.ShareHelper;
import com.httcinema.model.Ghe;
import com.httcinema.model.GiaVe;
import com.httcinema.model.Ve;

@SuppressWarnings("serial")
public class LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPaneDanhSachVeJPanel extends JPanel {
	
	// mảng chưa các panel Vé
	public static ArrayList<LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPaneDanhSachVeJPanelVeJPanel> pnlVes = new ArrayList<LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPaneDanhSachVeJPanelVeJPanel>();
	
	/**
	 * Create the panel.
	 */
	public LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPaneDanhSachVeJPanel(ArrayList<Ghe> gheDuocMuas) {
		setBackground(Color.WHITE);
		pnlVes.clear(); // reset mảng các panel vé mỗi lần tạo danh sách mới
		
		// tạo group layout
		GroupLayout groupLayout = new GroupLayout(this);
		
		// nhóm cho hàng ngang
		ParallelGroup hParallelGroup = groupLayout.createParallelGroup(Alignment.LEADING);
		
		// nhóm cho hàng dọc
		ParallelGroup vParallelGroup = groupLayout.createParallelGroup(Alignment.LEADING);
		SequentialGroup vSequentialGroup = groupLayout.createSequentialGroup();
		
		for (int i = 0; i < gheDuocMuas.size(); i++) {
			LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPaneDanhSachVeJPanelVeJPanel panel = new LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPaneDanhSachVeJPanelVeJPanel(gheDuocMuas.get(i));
			hParallelGroup.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
			vSequentialGroup.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(6);
			
			pnlVes.add(panel);
		}
		
		groupLayout.setHorizontalGroup(hParallelGroup);
		vParallelGroup.addGroup(vSequentialGroup);
		groupLayout.setVerticalGroup(vParallelGroup);
		
		setLayout(groupLayout);
	}
	
	/**
	 * hàm dùng để insert các vé vào cơ sở dữ liệu rồi in vé (cách 1: in vé trong từng lần lặp, mỗi vé tương ứng 1 file PDF)
	 * */
//	public static void insertVe() {
//		// trỏ đến mảng ghế được mua
//		ArrayList<Ghe> gheDuocMuas = LichChieuJScrollPanePhongChieuJDialog.gheDuocMuas;
//		
//		// quét hết mảng, từng lần quét thì tạo một vé rồi thêm vào cơ sở dữ liệu
//		for (int i = 0; i < gheDuocMuas.size(); i++) {
//			Ve ve = new Ve();
//			ve.setMaLichChieu(LichChieuJScrollPanePhongChieuJDialog.lichChieu.getMaLichChieu());
//			ve.setMaGhe(gheDuocMuas.get(i).getMaGhe());
//			ve.setTenDangNhap(ShareHelper.USER.getTenDangNhap());
//			ve.setNgayTao(DateHelper.now());
//			
//			GiaVe giaVe = (GiaVe) (pnlVes.get(i).getCboGiaTriGiaVe().getSelectedItem()); // lấy từ comboBox trong các panel Vé
//			ve.setMaGiaVe(giaVe.getMaGiaVe());
//			ve.setGiaVe(giaVe.getGiaVe());
//			
//			int maVeVuaThem = new VeDAO().insert(ve);
//			JasperReportHelper.inMotVePDF(maVeVuaThem + "");
//		}
//		
//		ShareHelper.refreshAllTable();
//	}
	
	/**
	 * hàm dùng để insert các vé vào cơ sở dữ liệu rồi in vé (cách 2: insert hết vé vào CSDL rồi bắt đầu in file PDF, mỗi vé tương ứng 1 trang trong file PDF đó)
	 * trả về đường dẫn của file vừa xuất
	 * */
	public static String insertVe() {
		// trỏ đến mảng ghế được mua
		ArrayList<Ghe> gheDuocMuas = LichChieuJScrollPanePhongChieuJDialog.gheDuocMuas;
		int[] maVes = new int[gheDuocMuas.size()]; // khởi tạo mảng mã vé cho việc in ấn
		
		// quét hết mảng, từng lần quét thì tạo một vé rồi thêm vào cơ sở dữ liệu
		for (int i = 0; i < gheDuocMuas.size(); i++) {
			Ve ve = new Ve();
			ve.setMaLichChieu(LichChieuJScrollPanePhongChieuJDialog.lichChieu.getMaLichChieu());
			ve.setMaGhe(gheDuocMuas.get(i).getMaGhe());
			ve.setTenDangNhap(ShareHelper.USER.getTenDangNhap());
			ve.setNgayTao(DateHelper.now());
			
			GiaVe giaVe = (GiaVe) (pnlVes.get(i).getCboGiaVe().getSelectedItem()); // lấy từ comboBox trong các panel Vé
			ve.setMaGiaVe(giaVe.getMaGiaVe());
			ve.setGiaVe(giaVe.getGiaVe());
			
			maVes[i] = new VeDAO().insert(ve); // đẩy giá vé vừa thêm vào mảng cho in ấn
		}
		
		String duongDanFile = JasperReportHelper.inNhieuVePDF(maVes);
		ShareHelper.refreshAllTable();
		return duongDanFile;
	}
}
