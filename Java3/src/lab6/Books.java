/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author thanh
 */
public class Books {
    private String ID;
    private String title;
    private double price;

    public Books(String ID, String title, double price) {
        this.ID = ID;
        this.title = title;
        this.price = price;
    }

    Books(int ID, String Title, float price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public Object[] toArray(){
        return new Object[]{
            ID, title, price
        };
    }
}
