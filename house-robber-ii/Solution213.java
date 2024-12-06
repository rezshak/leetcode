// https://leetcode.com/problems/house-robber-ii/

class Solution213 {

    // T: O(n), S: O(1)
    public int rob(int[] nums) {
        // Handle empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Handle single element array
        if (nums.length == 1) {
            return nums[0];
        }

        // Handle two-element array specifically
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // Key insight: solve problem by excluding either first or last house
        int max1 = robSimple(nums, 0, nums.length - 2);
        int max2 = robSimple(nums, 1, nums.length - 1);

        // Return the maximum of the two scenarios
        return Math.max(max1, max2);
    }

    public int robSimple(int[] nums, int start, int end) {
        // Initialize with first two houses
        int prev1 = Math.max(nums[start], nums[start + 1]);
        int prev2 = nums[start];

        // Iterate through remaining houses
        for (int i = start + 2; i <= end; i++) {
            // Choose max between:
            // 1. Previous max (skipping current house)
            // 2. Current house + max from two houses back
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        var sol = new Solution213();
        var nums1 = new int[] { 2, 3, 2 };
        var nums2 = new int[] { 1, 2, 3, 1 };
        var nums3 = new int[] { 1, 2, 3 };
        var nums4 = new int[] { 0, 0 };
        System.out.println(sol.rob(nums1));
        System.out.println(sol.rob(nums2));
        System.out.println(sol.rob(nums3));
        System.out.println(sol.rob(nums4));
    }

}
