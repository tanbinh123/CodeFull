// xắp sếp mảng các số nguyên theo chiều tăng dần các giá trị phần tử 5, 7, 2, 4, 8)
package baihoctest;

public class bai7 {

    public static void main(String[] args) {
        int[] xapSep = {5, 7, 2, 4, 8};
        int temp;
        for (int i = 0; i < xapSep.length; i++) {
            for(int j = i+1; j <xapSep.length; j++ ){
                if(xapSep[i]>xapSep[j]){
                    temp = xapSep[i];
                    xapSep[i] = xapSep[j];
                    xapSep[j] = temp;
                }
            }
        }
        for(int i = 0; i<xapSep.length; i++){
            System.out.println("sắp xếp = " + xapSep[i]);
        }
    }
}