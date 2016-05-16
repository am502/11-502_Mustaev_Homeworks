package ru.itis.inform;

import java.util.*;

public class SetsArrayImpl implements Sets {
    private int[] sets;
    private ArrayList<Pair> pairs;

    public SetsArrayImpl(int n){
        sets = new int[n + 1];
        pairs = new ArrayList<Pair>();
        for (int i = 0; i <= n; i++) {
            sets[i] = i;
        }
    }

    public int findSets(int element){
        return sets[element];
    }

    public void unionBySetsNames(int setA, int setB){
        for (int i = 0; i < sets.length; i++) {
            if(sets[i] == setA)
                sets[i] = setB;
        }
    }

    public void add(int vertexA, int vertexB) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        if (sets[vertexA] != sets[vertexB]) {
            unionBySetsNames(sets[vertexA], sets[vertexB]);
            pairs.add(new Pair(vertexA, vertexB));
        }
        else {
            int x = vertexA;
            array.add(x);
            while(x != vertexB) {
                for (int i = 0; i < pairs.size(); i++) {
                    if (x == pairs.get(i).getA()) {
                        x = pairs.get(i).getB();
                        checkForD(array, x);
                        array.add(x);
                    }
                    else if(x == pairs.get(i).getB()){
                        x = pairs.get(i).getA();
                        checkForD(array, x);
                        array.add(x);
                    }
                }
            }
            pairs.add(new Pair(array));
        }
    }

    public void show(){
        for (int i = 0; i < pairs.size(); i++) {
            System.out.println(pairs.get(i).toString());
        }
    }

    private void checkForD(ArrayList<Integer> array, int x){
        int size = array.size();
        for (int i = 0; i < array.size(); i++) {
            if(array.get(i) == x){
                int c = Math.abs(size - i);
                while(c != 0){
                    array.remove(i);
                    c--;
                }
            }
        }
    }
}
