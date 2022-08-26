package revision;

import ds.StronglyConnectedComponentsInGraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SCCInGraph {

    private int noOfVertices;
    private LinkedList<Integer>[] adj;
    private LinkedList<Integer> transposedAdj[];

    SCCInGraph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        transposedAdj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
            transposedAdj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adj[sourceVertex].add(destinationVertex);
    }

    public List<List<Integer>> findSCC() {
        boolean[] visited = new boolean[noOfVertices];
        List<List<Integer>> scc = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) {
                firstDFS(i, visited, stack);
            }
        }

        transposeGraph();

        for (int i = 0; i < noOfVertices; i++) {
            visited[i] = false;
        }
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                List<Integer> verticesInScc = new LinkedList<>();
                secondDFS(vertex, visited, verticesInScc);
                scc.add(verticesInScc);
//                System.out.println(" ");
            }
        }
        return scc;
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

    public void secondDFS(int vertex, boolean[] visited, List<Integer> verticesInScc) {
        visited[vertex] = true;
//        System.out.print(vertex + " ");
        verticesInScc.add(vertex);
        for (int adjVertex : transposedAdj[vertex]) {
            if (!visited[adjVertex]) {
                secondDFS(adjVertex, visited, verticesInScc);
            }
        }
    }


    public void transposeGraph() {
        for (int i = 0; i < noOfVertices; i++) {
            for (int adjVertex : adj[i]) {
                transposedAdj[adjVertex].add(i);
            }
        }
    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        SCCInGraph g = new SCCInGraph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components " +
                "in given graph ");
        System.out.println(g.findSCC());
    }
}
