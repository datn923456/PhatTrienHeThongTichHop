package Mau;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket s=null;
        Scanner nhap=new Scanner(System.in);
        try {
            
            System.out.println("Nhap IP:");
            String IP=nhap.nextLine();
            System.out.println("Nhap Port:");
            int port=nhap.nextInt();
            s=new Socket(IP,port);
            if(s!=null)
                {
                    System.out.println("Da ket noi");

                }
    
                while(true)
                {
                    InputStream is=s.getInputStream();
                    OutputStream os=s.getOutputStream();
                    byte[] a= new byte[1024];
                    int menu=is.read(a);
                    String menuString=new String(a,0,menu);
                    System.out.println(menuString);
                    System.out.println("Nhap yeu cau");
                    int yc=nhap.nextInt();
                    if(yc==0)  s.close();                 
                    os.write(yc);
                    byte[] b =new byte[100];
                    int ch=is.read(b);
                    String kq=new String(b, 0, ch);
                    System.out.println(kq);

                }
    
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
    
}

