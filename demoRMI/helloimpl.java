package demoRMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class helloimpl extends UnicastRemoteObject  implements hellointerface{

    protected helloimpl() throws RemoteException {
        super();
        //TODO Auto-generated constructor stub
    }

    @Override
    public String printHello() throws RemoteException {
       return String.format("Hello Tan Hung");
    }

}
