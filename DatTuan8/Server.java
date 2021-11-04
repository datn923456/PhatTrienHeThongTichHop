package DatTuan8;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            dattuan8impl obj = new dattuan8impl();
            System.out.println("Khoi tao doi tuong thanh cong");

            LocateRegistry.createRegistry(7070);
            Registry reg = LocateRegistry.getRegistry(7070);
            reg.bind("NguyenTinDat", obj);
            System.out.println("Da dang ky doi tuong Nguyen Tin Dat Tuan 8 voi registry");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}