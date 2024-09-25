// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution121 {

    // T: O(n), S: O(1)
    public int maxProfit(int[] prices) {
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
    }

}
