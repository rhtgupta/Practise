package leetcode;

import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }

    static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] tmp1 = new int[nums.length];
        Arrays.fill(tmp1, -1);
        int[] tmp2 = new int[nums.length];
        Arrays.fill(tmp2, -1);
        int robbery1 = findMaxRob(Arrays.copyOfRange(nums, 1, nums.length), nums.length - 2, tmp1);
        int robbery2 = findMaxRob(Arrays.copyOfRange(nums, 0, nums.length - 1), nums.length - 2, tmp2);
        return Math.max(robbery1, robbery2);
    }

    static int findMaxRob(int[] num, int n, int[] temp) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return num[0];
        }

        if (temp[n] != -1) {
            return temp[n];
        }

        int option1 = num[n] + findMaxRob(num, n - 2, temp);
        int option2 = findMaxRob(num, n - 1, temp);
        return temp[n] = Math.max(option1, option2);
    }
}
