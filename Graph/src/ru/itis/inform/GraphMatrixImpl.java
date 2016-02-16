public class GraphMatrixImpl implements Graph {
    private static final int DEFAULT_SIZE = 50;
    private int matrix[][];
    private int verticesCount;
    private int maxSize;
    public GraphMatrixImpl() {
        initGraph(DEFAULT_SIZE);
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
    public void addEdge(int vertexA, int vertexB, int h) {
        if (vertexA < verticesCount && vertexB < verticesCount) {
            this.matrix[vertexA][vertexB] = 0;
            this.matrix[vertexB][vertexA] = h;
        } else throw new IllegalArgumentException();
    }
    @Override
    public void showGraph() {
        for (int i = 0; i < verticesCount; i++) {
            for (int j = 0; j < verticesCount - 1; j++) {
                System.out.print(matrix[i][j] + ",  ");
            }
            System.out.println(matrix[i][verticesCount - 1]);
        }
    }
}