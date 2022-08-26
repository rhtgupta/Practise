package revision1;

import ds.GraphBFSAndDFS;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFSAndDFSRevision1 {

    private int noOfVertices;
    private LinkedList<Integer>[] adjList;

    GraphBFSAndDFSRevision1(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adjList = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adjList[sourceVertex].add(destinationVertex);
    }

    public void DFS(int vertex) {
        boolean[] visited = new boolean[noOfVertices];
        DFSUtil(vertex, visited);
    }

    public void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int adjVertex : adjList[vertex]) {
            if (!visited[adjVertex]) {
                DFSUtil(adjVertex, visited);
            }
        }
    }

    public void BFS(int vertex) {
        boolean[] visited = new boolean[noOfVertices];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(vertex);
        visited[vertex] = true;

        while (!queue.isEmpty()) {
            int vertexFromQueue = queue.poll();
            System.out.print(vertexFromQueue + " ");
            for (int adjVertex : adjList[vertexFromQueue]) {
                if (!visited[adjVertex]) {
                    queue.add(adjVertex);
                    visited[adjVertex] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFSAndDFSRevision1 g = new GraphBFSAndDFSRevision1(4);

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
