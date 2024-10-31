// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution121 {

    // T: O(n), S: O(n)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        var rightMaxes = new int[n];
        rightMaxes[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMaxes[i] = Math.max(rightMaxes[i + 1], prices[i]);
        }
        int maxProfit = 0, currProfit = 0;
        for (int i = 0; i < n; i++) {
            currProfit = rightMaxes[i] - prices[i];
            maxProfit = Math.max(maxProfit, currProfit);
        }
        return maxProfit;
    }

    // T: O(n), S: O(1)
    public int maxProfitOpt(int[] prices) {
        int l = 0, r = 1, n = prices.length;
        int res = 0;
        while (r < n) {
            if (prices[l] < prices[r]) {
                res = Math.max(res, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        var sol = new Solution121();
        var prices1 = new int[] { 7, 1, 5, 3, 6, 4 };
        var prices2 = new int[] { 7, 6, 4, 3, 1 };
        System.out.println(sol.maxProfit(prices1)); // 5
        System.out.println(sol.maxProfit(prices2)); // 0
        System.out.println(sol.maxProfitOpt(prices1)); // 5
        System.out.println(sol.maxProfitOpt(prices2)); // 0
    }

}
