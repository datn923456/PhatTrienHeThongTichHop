package DateTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;
import java.io.*;
public class server {
    public final static int serverPort = 8888 ;
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(serverPort);
            System.out.println("Server da duoc tao");
            while (true){
                try {
                    Socket s = ss.accept();
                    RequestProcessing rp = new RequestProcessing(s);
                    OutputStream os = s.getOutputStream();
                    InputStream is = s.getInputStream();
                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                    int n = is.read();
                    switch(n){
                        case 1:{
                            LocalTime Time = LocalTime.now();
                            System.out.println(Time);
                            String c1 = String.valueOf(Time);
                            dos.writeUTF(c1);
                            break;
                        }
                        case 2:{
                            LocalDate date = LocalDate.now();
                            System.out.println(date);
                            String c2 = String.valueOf(date);
                            dos.writeUTF(c2);
                            break;
                        }
                        case 3:{
                            LocalDateTime datetime = LocalDateTime.now();
                            System.out.println(datetime);
                            String c3 = String.valueOf(datetime);
                            dos.writeUTF(c3);
                            break;
                        }
                    }
                    os.write(n);
                    rp.start();
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