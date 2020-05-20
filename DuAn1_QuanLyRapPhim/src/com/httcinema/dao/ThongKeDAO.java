package com.httcinema.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.httcinema.helper.DateHelper;
import com.httcinema.helper.JdbcHelper;

/**
 *
 * @author LongThanh
 */
public class ThongKeDAO {
	
	public List<Object[]> getThongKeSoLuong() {
		List<Object[]> list = new ArrayList<>();
		try {
			ResultSet rs = null;
			try {
				String sql = "{call sp_DemSoLuongPhimLichChieuVeNhanVien}";
				rs = JdbcHelper.executeQuery(sql);
				while (rs.next()) {
					Object[] model = {
							rs.getInt("soLuongPhim"),
							rs.getString("soLuongLichChieu"),
							rs.getString("soLuongVe"),
							rs.getInt("soLuongNhanVien"),
					};
					list.add(model);
				}
			} finally {
				rs.getStatement().getConnection().close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	
	public List<Object[]> getDoanhThuPhongChieu(int nam, int maPhongChieu) {
		List<Object[]> list = new ArrayList<>();
		try {
			ResultSet rs = null;
			try {
				String sql = "{call sp_ThongKeTongTienTheoPhongChieu_DuaTheoNam (?, ?)}";
				rs = JdbcHelper.executeQuery(sql, nam, maPhongChieu);
				while (rs.next()) {
					Object[] modelPC = {
							rs.getInt("maPhongChieu"),
							"Rạp " + rs.getString("tenPhongChieu"),
							rs.getString("soLuongSuatChieu") + " suất",
							rs.getInt("soLuongVeMua") + " vé",
							new DecimalFormat("###,###,###,###,###,### VND").format(rs.getDouble("doanhThuCuaPhongChieu")),
					};
					list.add(modelPC);
				}
			} finally {
				rs.getStatement().getConnection().close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public List<Object[]> getDoanhThuGioChieu(Date ngayBatDau, Date ngayKetThuc) {
		List<Object[]> list = new ArrayList<>();
		try {
			ResultSet rs = null;
			try {
				String sql = "{call sp_ThongKeTongTienTheoGioChieu_DuaTheoNgay (?, ?)}";
				rs = JdbcHelper.executeQuery(sql, ngayBatDau, ngayKetThuc);
				while (rs.next()) {
					Object[] modelGC = {
							DateHelper.toString(rs.getTime("gioChieu"), "HH:mm"),
							rs.getInt("soLuongVeMua") + " vé",
							new DecimalFormat("###,###,###,###,###,### VND").format(rs.getDouble("doanhThuCuaGioChieu")),
					};
					list.add(modelGC);
				}
			} finally {
				rs.getStatement().getConnection().close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public List<Object[]> getDoanhThuPhim(int nam, int maPhim) {
		List<Object[]> list = new ArrayList<>();
		try {
			ResultSet rs = null;
			try {
				String sql = "{call sp_ThongKeTongTienTheoPhim_DuaTheoNam (?, ?)}";
				rs = JdbcHelper.executeQuery(sql, nam, maPhim);
				while (rs.next()) {
					Object[] modelP = {
							rs.getInt("maPhim"),
							rs.getString("tenPhim"),
							rs.getString("soLuongSuatChieu") + " suất",
							rs.getInt("soLuongVeMua") + " vé",
							new DecimalFormat("###,###,###,###,###,### VND").format(rs.getDouble("doanhThuCuaPhim")),
					};
					list.add(modelP);
				}
			} finally {
				rs.getStatement().getConnection().close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}
