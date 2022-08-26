package leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    static int lengthOfLIS(int[] nums) {
        int[] frequency = new int[nums.length];
        Arrays.fill(frequency, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && frequency[j] + 1 > frequency[i]) {
                    frequency[i] = nums[j] + 1;
                }
            }
        }
        int maxSum = 0;
        for (int i = 0; i < frequency.length; i++) {
            maxSum = Math.max(maxSum, frequency[i]);
        }
        return maxSum;
    }
}
