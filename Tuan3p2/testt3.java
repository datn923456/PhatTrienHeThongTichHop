package Tuan3p2;

import java.io.*;

public class testt3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run() {
                Tuan3p2.printTable(10);
            }
        };
        Thread t2 = new Thread(){
            public void run() {
                Tuan3p2.printTable(10);
            }
        };
        Thread t3 = new Thread(){
            public void run() {
                Tuan3p2.printTable(100);
            }
        };
        Thread t4 = new Thread(){
            public void run() {
                Tuan3p2.printTable(1000);
            }
        };
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
