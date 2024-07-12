// https://leetcode.com/problems/longest-continuous-increasing-subsequence/

class Solution674 {

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
        var sol = new Solution674();
        var nums1 = new int[] { 1, 3, 5, 4, 7 };
        var nums2 = new int[] { 2, 2, 2, 2, 2 };
        System.out.println(sol.findLengthOfLCIS(nums1)); // 3
        System.out.println(sol.findLengthOfLCIS(nums2)); // 1
    }

}
