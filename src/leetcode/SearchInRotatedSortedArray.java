package leetcode;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        // answer should be 4
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));

    }

    static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[end]) {
                // left
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = start + 1;
                }
            } else {
                // right
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
