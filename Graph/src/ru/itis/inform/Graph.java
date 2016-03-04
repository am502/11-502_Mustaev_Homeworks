package ru.itis.inform;
public interface Graph {
    void addVertex();
    void addEdge(int vertexA, int vertexB, int h);
    int[][] runFloyd();
    void showGraph();
}