
package com.httcinema.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.httcinema.helper.JdbcHelper;
import com.httcinema.model.Ghe;
import com.httcinema.model.LichChieu;

public class GheDAO {
    public void insert(Ghe model) {
        String sql = "INSERT INTO Ghe (maGhe) VALUES (?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaGhe());
    }

    public List<Ghe> select() {
        String sql = "SELECT * FROM Ghe";
        return select(sql);
    }
    
    public List<Ghe> selectBought(LichChieu lichChieu) {
        String sql = "{call sp_TimGheDaMua (?)}";
        return select(sql, lichChieu.getMaLichChieu());
    }
    
    public Ghe findById(String maGhe) {
        String sql = "SELECT * FROM Ghe WHERE maGhe=?";
        List<Ghe> list = select(sql, maGhe);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Ghe> select(String sql, Object... args) {
        List<Ghe> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Ghe model = readFromResultSet(rs);
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

    private Ghe readFromResultSet(ResultSet rs) throws SQLException {
        Ghe model = new Ghe();
        model.setMaGhe(rs.getString("maGhe"));
        return model;
    }
}
