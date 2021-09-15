package NguyenTinDat;

import java.util.Scanner;
import java.io.*;

public class tuan1 {
    static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		
		System.out.print("Nhập vào");
		InputStream is = System.in;//KeyBoard=System.in
		while(is != null) {
			try{
				int num = is.available(); 
				if(num > 0){
					byte[] b = new byte[num];  
					int result = is.read(b);
					if(result == -1){
						String s =new String(b);
						System.out.print(s);
						break;
					} 
					else{
						System.out.print('.');
						break;
					}
				}
			}
			catch(IOException ie) {
				System.out.print("Error:"+ie);
			}
		}
	}
}
