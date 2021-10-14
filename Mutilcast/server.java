package Mutilcast;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
public class server {
    final static String INET_ADDR = "224.0.0.3";
    final static int PORT = 8888;
    public static void main(String[] args) throws UnknownHostException, InterruptedException{
        try (DatagramSocket serverSocket = new DatagramSocket()){
            InetAddress address = InetAddress.getByName(INET_ADDR);
            for(int i=0; i<10; i++){
                String msg = "Sent msg no." + i;
                DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),msg.getBytes().length,address,PORT);
                serverSocket.send(msgPacket);
                System.out.println("Server sent packet with msg: " + msg);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
