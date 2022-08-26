package graph_revision_final;

import revision1.CycleInUndirectedGraphRevision1;

import java.util.LinkedList;

public class CycleInUndirectedGraphFinal {

    private int noOfVertices;
    private LinkedList<Integer>[] adjList;

    CycleInUndirectedGraphFinal(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adjList = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adjList[sourceVertex].add(destinationVertex);
        adjList[destinationVertex].add(sourceVertex);
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
        for (int adjVertex : adjList[vertex]) {
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

    public static void main(String[] args) {
        // Create a graph given
        // in the above diagram
        CycleInUndirectedGraphFinal g1 = new CycleInUndirectedGraphFinal(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn 't contains cycle");

        CycleInUndirectedGraphFinal g2 = new CycleInUndirectedGraphFinal(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(0, 2);
        if (g2.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn 't contains cycle");
    }

}
