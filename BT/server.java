package BT;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class server {
    public final static int serverPort = 8888 ;
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(serverPort);
            System.out.println("Server da duoc tao");
            while (true){
                try {
                    Socket s = ss.accept();
                    RequestProcessing rp = new RequestProcessing(s);
                    OutputStream os = s.getOutputStream();
                    InputStream is = s.getInputStream();
                    int n = is.read();
                    switch(n){
                        case 1:{
                            System.out.println("\nDang cho nguoi dung nhap n");
                            int n1 = is.read();
                            System.out.println("\nNguoi dung nhap n la " + n1);
                            os.write(tinhc1(n1));
                            
                            System.out.println("\nDang gui ket qua ve client");
                            break;
                        }
                        case 2:{
                            System.out.println("\nDang cho nguoi dung nhap n");
                            int n2 = is.read();
                            System.out.println("\nNguoi dung nhap n la " + n2);
                            os.write(tinhc2(n2));
                            
                            System.out.println("\nDang gui ket qua ve client");
                            break;
                        }
                        case 3:{
                            System.out.println("\nDang cho nguoi dung nhap n");
                            int n3 = is.read();
                            System.out.println("\nNguoi dung nhap n la " + n3);
                            os.write(tinhc3(n3));
                            
                            System.out.println("\nDang gui ket qua ve client");
                            break;
                        }
                    }
                    os.write(n);
                    rp.start();
                } catch (IOException ie1) {
                    //TODO: handle exception
                    System.out.println("Connection Error: "+ ie1);
                }
            }
        } catch (IOException ie) {
            //TODO: handle exception
            System.out.println("Connection Error: "+ ie);
        }
    }
    public static int tinhc1(int n){
        int tong1=0;
        for(int i=0; i<=n;i++){
            tong1 += (2*i+1);
        }
        return tong1;
    }
    public static int tinhc3(int n){
        int tong3=0;
        for(int i=1; i<=n+1;i++){
            if(i%2 == 0){
                tong3 -= i;
            }else{
                tong3 += i;
            }
        }
        return tong3;
    }
    public static int tinhc2(int n){
        int tong2=0;
        for(int i=0; i<=n;i++){
            tong2 += i*(i+1);
        }
        return tong2;
    }
}