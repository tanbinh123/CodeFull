package newpackage;
import java.util.Scanner;


public class sach {
    

   private String masach;
    private String tensach;
    private int sotrang;
    
  public sach() {
        this.masach = "";
        this.tensach = "";
        this.sotrang = 0;
    }

    public sach(String masach, String tensach, int sotrang) {
        this.masach = masach;
        this.tensach = tensach;
        this.sotrang = sotrang;

    }

    public String getMasach() { 
        return this.masach;

    }

    public void setmasach(String masach) {
        this.masach = masach;

    }

    public String getTensach() {
        return this.tensach;
    }

    public void settensach(String tensach) {
        this.tensach = tensach;
    }

    public int getSotrang() {
        return this.sotrang;
    }

    public void setsotrang(int sotrang) {
        this.sotrang = sotrang;
    }
public void nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma sach: ");

        this.masach = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        this.tensach = sc.nextLine();
        System.out.print("Nhap so trang ");

        this.sotrang = sc.nextInt();

    }

    public void xuat() {
        System.out.printf("%-10s %-25s %-25s\n ",
                this.masach, this.tensach, this.sotrang);
    }

    public static void main(String[] args) {
        sach[] sachList = new sach[5];
        for (int i = 0; i < 0; i++) {
            sachList[i] = new sach();

        }
        for (int i = 0; i < 0; i++) {
            sachList[i].xuat();
        }
    }
}

