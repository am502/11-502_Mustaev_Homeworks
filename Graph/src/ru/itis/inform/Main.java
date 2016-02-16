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

        graph.showGraph();
    }
}