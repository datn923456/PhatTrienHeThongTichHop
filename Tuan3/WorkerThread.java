package Tuan3;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;


public class WorkerThread implements Runnable{
    private String message;

    public WorkerThread(String s){
        this.message = s;
    }

    public void run(){
        System.out.println( Thread.currentThread().getName() + "(start) message = " + message);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "(End)");
    }

}
