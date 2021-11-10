package demobai10;
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
            InputStream is=s.getInputStream();
            OutputStream os=s.getOutputStream();
            System.out.println("Nhap ten file:");
            String s1=nhap.nextLine();
            String nameFile=nhap.nextLine();
            os.write(nameFile.getBytes());
            while(true)
            {
                is=s.getInputStream();
                os=s.getOutputStream();
                System.out.println("Nhap tin nhan: ");
                String tn=nhap.nextLine();
                if(tn.trim().equals("HET"))
                {
                    s.close();
                } 
                os.write(tn.getBytes());
                int n=is.read();
                if(n==0)
                {
                    System.out.println("Luu tin nhan thanh cong");
                }
            }
    
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
    
}
