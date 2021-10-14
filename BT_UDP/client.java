package BT_UDP;

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
                System.out.println("\nMENU:\n1. 2n+1\n2. n(n+1)\n3. 1-2+3-4+5-6...\nNhap cau muon lam vao: ");
                String i = br.readLine();
                byte[] guichon = i.getBytes();
                DatagramPacket guidatachon = new DatagramPacket(guichon, guichon.length,server,serverPort);
                ds.send(guidatachon);
                int chon = Integer.parseInt(i);
                switch(chon){
                    case 1:{
                        System.out.println("Cong thuc la 2n + 1");
                        System.out.println("Nhap n de tinh: ");
                        String n1 = br.readLine();
                        //gửi n đi qua server
                        byte[] gui = n1.getBytes();
                        DatagramPacket guidata = new DatagramPacket(gui, gui.length,server,serverPort);
                        ds.send(guidata);
                        //Trả về kết quả
                        byte[] buffer1 = new byte[60000];
                        DatagramPacket incoming = new DatagramPacket(buffer1, buffer1.length);
                        ds.receive(incoming);
                        String kq = new String(incoming.getData(),0,incoming.getLength());
                        System.out.println("Ket qua la: "+ kq);
                        break;
                    }
                    case 2:{
                        System.out.println("Cong thuc la n*(n + 1)");
                        System.out.println("Nhap n de tinh: ");
                        String n2 = br.readLine();
                        //gửi n đi qua server
                        byte[] gui = n2.getBytes();
                        DatagramPacket guidata = new DatagramPacket(gui, gui.length,server,serverPort);
                        ds.send(guidata);
                        //Trả về kết quả
                        byte[] buffer2 = new byte[60000];
                        DatagramPacket incoming = new DatagramPacket(buffer2, buffer2.length);
                        ds.receive(incoming);
                        String kq = new String(incoming.getData(),0,incoming.getLength());
                        System.out.println("Ket qua la: "+ kq);
                        break;
                    }
                    case 3:{
                        System.out.println("Cong thuc la 1-2+3-4+5....");
                        System.out.println("Nhap n de tinh: ");
                        String n3 = br.readLine();
                        //gửi n đi qua server
                        byte[] gui = n3.getBytes();
                        DatagramPacket guidata = new DatagramPacket(gui, gui.length,server,serverPort);
                        ds.send(guidata);
                        //Trả về kết quả
                        byte[] buffer3 = new byte[60000];
                        DatagramPacket incoming = new DatagramPacket(buffer3, buffer3.length);
                        ds.receive(incoming);
                        String kq = new String(incoming.getData(),0,incoming.getLength());
                        System.out.println("Ket qua la: "+ kq);
                        break;
                    }
                    default:{
                        break;
                    }
                }
                // String theString = br.readLine();
                // byte[] data = theString.getBytes();
                // DatagramPacket dp = new DatagramPacket(data , data.length, server, serverPort);
                // ds.send(dp);
                // byte[] buffer = new byte[60000];
                // DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
                // ds.receive(incoming);
                // System.out.println(new String(incoming.getData(),0,incoming.getLength()));
            }
        } catch (IOException ie) {
            //TODO: handle exception
            System.out.println(ie);
        }
    }
}
