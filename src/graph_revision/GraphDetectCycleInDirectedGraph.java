package graph_revision;

import ds.CycleInDirectedGraph;

import java.util.LinkedList;

public class GraphDetectCycleInDirectedGraph {

    private int noOfVertices;
    private LinkedList<Integer> adj[];

    GraphDetectCycleInDirectedGraph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adj[sourceVertex].add(destinationVertex);
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[noOfVertices];
        boolean[] recStack = new boolean[noOfVertices];

        for (int i = 0; i < noOfVertices; i++) {
            if (detectCycle(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    public boolean detectCycle(int vertex, boolean[] visited, boolean[] recStack) {
        if (recStack[vertex]) {
            return true;
        }
        if (visited[vertex]) {
            return false;
        }
        visited[vertex] = true;
        recStack[vertex] = true;

        for (int adjVertex : adj[vertex]) {
            if (detectCycle(adjVertex, visited, recStack)) {
                return true;
            }
        }
        recStack[vertex] = false;
        return false;
    }

    // Driver code
    public static void main(String[] args) {
        GraphDetectCycleInDirectedGraph graph = new GraphDetectCycleInDirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        /*graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(4, 3);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);*/

        if (graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}
