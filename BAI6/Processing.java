package BAI6;

import java.net.Socket;
import java.io.*;

public class Processing extends Thread{
    private Socket s;
    public  Processing(Socket s) {
        this.s=s;
    }

    public void run() {
        try {
            DataInputStream dis=new DataInputStream(s.getInputStream());
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            while(true)
            {
            String yc,n;
            yc=dis.readLine();
            n=dis.readLine();
            int a=Integer.parseInt(yc);
            int b=Integer.parseInt(n);
            int kq=0;
            String chuoikq;
            switch (a) {
                case 1: kq=b*b;
                    
                    break;
                case 2: 
                    for(int i = 1; i <= b; i++) 
                    {
                        int sum=0;
                        kq += 1.0*i/(i + 1);
                        // kq=sum;
                    } break;

                
                case 3:
                
                    for (int i = 1; i <= b; i++) {
                        if(i%2==0)
                        {
                            kq-=i;
                        }
                        else
                        {
                            kq+=i;
                        }
                    }
                    break;
                
                
                default:dos.writeBytes("Chuoi khong hop le");
                    break;
            }
            chuoikq=String.valueOf(kq);
            dos.writeBytes(chuoikq+'\n');
            }
            
            

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}
