package org.code.data_structures.graph;

public class Graph {
    protected int vertices;
    protected int edges;
    protected Edge[] edge;

    public Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        edge = new Edge[edges];

        for (int i = 0; i < edges; i++) {
            edge[i] = new Edge();
        }
    }
}
