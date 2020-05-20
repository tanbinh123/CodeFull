package demoasm;

import java.util.Scanner;
import demoasm.Keyboard;
import demoasm.Xarray;

public class demoasm {

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
                    System.out.println("tìm học viên theo khoảng điểm");
                    timHocVienTheoKhoangDiem();
                    break;
                case 4:
                    System.out.println("tìm học viên theo học lực");
                    timHocVienTheoHocLuc();
                    break;
                case 5:
                    System.out.println("tìm học viên và cập nhật theo mã số");
                    timHocVienTheoMaSo();
                    break;
                case 6:
                    System.out.println("xắp xếp học viên theo điểm");
                    xapSepTheoDiem();
                    System.out.println("Đã sắp xếp xong, vui lòng chọn chức năng 2 để xem danh sách");
                    break;
                case 7:
                    System.out.println("xuất 5 học viên có điểm cao nhất");
                    namHocVienCoDiemCaoNhat();
                    break;
                case 8:
                    System.out.println("tính điểm trung bình của lớp");
                    tinhDiemTrungBinhCuaLop();
                    break;
                case 9:
                    System.out.println("xuất học viên có điểm trên trung bình");
                    hocVienCoDiemTrenTB();
                    break;
                case 10:
                    System.out.println("tổng hợp số học viên theo học lực");
                    tongHopHocVienTheoHocLuc();
                case 11:
                    break;
                default:
                    System.out.println("mời nhập lại! (0-11)");
            }
            if (chon == 11) {
                try {
                    System.out.println("are you sure? (y/n): ");
                    char ch = (char) System.in.read();

                    if (ch == 'y' || ch == 'Y') {
                        System.out.println("thoat....");
                        System.exit(0);

                    }
                } catch (Exception ex) {

                }
            }
        }
    }

    // case 1
    private static void nhapDanhSachHocVien() {
        soLuong = Keyboard.readInt("nhập số lượng sinh viên: ");

        maso = new String[soLuong];
        hoten = new String[soLuong];
        diem = new double[soLuong];
        email = new String[soLuong];

        for (int i = 0; i < soLuong; i++) {

            while (true) {
                String input = Keyboard.readString("nhập mã số học viên: " + (i + 1) + ": ");
                boolean timthay = false;
                for (int j = 0; j < soLuong; j++) {
                    if (input.equalsIgnoreCase(maso[j])) {
                        timthay = true;
                        break;
                    }
                }
                if (timthay == true) {
                    System.out.println("mã số trùng, mời nhập lại");
                } else {
                    maso[i] = input;
                    break;
                }
            }
            //trim = cắt khoảng trắng
            while (true) {
                String input = Keyboard.readString("nhập tên học viên " + (i + 1) + ": ");

                if (input.trim().equals("")) {
                    System.out.println("tên không được trống");
                } else {
                    hoten[i] = input.trim();
                    break;
                }
            }
            while (true) {
                diem[i] = Keyboard.readDouble("Nhập điểm học viên " + (i + 1) + ": ");
                if (diem[i] >= 0 && diem[i] <= 10) {
                    break;
                } else {
                    System.out.println("nhập lại điểm");

                }
            }

            while (true) {
                email[i] = Keyboard.readString("nhập emalil học viên " + (i + 1) + ": ");
                String regex = "^\\w+[a-z0-9]*@\\w+mail.com$";

                if (email[i].matches(regex)) {
                    break;
                } else {
                    System.out.println("nhập lại email");
                    continue;
                }

            }

            System.out.println("---------------------");
        }
    }

    private static String hocluc(double diem) {
        String hocluc = "";

        if (diem < 5) {
            hocluc = "yeu";
        } else if (diem >= 5 && diem < 6.5) {
            hocluc = "trung binh";
        } else if (diem >= 6.5 && diem < 7.5) {
            hocluc = "kha";
        } else if (diem >= 7.5 && diem < 9) {
            hocluc = "gioi";
        } else {
            hocluc = "xuat sac";
        }

        return hocluc;
    }

    //case 2
    private static void xuatHocVienThu(int i) {
        System.out.println("mã số là: " + maso[i]);
        System.out.println("họ tên: " + hoten[i]);
        System.out.println("email: " + email[i]);
        System.out.println("điểm: " + diem[i]);
        System.out.println("học lực: " + hocluc(diem[i]));
        System.out.println("---------------------");
    }

    private static void xuatDanhSachHocVien() {
        for (int i = 0; i < soLuong; i++) {
            xuatHocVienThu(i);
        }
    }

    //case 3
    private static void timHocVienTheoKhoangDiem() {
        int a, b;

        a = Keyboard.readInt("Nhập vào khoảng điểm từ: ");
        b = Keyboard.readInt("Tới: ");

        for (int i = 0; i < diem.length; i++) {
            if (diem[i] > a && diem[i] < b) {

                xuatHocVienThu(i);
            }
        }
    }

    //case 4
    private static void timHocVienTheoHocLuc() {

        String S = Keyboard.readString("nhập học lực: ");
        boolean timthay = false;
        for (int i = 0; i < soLuong; i++) {
            if (hocluc(diem[i]).equalsIgnoreCase(S)) {
                xuatHocVienThu(i);
                timthay = true;
            }
        }

        if (timthay == false) {
            System.out.println("không tìm thấy học viên có học lực: " + S);
        }
    }

    //case 5
    private static void timHocVienTheoMaSo() {

        String T = Keyboard.readString("nhập mã số: ");
        boolean timthay = false;
        int chiSo = -1;
        for (int i = 0; i < soLuong; i++) {
            if (maso[i].equalsIgnoreCase(T)) {
                xuatHocVienThu(i);
                timthay = true;
                chiSo = i;
                break;
            }
        }

        if (timthay == false) {
            System.out.println("không tìm thấy học viên có mã số: " + T);
        } else {
            hoten[chiSo] = Keyboard.readString("hãy nhập tên mới: ");
            diem[chiSo] = Keyboard.readDouble("nhập điểm mới: ");
            while (true) {
                email[chiSo] = Keyboard.readString("nhập emalil học viên " + (chiSo + 1) + ": ");
                String regex = "^\\w+[a-z0-9]*@\\w+mail.com$";

                if (email[chiSo].matches(regex)) {
                    break;
                } else {
                    System.out.println("nhập lại email");
                    continue;
                }

            }
        }

    }

    // case 6
    private static void xapSepTheoDiem() {

        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                if (diem[i] > diem[j]) {

                    Xarray.swap(maso, i, j);
                    Xarray.swap(hoten, i, j);
                    Xarray.swap(diem, i, j);
                    Xarray.swap(email, i, j);

                }
            }
        }
    }

    //case 7
    private static void namHocVienCoDiemCaoNhat() {

        xapSepTheoDiem();

        if (soLuong < 5) {
            System.out.println("danh sách chỉ có " + soLuong + " sinh viên");
            for (int i = soLuong - 1; i >= 0; i--) {
                xuatHocVienThu(i);
            }
        } else {
            System.out.println("5 học viên có điểm cao nhất là: ");
            for (int i = 4; i >= 0; i--) {
                xuatHocVienThu(i);
            }
        }
    }

    //case 8
    private static void tinhDiemTrungBinhCuaLop() {
        double tong = 0;
        double diemtrungbinh = 0;
        for (int i = 0; i < soLuong; i++) {
            tong = tong + diem[i];
        }

        diemtrungbinh = tong / soLuong;
        System.out.println(diemtrungbinh);
    }

    //case 9
    private static void hocVienCoDiemTrenTB() {
        for (int i = 0; i < soLuong; i++) {
            if (diem[i] > 5) {
                xuatHocVienThu(i);
            }
        }

    }

    //case 10
    private static void tongHopHocVienTheoHocLuc() {
        int demXuatSac = 0;
        int demGioi = 0;
        int demKha = 0;
        int demTB = 0;
        int demYeu = 0;
        for (int i = 0; i < soLuong; i++) {
            if (diem[i] >= 9) {
                demXuatSac++;
            }
            if (diem[i] >= 7.5 && diem[i] < 9) {
                demGioi++;
            }
            if (diem[i] >= 6.5 && diem[i] < 7.5) {
                demKha++;
            }
            if (diem[i] >= 5 && diem[i] < 6.5) {
                demTB++;
            }
            if (diem[i] < 5) {
                demYeu++;
            }

        }
        System.out.println("Số học sinh xuất sắc là: " + demXuatSac);
        System.out.println("Số học sinh giỏi là: " + demGioi);
        System.out.println("Số học sinh khá là: " + demKha);
        System.out.println("Số học sinh trung bình là: " + demTB);
        System.out.println("Số học sinh yếu là: " + demYeu);
    }
}
