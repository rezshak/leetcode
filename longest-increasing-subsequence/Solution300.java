// https://leetcode.com/problems/longest-increasing-subsequence/

import java.util.*;

class Solution300 {

    // T: O(2^n), S: O(n)
    public int lengthOfLISRec(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return helperRec(nums, -1, 0);
    }

    private int helperRec(int[] nums, int prevIdx, int currIdx) {
        // Base case: reached the end of the array
        if (currIdx == nums.length) {
            return 0;
        }

        // Option 1: Do not include the current element
        int excludeCurrent = helperRec(nums, prevIdx, currIdx + 1);

        // Option 2: Include the current element if it's larger than the previous
        int includeCurrent = 0;
        if (prevIdx == -1 || nums[currIdx] > nums[prevIdx]) {
            includeCurrent = 1 + helperRec(nums, currIdx, currIdx + 1);
        }

        // Return the maximum of including or excluding the current element
        return Math.max(excludeCurrent, includeCurrent);
    }

    // T: O(n^2), S: O(n)
    public int lengthOfLISDpBottomUp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp array to store the length of LIS ending at each index
        int n = nums.length;
        int[] dp = new int[n];

        // Initialize each position with 1 (minimum LIS length is 1)
        Arrays.fill(dp, 1);

        // Variable to track the overall maximum LIS
        int maxLen = 1;

        // Iterate through the array
        for (int i = 1; i < n; i++) {
            // For each element, check previous elements
            for (int j = 0; j < i; j++) {
                // If current element is greater than previous element
                if (nums[i] > nums[j]) {
                    // Update the LIS length for current index
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // Update overall maximum
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    // T: O(nlogn), S: O(n)
    public int lengthOfLISBinarySearch(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Array to store the smallest tail of all increasing subsequences
        // of current length
        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            // Binary search to find the correct position for the current number
            int left = 0, right = size;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // Place the current number in its correct position
            tails[left] = num;

            // If we're at the end of the current subsequence, increase its length
            if (left == size) {
                size++;
            }
        }

        return size;
    }

    public static void main(String[] args) {
        var sol = new Solution300();

        int[][] testCases = {
                { 10, 9, 2, 5, 3, 7, 101, 18 },
                { 0, 1, 0, 3, 2, 3 },
                { 7, 7, 7, 7, 7, 7, 7 },
                {}
        };

        for (int[] testCase : testCases) {
            System.out.print(Arrays.toString(testCase) + " -> ");
            System.out.print(sol.lengthOfLISRec(testCase) + " ");
            System.out.print(sol.lengthOfLISDpBottomUp(testCase) + " ");
            System.out.print(sol.lengthOfLISBinarySearch(testCase) + "\n");
        }
    }

}
