package com.httcinema.helper;

import java.awt.Component;

import com.httcinema.custom_jcomponents.CustomDialog;

public class DialogHelper {
	/**
	 * Hiển thị thông báo thành công cho người dùng
	 * 
	 * @param parent  là cửa sổ chứa thông báo
	 * @param message là thông báo
	 */
	public static void success(Component parent, String message) {
		CustomDialog.showDialog(parent, "Thành công", message, CustomDialog.SUCCESS);
	}
	
	/**
	 * Hiển thị thông báo lỗi cho người dùng
	 * 
	 * @param parent  là cửa sổ chứa thông báo
	 * @param message là thông báo
	 */
	public static void error(Component parent, String message) {
		CustomDialog.showDialog(parent, "Lỗi", message, CustomDialog.ERROR);
	}
	
	/**
	 * Hiển thị cảnh báo cho người dùng
	 * 
	 * @param parent  là cửa sổ chứa thông báo
	 * @param message là thông báo
	 */
	public static void warning(Component parent, String message) {
		CustomDialog.showDialog(parent, "Cảnh báo", message, CustomDialog.WARNING);
	}
	
	/**
	 * Hiển thị thông báo cho người dùng
	 * 
	 * @param parent  là cửa sổ chứa thông báo
	 * @param message là thông báo
	 */
	public static void inform(Component parent, String message) {
		CustomDialog.showDialog(parent, "Thông báo", message, CustomDialog.INFORMATION);
	}
	
	/***
	 * 
	 * Hiển thị thông báo và yêu cầu người dùng xác nhận
	 * 
	 * @param parent  là cửa sổ chứa thông báo
	 * @param message là câu hỏi yes/no
	 * @return là kết quả nhận được true/false
	 */
	public static boolean confirm(Component parent, String message) {
		int result = CustomDialog.showDialog(parent, "Thông báo", message, CustomDialog.CONFIRM);
		return result == CustomDialog.YES_OPTION;
	}
	
}