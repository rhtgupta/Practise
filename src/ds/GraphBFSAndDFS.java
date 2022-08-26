package ds;

import javax.print.attribute.IntegerSyntax;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFSAndDFS {

    private int noOfVertices;
    private LinkedList<Integer>[] adj;

    GraphBFSAndDFS(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adj[sourceVertex].add(destinationVertex);
    }

    public void DFS(int vertex) {
        boolean[] visited = new boolean[noOfVertices];
        visitVertex(vertex, visited);
    }

    public void visitVertex(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int value : adj[vertex]) {
            if (!visited[value]) {
                visitVertex(value, visited);
            }
        }
    }

    public void BFS(int vertex) {
        boolean[] visited = new boolean[noOfVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            int value = queue.poll();
            System.out.print(value + " ");
            for (int adjVertex : adj[value]) {
                if (!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                }
            }
        }
    }


    // Driver Code
    public static void main(String args[]) {
        GraphBFSAndDFS g = new GraphBFSAndDFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.DFS(2);
        System.out.println(" ");
        g.BFS(2);
    }
}
