package leetcode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int nums1[] = {4, 7, 9, 7, 6, 7};
        int nums2[] = {5, 0, 0, 6, 1, 6, 2, 2, 4};
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersectionSet = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                intersectionSet.add(nums2[j]);
            }
        }
        int[] result = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            result[index] = num;
            index++;
        }
    }
}
