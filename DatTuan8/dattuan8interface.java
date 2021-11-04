package DatTuan8;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface dattuan8interface extends Remote {
    public String daochuoi(String dao) throws RemoteException;

    public String InHoaKyTuDau(String dao) throws RemoteException;

}