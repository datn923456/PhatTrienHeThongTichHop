package SoThanhChu;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class client {
    public final static String serverIP = "127.0.0.1";
    public final static int serverPort = 7;  
    public static void main(String[] args) throws InterruptedException, IOException{
        Socket s = null;
        try {
            s = new Socket (serverIP,serverPort);
            System.out.println("Client da duoc tao");
            while(true){
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            Scanner sn = new Scanner(System.in);
            System.out.println("Nhap vao so tu 0-9");
            int sa = sn.nextInt();
            os.write(sa);
            String ch = dis.readUTF();
            System.out.println(ch);
            }
        } catch (IOException ie) {
            //TODO: handle exception
            System.out.println("Error : can not create socket");
        }finally{
            if(s != null){
                s.close();
            }
        }
    }
}
