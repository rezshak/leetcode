// https://leetcode.com/problems/coin-change/

import java.util.*;

class Solution322 {

    // T: O(n^amt), S: O(amt)
    public int coinChangeRec(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        return dfsRec(coins, amount);
    }

    private int dfsRec(int[] coins, int remainingAmount) {
        if (remainingAmount < 0) {
            return -1; // Invalid amount
        }
        if (remainingAmount == 0) {
            return 0; // Exact amount reached
        }

        // Initialize minimum coins to a large value
        int minCoins = Integer.MAX_VALUE;

        // Try each coin denomination
        for (int coin : coins) {
            // Recursively solve for remaining amount
            int subResult = dfsRec(coins, remainingAmount - coin);

            // If a valid solution exists for the sub-problem
            if (subResult != -1) {
                // Update minimum coins, adding 1 for current coin
                minCoins = Math.min(minCoins, subResult + 1);
            }
        }

        // Return minimum coins or -1 if no solution
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    // T: O(n*amt), S: O(amt)
    public int coinChangeRecMemo(int[] coins, int amount) {
        return dfsRecMemo(coins, amount, new HashMap<>());
    }

    private int dfsRecMemo(int[] coins, int remainingAmount, Map<Integer, Integer> memo) {
        // Check memoized result first
        if (memo.containsKey(remainingAmount)) {
            return memo.get(remainingAmount);
        }

        // Base cases
        if (remainingAmount < 0)
            return -1; // Invalid amount
        if (remainingAmount == 0)
            return 0; // Exact amount reached

        // Initialize minimum coins to a large value
        int minCoins = Integer.MAX_VALUE;

        // Try each coin denomination
        for (int coin : coins) {
            // Recursively solve for remaining amount
            int subResult = dfsRecMemo(coins, remainingAmount - coin, memo);

            // If a valid solution exists for the sub-problem
            if (subResult != -1) {
                // Update minimum coins, adding 1 for current coin
                minCoins = Math.min(minCoins, subResult + 1);
            }
        }

        // Compute final result
        int result = minCoins == Integer.MAX_VALUE ? -1 : minCoins;

        // Memoize and return the result
        memo.put(remainingAmount, result);
        return result;
    }

    // T: O(n*amt), S: O(amt)
    public int coinChangeDpBottomUp(int[] coins, int amount) {
        // If amount is 0, no coins are needed
        if (amount == 0) {
            return 0;
        }

        // Create a dp array to store minimum coins needed for each amount
        // Initialize with amount + 1 as a "impossible" marker
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        // Base case: 0 coins needed to make 0 amount
        dp[0] = 0;

        // Compute minimum coins for each amount from 1 to target amount
        for (int i = 1; i <= amount; i++) {
            // Try each coin denomination
            for (int coin : coins) {
                // If coin is less than or equal to current amount
                if (coin <= i) {
                    // Update minimum coins needed
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // Return result, or -1 if no solution found
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        var sol = new Solution322();
        var coins1 = new int[] { 1, 2, 5 };
        int amount1 = 11;
        System.out.println(sol.coinChangeRec(coins1, amount1)); // 3 (5 + 5 + 1)
        System.out.println(sol.coinChangeRecMemo(coins1, amount1)); // 3 (5 + 5 + 1)
        System.out.println(sol.coinChangeDpBottomUp(coins1, amount1)); // 3 (5 + 5 + 1)
        var coins2 = new int[] { 2 };
        int amount2 = 3;
        System.out.println(sol.coinChangeRec(coins2, amount2)); // -1
        System.out.println(sol.coinChangeRecMemo(coins2, amount2)); // -1
        System.out.println(sol.coinChangeDpBottomUp(coins2, amount2)); // -1
        var coins3 = new int[] { 1 };
        int amount3 = 0;
        System.out.println(sol.coinChangeRec(coins3, amount3)); // 0
        System.out.println(sol.coinChangeRecMemo(coins3, amount3)); // 0
        System.out.println(sol.coinChangeDpBottomUp(coins3, amount3)); // 0
    }

}
