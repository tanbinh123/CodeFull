/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8_nop;

/**
 *
 * @author thanh
 */
public class ProductManager {

    public static void main(String[] args) {
        Product p1 = new Product("iPhone9", 1000.0);
        Product p2 = new Product("Samsung Start", 3000.0);
        ProductDAO dao = new ProductDAO();
        dao.add(p1);
        dao.add(p2);
        dao.store("E:\\prod.dat");
        ProductDAO dao2 = new ProductDAO();
        dao2.load("E:\\prod.dat");
        Product p = dao2.find("iPhone9");
        System.out.println(">Name: " + p.name);
        System.out.println(">Price: " + p.price);

    }
}
