package caitien;

import java.rmi.Naming;
import java.rmi.*;

public class MultiSortClient extends Thread{

    public static void main(String args[]) throws Exception{
        int unsorted1[] = {93,81,95,74}, unsorted2[] = {93,81,95,74};
        int sorted1[], sorted2[], sorted[];
        String host1 = "localhost", host2 = "localhost";
        if(args.length == 2) {host1 = args[0]; host2 = args[1];}
        ISortList ss1 = (ISortList) Naming.lookup("//" + host1 + "/Sort1");
        ISortList ss2 = (ISortList) Naming.lookup("//" + host2 + "/Sort2");
        sorted1 = ss1.sort(unsorted1);
        sorted2 = ss2.sort(unsorted2);
        sorted = new MultiSortClient().merge(sorted1,sorted2);
        System.out.println("Sorted");
        for(int i=0; i<sorted.length; i++)
            System.out.println(sorted[i]);
    }

    public int[] merge(int[] s1, int[] s2) {
            int merged[] = new int[s1.length + s2.length];
            int i1=0, i2=0;
            for(int i=0; i<merged.length; i++)
                if(i1 == s1.length) merged[i] = s2[i2++];
                else if(i2 == s2.length) merged[i] = s1[i1++];
                    else if (s1[i1] > s2[i2]) merged[i] = s1[i1++];
                        else merged[i] = s2[i2++];
            return merged;            
    }

}
