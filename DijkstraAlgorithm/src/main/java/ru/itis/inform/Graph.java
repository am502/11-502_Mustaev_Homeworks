package ru.itis.inform;

import java.util.Arrays;

public class Graph {

    private static final int DEFAULT_SIZE = 50;
    private static final int INF = 999;

    private int matrix[][];
    private int dmatrix[][];
    private int verticesCount;
    private int maxSize;

    public Graph() {
        initGraph(DEFAULT_SIZE);
    }

    public Graph(int maxSize) {
        initGraph(maxSize);
    }

    private void initGraph(int maxSize) {
        this.maxSize = maxSize;
        this.verticesCount = 0;
        this.matrix = new int[maxSize][maxSize];
    }

    public void addVertex() {
        if (this.verticesCount < this.maxSize) {
            this.verticesCount++;
        } else throw new IllegalArgumentException();
    }

    public void addEdge(int vertexA, int vertexB, int weightEdge) {
        if (vertexA < verticesCount && vertexB < verticesCount && this.matrix[vertexA][vertexB] == 0) {
            this.matrix[vertexA][vertexB] = weightEdge;
            this.matrix[vertexB][vertexA] = weightEdge;
        } else throw new IllegalArgumentException();
    }

    public void addDirectedEgde(int vertexFrom, int vertexTo, int weightEdge) {
        if (vertexFrom < verticesCount && vertexTo < verticesCount && this.dmatrix[vertexFrom][vertexTo] == 0) {
            this.dmatrix[vertexFrom][vertexTo] = weightEdge;
        }
    }

    public void runFloyd(){
        for (int k = 0; k < verticesCount; k++) {
            for (int i = 0; i < verticesCount; i++) {
                for (int j = 0; j < verticesCount; j++) {
                    dmatrix[i][j] = Math.min(dmatrix[i][j], dmatrix[i][k] + dmatrix[k][j]);
                }
            }
        }
    }

    public int[] runDijkstra(int number) {
        int[] dist = new int[verticesCount];
        int[] used = new int[verticesCount];
        used[number] = 1;
        for (int i = 0; i < verticesCount; i++) {
            dist[i] = INF;
        }
        dist[number] = 0;
        int count = 0;
        int g = 0;
        int ch = number;
        while(count != verticesCount - 1) {
            int min = INF;
            for (int i = 0; i < verticesCount; i++) {
                if (used[i] != 1) {
                    if(g + dmatrix[number][i] < dist[i])
                        dist[i] = g + dmatrix[number][i];
                    if (dist[i] < min) {
                        min = dist[i];
                        ch = i;
                    }
                }
            }
            number = ch;
            used[number] = 1;
            g = min;
            count++;
        }
        return dist;
    }

    public void showMatrix() {
        for (int i = 0; i < verticesCount; i++) {
            for (int j = 0; j < verticesCount - 1; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(matrix[i][verticesCount - 1]);
        }
    }

    public void showDMatrix() {
        for (int i = 0; i < verticesCount; i++) {
            for (int j = 0; j < verticesCount - 1; j++) {
                System.out.print(dmatrix[i][j] + " ");
            }
            System.out.println(dmatrix[i][verticesCount - 1]);
        }
    }

    public void initMatrix(int[][] array){
        this.matrix = array;
    }

    public void initDMatrix(int[][] array){
        this.dmatrix = array;
        for(int i = 0; i < verticesCount; i++){
            for(int j = 0; j < verticesCount; j++){
                if(dmatrix[i][j] == 0 && i != j)
                    dmatrix[i][j] = INF;
            }
        }
    }
}