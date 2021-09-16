package NguyenTinDatT2;

import java.io.*;
import java.util.Scanner;

public class Bai2T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số vào: ");
        int n = sc.nextInt();
        if(checkSoNguyenTo(n)){
            System.out.println(n+" là số nguyên tố");
        } else {
            System.out.println(n+" không là số nguyên tố");
        }

        sc.close();
    }
    public static boolean checkSoNguyenTo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
