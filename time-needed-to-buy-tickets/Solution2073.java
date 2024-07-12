// https://leetcode.com/problems/time-needed-to-buy-tickets/

class Solution2073 {

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
        var sol = new Solution2073();
        var nums1 = new int[] { 2, 3, 2 };
        var nums2 = new int[] { 5, 1, 1, 1 };
        System.out.println(sol.timeRequiredToBuy(nums1, 2)); // 6
        System.out.println(sol.timeRequiredToBuy(nums2, 0)); // 8
    }

}
