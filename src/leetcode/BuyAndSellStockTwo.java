package leetcode;

public class BuyAndSellStockTwo {

    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int totalProfit = 0;
        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                if (prices[right - 1] <= prices[right]) {
                    maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
                } else {
                    left = right;
                    totalProfit = totalProfit + maxProfit;
                    maxProfit = 0;
                }

            } else {
                left = right;
            }
            right = right + 1;
        }
        if (maxProfit != 0) {
            totalProfit = totalProfit + maxProfit;
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        BuyAndSellStockTwo obj = new BuyAndSellStockTwo();
        int[] prices = {6, 1, 3, 2, 4, 7};
        System.out.println(obj.maxProfit(prices));
    }

}
