package ru.itis.inform;
public interface Graph {
    void addVertex();
    void addEdge(int A, int B, int h);
    void showGraph();
    void runFloyd();
}
