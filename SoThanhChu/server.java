package SoThanhChu;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;
public class server {
    public final static int serverPort = 7 ;
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
                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                    Scanner sn = new Scanner(System.in);
                    int ch = is.read();
                    switch(ch){
                        case 0:{
                            dos.writeUTF("Khong");
                            break;
                        }
                        case 1:{
                            dos.writeUTF("Mot");
                            break;
                        }
                        case 2:{
                            dos.writeUTF("Hai");
                            break;
                        }
                        case 3:{
                            dos.writeUTF("Ba");
                            break;
                        }
                        case 4:{
                            dos.writeUTF("Bon");
                            break;
                        }
                        case 5:{
                            dos.writeUTF("Nam");
                            break;
                        }
                        case 6:{
                            dos.writeUTF("Sau");
                            break;
                        }
                        case 7:{
                            dos.writeUTF("Bay");
                            break;
                        }
                        case 8:{
                            dos.writeUTF("Tam");
                            break;
                        }
                        case 9:{
                            dos.writeUTF("Chin");
                            break;
                        }
                        default:{
                            dos.writeUTF("Khong phai so nguyen");
                        }
                    }
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
}