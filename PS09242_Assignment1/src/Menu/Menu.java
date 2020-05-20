package Menu;

import java.util.*;

public class Menu{

    private static class args {

        public args() {
        }
    }
    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        int chon;
        while(true){
            System.out.println("------- Menu -------");
            System.out.println("1. nhập danh sách học viên");
            System.out.println("2. xuất danh sách học viên");
            System.out.println("3. tìm học viên theo điểm");
            System.out.println("4. tìm học viên theo học lực");
            System.out.println("5. tìm học viên theo mã số");
            System.out.println("6. xắp xếp học viên theo điểm");
            System.out.println("7. xuất 5 học viên có điểm cao nhất");
            System.out.println("8. tính điểm trung bình của lớp");
            System.out.println("9. xuất học viên có điểm trên trung bình của lớp");
            System.out.println("10. tổng hợp số học viên theo học lực");
            System.out.println("11. thoát");
            System.out.println("chọn Menu: ");
            chon = sc.nextInt();
            switch(chon){
                case 1:
                    System.out.println("nhập danh sách học viên");
                    break;
                case 2:
                    System.out.println("xuất danh sách học viên");
                    break;
                case 3:
                    System.out.println("tìm học viên theo điểm");
                    break;
                case 4:
                    System.out.println("tìm học viên theo học lực");
                    break;
                case 5:
                    System.out.println("tìm học viên sắp xếp theo mã số");
                    break;
                case 6:
                    System.out.println("xắp xếp học viên theo điểm");
                    break;
                case 7:
                    System.out.println("xuất 5 học viên có điểm cao nhất");
                    break;
                case 8:
                    System.out.println("tính điểm trung bình của lớp");
                    break;
                case 9:
                    System.out.println("xuất học viên có điểm trên trun bình");
                    break;
                case 10:
                    System.out.println("tổng hợp số học viên theo học lực");
                case 11:
                    break;
                default:
                    System.out.println("mời nhập lại! (0-11)");
            }
            if (chon == 11 ){
                try{
                    System.out.println("are you sure?y/n?: ");
                    char ch = (char) System.in.read();
                    if (ch == 'y' || ch == 'y'){
                        System.out.println("thoat....");
                        System.exit(0);
                        
                    }
            }catch(Exception ex){
                
            }
        }
        
    }
    }
}