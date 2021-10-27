package Chat;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class client {
    public final static String serverIP = "127.0.0.1";
    public final static int serverPort = 8888;  
    public static void main(String[] args) throws InterruptedException, IOException{
        Socket s = null;
        Scanner scn = new Scanner(System.in);
        try {
            s = new Socket (serverIP,serverPort);
            System.out.println("Client da duoc tao");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            //String mau = "";
            while(true){
                    System.out.println("SERVER: " + dis.readUTF());
                    System.out.println("Nhap de chat");
                    Scanner sn = new Scanner(System.in);
                    String nhap = sn.nextLine();
                    dos.writeUTF(nhap);
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