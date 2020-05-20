// viết chương trình tính tổng các số lẻ từ 1 đến 100


package baihoctest;

/**
 *
 * @author thanh
 */
public class tu_giai1 {

    public static void main(String[] args) {
        
        
        int tong = 0;
        for(int i = 0; i<101;i++){
            if(i%2 !=0){
                tong+=i;
            }
            System.out.println("tổng các số lẻ là: "+tong);
        }
    }

}
