package cachrieng;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class dattuan8impl extends UnicastRemoteObject implements dattuan8interface {

    protected dattuan8impl() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }
    public int[] sort(int data[]) throws RemoteException{
        int n = data.length;
        int temp;
        for(int pass = 0; pass < n-1 ; pass++)
            for(int pair=0; pair < n-pass-1; pair++)
                if(data[pair] < data[pair + 1]){
                    temp = data[pair];
                    data[pair] = data[pair+1];
                    data[pair+1] = temp;
                }
        return data; 
    }
    
}