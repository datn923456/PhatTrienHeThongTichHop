package Phần2;
import java.util.Scanner;
import java.io.*;
public class PhanSo {
    static Scanner sc=new Scanner(System.in);
	private int tuSo ;
	private int mauSo;

	public int getTuSo() {
		return tuSo;
	}
	public void setTuSo(int tuSo) {
		this.tuSo = tuSo;
	}
	public int getMauSo() {
		return mauSo;
	}
	public void setMauSo(int mauSo) {
		this.mauSo = mauSo;
	}

	public PhanSo() {

	}
	public PhanSo(int tuSo, int mauSo) {
		super();
		this.tuSo=tuSo;
		this.mauSo=mauSo;

	}
    static int UCLN(int a, int b){
        while(a!=b){
                if(a>b) a=a-b;
                else b=b-a;
        }
        return a;
    }
    static PhanSo toigian(PhanSo ps){
        PhanSo phanso = new PhanSo();
        phanso.tuSo = ps.tuSo/UCLN(Math.abs(ps.tuSo),Math.abs(ps.mauSo));
        phanso.mauSo = ps.mauSo/UCLN(Math.abs(ps.tuSo),Math.abs(ps.mauSo));
        return phanso;
    }
	@Override
	public String toString() {
		return String.format("Phân số: (%d/%d)",tuSo,mauSo);
	}
    static PhanSo nhapmem() {

		System.out.println("nhập  tử số:");
		int x=sc.nextInt();

		System.out.println("nhập  mẫu số:");
		int y=sc.nextInt();

		PhanSo ps = new PhanSo(x,y);
		return ps ;
	}
	public static void main(String[] args ) {
		PhanSo ps = nhapmem();
		System.out.println(ps);
        PhanSo toigianps = ps.toigian(ps);
        System.out.println("Phân số sau khi tối giãn là: " + toigianps);
	}
}