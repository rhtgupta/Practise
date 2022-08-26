package leetcode;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test<T> {
    public static void main(String[] args) {

        try {
            Class.forName("Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ClassLoader.class.getClassLoader().loadClass("Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    static void printMap(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + "value : " + entry.getValue());
        }
    }

    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - k)) {
                count = count + map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
