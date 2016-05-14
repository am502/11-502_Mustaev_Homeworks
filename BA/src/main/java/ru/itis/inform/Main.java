package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();

        for (int i = 0; i < 4; i++) {
            g.addVertex();
        }

        g.show();
    }
}
