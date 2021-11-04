package DatTuan8;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class dattuan8impl extends UnicastRemoteObject implements dattuan8interface {

    protected dattuan8impl() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }
    public String InHoaKyTuDau(String c){
        char[] charArray = c.toCharArray();
        boolean foundSpace = true;
    
        for(int i = 0; i < charArray.length; i++) {
      
            if(Character.isLetter(charArray[i])) {
            
                if(foundSpace) {
            
                charArray[i] = Character.toUpperCase(charArray[i]);
                foundSpace = false;
                }
            }
            else {
                foundSpace = true;
            }
        }
    
        String TraChuoiInHoa = String.valueOf(charArray);
        return TraChuoiInHoa;
    }
    public String daochuoi(String a){
        byte[] strAsByteArray = a.getBytes();
        byte[] result = new byte[strAsByteArray.length];
        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
        String tra = new String(result);
        return tra;
    }
}