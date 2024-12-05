// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

import java.util.HashMap;
import java.util.Map;

class Solution188 {

    public int maxProfitRec(int k, int[] prices) {
        // Start from first price in 'buy' state
        return maxProfitUtilRec(0, k, 1, prices);
    }

    private int maxProfitUtilRec(int i, int k, int buy, int[] prices) {

        // Base case: no transactions or end of list
        if (k <= 0 || i >= prices.length) {
            return 0;
        }

        int result = 0, profit = 0;

        // If we are in a 'buy' state
        if (buy == 1) {
            // Buy at current price or skip
            profit = maxProfitUtilRec(i + 1, k, 0, prices) - prices[i];
            result = Math.max(result, profit);
        } else {
            // Sell at current price or skip
            profit = prices[i] + maxProfitUtilRec(i + 1, k - 1, 1, prices);
            result = Math.max(result, profit);
        }

        // Skip current price
        profit = maxProfitUtilRec(i + 1, k, buy, prices);
        return Math.max(result, profit);
    }

    public int maxProfitRecMemo(int k, int[] prices) {
        Map<String, Integer> memo = new HashMap<>();
        return maxProfitUtilMemo(0, k, 1, prices, memo);
    }

    private int maxProfitUtilMemo(int i, int k, int buy, int[] prices, Map<String, Integer> memo) {
        // Base case
        if (k == 0 || i >= prices.length) {
            return 0;
        }

        // Generate a unique key for the current state
        String key = i + "," + k + "," + buy;

        // If the result is already calculated, return it
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result = 0;

        // Recursive cases
        if (buy == 1) {
            // Buy or skip
            result = Math.max(maxProfitUtilMemo(i + 1, k, 0, prices, memo) - prices[i],
                    maxProfitUtilMemo(i + 1, k, 1, prices, memo));
        } else {
            // Sell or skip
            result = Math.max(prices[i] + maxProfitUtilMemo(i + 1, k - 1, 1, prices, memo),
                    maxProfitUtilMemo(i + 1, k, 0, prices, memo));
        }

        // Store the result in the memo and return it
        memo.put(key, result);
        return result;
    }

    public int maxProfitDp(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        int n = prices.length;

        // If k is greater than n/2, it's equivalent to unlimited transactions
        if (k >= n / 2) {
            return maxProfitWithUnlimitedTransactions(prices);
        }

        // DP table to store maximum profit
        int[][] dp = new int[k + 1][n];

        // Iterate over transactions
        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0];
            for (int d = 1; d < n; d++) {
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[t - 1][d] - prices[d]);
            }
        }

        return dp[k][n - 1];
    }

    private int maxProfitWithUnlimitedTransactions(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        var sol = new Solution188();
        var prices = new int[] { 3, 2, 6, 5, 0, 3 };
        System.out.println(sol.maxProfitRec(2, prices)); // 7
    }

}
