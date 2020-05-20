package com.httcinema.dao;

import com.httcinema.helper.JdbcHelper;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.httcinema.model.TaiKhoan;

public class TaiKhoanDAO {

    public void insert(TaiKhoan model) {
        String sql = "INSERT INTO TaiKhoan(tenDangNhap, matKhau, hoTen, gioiTinh, ngaySinh, diaChi, soDienThoai, hinh, maVaiTro) VALUES (?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getTenDangNhap(),
                model.getMatKhau(),
                model.getHoTen(),
                model.isGioiTinh(),
                model.getNgaySinh(),
                model.getDiaChi(),
                model.getSoDienThoai(),
                model.getHinh(),
                model.getMaVaiTro());
    }

    public void update(TaiKhoan model) {
        String sql = "UPDATE TaiKhoan SET matKhau=?, hoTen=?, gioiTinh=?, ngaySinh=?, diaChi=?, soDienThoai=?, hinh=?, maVaiTro=? WHERE tenDangNhap=?";
        JdbcHelper.executeUpdate(sql,
        		model.getMatKhau(),
                model.getHoTen(),
                model.isGioiTinh(),
                model.getNgaySinh(),
                model.getDiaChi(),
                model.getSoDienThoai(),
                model.getHinh(),
                model.getMaVaiTro(),
                model.getTenDangNhap()
        );
    }

    public void delete(String tenDangNhap) {
        String sql = "DELETE FROM TaiKhoan WHERE tenDangNhap=?";
        JdbcHelper.executeUpdate(sql, tenDangNhap);
    }

    public List<TaiKhoan> select() {
        String sql = "SELECT * FROM TaiKhoan";
        return select(sql);
    }
    
    public List<TaiKhoan> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM TaiKhoan WHERE hoTen LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public TaiKhoan findById(String tenDangNhap) {
        String sql = "SELECT * FROM TaiKhoan WHERE tenDangNhap=?";
        List<TaiKhoan> list = select(sql, tenDangNhap);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<TaiKhoan> select(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    TaiKhoan model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private TaiKhoan readFromResultSet(ResultSet rs) throws SQLException {
        TaiKhoan model = new TaiKhoan();
        model.setTenDangNhap(rs.getString("tenDangNhap"));
        model.setMatKhau(rs.getString("matKhau"));
        model.setHoTen(rs.getString("hoTen"));
        model.setGioiTinh(rs.getBoolean("gioiTinh"));
        model.setNgaySinh(rs.getDate("ngaySinh"));
        model.setDiaChi(rs.getString("diaChi"));
        model.setSoDienThoai(rs.getString("soDienThoai"));
        model.setHinh(rs.getString("hinh"));
        model.setMaVaiTro(rs.getString("maVaiTro"));
        return model;
    }
}
