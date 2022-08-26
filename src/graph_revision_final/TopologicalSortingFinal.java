package graph_revision_final;

import revision1.TopologicalSortRevision1;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSortingFinal {

    private int noOfVertices;
    private LinkedList<Integer>[] adjList;

    TopologicalSortingFinal(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adjList = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adjList[sourceVertex].add(destinationVertex);
    }

    public void topologicalSort() {
        boolean[] visited = new boolean[noOfVertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) {
                sort(i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public void sort(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        for (int adjVertex : adjList[vertex]) {
            if (!visited[adjVertex]) {
                sort(adjVertex, visited, stack);
            }
        }
        stack.push(vertex);
    }

    public static void main(String[] args) {
        TopologicalSortingFinal g = new TopologicalSortingFinal(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.topologicalSort();
    }

}
