package DateTCP;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class client {
    public final static String serverIP = "127.0.0.1";
    public final static int serverPort = 8888;  
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
                System.out.println("1.In Time\n2.In Date\n3.In Date & Time\n");
                Scanner sn = new Scanner(System.in);
                int nhap = sn.nextInt();
                os.write(nhap);
                //trả về
                switch(nhap){
                    case 1:{
                        String c1 = dis.readUTF();
                        System.out.println("Thoi gian(Time) la: "+c1);
                        break;
                    }
                    case 2:{
                        String c2 = dis.readUTF();
                        System.out.println("Ngay(Date) la: "+c2);
                        break;
                    }
                    case 3:{
                        String c3 = dis.readUTF();
                        System.out.println("Ngay & Gio (Date & Time) la: "+c3);
                        break;
                    }
                }
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