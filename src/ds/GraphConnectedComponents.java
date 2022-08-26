package ds;

import java.util.LinkedList;
import java.util.List;

public class GraphConnectedComponents {

    private int noOfVertices;
    private LinkedList<Integer> adj[];

    GraphConnectedComponents(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adj[sourceVertex].add(destinationVertex);
        adj[destinationVertex].add(sourceVertex);
    }

    public List<List<Integer>> findConnectedComponents() {
        boolean[] visited = new boolean[noOfVertices];
        List<List<Integer>> components = new LinkedList<>();
//        int count = 0;
        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) {
                List<Integer> verticesInComponent = new LinkedList<>();
                DFS(i, visited, verticesInComponent);
                components.add(verticesInComponent);
            }
        }
        return components;
    }

    public void DFS(int vertex, boolean[] visited, List<Integer> verticesInComponent) {
        verticesInComponent.add(vertex);
        visited[vertex] = true;
        for (int adjVertex : adj[vertex]) {
            if (!visited[adjVertex]) {
                DFS(adjVertex, visited, verticesInComponent);
            }
        }
    }


    public static void main(String[] args) {
        GraphConnectedComponents g = new GraphConnectedComponents(6);

        g.addEdge(1, 5);
        g.addEdge(0, 2);
        g.addEdge(2, 4);
        System.out.println("Graph DFS:");
        System.out.println(g.findConnectedComponents());
    }

}
