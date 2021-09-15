package NguyenTinDatT2;

import java.io.*;
import java.util.Scanner;

public class Bai4T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n vao: ");
        int nhapn = sc.nextInt();

        int tong = 0;

        
        for (int n=1; n <= nhapn; n++) {
            tong = tong+n;
            
        }
        System.out.print("Tong =" + tong);
    }
}
