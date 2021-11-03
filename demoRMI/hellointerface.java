package demoRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface hellointerface extends Remote{
    String printHello() throws RemoteException;
}
