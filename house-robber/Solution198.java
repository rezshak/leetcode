// https://leetcode.com/problems/house-robber/

import java.util.HashMap;
import java.util.Map;

class Solution198 {

    // T: O(n), S: O(1)
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int prev1 = Math.max(nums[0], nums[1]);
        int prev2 = nums[0];

        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    // T: O(n), S: O(n)
    public int robDp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        var dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            // Two choices at each step:
            // 1. Skip current house and take max money from previous house
            // 2. Rob current house + money from two houses before
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }

    // T: O(n), S: O(n)
    public int robMemo(int[] nums) {
        var memo = new HashMap<Integer, Integer>();
        return dfsMemo(nums, 0, memo);
    }

    private int dfsMemo(int[] nums, int i, Map<Integer, Integer> memo) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        int skip = dfsMemo(nums, i + 1, memo);
        int rob = nums[i] + dfsMemo(nums, i + 2, memo);
        int result = Math.max(rob, skip);
        memo.put(i, result);
        return result;
    }

    // T: O(2^n), S: O(n)
    public int robBrute(int[] nums) {
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int i) {
        // Base case: all houses processed
        if (i >= nums.length) {
            return 0;
        }

        // Option 1: skip current nums[i] and move to next house (i+1)
        int skip = dfs(nums, i + 1);

        // Option 2: Rob current nums[i] and move to house after next (i+2)
        int rob = nums[i] + dfs(nums, i + 2);

        // Return the maximum money we can get from either choice
        return Math.max(skip, rob);
    }

    public static void main(String[] args) {
        var sol = new Solution198();
        var nums1 = new int[] { 1, 2, 3, 1 };
        System.out.println(sol.rob(nums1)); // 4
        System.out.println(sol.robDp(nums1)); // 4
        System.out.println(sol.robMemo(nums1)); // 4
        System.out.println(sol.robBrute(nums1)); // 4
        var nums2 = new int[] { 2, 7, 9, 3, 1 };
        System.out.println(sol.rob(nums2)); // 12
        System.out.println(sol.robDp(nums2)); // 12
        System.out.println(sol.robMemo(nums2)); // 12
        System.out.println(sol.robBrute(nums2)); // 12
    }

}
