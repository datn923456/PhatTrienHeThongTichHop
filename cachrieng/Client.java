package cachrieng;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public final static String serverIP = "127.0.0.1";
    public final static int serverPort = 8888;
    public static void main(String[] args) throws NotBoundException, UnknownHostException, IOException {
        Socket s=null;
        Scanner sn = new Scanner(System.in);
        Registry reg;
        try {
            s = new Socket (serverIP,serverPort);
            System.out.println("\nClient da duoc tao");
            reg = LocateRegistry.getRegistry(7070);
            dattuan8interface cItf = (dattuan8interface) reg.lookup("NguyenTinDat");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            while(true){
                System.out.println("\nNhap 1 de sap xep\n Nhap 2 de gop 2 sap xep");
                int nhap = sn.nextInt();
                switch(nhap){
                    case 1:{
                        int chuoi1[] = {93,81,95,74}, chuoi2[] = {93,81,95,74};
                        int sorted1[], sorted2[], sorted[];
                        sorted1 = cItf.sort(chuoi1);
                        sorted2 = cItf.sort(chuoi2);
                        System.out.println("\nDa sap xep 1: ");
                        for (int i = 0; i < sorted1.length; i++) {
                            System.out.print(sorted1[i] + "\t");
                        }
                        System.out.println("\nDa sap xep 2: ");
                        for (int i = 0; i < sorted2.length; i++) {
                            System.out.print(sorted2[i] + "\t");
                        }
                        break;
                    }
                    case 2:{
                        int chuoi1[] = {93,81,95,74}, chuoi2[] = {93,81,95,74};
                        int sorted1[], sorted2[], sorted[];
                        sorted1 = cItf.sort(chuoi1);
                        sorted2 = cItf.sort(chuoi2);
                        System.out.println("\nDa sap xep 1: ");
                        for (int i = 0; i < sorted1.length; i++) {
                            System.out.print(sorted1[i] + "\t");
                        }
                        System.out.println("\nDa sap xep 2: ");
                        for (int i = 0; i < sorted2.length; i++) {
                            System.out.print(sorted2[i] + "\t");
                        }
                        dos.writeUTF(c1);
                        dos.writeUTF(c2);

                        String tra = dis.readUTF();
                        System.out.println("tra ve: " + tra);
                        break;
                    }
                    default:{
                        System.out.println("Khong co gi het!!!");
                        break;
                    }
                }
                //sorted = cItf.merge(sorted1, sorted2);
                //System.out.println("\nket hop chuoi 1 va 2 vua sap xep");
                //for (int i = 0; i < sorted.length; i++) {
                     //System.out.print(sorted[i] + "\t");
                //}
                // String nhap = sn.nextLine();
                
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}