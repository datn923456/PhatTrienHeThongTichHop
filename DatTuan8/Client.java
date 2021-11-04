package DatTuan8;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws NotBoundException {
        Scanner sn = new Scanner(System.in);
        Registry reg;
        try {
            reg = LocateRegistry.getRegistry(7070);
            dattuan8interface cItf = (dattuan8interface) reg.lookup("NguyenTinDat");
            while(true){
                System.out.println("\n1: Viet hoa ky tu dau\n2: Dao chuoi ky tu\nNhap 'exit' de thoat");
                String nhap = sn.nextLine();
                switch(nhap){
                    case "1":{
                        System.out.println("\nNhap du lieu de viet hoa ky tu dau");
                        String dao = sn.nextLine();
                        System.out.println("\nChuoi duoc in hoa la : " + cItf.InHoaKyTuDau(dao));
                        break;
                    }
                    case "2":{
                        System.out.println("\nNhap du lieu dao nguoc");
                        String dao = sn.nextLine();
                        System.out.println("\nChuoi dao la : " + cItf.daochuoi(dao));
                        break;
                    }
                    case "exit":{
                        reg = LocateRegistry.getRegistry(0);
                        dattuan8interface ngatketnoi = (dattuan8interface) reg.lookup("null");
                        break;
                    }
                    default:{
                        System.out.println("\nKhong co gi het !!!");
                        break;
                    }
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}