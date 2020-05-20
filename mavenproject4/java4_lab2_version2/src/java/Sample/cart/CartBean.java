/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample.cart;

import Sample.model.Products;
import java.util.HashMap;

/**
 *
 * @author thanh
 */
public class CartBean extends HashMap {

    public void addSanPham(ProductDTO sp) {
        String key = sp.getSanPham().getCode();
        if (this.contaisKey(key)) {
            int oldQuantity = ((ProductDTO) this.get(key)).getQuantity();
            ((ProductDTO) this.get(key)).setQuantity(oldQuantity + 1);
        } else {
            this.put(sp.getSanPham().getCode(), sp);
        }
    }

    public boolean removeSanPham(String code) {
        if (this.contaisKey(code)) {
            this.remove(code);
            return true;
        }
        return false;
    }

    public CartBean() {
        super();
    }

    private boolean contaisKey(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
