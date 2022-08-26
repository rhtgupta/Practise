package ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CycleInDirectedGraph {

    private int noOfVertices;
    private LinkedList<Integer>[] adj;

    CycleInDirectedGraph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // This function is a variation of DFSUtil() in
    // https://www.geeksforgeeks.org/archives/18212
    private boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack) {
        if (recStack[i]) {
            return true;
        }

        if (visited[i]) {
            return false;
        }

        visited[i] = true;
        recStack[i] = true;

        for (int value : adj[i]) {
            if (isCyclicUtil(value, visited, recStack)) {
                return true;
            }
        }
        recStack[i] = false;
        return false;
    }

    private void addEdge(int source, int dest) {
        adj[source].add(dest);
    }

    // Returns true if the graph contains a
    // cycle, else false.
    // This function is a variation of DFS() in
    // https://www.geeksforgeeks.org/archives/18212
    private boolean isCyclic() {
        boolean[] visited = new boolean[noOfVertices];
        boolean[] recStack = new boolean[noOfVertices];

        for (int i = 0; i < noOfVertices; i++) {
            if (isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    // Driver code
    public static void main(String[] args) {
        CycleInDirectedGraph graph = new CycleInDirectedGraph(5);
        /*graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);*/

        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(4, 3);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);

        if (graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}