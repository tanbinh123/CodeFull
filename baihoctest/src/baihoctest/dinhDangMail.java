

package baihoctest;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author thanh
 */
public class dinhDangMail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String regex = "^\\w+[a-z0-9]*@\\w+mail.com$";

        if(input.matches(regex)){
            System.out.println("ok");
        }else{
            System.out.println("vui lòng nhập lại email");
        }
    }
}
