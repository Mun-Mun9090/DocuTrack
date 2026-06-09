package modules.graph;

import java.util.*;

public class Graph {

    int vertices;
    ArrayList<Integer>[] adj;

    public Graph(int vertices) {

        this.vertices = vertices;

        adj = new ArrayList[vertices];

        for(int i=0;i<vertices;i++) {

            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int source,
                        int destination) {

        adj[source].add(destination);

        adj[destination].add(source);
    }

    public void display() {

        for(int i=0;i<vertices;i++) {

            System.out.print(i + " -> ");

            for(Integer x : adj[i]) {

                System.out.print(x + " ");
            }

            System.out.println();
        }
    }
}