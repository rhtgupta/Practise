package revision1;

import ds.CycleInUndirectedGraph;

import java.util.LinkedList;

public class CycleInUndirectedGraphRevision1 {

    private int noOfVertices;
    private LinkedList<Integer>[] adjList;

    CycleInUndirectedGraphRevision1(int noOfVertices) {
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

    public boolean cycleDetection() {
        boolean[] visited = new boolean[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) {
                if (isCyclic(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCyclic(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;
        for (int adjVertex : adjList[vertex]) {
            if (!visited[adjVertex]) {
                if (isCyclic(adjVertex, visited, vertex)) {
                    return true;
                }
            } else if (parent != adjVertex) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {

        // Create a graph given
        // in the above diagram
        CycleInUndirectedGraphRevision1 g1 = new CycleInUndirectedGraphRevision1(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.cycleDetection())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn 't contains cycle");

        CycleInUndirectedGraphRevision1 g2 = new CycleInUndirectedGraphRevision1(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.cycleDetection())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn 't contains cycle");
    }

}
