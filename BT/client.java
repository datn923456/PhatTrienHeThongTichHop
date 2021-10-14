package BT;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class client {
    //public final static String serverIP = "127.0.0.1";
    //public final static int serverPort = 8888;  
    public static void main(String[] args) throws InterruptedException, IOException{
        Socket s = null;
        Scanner scn = new Scanner(System.in);
        try {
            System.out.println("Nhap IP:");
            String serverIP = scn.nextLine();
            System.out.println("Nhap Port:");
            int serverPort = scn.nextInt();
            s = new Socket (serverIP,serverPort);
            System.out.println("Client da duoc tao");
            while(true){
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            System.out.println("\nMENU:\n1. 2n+1\n2. n(n+1)\n3. 1-2+3-4+5-6...\n4. QUIT\nNhap cau muon lam vao: ");
            Scanner sn = new Scanner(System.in);
            int nhap = sn.nextInt();
            os.write(nhap);
            // int tra = is.read();
            switch(nhap){
                case 1:{
                    System.out.println("Cong thuc c1 la 2n+1");
                    System.out.println("Nhap n de tinh");
                    int n1 = sn.nextInt();
                    os.write(n1);
                    int ch1 = is.read();
                    System.out.println("Ket qua la:" + ch1);
                    break;
                }
                case 2:{
                    System.out.println("Cong thuc c1 la n*(n+1)");
                    System.out.println("Nhap n de tinh");
                    int n2 = sn.nextInt();
                    os.write(n2);
                    int ch2 = is.read();
                    System.out.println("Ket qua la:" + ch2);
                    break;
                }
                case 3:{
                    System.out.println("Cong thuc c1 la 1-2+3-4+5...");
                    System.out.println("Nhap n de tinh");
                    int n3 = sn.nextInt();
                    os.write(n3);
                    int ch3 = is.read();
                    System.out.println("Ket qua la:" + ch3);
                    break;
                }
                case 4:{
                    System.out.println("EXIT");
                    s.close();
                    break;
                }
            }
        } 
        }catch (IOException ie) {
            //TODO: handle exception
            System.out.println("Error : can not create socket");
        }finally{
            if(s != null){
                s.close();
            }
        }
    }
}