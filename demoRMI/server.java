package demoRMI;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class server {
    public static void main(String[] args) {
        try {
            helloimpl obj=new helloimpl();
            System.out.println("Exporting HelloImpl obj");
            LocateRegistry.createRegistry(6789);
            Registry reg= LocateRegistry.getRegistry(6789);
            reg.bind("tuan8", obj);
            System.out.println("HelloObj registry");

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}
