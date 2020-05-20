/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.models.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thanh
 */
public class ProductDAO extends AbstractConnection {

    public ProductDAO() {

    }

    public boolean deleteProduct(int id) {
        boolean result = false;
        try {
            this.open();
            PreparedStatement ps = conn.prepareStatement("delete products where id = ?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return result;
    }
    
    public boolean deletecart(int id) {
        boolean result = false;
        try {
            this.open();
            PreparedStatement ps = conn.prepareStatement("delete cart where id = ?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return result;
    }

    public List<Product> fillToProduct() {
        List<Product> list = new ArrayList<Product>();
        try {
            this.open();
            PreparedStatement ps = conn.prepareStatement("select * from products");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setId(rs.getInt("id"));
                pro.setName(rs.getString("name"));
                pro.setPrice(rs.getFloat("price"));
                pro.setNote(rs.getString("note"));
                pro.setImage(rs.getString("image"));
                pro.setidcategory_id(rs.getInt("idcategory_id"));
                list.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return list;
    }

    public List<Product> filltocart() {
        List<Product> list = new ArrayList<Product>();
        try {
            this.open();
            PreparedStatement ps = conn.prepareStatement("select * from cart");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setId(rs.getInt("id"));
                pro.setName(rs.getString("name"));
                pro.setNote(rs.getString("note"));
                pro.setImage(rs.getString("image"));
                pro.setidcategory_id(rs.getInt("idproduct"));
                list.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return list;
    }

    public boolean insertproduct(Product product) {
        boolean reusult = false;
        try {
            this.open();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO products (name, price, note, image, idcategory_id)VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, product.getName());
            ps.setFloat(2, product.getPrice());
            ps.setString(3, product.getNote());
            ps.setString(4, product.getImage());
            ps.setInt(5, product.getidcategory_id());
            if (ps.executeUpdate() > 0) {
                reusult = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return reusult;
    }

    public boolean UpdateProduct(Product product) {
        boolean result = false;
        try {
            this.open();
            PreparedStatement ps = conn.prepareStatement("update products set name=?, price=?, note=?, image=?, idcategory_id=? where id=?");
            ps.setString(1, product.getName());
            ps.setFloat(2, product.getPrice());
            ps.setString(3, product.getNote());
            ps.setString(4, product.getImage());
            ps.setInt(5, product.getidcategory_id());
            ps.setInt(6, product.getId());
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return result;
    }

    public boolean buyproduct(Product product) {
        boolean reusult = false;
        try {
            this.open();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO cart (name, note, image, idproduct)VALUES(?, ?, ?, ?)");
            ps.setString(1, product.getName());
            ps.setString(2, product.getNote());
            ps.setString(3, product.getImage());
            ps.setInt(4, product.getId());
            if (ps.executeUpdate() > 0) {
                reusult = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return reusult;
    }

}
