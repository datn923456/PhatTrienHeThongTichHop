package BAI6;

import java.io.InputStream;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(777);
            System.out.println("Sever duco tao");
            while(true)
            {
                Socket s=ss.accept();
                Processing p=new Processing(s);
                p.start();
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    

    
}
