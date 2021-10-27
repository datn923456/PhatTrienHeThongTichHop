package BAI6;

import java.io.InputStream;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public final static String severIP="127.0.0.1";
    public final static int severPort=777;
    public static void main(String[] args) {
        Socket s=null;
        try {
            while(true)
            {
                s=new Socket(severIP,severPort);
                DataInputStream dis=new DataInputStream(s.getInputStream());
                DataOutputStream dos=new DataOutputStream(s.getOutputStream());
                DataInputStream disClient=new DataInputStream(System.in);
                System.out.println("Nhap yeu cau");
                String yc=disClient.readLine();
                int a=Integer.parseInt(yc);
                if(a==-1) break;
                System.out.println("Nhap so n");
                String n=disClient.readLine();
                dos.writeBytes(yc+'\n');
                dos.writeBytes(n+'\n');
                String kq= dis.readLine();
                System.out.println("Ket qua: "+kq);
            }
            
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}
