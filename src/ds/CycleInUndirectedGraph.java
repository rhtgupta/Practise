package ds;

import java.util.Iterator;
import java.util.LinkedList;

public class CycleInUndirectedGraph {

    private int noOfVertices;
    private LinkedList<Integer> adj[];

    CycleInUndirectedGraph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adj[sourceVertex].add(destinationVertex);
        adj[destinationVertex].add(sourceVertex);
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) {
                if (isCycleDetected(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycleDetected(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;
        for (int adjVertex : adj[vertex]) {
            if (!visited[adjVertex]) {
                if (isCycleDetected(adjVertex, visited, vertex)) {
                    return true;
                }
            } else if (parent != adjVertex) {
                return true;
            }
        }
        return false;
    }


    // Driver method to test above methods
    public static void main(String args[]) {

        // Create a graph given
        // in the above diagram
        CycleInUndirectedGraph g1 = new CycleInUndirectedGraph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn 't contains cycle");

        CycleInUndirectedGraph g2 = new CycleInUndirectedGraph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn 't contains cycle");
    }

}
