package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
public class RequestProcessing extends Thread{
    Socket s;
    public RequestProcessing(Socket s) {
        this.s = s;
    }
    @Override
    public void run(){
        while(true)
        {
            try {             
                //RequestProcessing rp = new RequestProcessing(s);
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                Scanner sn = new Scanner(System.in);
                while(true){
                    System.out.println("CLIENT: " +dis.readUTF());
                    
                    System.out.println("nhap de chat");
                    String chata = sn.nextLine();
                    dos.writeUTF(chata);
                    
                }
                // os.write(n);
        } catch (IOException ie) {
            //TODO: handle exception
            System.out.println("Request Processing Error: " + ie);
        }
    }
    }
}
