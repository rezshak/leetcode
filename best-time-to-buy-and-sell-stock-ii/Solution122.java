// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class Solution122 {

    // T: O(n), S: O(1)
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                int currProfit = prices[i] - prices[i - 1];
                maxProfit += currProfit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        var sol = new Solution122();
        var prices1 = new int[] { 7, 1, 5, 3, 6, 4 };
        var prices2 = new int[] { 1, 2, 3, 4, 5 };
        var prices3 = new int[] { 7, 6, 4, 3, 1 };
        System.out.println(sol.maxProfit(prices1)); // 7
        System.out.println(sol.maxProfit(prices2)); // 4
        System.out.println(sol.maxProfit(prices3)); // 0
    }

}
