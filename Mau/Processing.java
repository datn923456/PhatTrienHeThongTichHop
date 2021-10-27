package Mau;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

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
                InputStream is=s.getInputStream();
                OutputStream os=s.getOutputStream();
                FileInputStream fis=new FileInputStream("data1.txt");
                String menu="1.IN HOA\n2.Dao nguoc\n0.Thoat";
                os.write(menu.getBytes());
                int yc=is.read();
                byte[] b=new byte[2048];
                int c=fis.read(b);
                String kq=new String(b,0,c);
                switch (yc) {
                    case 1:
                        String s= kq.toUpperCase();
                        os.write(s.getBytes());
                            
                        break;
                    case 2:
                        String s1=kq;
                        byte[] strAsByteArray = s1.getBytes();
                        byte[] result = new byte[strAsByteArray.length];
                        for (int i = 0; i < strAsByteArray.length; i++)
                        {
                            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
                        }
                        String s2=new String(result);
                        os.write(s2.getBytes());  
                        break;
                    
                    default:os.write(0);
                        break;
                }
                
            } catch (Exception e) {
                //TODO: handle exception
            }
           

        }
        
    }
     
    
}
