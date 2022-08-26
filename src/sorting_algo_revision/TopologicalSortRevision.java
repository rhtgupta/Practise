package sorting_algo_revision;

import ds.GraphBFSAndDFS;
import jdk.jshell.EvalException;
import sorting.TopologicalSort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSortRevision {

    private int noOfVertices;
    private LinkedList<Integer> adj[];

    TopologicalSortRevision(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adj[sourceVertex].add(destinationVertex);
    }

    public void DFS(int vertex) {
        boolean[] visited = new boolean[noOfVertices];
        visitVertices(vertex, visited);
    }

    public void visitVertices(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int value : adj[vertex]) {
            if (!visited[value]) {
                visitVertices(value, visited);
            }
        }
    }

    public void BFS(int vertex) {
        boolean[] visited = new boolean[noOfVertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            System.out.print(tmp + " ");

            for (int value : adj[tmp]) {
                if (!visited[value]) {
                    visited[value] = true;
                    queue.add(value);
                }
            }
        }
    }

    public void topologicalSort() {
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

    public static void main(String args[]) {
       /* TopologicalSortRevision g = new TopologicalSortRevision(4);

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
        g.BFS(2);*/
        TopologicalSortRevision g = new TopologicalSortRevision(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
//        g.topologicalSort();

        boolean[] tmp = new boolean[5];
        for (boolean value : tmp) {
            System.out.print(value + " ");
        }

    }


}
