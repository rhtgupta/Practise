package leetcode;

public class MinimalSizeSubArray {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(findMinimum(nums, target));
    }

    static int findMinimum(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;

        while (endIndex < nums.length) {
            sum = sum + nums[endIndex];
            while (sum >= target) {
                minLength = Math.min(minLength, endIndex - startIndex + 1);
                sum = sum - nums[startIndex];
                startIndex++;
            }
            endIndex++;
        }
        return minLength;
    }
}
