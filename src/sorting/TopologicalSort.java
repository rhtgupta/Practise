package sorting;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

    private int noOfVertices;
    private LinkedList<Integer> adj[];

    TopologicalSort(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adj[sourceVertex].add(destinationVertex);
    }

    public void sort() {
        boolean[] visited = new boolean[noOfVertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < noOfVertices; i++) {
            visited[i] = false;
        }

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

        for (int value : adj[vertex]) {
            if (!visited[value]) {
                sort(value, visited, stack);
            }
        }
        stack.push(vertex);
    }

    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.sort();
    }

}
