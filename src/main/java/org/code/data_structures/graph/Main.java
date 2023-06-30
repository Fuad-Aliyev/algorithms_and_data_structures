package org.code.data_structures.graph;

public class Main {
    public static void main(String[] args) {
        int vertices = 6;
        int edges = 10;

        Graph graph = new Graph(vertices, edges);
        graph.edge[0].source = 1;   // edge 1---2
        graph.edge[0].destination = 2;

        graph.edge[1].source = 1;   // edge 1---3
        graph.edge[1].destination = 3;

        graph.edge[2].source = 1;   // edge 1---4
        graph.edge[2].destination = 4;

        graph.edge[3].source = 2;   // edge 2---4
        graph.edge[3].destination = 4;

        graph.edge[4].source = 2;   // edge 2---5
        graph.edge[4].destination = 5;

        graph.edge[5].source = 3;   // edge 3---4
        graph.edge[5].destination = 4;

        graph.edge[6].source = 3;   // edge 3---5
        graph.edge[6].destination = 5;

        graph.edge[7].source = 4;   // edge 4---5
        graph.edge[7].destination = 5;

        for(int i = 0; i < edges; i++) {
            System.out.println(graph.edge[i].source + " - " + graph.edge[i].destination);
        }
    }
}
