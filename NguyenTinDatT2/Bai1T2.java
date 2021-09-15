package NguyenTinDatT2;

import java.io.*;
import java.util.Scanner;

public class Bai1T2 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String message;
    System.out.println("\n\nNhập vào chuỗi cần in hoa: ");
    message = sc.nextLine();
    System.out.println("Chuỗi sau khi in hoa: ");
    System.out.println(message.toUpperCase());
    }
}