package BT_UDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class server {
    public final static int serverPort  = 7;
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(serverPort);
            System.out.println("server create...");
            byte[] buffer = new byte[60000];
            while(true){
                DatagramPacket incoming  = new DatagramPacket(buffer, buffer.length);
                ds.receive(incoming);
                String theString = new String (incoming.getData(),0,incoming.getLength());
                switch(theString){
                    case "1":{
                        System.out.println("Cho nguoi dung nhap n");
                        //Nhận n từ client kiểu string
                        ds.receive(incoming);
                        String n1 = new String (incoming.getData(),0,incoming.getLength());
                        int n = Integer.parseInt(n1);//ép kiểu để tính 
                        System.out.println("nguoi dung nhap n la : "+ n);
                        tinhc1(n);
                        String s = String.valueOf(tinhc1(n));
                        System.out.println("Ket qua la: "+ s);
                        byte[] guidi = s.getBytes();
                        DatagramPacket outsending = new DatagramPacket(guidi,guidi.length,incoming.getAddress(),incoming.getPort());
                        ds.send(outsending);
                        break;
                    }
                    case "2":{
                        System.out.println("Cho nguoi dung nhap n");
                        //Nhận n từ client kiểu string
                        ds.receive(incoming);
                        String n1 = new String (incoming.getData(),0,incoming.getLength());
                        int n = Integer.parseInt(n1);//ép kiểu để tính 
                        System.out.println("nguoi dung nhap n la : "+ n);
                        tinhc2(n);
                        String s = String.valueOf(tinhc2(n));
                        System.out.println("Ket qua la: "+ s);
                        byte[] guidi = s.getBytes();
                        DatagramPacket outsending = new DatagramPacket(guidi,guidi.length,incoming.getAddress(),incoming.getPort());
                        ds.send(outsending);
                        break;
                    }
                    case "3":{
                        System.out.println("Cho nguoi dung nhap n");
                        //Nhận n từ client kiểu string
                        ds.receive(incoming);
                        String n1 = new String (incoming.getData(),0,incoming.getLength());
                        int n = Integer.parseInt(n1);//ép kiểu để tính 
                        System.out.println("nguoi dung nhap n la : "+ n);
                        tinhc3(n);
                        String s = String.valueOf(tinhc3(n));
                        System.out.println("Ket qua la: "+ s);
                        byte[] guidi = s.getBytes();
                        DatagramPacket outsending = new DatagramPacket(guidi,guidi.length,incoming.getAddress(),incoming.getPort());
                        ds.send(outsending);
                        break;
                    }
                    default:{
                        break;
                    }
                }
                // DatagramPacket outsending = new DatagramPacket(theString.getBytes(),incoming.getLength(),incoming.getAddress(),incoming.getPort());
                // ds.send(outsending);
            }
        } catch (IOException ie) {
            //TODO: handle exception
            System.out.println(ie);
        }
    }
    public static int tinhc1(int n){
        int tong1=0;
        for(int i=0; i<=n;i++){
            tong1 += (2*i+1);
        }
        return tong1;
    }
    public static int tinhc3(int n){
        int tong3=0;
        for(int i=1; i<=n+1;i++){
            if(i%2 == 0){
                tong3 -= i;
            }else{
                tong3 += i;
            }
        }
        return tong3;
    }
    public static int tinhc2(int n){
        int tong2=0;
        for(int i=1; i<=n;i++){
            tong2 += (i*(i+1));
        }
        return tong2;
    }
}
