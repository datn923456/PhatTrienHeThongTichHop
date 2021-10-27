package baithi;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.net.Socket;
import java.util.Scanner;

public class Processing extends Thread{
    private Socket s;
    public  Processing(Socket s) {
        this.s=s;
    }
    @Override
    public void run() {
        while(true)
        {
            try {
                DatagramSocket ds = new DatagramSocket(1111);
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                String client1 = "D:\\txt\\client1.txt";
                String client2 = "D:\\txt\\client2.txt";
                
                String nhan = dis.readUTF();
                
                switch(nhan){
                    case "client1":{
                        String nhans = dis.readUTF();
                        String nhanst[] = nhans.split(" "); 
                        int Tong = 0;
                        for (String s : nhanst) {
                            
                            Tong += Integer.parseInt(s);
                        }
                        //nhan
                        //String nhandulieu = dis.readUTF();
                        //viet file
                        System.out.println(Tong);
                        FileWriter fw = new FileWriter(client1,true); //có true là không có xóa dữ liệu cũ trong file txt rồi ghi vào
                        //FileWriter fw = new FileWriter(alo); //không true xóa dữ liệu cũ trong file txt rồi ghi vào
                        BufferedWriter bw = new BufferedWriter(fw);
                        String saa = String.valueOf(Tong);                    
                        bw.write(saa);
                        bw.close(); // đóng bw
                        fw.close(); // đóng fw
                        String phanhoi = new String();
                        phanhoi = "\nKet qua la: " + saa;
                        dos.writeUTF(phanhoi);
                        break;
                    }
                    case "client2":{
                        String nhans = dis.readUTF();
                        String nhanst[] = nhans.split(" "); 
                        int Tong2 = 0;
                        for (String s : nhanst) {
                            
                            Tong2 += Integer.parseInt(s);
                        }
                        //nhan
                        System.out.println(Tong2);
                        //viet file
                        FileWriter fw = new FileWriter(client2,true); //có true là không có xóa dữ liệu cũ trong file txt rồi ghi vào
                        //FileWriter fw = new FileWriter(txt2); //không true xóa dữ liệu cũ trong file txt rồi ghi vào
                        BufferedWriter bw = new BufferedWriter(fw); 
                        String saa2 = String.valueOf(Tong2);
                        bw.write(saa2);
                        bw.close(); // đóng bw
                        fw.close(); // đóng fw
                        String phanhoi = new String();
                        phanhoi = "\nKet qua la: " + saa2;
                        dos.writeUTF(phanhoi);
                        break;
                    }
                    default:{
                        break;
                    }
                }
            } catch (Exception e) {
                //TODO: handle exception
            }
            
        }
    }
}
