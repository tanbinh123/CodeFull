/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample.model;

/**
 *
 * @author thanh
 */
public class Product {
    private String code;
    private String name;
    private float price;
    public Product(String code, String name, float price){
        this.code = code;
        this.name = name;
        this.price = price;
    }
    public Product(){
        
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
