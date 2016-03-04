package ru.itis.inform;

import static org.junit.Assert.*;

public class GraphMatrixImplTest {

    private GraphMatrixImpl graph;

    @org.junit.Before
    public void setUp() throws Exception {
        this.graph = new GraphMatrixImpl();
    }

    @org.junit.Test
    public void testRunFloyd1() throws Exception {
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

        int[][] actual = graph.runFloyd();

        int[][] expected = {
                {0, 5, 4, 11, 8},
                {5, 0, 3, 10, 3},
                {4, 3, 0, 7, 6},
                {11, 10, 7, 0, 9},
                {8, 3, 6, 9, 0},
        };
        assertEquals(expected, actual);
    }
}