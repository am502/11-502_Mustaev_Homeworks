package ru.itis.inform;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        RadixSort radix = new RadixSort();
        ReaderWriter rw = new ReaderWriter();
        ArrayList<Integer> count = new ArrayList<Integer>();
        ArrayList<Double> timer = new ArrayList<Double>();
        int countOfI[] = new int[20];
        double timerArray[] = new double[20];
        rw.write();
        int k = 100;
        timer.add(0.0);
        count.add(0);

        for(int i = 1; i <= 20; i++){
            int a[] = new int[k];
            a = rw.read(a, i);
            radix.sort(a, count, timer);
            k += 100;

            countOfI[i - 1] = count.get(0);
            timerArray[i - 1] = timer.get(0);
        }

        System.out.println(Arrays.toString(countOfI));
        System.out.println(Arrays.toString(timerArray));

        rw.clear();
    }
}
