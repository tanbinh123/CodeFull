package com.httcinema.share;

public interface DangNhapJFrameResource extends ShareResource {
	// thông báo xác nhận tài khoản
	final String LOGIN_SUCCESS_MANAGER = "Quản lý %s đăng nhập thành công";
	final String LOGIN_SUCCESS_STAFF = "Nhân viên %s đăng nhập thành công";
	final String LOGIN_SUCCESS_UNDEFINED = "Tài khoản %s chưa được cấp phép";
	final String LOGIN_FAIL_WRONG_PASS = "Sai mật khẩu";
	final String LOGIN_FAIL_WRONG_USERNAME = "Tài khoản không tồn tại";
	
	// thông báo dữ liệu trống
	final String LOGIN_FAIL_EMPTY_PASS = "Bạn chưa nhập mật khẩu";
	final String LOGIN_FAIL_EMPTY_USERNAME = "Bạn chưa nhập tên tài khoản";
	
	// hình, biểu tượng
	final String LOGIN_IMAGE_APP_LOGO = "app-logo-2.png";
	final String LOGIN_IMAGE_BACKGROUND = "login-form-background-5.gif";
	final String LOGIN_IMAGE_ICON_EMPTY = "empty-label.png";
	final String LOGIN_IMAGE_ICON_PASS_HIDE = "password-hide-label.png";
	final String LOGIN_IMAGE_ICON_PASS_SHOW = "password-show-label.png";
	final String LOGIN_IMAGE_ICON_PASS = "password-label.png";
	final String LOGIN_IMAGE_ICON_USERNAME = "username-label.png";
}
