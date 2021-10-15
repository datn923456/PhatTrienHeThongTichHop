package txtTCP;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

public class server {
    public final static int serverPort = 8888 ;
    public static void main(String[] args) throws InterruptedException {
        try {
            ServerSocket ss = new ServerSocket(serverPort);
            System.out.println("Server da duoc tao");
            while (true)
            {
                try 
                {
                    Socket s = ss.accept();
                    System.out.println("client da ket noi");
                    System.out.println("Cho nguoi dung nhap ten file");
                    while(true)
                    {
                        RequestProcessing rp = new RequestProcessing(s);
                        //OutputStream os = s.getOutputStream();
                        //InputStream is = s.getInputStream();
                        DataInputStream dis = new DataInputStream(s.getInputStream());
                        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                        String txt1 = "D:\\txt\\txt1.txt";
                        String txt2 = "D:\\txt\\txt2.txt";
                        Scanner scn = new Scanner(s.getInputStream());
                        PrintStream in = new PrintStream(s.getOutputStream());
                        String nhan = dis.readUTF();
                        
                        System.out.println("ok");
                        if(nhan.equals("txt1"))
                        {
                            FileReader fr = new FileReader(txt1);
                            BufferedReader br = new BufferedReader(fr);
                            String line ="";
                            while(true){
                                line = br.readLine();
                                if(line == null){
                                    break;
                                }
                                System.out.println(line);
                                String tra = String.valueOf(line);  
                                
                                //dos.writeUTF(line);                 
                                in.println(tra);
                            }
                            br.close();
                        }
                        //os.write(n);
                        rp.start();
                    }
                } catch (IOException ie1) {
                    //TODO: handle exception
                    System.out.println("Connection Error: "+ ie1);
                }

            }
        } catch (IOException ie) {
            //TODO: handle exception
            System.out.println("Connection Error: "+ ie);
        }
    }
}