package txtTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.*;
import java.net.Socket;
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
                //int n = is.read();
                if(n == null ) break;
                dos.writeUTF(n);
            }
        } catch (IOException ie) {
            //TODO: handle exception
            System.out.println("Request Processing Error: " + ie);
        }
    }
}
