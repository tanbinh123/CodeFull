//viết chương trình tính s = 7!+10!+12!+14!
package baihoctest;


public class bai8 {
    public static long fact(int n){
        int giaithua = 1;
        for(int i = 2; i<=n; i++){
        giaithua*=1;
    }
        return giaithua;
    }
    public static void main(String[] args) {
        long s = fact(7)+fact(10)+fact(12)+fact(14);
        System.out.println("giai thừa là: " + s);
    }
}
