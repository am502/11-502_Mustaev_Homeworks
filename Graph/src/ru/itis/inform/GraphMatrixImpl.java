package ru.itis.inform;
public class GraphMatrixImpl implements Graph, DirectedGraph {
    private static final int DEFAULT = 50;
    private static final int infinity = 1000;
    private int matrix[][];
    private int verticesCount;
    private int maxSize;

    public GraphMatrixImpl() {
        initGraph(DEFAULT);
    }

    public GraphMatrixImpl(int maxSize) {
        initGraph(maxSize);
    }

    private void initGraph(int maxSize) {
        this.maxSize = maxSize;
        this.verticesCount = 0;
        this.matrix = new int[maxSize][maxSize];
    }

    @Override
    public void addVertex() {
        if (this.verticesCount < this.maxSize) {
            this.verticesCount++;
        } else throw new IllegalArgumentException();
    }

    @Override
    public void addEdge(int A, int B, int h) {
        if (A < verticesCount && B < verticesCount) {
            this.matrix[A][B] = h;
            this.matrix[B][A] = h;
            for (int i = 0; i < verticesCount; i++) {
                for (int j = 0; j < verticesCount; j++) {
                    if (matrix[i][j] == 0)
                        this.matrix[i][j] = infinity;
                    if (i == j)
                        this.matrix[i][j] = 0;
                }
            }
        } else throw new IllegalArgumentException();
    }
    @Override
    public void addWeightEdge(int vertexA, int vertexB, int h) {
        if (vertexA < verticesCount && vertexB < verticesCount) {
            this.matrix[vertexA][vertexB] = h;
            for (int i = 0; i < verticesCount; i++) {
                for (int j = 0; j < verticesCount; j++) {
                    if (matrix[i][j] == 0)
                        this.matrix[i][j] = infinity;
                    if (i == j)
                        this.matrix[i][j] = 0;
                }
            }
        } else throw new IllegalArgumentException();
    }
    @Override
    public int[][] runFloyd() {
        for (int k = 0; k < verticesCount; k++) {
            for (int i = 0; i < verticesCount; i++) {
                for (int j = 0; j < verticesCount; j++) {
                    this.matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        return matrix;
    }
    @Override
    public void showGraph() {
        for (int i = 0; i < verticesCount; i++) {
            for (int j = 0; j < verticesCount - 1; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println(matrix[i][verticesCount - 1]);

        }
    }
}