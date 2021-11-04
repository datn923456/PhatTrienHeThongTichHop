package demoRMI;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;

public class client {
    public static void main(String[] args) throws NotBoundException{
       try {
        Registry reg=LocateRegistry.getRegistry(6789);
        hellointerface obj=(hellointerface)reg.lookup("tuan8");
        System.out.println( obj.printHello());

    } catch (RemoteException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
       
    }
    
}