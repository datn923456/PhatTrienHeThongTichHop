package NguyenTinDatT2;
import java.io.*;
import java.util.Scanner;

public class Bai5T2 {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		String n;
		float tong=0;
		System.out.println("Nhập dãy số n vào: ");
		n = sc.nextLine();
		var arr = n.split(" ");
		for (String s : arr) {
			float so = Float.parseFloat(s);
			if(so > 0){
				tong += so;
			}
		}
		System.out.println("Tổng là : " + tong);
   }
}
