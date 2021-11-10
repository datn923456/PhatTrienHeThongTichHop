package cachrieng;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.DatagramSocket;
import java.net.Socket;
import java.rmi.registry.Registry;

public class Processing extends Thread{
    private Socket s;
    public  Processing(Socket s) {
        this.s=s;
    }
    public Processing(Registry reg) {

    }
    @Override
    public void run(){
        while(true){
            try {
                DatagramSocket ds = new DatagramSocket(1111);
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                
                String chuoi1 = dis.readUTF();
                String chuoi2 = dis.readUTF();

                int c1 = Integer.parseInt(chuoi1);
                int c2 = Integer.parseInt(chuoi2);
                // int a1[] = c1;
                // merge(c1, c2);
                String sss = String.valueOf(c1);
                dos.writeUTF(sss);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
    public int[] merge(int[] s1, int[] s2) {
        int merged[] = new int[s1.length + s2.length];
        int i1=0, i2=0;
        for(int i=0; i<merged.length; i++)
            if(i1 == s1.length) merged[i] = s2[i2++];
            else if(i2 == s2.length) merged[i] = s1[i1++];
                else if (s1[i1] > s2[i2]) merged[i] = s1[i1++];
                    else merged[i] = s2[i2++];
        return merged;            
}

}
