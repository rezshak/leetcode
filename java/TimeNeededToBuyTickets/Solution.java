// https://leetcode.com/problems/time-needed-to-buy-tickets/

package TimeNeededToBuyTickets;

public class Solution {

    // T: O(n^2), S: O(1)
    public int timeRequiredToBuy(int[] tickets, int k) {
        int result = 0, n = tickets.length;
        while (tickets[k] > 0) {
            for (int i = 0; i < n; i++) {
                if (tickets[i] > 0) {
                    tickets[i]--;
                    result++;
                    if (tickets[k] == 0) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var nums1 = new int[] { 2, 3, 2 }; // 6
        var nums2 = new int[] { 5, 1, 1, 1 }; // 8
        System.out.println(sol.timeRequiredToBuy(nums1, 2));
        System.out.println(sol.timeRequiredToBuy(nums2, 0));
    }

}
