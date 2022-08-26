package thread_revision;

import java.util.LinkedList;

public class MyGraphRevisionAgain {

    private int noOfVertices;
    private LinkedList<Integer>[] adjList;

    MyGraphRevisionAgain(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adjList = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adjList[sourceVertex].add(destinationVertex);
    }

}
