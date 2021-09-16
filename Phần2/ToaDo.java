package Phần2;
import java.util.Scanner;
import java.io.*;
public class ToaDo {
    static Scanner sc=new Scanner(System.in);
	private int toaDoX ;
	private int toaDoY;

	public int getToaDoX() {
		return toaDoX;
	}
	public void setToaDoX(int toaDoX) {
		this.toaDoX = toaDoX;
	}
	public int getToaDoY() {
		return toaDoY;
	}
	public void setToaDoY(int toaDoY) {
		this.toaDoY = toaDoY;
	}

	public ToaDo() {

	}
	public static void tinhKhoangCach(int x,int y){
		double tinhKhoangCach;
		tinhKhoangCach = Math.sqrt((x*x)+y*y);
		System.out.println("Khoảng cách từ tọa độ đó đến tọa độ 0 là:" + tinhKhoangCach);
	}
	public ToaDo(int toaDoX, int toaDoY) {
		super();
		this.toaDoX=toaDoX;
		this.toaDoY=toaDoY;

	}
	@Override
	public String toString() {
		return String.format("kết quả: (%d,%d)",toaDoX,toaDoY);
	}
    static ToaDo nhapmem() {

		System.out.println("nhập  tọa độ x:");
		int x=sc.nextInt();

		System.out.println("nhập  tọa độ y:");
		int y=sc.nextInt();

		ToaDo td = new ToaDo(x,y);
		tinhKhoangCach(x,y);

		return td ;

	}
	public static void main(String[] args ) {
		ToaDo td = nhapmem();
		System.out.println(td);

	}
}