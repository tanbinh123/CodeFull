package com.httcinema.share;

import java.awt.Image;
import java.util.Formatter;

import javax.swing.ImageIcon;

public interface ShareResource {
	// các tài nguyên chia sẻ
	final String APP_IMAGE_PACKAGE_PATH = "/com/httcinema/icon/%s";
	final String APP_SHARED_ICON = "app-icon-2.png";
	
	// các vai trò của tài khoản đăng nhập
	final String ROLE_MANAGER = "QL";
	final String ROLE_STAFF = "NV";
	
	
	/** các hàm dùng xuyên suốt trong ứng dụng */
	// hàm trả về đường dẫn của hình
	default String setImagePath(String str) {
		return format(APP_IMAGE_PACKAGE_PATH, str);
	}
	
	// hàm dùng cho việc tối ưu các chuỗi tùy biến
	@SuppressWarnings("resource")
	default String format(String str, Object... objs) {
		if (objs.length == 0) {
			return str;
		}
		
		return new Formatter().format(str, objs).toString();
	}
	
	// hàm trả về biểu tượng của ứng dụng
	default Image returnAppIcon() {
		return new ImageIcon(ShareResource.class.getResource(setImagePath(APP_SHARED_ICON))).getImage();
	}
	
}
