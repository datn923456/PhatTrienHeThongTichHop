package txtTCP;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class client {
    public final static String serverIP = "127.0.0.1";
    public final static int serverPort = 8888;  
    public static void main(String[] args) throws InterruptedException, IOException{
        Socket s = null;
        Scanner scn = new Scanner(System.in);
        while(true){
        try {
            // System.out.println("Nhap IP:");
            // String serverIP = scn.nextLine();
            // System.out.println("Nhap Port:");
            // int serverPort = scn.nextInt();
            
            s = new Socket (serverIP,serverPort);
            System.out.println("Client da duoc tao");
            while(true){
                Scanner trafile = new Scanner(s.getInputStream());
                InputStream is = s.getInputStream();
                OutputStream os = s.getOutputStream();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                PrintWriter in = new PrintWriter(dos);
                System.out.println("Nhap ten file muon doc: ");
                Scanner sn = new Scanner(System.in);
                String nhap = sn.nextLine();
                dos.writeUTF(nhap);
                String sda = trafile.nextLine();
                while(sda.length() >= 1){
                    String sd = trafile.nextLine();
                        if(sd.equals("null") || sd.length()<1)
                        {
                            break;
                        }
                        
                        // System.out.println(sd);
                        System.out.println(sd);
                             //System.out.println(sd);
                }
                //String tra = dis.readUTF();
                //while(dis.available() >0){
                // while(dis.readUTF().length() > 0){
                //     String tra = dis.readUTF();
                //     //while(tra.equalsIgnoreCase(" ")){
                //         System.out.println(tra);
                //     //}
                // }
            } 
        }
        catch (IOException ie) {
            //TODO: handle exception
            System.out.println("Error : can not create socket");
        }finally{
            if(s != null){
                s.close();
            }
        }
        }
    }
}