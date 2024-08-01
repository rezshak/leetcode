// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution121 {

    // T: O(n), S: O(1)
    public int maxProfit(int[] prices) {
        int n = prices.length, maxProfit = 0;
        for (int buy = 0, sell = 1; sell < n; sell++) {
            if (prices[buy] < prices[sell]) {
                int currProfit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit, currProfit);
            } else {
                buy = sell;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        var sol = new Solution121();
        var prices1 = new int[] { 7, 1, 5, 3, 6, 4 };
        var prices2 = new int[] { 7, 6, 4, 3, 1 };
        System.out.println(sol.maxProfit(prices1)); // 5
        System.out.println(sol.maxProfit(prices2)); // 0
    }

}
