package ru.itis.inform;

import java.util.*;

public class SetArrayWithLinksImpl {
    private int[] sets;

    public SetArrayWithLinksImpl(int n) {
        sets = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            sets[i] = i;
        }
    }

    public int find(int element) {
        while(sets[element] != element){
            element = sets[element];
        }
        return element;
    }

    public void union(int vertexA, int vertexB) {
        if(find(vertexA) != find(vertexB)){
            sets[find(vertexA)] = vertexB;
        }
    }

    public void showSet(){
        System.out.println(Arrays.toString(sets));
    }
}