package SoThanhChu;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.*;
public class RequestProcessing extends Thread{
    Socket channel;
    public RequestProcessing(Socket s) {
        channel = s;
    }
    public void run(){
        try {
            OutputStream os = channel.getOutputStream();
            InputStream is = channel.getInputStream();
            DataInputStream dis = new DataInputStream(channel.getInputStream());
            DataOutputStream dos = new DataOutputStream(channel.getOutputStream());
            while(true){
                String n = dis.readUTF();
                int n1 = is.read();
                dos.writeUTF(n);
                os.write(n1);
                break;
            }
        } catch (IOException ie) {
            //TODO: handle exception
            System.out.println("Request Processing Error: " + ie);
        }
    }
}
