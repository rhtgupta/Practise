package ds;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyGraph<T> {

    private Map<T, List<T>> map = new HashMap<>();

    private void addVertex(T v) {
        map.put(v, new LinkedList<>());
    }

    public void addEdge(T source, T destination, boolean biDirectional) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }
        if (!map.containsKey(destination)) {
            addVertex(destination);
        }
        map.get(source).add(destination);
        if (biDirectional) {
            map.get(destination).add(source);
        }
    }

    public void display() {
        for (Map.Entry<T, List<T>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " :");
            for (T value : entry.getValue()) {
                System.out.print(" " + value);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        MyGraph g = new MyGraph();
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);
        g.display();
    }

}
