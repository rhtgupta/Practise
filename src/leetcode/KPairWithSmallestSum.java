package leetcode;

import java.util.*;

public class KPairWithSmallestSum {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> ((a[0] + a[1]) - (b[0] + b[1])));
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.add(new int[]{nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            list.add(Arrays.asList(top[0], top[1]));
            int next = top[2] + 1;

            if (next < nums2.length) {
                pq.add(new int[]{top[0], nums2[next], next});
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int nums1[] = {1, 1, 2};
        int nums2[] = {1, 2, 3};
        KPairWithSmallestSum obj = new KPairWithSmallestSum();
        List<List<Integer>> list = obj.kSmallestPairs(nums1, nums2, 5);
        System.out.println(list);
    }
}
