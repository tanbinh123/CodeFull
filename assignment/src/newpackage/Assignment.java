
package newpackage;




import java.util.Scanner;


/**
 *
 * @author Welcome
 */
public class Assignment{
  
    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
      static final int MaxSV = 20;
      static int SoSV;
      static String[] hoTen;
      static String[] email;
      static String[] masv;
      static double[] diem;
      
             
    public static void main(String[] args) {
    
        String nhap;
       
        
        boolean check = true;
        System.out.println("=***********************************************************=");
        System.out.println("=                Chao muong den chuong trinh                =");
        System.out.println("=  1 de nhap thong tin                                      =");
        System.out.println("=  2 de xuat thong tin                                      =");
        System.out.println("=  3 de tim thong tin theo khoang diem                      =");
        System.out.println("=  4 de tim thong tin theo hoc luc                          =");
        System.out.println("=  5 tim hoc vien theo ma so va cap nhat                    =");
        System.out.println("=  6 de sap xep thong tin theo diem                         =");
        System.out.println("=  7 de xuat 5 hoc vien diem cao                            =");
        System.out.println("=  8 de tinh diem trung binh                                =");
        System.out.println("=  9 de xuat thong tin co diem trung binh cao hon trung binh lop =");
        System.out.println("=  10 de tong hop so hoc vien theo hoc luc                      =");
        System.out.println("=***********************************************************=");
        System.out.println("= '0' de thoat");
        
        
        do {
            nhap = Keyboard.readString("= Lựa chọn chức năng: ");
            
            switch (nhap) {
                
                case "1":
                    System.out.println("nhập thông tin");
                    nhapthongtin();
                    break;
                case "2":
                    System.out.println("xuất thông tin ");
                    xuatdanhsachSV();
                    break;
                case "3":
                    System.out.println("tìm thông tin theo khoảng điểm");
                    thongtintheodiem();
                    break;
                case "4":
                    System.out.println("tìm thông tin theo học lực");                   
                    hoclucSV();
                    break;
                case "5":
                    System.out.println("tì, thhoong tin theo mã Sv và cập nhật");
                    maSoVaCapNhat();
                    break;
                case "6":
                    System.out.println("sắp xếp thông tin theo điểm");
                     sxthongtintheodiem();
                    break;
                case "7":
                    System.out.println("xuất ra 5 học viên có điểm cao nhất");
                    xuatdiemSVcaonhat();
                    break;
                case "8":
                    System.out.println("Tính trung bình SV");
                    tinhdiemTb();
                    System.out.println("Xuất điểm trung bình" + tinhdiemTb());
                    break;
                case "9":
                    System.out.println("Xuất học viên có điểm trung bình cao hơn trung bình lớp");
                    xuatdiemTBcaonhat();
                    break;
                case "10":
                    System.out.println("Tổng hợp học viên theo học lực");
                    THhocvientheoHL();
                    break;
                case "0":
                    System.out.println("Cảm ơn đã sử dụng ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bạn chon sai chức năng, nhập lại:");
                    continue;
                
                    
            }
        } while (check == true);
             
        System.out.println("Tắt chương trình");
    }
    // case 1
    public static void nhapthongtin() {
        // nhap so luong SV
        do {
            System.out.println("Nhap so sinh viên : ");
            SoSV = sc.nextInt();
            if (SoSV > MaxSV) {
                System.out.println("Vuot quá so luong");
            }
        } while (SoSV > MaxSV);
        
        hoTen = new String[SoSV];
        email = new String[SoSV];
        diem = new double[SoSV];
        masv = new String[SoSV];
        
        for (int i = 0; i <= SoSV - 1; i++) {   
            while (true) {
                String hoTenNhap = Keyboard.readString("Nhap tên sinh viên thứ " + (i+1) + ": ");
                if (hoTenNhap.trim().equals("") == false) {
                    boolean trung = false;
                    for (int j = 0; j <= hoTen.length -1; j++) {
                        if (hoTenNhap.trim().equals(hoTen[j])) {
                            System.out.println("Tên bị trùng. Vui lòng nhập lại");
                            trung = true;
                            break;
                        }
                    }
                    
                    if (trung == false) {
                        hoTen[i] = hoTenNhap.trim();
                        break;
                    }
                    
                }
                else {
                    System.out.println("Tên không được trống");
                }
            }

               
            while (true) {
                diem[i] = Keyboard.readDouble("Nhap diem: ");   
                if (diem[i] >= 0 && diem[i] <= 10) {
                    break;
                } else {
                    System.out.println("Sai điểm");
                }  
            }
          
            email[i] = test.text();
            masv[i] = Keyboard.readString("Nhập mã số: ");
            
        }  
    }
    
    //case 2
    public static void xuatHocVien(int a) {
        System.out.printf("%s\t%s\t\t%s\t%.2f\t%s\n", masv[a], hoTen[a], email[a], diem[a], hocluc.xepLoai(diem[a]));
    }
    
    public static void  xuatdanhsachSV(){
        System.out.println("Xuat Danh sách SV: ");
        System.out.printf("%s\t%s\t\t%s\t%s\t%s\t\n", "Mã số SV", "Ho Tên", "Email","Ðiểm", "Hoc lực");
        for (int i = 0; i <= SoSV - 1; i++) {
            xuatHocVien(i);
        }
        System.out.println();
    }
    
    //case 3
    public static void thongtintheodiem(){
        int min, max;
        min =sc.nextInt();
        max = sc.nextInt();
        for(int i =0; i <= diem.length -1; i++){
            if (diem[i] > min && diem[i] < max) {
                System.out.println("Xuat diem khoang cach :" + diem[i]);   
            }
        }
    }
    
    //case 4
    public static void hoclucSV() {
   
            System.out.println("Tim SV theo hoc luc   ");
            String hocLuc = Keyboard.readString("  Nhap hoc luc : ");
            System.out.println("Danh sach hoc vien có hoc luc  : " + hocLuc.toUpperCase());
        
        for(int i = 0; i < diem.length; i++){
            if(hocluc.xepLoai(diem[i]).equalsIgnoreCase(hocLuc)) {
              
                xuatHocVien(i);
            }            
        }   
    }
    
    //case 5
    public static void maSoVaCapNhat() {
        
        String maSV = Keyboard.readString("Nhap mã SV: ");
         
        boolean foud = false; // ket qua true (tim thay va false (khong tim thay 
        int chiSo = 0;
        for (int i = 0; i <= SoSV; i++) {
            if (masv[i].equalsIgnoreCase(maSV)) {
                foud = true; // tim thay va ra khoi vong lap
                chiSo = i;
                break;
            }
        }
        if (foud == false) {
            System.out.println("Sinh viên không ton tai"); 
        }
        else{
            hoTen[chiSo] = Keyboard.readString("Cap nhat tên sinh viên moi: ");
            diem[chiSo]  = Keyboard.readDouble("Cap nhat diem sinh viên moi: ");
            email[chiSo] = test.text();
        }
    }
    
    //case 6
    public static void sxthongtintheodiem () {
        for(int i = 0; i <= SoSV -1; i++) {
            for(int j = i + 1; j <= SoSV -1; j++ ){
                if (diem[i] > diem[j]) {
                    xArray.swap(masv, i, j);
                    xArray.swap(diem, i, j);
                    xArray.swap(hoTen, i, j);
                    xArray.swap(email, i, j);
                }
            } 
        }
              
        System.out.println("Ðã sap xep theo diem tu thap toi cao ");
    }
    
    //case 7
    public static void xuatdiemSVcaonhat() {
     
        System.out.println("Top 5 Sinh viên có diem cao nhat: ");
        System.out.printf("%s\t%s\t%2s\t\t%s\t%s\n","Mã SV","Ho tên","Email","Ðiểm","Hoc luc");
        for(int i = 0; i <= SoSV -1; i++) {
            for(int j = i + 1; j <= 4; j++ ){
                if (diem[i] > diem[j]) {
                    xArray.swap(diem,i, j);
                    xArray.swap(hoTen, i, j);
                    xArray.swap(masv, i, j);
                    xArray.swap(email, i, j);
                } else{
                    System.out.println();
                }  
            }
        }
            for( int t = 0; t <= 4; t++){
                xuatHocVien(t);
            }       
    }
    
    //case 8
    public static double tinhdiemTb (){
        double Tong = 0;
        double TB = 0;
            for(int i = 0; i <= diem.length -1; i++) {
                 Tong = Tong + diem[i];
           }
            return TB = Tong/SoSV; 
    }
    //case 9
    public static void xuatdiemTBcaonhat (){
      
     
        System.out.println("Nhung sinh viên có diem trên trung bình lop");
        System.out.printf("%s\t%s\t%2s\t\t%s\t%s\n","Mã SV","Ho tên","Email","Diem","Hoc luc");
            for(int i = 0; i <= SoSV -1; i++){
               if(diem[i] > tinhdiemTb()){
                  xuatHocVien(i);
                }
            }    
    }
    //case 10
    public static void THhocvientheoHL(){
     int yeu = 0, Tb = 0, Kha = 0,gioi = 0, xuatsac = 0;
            for(int i = 0;i <= diem.length -1; i++){
                if(diem[i] < 5){
                    yeu = yeu + 1;     
                } 
                else if(diem[i] > 5 && diem[i] <6.5){
                    Tb = Tb + 1;
                }
                else if(diem[i] > 6.5 && diem[i] <7.5 ){
                    Kha = Kha +1;
                }
                else if(diem[i] > 7.5 && diem[i] < 9 ){
                    
                    gioi = gioi + 1;
                } 
                else  {
                    xuatsac = xuatsac + 1;
                }
            
            }
        System.out.println("hoc luc  yeu\t\n" + yeu);
        System.out.println("hoc luc  Trung bình\t\n" + Tb);
        System.out.println("hoc luc  khá\t\n" + Kha);
        System.out.println("hoc luc  gioi\t\n " + gioi);
        System.out.println("hoc luc  xuat soc\t\n" + xuatsac);

        
    }

    private static String xuatHocVien(double[] diem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
