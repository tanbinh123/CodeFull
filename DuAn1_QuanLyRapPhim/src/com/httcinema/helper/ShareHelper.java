package com.httcinema.helper;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.httcinema.model.Phim;
import com.httcinema.model.TaiKhoan;
import com.httcinema.ui.subpanel.LichChieuJScrollPane;
import com.httcinema.ui.subpanel.QuanLyGiaVeJScrollPaneNoiDungJPanel;
import com.httcinema.ui.subpanel.QuanLyLichChieuJScrollPaneNoiDungJPanel;
import com.httcinema.ui.subpanel.QuanLyNhanVienJScrollPaneNoiDungJPanel;
import com.httcinema.ui.subpanel.QuanLyPhimJScrollPanelNoiDungJPanel;
import com.httcinema.ui.subpanel.QuanLyThongKeJScrollPaneNoiDungJPanel;
import com.httcinema.ui.subpanel.QuanLyVeJScrollPaneNoiDungJPanel;

public class ShareHelper {
	// các con trỏ panel
	public static LichChieuJScrollPane pnlLichChieu;
	public static QuanLyPhimJScrollPanelNoiDungJPanel pnlQuanLyPhim;
	public static QuanLyGiaVeJScrollPaneNoiDungJPanel pnlQuanLyGiaVe;
	public static QuanLyLichChieuJScrollPaneNoiDungJPanel pnlQuanLyLichChieu;
	public static QuanLyVeJScrollPaneNoiDungJPanel pnlQuanLyVe;
	public static QuanLyNhanVienJScrollPaneNoiDungJPanel pnlQuanLyNhanVien;
	public static QuanLyThongKeJScrollPaneNoiDungJPanel pnlQuanLyThongKe;
	
	// thư mục chứa hình
	public final static String thuMucHinhPhim = "hinhPhim";
	public final static String thuMucHinhTaiKhoan = "hinhTaiKhoan";

	// tạo các thư mục chứa báo cáo nếu chưa tồn tại
	public static void setAppReady() {
		File dir = new File("ve");
		// Tạo thư mục nếu chưa tồn tại
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		dir = new File("thongKe");
		// Tạo thư mục nếu chưa tồn tại
		if (!dir.exists()) {
			dir.mkdirs();
		}
	}
	
	/**
	 * Sao chép file logo chuyên đề vào thư mục logo
	 * 
	 * @param file là đối tượng file ảnh
	 * @return chép được hay không
	 */
	public static boolean saveImage(File file, String newName, String thuMucHinh) {
		File dir = new File(thuMucHinh);
		// Tạo thư mục nếu chưa tồn tại
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File newFile = new File(dir, newName);
		try {
			// Copy vào thư mục (đè nếu đã tồn tại)
			Path source = Paths.get(file.getAbsolutePath());
			Path destination = Paths.get(newFile.getAbsolutePath());
			Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public static boolean saveMovieImage(File file, String newName) {
		return saveImage(file, newName, thuMucHinhPhim);
	}

	public static boolean saveUserImage(File file, String newName) {
		return saveImage(file, newName, thuMucHinhTaiKhoan);
	}

	/**
	 * Đọc hình ảnh 
	 * 
	 * @param fileName là tên file
	 * @param thuMucHinh là thư mục chứa hình
	 * @return ảnh đọc được
	 */
	public static ImageIcon readImage(String fileName, String thuMucHinh) {
		File path = new File(thuMucHinh, fileName);
		return new ImageIcon(path.getAbsolutePath());
	}

	/**
	 * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
	 */
	public static TaiKhoan USER = null;
	
	/** 
	 * this method uses key binding technique to add keyboard listenter to a JComponent
	 * 
	 * @param contentPane	a jcomponent that we want to binding key
	 * @param key			a key pattern, this pattern should be referenced in java documentation or more information
	 * @param action		an Action object which will determine the action after the event happened
	 * @param id			a String for specification
	 */
	public static void addKeyBind(JComponent contentPane, String key, Action action, String id) {
	    InputMap iMap = contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	    ActionMap aMap = contentPane.getActionMap();
	    
	    iMap.put(KeyStroke.getKeyStroke(key), id);
	    aMap.put(id, action);
	}
	
	/**
	 * This method helps resize an image
	 * 
	 * @param icon		an icon or image
	 * @param width		width that you want to resize to
	 * @param height	height that you want to resize to
	 * @return image	an resized image
	 * */
	
	public static Image resizeImage(ImageIcon icon, int width, int height) {
		Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return image;
	}
	
	/**
	 * Read user's image and resize it.
	 * */
	public static Image readUserImage(TaiKhoan taiKhoan, int width, int height) {
		return resizeImage(readImage(taiKhoan.getHinh(), thuMucHinhTaiKhoan), width, height);
	}
	
	
	/**
	 * Read movie's image and resize it.
	 * */
	public static Image readMovieImage(Phim phim, int width, int height) {
		return resizeImage(readImage(phim.getHinh(), thuMucHinhPhim), width, height);
	}
	
	public static void refreshAllTable() {
		pnlLichChieu.refreshAll();
		pnlQuanLyPhim.refreshAll();
		pnlQuanLyGiaVe.refreshAll();
		pnlQuanLyLichChieu.refreshAll();
		pnlQuanLyVe.refreshAll();
		pnlQuanLyNhanVien.refreshAll();
		pnlQuanLyThongKe.refreshAll();
	}
	
	public static String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return "." + fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}
}