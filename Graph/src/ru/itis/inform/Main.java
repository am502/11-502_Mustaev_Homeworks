package ru.itis.inform;
public class Main {

    public static void main(String[] args) {
        Graph graph = new GraphMatrixImpl();

        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();

        graph.addEdge(0, 2, 4);
        graph.addEdge(2, 1, 3);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 9);
        graph.addEdge(1, 4, 3);
        graph.addEdge(0, 1, 5);

        graph.showGraph();

        System.out.println();

        graph.runFloyd();

        System.out.println();

        graph.showGraph();

        System.out.println();

        GraphMatrixImpl graph2 = new GraphMatrixImpl();

        graph2.addVertex();
        graph2.addVertex();
        graph2.addVertex();
        graph2.addVertex();
        graph2.addVertex();

        graph2.addWeightEdge(0, 2, 4);
        graph2.addWeightEdge(2, 1, 3);
        graph2.addWeightEdge(2, 3, 7);
        graph2.addWeightEdge(3, 4, 9);
        graph2.addWeightEdge(1, 4, 3);
        graph2.addWeightEdge(0, 1, 5);

        graph2.showGraph();

        System.out.println();

        graph2.runFloyd();

        System.out.println();

        graph2.showGraph();
    }
}