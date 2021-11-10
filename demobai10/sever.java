package demobai10;

import java.net.ServerSocket;
import java.net.Socket;

public class sever {
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(1111);
            System.out.println("Sever dduoc tao");
            while(true)
            {
                Socket s= ss.accept();
                Processing p=new Processing(s);
                p.start();
                
            }

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}
