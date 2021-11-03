package demoRMI;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;

public class client {
    public static void main(String[] args) {
       try {
        Registry reg=LocateRegistry.getRegistry("localhost",6789);
        hellointerface obj=(hellointerface)reg.lookup("Hello");
        System.out.println( obj.printHello());

    } catch (RemoteException | NotBoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
       
    }
    
}