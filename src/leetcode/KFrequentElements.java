package leetcode;

import java.util.*;

public class KFrequentElements {

    public void print(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("key : " + entry.getKey() + " value : " + entry.getValue());
        }
    }

    public Map<String, Integer> sort(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, (l1, l2) -> l2.getValue().compareTo(l1.getValue()));

        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            temp.put(entry.getKey(), entry.getValue());
        }
        return temp;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Ten", 10);
        map.put("Five", 5);
        map.put("Eight", 8);
        map.put("Two", 2);
        KFrequentElements obj = new KFrequentElements();
        obj.print(obj.sort(map));


    }
}
