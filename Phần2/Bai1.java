package Phần2;

import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class Bai1 {
    Scanner sc = new Scanner(System.in);
    double x;
    double y;
    double khoangCach=0;

    public void toado(double x, double y){
        this.x=x;
        this.y=y;
    }
    public static void inManHinh(double x,double y){
        System.out.println(x+","+y);
    }
    public static void nhapToaDo(double x,double y){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhập tọa độ x");
            x = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Không được để trống");
        }
        try {
            System.out.println("Nhập tọa độ y");
            y = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Không được để trống");
        }
    }
    public static void tinhKhoangCach(double x,double y,double khoangCach){
        khoangCach = Math.sqrt(x*x)+Math.sqrt(y*y);
    }
    public static void main(String[] args) {
        double x=0;
        double y=0;
        double khoangCach=0;
        Scanner sc = new Scanner(System.in);
        nhapToaDo(x,y);
        tinhKhoangCach(x, y, khoangCach);
        inManHinh(x, y);
    }
}
