package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
//        if(nums == null || nums.length == 0) return 0;

        //running sum and frequency of running sum
        int[] nums = {1, 2, 3};
//        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 3;
//        int k = 7;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);

        int rSum = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            //calculating rSum
            rSum += nums[i];
            //check whether complement exists or not
            if (sumMap.containsKey(rSum - k)) {
//                count += sumMap.get(rSum - k);
                count++;
            }

            // update map with new sum/ count

            sumMap.put(rSum, sumMap.getOrDefault(rSum, 0) + 1);
        }
        System.out.println(count);
    }
}
