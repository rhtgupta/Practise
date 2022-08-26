package ds;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

public class StronglyConnectedComponentsInGraph {

    private int noOfVertices;
    private LinkedList<Integer>[] adj;
    private LinkedList<Integer>[] transposedAdj;

    StronglyConnectedComponentsInGraph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
        transposedAdj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            transposedAdj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adj[sourceVertex].add(destinationVertex);
    }

    public void findSCC() {
        boolean[] visited = new boolean[noOfVertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) {
                firstDFS(i, visited, stack);
            }
        }

        transpose();

        for (int i = 0; i < noOfVertices; i++) {
            visited[i] = false;
        }

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                secondDFS(vertex, visited);
                System.out.println(" ");
            }
        }

    }

    public void transpose() {
        for (int i = 0; i < noOfVertices; i++) {
            for (int adjVertex : adj[i]) {
                transposedAdj[adjVertex].add(i);
            }
        }
    }


    public void firstDFS(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        for (int adjVertex : adj[vertex]) {
            if (!visited[adjVertex]) {
                firstDFS(adjVertex, visited, stack);
            }
        }
        stack.push(vertex);
    }

    public void secondDFS(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adjVertex : transposedAdj[vertex]) {
            if (!visited[adjVertex]) {
                secondDFS(adjVertex, visited);
            }
        }
    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        StronglyConnectedComponentsInGraph g = new StronglyConnectedComponentsInGraph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components " +
                "in given graph ");
        g.findSCC();
    }

}
