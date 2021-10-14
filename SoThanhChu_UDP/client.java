package SoThanhChu_UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class client {
    public final static int serverPort = 7 ;
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            InetAddress server = InetAddress.getByName("localhost");
            while(true){
                InputStreamReader isr  = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                System.out.println("Nhap so bat ky tu 0-9");
                String i = br.readLine();
                byte[] guichon = i.getBytes();
                DatagramPacket guidatachon = new DatagramPacket(guichon, guichon.length,server,serverPort);
                //gửi đi
                ds.send(guidatachon);
                //Trả về
                byte[] buffer1 = new byte[60000];
                DatagramPacket incoming = new DatagramPacket(buffer1, buffer1.length);
                ds.receive(incoming);
                String kq = new String(incoming.getData(),0,incoming.getLength());
                System.out.println("Nhan ve la: "+ kq);
            }
        } catch (IOException ie) {
            System.out.println(ie);
        }
    }
}
