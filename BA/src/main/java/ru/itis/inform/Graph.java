package ru.itis.inform;

import java.util.*;

public class Graph {
    Random rand = new Random();
    private static final int DEFAULT_SIZE = 100;
    private int[] ArrayOfDegree = new int[DEFAULT_SIZE];
    private int[][] matrix;
    private int count;
    private int degree;

    public Graph(){
        this.matrix = new int[DEFAULT_SIZE][DEFAULT_SIZE];
        matrix[0][1] = 1;
        matrix[1][0] = 1;
        this.ArrayOfDegree[0] = 1;
        this.ArrayOfDegree[1] = 1;
        this.count = 2;
        this.degree = 2;
    }

    public void addVertex(){
        for (int i = 0; i < count; i++) {
            int rd = rand.nextInt(101);
            if(rd <= probability(ArrayOfDegree[i])){
                degree += 2;
                ArrayOfDegree[i]++;
                ArrayOfDegree[count]++;
                matrix[i][count] = 1;
                matrix[count][i] = 1;
            }
        }
        count++;
    }

    private int probability(int k){
        return (k * 100) / degree;
    }

    public void show(){
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
