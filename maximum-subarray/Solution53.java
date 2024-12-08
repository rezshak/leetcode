// https://leetcode.com/problems/maximum-subarray/

class Solution53 {

    // T: O(n^2), S: O(1)
    public int maxSubArrayBrute(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for (int i = 0; i < n; i++) {
            // Current sum of the subarray, reset for each starting point
            int currSum = 0;

            // Inner loop: end of potential subarray
            for (int j = i; j < n; j++) {
                // Add the current element to the subarray sum
                currSum += nums[j];

                // Update the maximum sum if current subarray sum is larger
                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }

    // T: O(n), S: O(n)
    public int maxSubArrayDpOpt(int[] nums) {
        // Create a copy of the input array to use as our DP array
        int[] dp = nums.clone();

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // For each position, decide whether to:
            // 1. Start a new subarray from the current element, or
            // 2. Extend the previous subarray
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        // Find the maximum value in the DP array
        int maxSum = dp[0];
        for (int sum : dp) {
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    // T: O(n), S: O(1)
    public int maxSubArrayKadane(int[] nums) {
        // Initialize max sum with the first element
        int maxSum = nums[0];
        // Initialize current sum with the first element
        int currSum = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // For each element, decide whether to start a new subarray
            // or extend the existing subarray
            currSum = Math.max(nums[i], currSum + nums[i]);

            // Update the maximum sum if current sum is larger
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        var sol = new Solution53();
        var nums1 = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        var nums2 = new int[] { 1 };
        var nums3 = new int[] { 5, 4, -1, 7, 8 };

        System.out.println(sol.maxSubArrayBrute(nums1));
        System.out.println(sol.maxSubArrayDpOpt(nums1));
        System.out.println(sol.maxSubArrayKadane(nums1));
        System.out.println();

        System.out.println(sol.maxSubArrayBrute(nums2));
        System.out.println(sol.maxSubArrayDpOpt(nums2));
        System.out.println(sol.maxSubArrayKadane(nums2));
        System.out.println();

        System.out.println(sol.maxSubArrayBrute(nums3));
        System.out.println(sol.maxSubArrayDpOpt(nums3));
        System.out.println(sol.maxSubArrayKadane(nums3));
    }

}
