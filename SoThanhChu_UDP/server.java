package SoThanhChu_UDP;

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
                    case "0":{
                        System.out.println("Cho nguoi dung nhap so");
                        System.out.println("Nguoi dung da nhap so: " + theString);
                        String s = "Khong";
                        byte[] guidi = s.getBytes();
                        DatagramPacket outsending = new DatagramPacket(guidi,guidi.length,incoming.getAddress(),incoming.getPort());
                        ds.send(outsending);
                        break;
                    }
                    case "1":{
                        System.out.println("Cho nguoi dung nhap so");
                        System.out.println("Nguoi dung da nhap so: " + theString);
                        String s = "Mot";
                        byte[] guidi = s.getBytes();
                        DatagramPacket outsending = new DatagramPacket(guidi,guidi.length,incoming.getAddress(),incoming.getPort());
                        ds.send(outsending);
                        break;
                    }
                    case "2":{
                        System.out.println("Cho nguoi dung nhap so");
                        System.out.println("Nguoi dung da nhap so: " + theString);
                        String s = "Hai";
                        byte[] guidi = s.getBytes();
                        DatagramPacket outsending = new DatagramPacket(guidi,guidi.length,incoming.getAddress(),incoming.getPort());
                        ds.send(outsending);
                        break;
                    }
                    case "3":{
                        System.out.println("Cho nguoi dung nhap so");
                        System.out.println("Nguoi dung da nhap so: " + theString);
                        String s = "Ba";
                        byte[] guidi = s.getBytes();
                        DatagramPacket outsending = new DatagramPacket(guidi,guidi.length,incoming.getAddress(),incoming.getPort());
                        ds.send(outsending);
                        break;
                    }
                    case "4":{
                        System.out.println("Cho nguoi dung nhap so");
                        System.out.println("Nguoi dung da nhap so: " + theString);
                        String s = "Bon";
                        byte[] guidi = s.getBytes();
                        DatagramPacket outsending = new DatagramPacket(guidi,guidi.length,incoming.getAddress(),incoming.getPort());
                        ds.send(outsending);
                        break;
                    }
                    case "5":{
                        System.out.println("Cho nguoi dung nhap so");
                        System.out.println("Nguoi dung da nhap so: " + theString);
                        String s = "Nam";
                        byte[] guidi = s.getBytes();
                        DatagramPacket outsending = new DatagramPacket(guidi,guidi.length,incoming.getAddress(),incoming.getPort());
                        ds.send(outsending);
                        break;
                    }
                    case "6":{
                        System.out.println("Cho nguoi dung nhap so");
                        System.out.println("Nguoi dung da nhap so: " + theString);
                        String s = "Sau";
                        byte[] guidi = s.getBytes();
                        DatagramPacket outsending = new DatagramPacket(guidi,guidi.length,incoming.getAddress(),incoming.getPort());
                        ds.send(outsending);
                        break;
                    }
                    case "7":{
                        System.out.println("Cho nguoi dung nhap so");
                        System.out.println("Nguoi dung da nhap so: " + theString);
                        String s = "Bay";
                        byte[] guidi = s.getBytes();
                        DatagramPacket outsending = new DatagramPacket(guidi,guidi.length,incoming.getAddress(),incoming.getPort());
                        ds.send(outsending);
                        break;
                    }
                    case "8":{
                        System.out.println("Cho nguoi dung nhap so");
                        System.out.println("Nguoi dung da nhap so: " + theString);
                        String s = "Tam";
                        byte[] guidi = s.getBytes();
                        DatagramPacket outsending = new DatagramPacket(guidi,guidi.length,incoming.getAddress(),incoming.getPort());
                        ds.send(outsending);
                        break;
                    }
                    case "9":{
                        System.out.println("Cho nguoi dung nhap so");
                        System.out.println("Nguoi dung da nhap so: " + theString);
                        String s = "Chin";
                        byte[] guidi = s.getBytes();
                        DatagramPacket outsending = new DatagramPacket(guidi,guidi.length,incoming.getAddress(),incoming.getPort());
                        ds.send(outsending);
                        break;
                    }
                    default:{
                        System.out.println("Cho nguoi dung nhap so");
                        System.out.println("Nguoi dung da nhap so: " + theString);
                        String s = "Khong phai so nguyen";
                        byte[] guidi = s.getBytes();
                        DatagramPacket outsending = new DatagramPacket(guidi,guidi.length,incoming.getAddress(),incoming.getPort());
                        ds.send(outsending);
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
