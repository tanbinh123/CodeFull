package demoasm;

// tsua 0: xài lớp Keyboard thì không phải lo vụ sc.nextLine().
import java.util.Scanner;
import demoasm.Keyboard;
import demoasm.Xarray;

public class demoasm {
	// tsua 1: không cần mảng học lực, lý do vì sao ông đọc tiếp sẽ rõ hơn, biến soLuong dùng để lưu số lượng sinh viên

    // những dòng này mới chỉ là những dòng KHỞI TẠO
    static int soLuong;
    static String[] maso;
    static String[] hoten;
    static double[] diem;
    static String[] email;

    public static void main(String[] args) {
        while (true) {
            System.out.println("------------------------- Menu ------------------------");
            System.out.println("= 1. nhập danh sách học viên                          =");
            System.out.println("= 2. xuất danh sách học viên                          =");
            System.out.println("= 3. tìm học viên theo điểm                           =");
            System.out.println("= 4. tìm học viên theo học lực                        =");
            System.out.println("= 5. tìm học viên theo mã số                          =");
            System.out.println("= 6. xắp xếp học viên theo điểm                       =");
            System.out.println("= 7. xuất 5 học viên có điểm cao nhất                 =");
            System.out.println("= 8. tính điểm trung bình của lớp                     =");
            System.out.println("= 9. xuất học viên có điểm trên trung bình của lớp    =");
            System.out.println("= 10. tổng hợp số học viên theo học lực               =");
            System.out.println("= 11. thoát                                           =");
            System.out.println("-------------------------------------------------------");
            System.out.println("chọn Menu: ");

            int chon = Keyboard.readInt("Hãy chọn chức năng: ");
            switch (chon) {
                case 1:
                    System.out.println("nhập danh sách học viên");
                    nhapDanhSachHocVien();
                    break;
                case 2:
                    System.out.println("xuất danh sách học viên");
                    xuatDanhSachHocVien();
                    break;
                case 3: