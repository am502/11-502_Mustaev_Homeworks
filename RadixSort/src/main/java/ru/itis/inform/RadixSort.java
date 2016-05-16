package ru.itis.inform;

import java.util.*;

public class RadixSort {
    public void sort(int[] a, ArrayList<Integer> count, ArrayList<Double> timer) {
        int w = maxDigit(a);
        int r = 10;
        int check = 0;

        ArrayList<Integer>[] basket = new ArrayList[r];
        for (int i = 0; i < r; i++)
            basket[i] = new ArrayList<Integer>();

        double start = System.nanoTime();

        for(int i = 0; i < w; i++){
            for(int j = 0; j < a.length; j++){
                basket[digit(a[j], i)].add(a[j]);
            }

            int k = 0;
            for (int b = 0; b < r; b++) {
                for (int p = 0; p < basket[b].size(); p++) {
                    a[k++] = basket[b].get(p);
                    check++;
                }
                basket[b].clear();
            }
        }

        double end = System.nanoTime();

        timer.set(0, (end - start)/1000000);
        count.set(0, check);
    }

    private int maxDigit(int[] a) {
        int max = 0;

        for (int i = 0; i < a.length; i++) {
            int number = a[i];
            int count = (number == 0) ? 1 : 0;
            while (number != 0) {
                count++;
                number /= 10;
            }

            if (count > max) {
                max = count;
            }
        }

        return max;
    }

    private int digit(int a, int i){
        ArrayList<Integer> array = new ArrayList<Integer>();

        while (a != 0) {
            array.add(a%10);
            a /= 10;
        }
        if(i >= array.size())
            return 0;
        else
            return array.get(i);
    }
}