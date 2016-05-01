package ru.itis.inform;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Graph graph = new Graph();

        System.out.println("Enter the quantity of vertexes:");
        int count = sc.nextInt();
        for(int i = 0; i < count; i++){
            graph.addVertex();
        }

        System.out.println("Enter the matrix:");
        int[][] array = new int[count][count];
        for (int i = 0; i < count; i++) {
            for(int j = 0; j < count; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        graph.initDMatrix(array);

        System.out.println("Enter the number of vertex:");
        int vertex = sc.nextInt();
        int[] a = graph.runDijkstra(vertex - 1);
        System.out.println(Arrays.toString(a));
    }
}