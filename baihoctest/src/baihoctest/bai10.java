// viết chương trình thực hiện thao tác sau đối với một chuỗi cho trước
// - đếm số lượng ký tự 'a' có trong chuỗi 
// - kiểm tra chuỗi có chứa từ "java"
// - kiểm tra chuỗi có từ bắt đầu bằng "write"
// - kiểm tra chuỗi có kết thúc bằng từ "eáily"

/* chuỗi cho sẵn: "write a java program very easily" */
package baihoctest;

public class bai10 {

    public static void main(String[] args) {
        String z = "write a java program very easily";
        int count = 0;
        for (int i = 0; i < z.length(); i++) {
            if (z.charAt(i) == 'a') {
                count++;
                System.out.println("số ký tự a là: " + count);
            }

        }
        // kiểm tra chuỗi có chứa từ java
        int index = z.indexOf("java");
        if(index >=0){
            System.out.println("từ java có trong chuỗi ở vị trí thứ "+index);
        }
        // kiểm tra chuỗi có từ bắt đầu bằng "write"
        if(z.startsWith("write ")==true){
            System.out.println("từ write bắt đầu chuỗi");
        }else{
            System.out.println("từ write không bắt đầu chuỗi");
        }
        // kiểm tra chuỗi có kết thúc bằng từ  "easily"
        if (z.endsWith("easily")){
            System.out.println("nó kết thúc bằng easily");
        }else{
            System.out.println("nó không kết thúc bằng easily");
        }
    }
}
