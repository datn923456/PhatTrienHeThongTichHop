package DateUDP;

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
                System.out.println("\n1.In Time\n2.In Date\n3.Date & Time\n");
                System.out.println("Chon chuc nang:");
                String i = br.readLine();
                byte[] guichon = i.getBytes();
                DatagramPacket guidatachon = new DatagramPacket(guichon, guichon.length,server,serverPort);
                ds.send(guidatachon);
                int chon = Integer.parseInt(i);
                switch(chon){
                    case 1:{
                        //Trả về kết quả
                        byte[] buffer1 = new byte[60000];
                        DatagramPacket incoming = new DatagramPacket(buffer1, buffer1.length);
                        ds.receive(incoming);
                        String kq = new String(incoming.getData(),0,incoming.getLength());
                        System.out.println("Thoi gian (Time) la:  "+ kq);
                        break;
                    }
                    case 2:{
                        //Trả về kết quả
                        byte[] buffer2 = new byte[60000];
                        DatagramPacket incoming = new DatagramPacket(buffer2, buffer2.length);
                        ds.receive(incoming);
                        String kq = new String(incoming.getData(),0,incoming.getLength());
                        System.out.println("Ngay (Date) la: "+ kq);
                        break;
                    }
                    case 3:{
                        //Trả về kết quả
                        byte[] buffer3 = new byte[60000];
                        DatagramPacket incoming = new DatagramPacket(buffer3, buffer3.length);
                        ds.receive(incoming);
                        String kq = new String(incoming.getData(),0,incoming.getLength());
                        System.out.println("Ngay va Gio (Date & Time) la: "+ kq);
                        break;
                    }
                    default:{
                        break;
                    }
                }
            }
        } catch (IOException ie) {
            //TODO: handle exception
            System.out.println(ie);
        }
    }
}
