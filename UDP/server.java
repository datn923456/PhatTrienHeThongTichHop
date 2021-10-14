package UDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class server {
    public final static int serverPort  = 8888;
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(serverPort);
            System.out.println("server create...");
            byte[] buffer = new byte[60000];
            while(true){
                DatagramPacket incoming  = new DatagramPacket(buffer, buffer.length);
                ds.receive(incoming);
                String theString = new String (incoming.getData(),0,incoming.getLength());
                DatagramPacket outsending = new DatagramPacket(theString.getBytes(),incoming.getLength(),incoming.getAddress(),incoming.getPort());
                ds.send(outsending);
            }
        } catch (IOException ie) {
            //TODO: handle exception
            System.out.println(ie);
        }
    }
}
