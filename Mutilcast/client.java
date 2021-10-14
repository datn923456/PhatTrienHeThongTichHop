package Mutilcast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
    final static String INET_ADDR = "224.0.0.3";
    final static int PORT = 8888;
    public static void main(String[] args) throws UnknownHostException{
        // Scanner scn = new Scanner(System.in);
        // System.out.println("Nhap IP:");
        // String INET_ADDR = scn.nextLine();
        // System.out.println("Nhap Port");
        // int PORT = scn.nextInt();
        InetAddress address = InetAddress.getByName(INET_ADDR);
        byte[] buff = new byte[256];
        try (MulticastSocket clientSocket = new MulticastSocket(PORT)){
            clientSocket.joinGroup(address);

            while(true){
                DatagramPacket msgPacket = new DatagramPacket(buff,buff.length);
                clientSocket.receive(msgPacket);

                String msg = new String (buff,0,buff.length);
                System.out.println("Socket 1 received msg: " + msg);
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
