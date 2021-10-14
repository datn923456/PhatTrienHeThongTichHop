package DateUDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
                        LocalTime Time = LocalTime.now();
                        System.out.println(Time);
                        String c1 = String.valueOf(Time);
                        byte[] guidi = c1.getBytes();
                        DatagramPacket outsending = new DatagramPacket(guidi,guidi.length,incoming.getAddress(),incoming.getPort());
                        ds.send(outsending);
                        break;
                    }
                    case "2":{
                        LocalDate date = LocalDate.now();
                        System.out.println(date);
                        String c2 = String.valueOf(date);
                        byte[] guidi = c2.getBytes();
                        DatagramPacket outsending = new DatagramPacket(guidi,guidi.length,incoming.getAddress(),incoming.getPort());
                        ds.send(outsending);
                        break;
                    }
                    case "3":{
                        LocalDateTime datetime = LocalDateTime.now();
                        System.out.println(datetime);
                        String c3 = String.valueOf(datetime);
                        byte[] guidi = c3.getBytes();
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
}
