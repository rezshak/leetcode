// https://leetcode.com/problems/left-and-right-sum-differences/

import java.util.Arrays;

class Solution2574 {

    // T: O(n), S: O(n)
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return new int[] { 0 };
        }
        var diff = new int[n];
        int rightSum = 0, leftSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];
            diff[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        return diff;
    }

    public static void main(String[] args) {
        var sol = new Solution2574();
        var nums1 = new int[] { 10, 4, 8, 3 };
        System.out.println(Arrays.toString(sol.leftRightDifference(nums1))); // 15,1,11,22
        var nums2 = new int[] { 1 };
        System.out.println(Arrays.toString(sol.leftRightDifference(nums2))); // 0
    }

}
