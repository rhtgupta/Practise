package graph_revision_final;

import revision1.CycleInDirectedGraphRevision1;

import java.util.LinkedList;

public class CycleInDirectedGraphFinal {

    private int noOfVertices;
    private LinkedList<Integer>[] adjList;

    CycleInDirectedGraphFinal(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adjList = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adjList[sourceVertex].add(destinationVertex);
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[noOfVertices];
        boolean[] recStack = new boolean[noOfVertices];

        for (int i = 0; i < noOfVertices; i++) {
            if (isCycleDetected(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCycleDetected(int vertex, boolean[] visited, boolean[] recStack) {
        if (recStack[vertex]) {
            return true;
        }
        if (visited[vertex]) {
            return false;
        }
        visited[vertex] = true;
        recStack[vertex] = true;
        for (int adjVertex : adjList[vertex]) {
            if (isCycleDetected(adjVertex, visited, recStack)) {
                return true;
            }
        }
        recStack[vertex] = false;
        return false;
    }

    public static void main(String[] args) {
        CycleInDirectedGraphFinal graph = new CycleInDirectedGraphFinal(5);
       /* graph.addEdge(0, 1);
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
