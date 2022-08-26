package leetcode;

import java.util.Arrays;

class GFG {
    // Function to calculate the maximum stolen value
    static int maxLoot(int hval[], int n, int dp[]) {
        // base case
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return hval[0];
        }
        // If the subproblem is already solved
        // then return its value
        if (dp[n] != -1) {
            return dp[n];
        }

        // if current element is pick then previous cannot
        // be picked
        int pick = hval[n] + maxLoot(hval, n - 2, dp);
        // if current element is not picked then previous
        // element is picked
        int notPick = maxLoot(hval, n - 1, dp);

        // return max of picked and not picked
        return dp[n] = Math.max(pick, notPick);
    }

    // Driver program
    public static void main(String[] args) {
        int hval[] = {6, 7, 1, 3, 8, 2, 4};
        int n = hval.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Maximum loot value : "
                + maxLoot(hval, n - 1, dp));
    }
}