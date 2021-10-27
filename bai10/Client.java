package baithi;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public final static String serverIP = "127.0.0.1";
    public final static int serverPort = 8888; 
    public static void main(String[] args) throws IOException {
        Socket s=null;
        Scanner nhap=new Scanner(System.in);
            try {
                s = new Socket (serverIP,serverPort);
                System.out.println("\nClient da duoc tao");
                while(true){
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                
                System.out.println("\nNhap ten file muon doc (ngung nhap go 'ht'): ");
                String nhapdulieu = nhap.nextLine();
                dos.writeUTF(nhapdulieu);
                switch(nhapdulieu){
                    case "client1":{
                        System.out.println("\nNhap du lieu vao file");
                        String guidulieu = nhap.nextLine();
                        dos.writeUTF(guidulieu);
                        String tra = dis.readUTF();
                        System.out.println(tra);
                        break;
                    }
                    case "client2":{
                        System.out.println("\nNhap du lieu vao file");
                        String guidulieu = nhap.nextLine();
                        dos.writeUTF(guidulieu);
                        String tra = dis.readUTF();
                        System.out.println(tra);
                        break;
                    }
                    case "cham":{
                        System.out.println("Ngung nhap !!!");
                        s.close();
                        break;
                    }
                }
                
            }
            } catch (Exception e) {
                //TODO: handle exception
            }finally{
                if(s != null){
                    s.close();
                }
            }
    }
}
