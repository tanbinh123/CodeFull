/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.models;

/**
 *
 * @author thanh
 */
public class Product {
    int id;
    String name;
    float price;
    String note;
    String image;
    int idcategory_id;
    
    
    public Product(){
        
    }

    public Product(int id, String name, float price, String note, String image, int idcategory_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.note = note;
        this.image = image;
        this.idcategory_id = idcategory_id;
    }

    public Product(String name, float price, String note, String image, int idcategory_id) {
        this.name = name;
        this.price = price;
        this.note = note;
        this.image = image;
        this.idcategory_id = idcategory_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getidcategory_id() {
        return idcategory_id;
    }

    public void setidcategory_id(int idcategory_id) {
        this.idcategory_id = idcategory_id;
    }

}
