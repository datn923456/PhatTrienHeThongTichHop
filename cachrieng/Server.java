package cachrieng;

import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
                // dattuan8impl obj = new dattuan8impl();
                // System.out.println("Khoi tao doi tuong thanh cong");

                // LocateRegistry.createRegistry(7070);
                // Registry reg = LocateRegistry.getRegistry(7070);
                // reg.bind("NguyenTinDat", obj);
                
                // System.out.println("registry");
            while(true)
            {
                
                ServerSocket ss=new ServerSocket(8888);
                System.out.println("Sever duoc tao");
                Socket s= ss.accept();
                Processing p =new Processing(s);
                p.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}