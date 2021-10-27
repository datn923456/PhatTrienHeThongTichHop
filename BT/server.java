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
            ServerSocket ss=new ServerSocket(8888);
            System.out.println("Sever dduoc tao");
            while(true)
            {
                Socket s= ss.accept();
                RequestProcessing p =new RequestProcessing(s);
                p.start();
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}