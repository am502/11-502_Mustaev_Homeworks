package ru.itis.inform;

import java.util.ArrayList;

public class Pair {
    private int a;
    private int b;
    private ArrayList<Integer> array = new ArrayList<Integer>();

    public Pair(int a, int b){
        this.a = a;
        this.b = b;
    }

    public Pair(ArrayList<Integer> array){
        this.array = array;
    }

    public int getB() {
        return b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString(){
        if(array.isEmpty())
            return a + " " + b;
        else {
            String s = array.get(0) + " -> ";
            for (int i = 1; i < array.size() - 1; i++) {
                s += array.get(i) + " -> ";
            }
            s += array.get(array.size() - 1);
            return s;
        }

    }
}
