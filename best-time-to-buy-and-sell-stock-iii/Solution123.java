// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

class Solution123 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int n = prices.length;

        // Calculate max profit from left to right (first transaction)
        var leftProfits = new int[n];
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]); // Update the minimum price so far
            leftProfits[i] = Math.max(leftProfits[i - 1], prices[i] - minPrice); // Max profit so far
        }

        // Calculate max profit from right to left (second transaction)
        var rightProfits = new int[n];
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]); // Update the maximum price so far
            rightProfits[i] = Math.max(rightProfits[i + 1], maxPrice - prices[i]); // Max profit so far
        }

        // Combine the results from both arrays
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, leftProfits[i] + rightProfits[i]);
        }

        return maxProfit;
    }

    public int maxProfitDp(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // Initialize variables to track the maximum profit
        int firstBuy = Integer.MIN_VALUE; // Max profit after first buy
        int firstSell = 0; // Max profit after first sell
        int secondBuy = Integer.MIN_VALUE; // Max profit after second buy
        int secondSell = 0; // Max profit after second sell

        for (int price : prices) {
            // Maximize profit for each transaction
            firstBuy = Math.max(firstBuy, -price); // Buy first stock
            firstSell = Math.max(firstSell, firstBuy + price); // Sell first stock
            secondBuy = Math.max(secondBuy, firstSell - price); // Buy second stock
            secondSell = Math.max(secondSell, secondBuy + price); // Sell second stock
        }

        return secondSell; // Maximum profit after at most two transactions
    }

    public static void main(String[] args) {
        var sol = new Solution123();
        var prices = new int[] { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println(sol.maxProfit(prices)); // 6
    }

}
