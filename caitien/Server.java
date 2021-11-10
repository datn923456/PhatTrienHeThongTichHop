package caitien;

import java.rmi.Naming;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String args[]) throws Exception{
        System.err.println("Initializing server: please wait.");

        String number = "";
        if(args.length >0) number = args[0];

        Naming.rebind("//localhost/Sort" + number, new SortListImpl());
        System.err.println("The Sort Server " + number + " is up and running.");
    }
}
