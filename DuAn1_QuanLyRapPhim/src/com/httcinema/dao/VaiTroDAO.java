
package com.httcinema.dao;

import com.httcinema.helper.JdbcHelper;
import com.httcinema.model.VaiTro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VaiTroDAO {
    public void insert(VaiTro model) {
        String sql = "INSERT INTO VaiTro (maVaiTro, tenVaiTro, moTa) VALUES (?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaVaiTro(),
                model.getTenVaiTro(),
                model.getMoTa());
    }

    public void update(VaiTro model) {
        String sql = "UPDATE VaiTro SET tenVaiTro=?, moTa=? WHERE maVaiTro=?";
        JdbcHelper.executeUpdate(sql, 
                model.getTenVaiTro(),
                model.getMoTa(),
                model.getMaVaiTro());
    }

    public void delete(String maVaiTro) {
        String sql = "DELETE FROM VaiTro WHERE maVaiTro=?";
        JdbcHelper.executeUpdate(sql, maVaiTro);
    }

    public List<VaiTro> select() {
        String sql = "SELECT * FROM VaiTro";
        return select(sql);
    }

    public VaiTro findById(String maVaiTro) {
        String sql = "SELECT * FROM VaiTro WHERE maVaiTro=?";
        List<VaiTro> list = select(sql, maVaiTro);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<VaiTro> select(String sql, Object... args) {
        List<VaiTro> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    VaiTro model = readFromResultSet(rs);
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

    private VaiTro readFromResultSet(ResultSet rs) throws SQLException {
        VaiTro model = new VaiTro();
        model.setMaVaiTro(rs.getString("maVaiTro"));
        model.setTenVaiTro(rs.getString("tenVaiTro"));
        model.setMoTa(rs.getString("moTa"));
        return model;
    }
}
