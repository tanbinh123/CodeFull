/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample.cart;

import Sample.model.Product;
import java.io.Serializable;

/**
 *
 * @author thanh
 */
public class ProductDTO implements Serializable {

    private Product sanPham;
    private int quantity;

    public ProductDTO() {
        
    }
    public ProductDTO(Product sp){
        this.sanPham = sp;
        this.quantity = 1;
    }

    public Product getSanPham() {
        return sanPham;
    }

    public void setSanPham(Product sanPham) {
        this.sanPham = sanPham;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
