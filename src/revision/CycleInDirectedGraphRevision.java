package revision;

import javax.sound.sampled.Line;
import java.util.LinkedList;

public class CycleInDirectedGraphRevision {

    private int noOfVertices;
    private LinkedList<Integer>[] adj;

    CycleInDirectedGraphRevision(int noOfVertices) {
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

        for (int adjVertex : adj[vertex]) {
            if (isCycleDetected(adjVertex, visited, recStack)) {
                return true;
            }
        }

        recStack[vertex] = false;
        return false;
    }

}
