/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2_buôi5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author locth
 */
public class Demo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SV sv1 = new SV();
        List<SV> dssv = new ArrayList<SV>();
        sv1.name="lan";
        sv1.tuoi=20;
        dssv.add(sv1);
        SV sv2=new SV("Vy",22);
        
        dssv.add(sv2);
        
        dssv.add(new SV("Ha",18));
        dssv.add(new SV("Hoa",18));
        
        System.out.println(SV.soluong);
        
        for(int i=0; i<dssv.size();i++)
        {
            System.out.println(dssv.get(i).name + dssv.get(i).tuoi);
        }
        
        
    }
    
}
