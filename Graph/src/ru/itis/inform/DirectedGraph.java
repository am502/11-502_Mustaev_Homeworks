package ru.itis.inform;
public interface DirectedGraph {
    void addVertex();
    void addWeightEdge(int vertexA, int vertexB, int h);
    int[][] runFloyd();
    void showGraph();
}
