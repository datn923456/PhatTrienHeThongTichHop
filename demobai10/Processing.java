package demobai10;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
        try {

           
            InputStream is= s.getInputStream();
            byte[] m=new byte[100];
            int c=is.read(m);
            String nameFile=new String(m,0,c);
            FileOutputStream fos=new FileOutputStream(nameFile);
            while(true)
            {

                try {
                    
                    
                    is=s.getInputStream();
                    DataOutputStream dos=new DataOutputStream(fos);
                    OutputStream os=s.getOutputStream();
                    int num=is.available();
                    if(num>0)
                    {
                        byte[] b= new byte[num];
                        int ch=is.read(b);
                        String s= new String(b,0,ch);
                        System.out.println(s);
                        dos.writeBytes(s);
                        os.write(0);
                    }
 
                    
                } catch (Exception e) {
                    //TODO: handle exception
                }
                
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }
    
}
