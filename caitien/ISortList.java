package caitien;
import java.rmi.*;

public interface ISortList extends Remote{
    public int[] sort(int data[]) throws RemoteException;
}
