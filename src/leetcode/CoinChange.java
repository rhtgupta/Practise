package leetcode;

import java.net.Inet4Address;
import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int amount = 3;
        int[] coins = {2};
        System.out.println(Integer.MAX_VALUE);
        System.out.println("Answer :" + minCoins(amount, coins));

    }

    static int minCoins(int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int subAnswer = minCoins(amount - coins[i], coins);
                if (subAnswer != Integer.MAX_VALUE && subAnswer + 1 < answer) {
                    answer = subAnswer + 1;
                }
            }
        }
        return answer;
    }
}
