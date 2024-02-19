// https://leetcode.com/problems/longest-continuous-increasing-subsequence/

package LongestContinuousIncreasingSubsequence;

public class Solution {

    // T: O(n), S: O(1)
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length, count = 0;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
                ans = Math.max(ans, count);
            } else {
                count = 0;
            }
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        int[] nums1 = { 1, 3, 5, 4, 7 }; // 3
        int[] nums2 = { 2, 2, 2, 2, 2 }; // 1
        System.out.println(sol.findLengthOfLCIS(nums1));
        System.out.println(sol.findLengthOfLCIS(nums2));
    }

}
