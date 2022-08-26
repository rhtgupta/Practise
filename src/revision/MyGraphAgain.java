package revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGraphAgain<E> {

    private Map<E, List<E>> map = new HashMap<>();

    private void addVertex(E v) {
        map.put(v, new ArrayList<>());
    }

    public void addEdge(E source, E destination, boolean biDirectional) {
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
        for (Map.Entry<E, List<E>> entry : map.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(" :");
            for (E value : entry.getValue()) {
                System.out.print(" " + value);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        MyGraphAgain<Integer> g = new MyGraphAgain<>();
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);

        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(-18));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(4));
    }

}
