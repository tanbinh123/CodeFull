
package lab8_nop;

import java.util.ArrayList;

public class bai2 {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			arrayList.add(i);
		}
		for (Integer integer : arrayList) {
			System.out.println(integer.toString());
		}
	}
}
