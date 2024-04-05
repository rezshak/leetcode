// https://leetcode.com/problems/richest-customer-wealth/

package RichestCustomerWealth;

class Solution {

    // T: O(n), S: O(1)
    public int maximumWealth(int[][] accounts) {
        var maxWealth = 0;
        for (var acct : accounts) {
            var acctSum = 0;
            for (var bal : acct) {
                acctSum += bal;
            }
            maxWealth = Math.max(acctSum, maxWealth);
        }
        return maxWealth;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var accts1 = new int[][] {
            { 1, 2, 3},
            { 3, 2, 1}
        };
        System.out.println(sol.maximumWealth(accts1)); // 6
    }

}
